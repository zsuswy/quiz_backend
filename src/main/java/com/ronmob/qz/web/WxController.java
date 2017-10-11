package com.ronmob.qz.web;

import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.request.WxPayBaseRequest;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayBaseResult;
import com.github.binarywang.wxpay.service.WxPayService;
import com.ronmob.qz.common.Util;
import com.ronmob.qz.common.WxHelper;
import com.ronmob.qz.model.PayOrder;
import com.ronmob.qz.model.User;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.model.wx.SnsApiBaseReturnResult;
import com.ronmob.qz.service.PayOrderService;
import com.ronmob.qz.service.UserService;
import com.ronmob.qz.vo.SearchVo;
import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/wx")
public class WxController {
    private static Log log = LogFactory.getLog(SurveyController.class);

    @Autowired
    UserService userService;

    @Autowired
    PayOrderService payOrderService;


    public WxController() {
    }

    @RequestMapping(value = "/getUserInfo")
    public void getUserInfo(HttpServletRequest req, HttpServletResponse response, String retUrl) throws Exception {
        req.getSession().setAttribute("retUrl", retUrl);
        String url = WxHelper.getWxService().oauth2buildAuthorizationUrl("http://quiz.ronmob.com/qz/wx/sns_api_base_callback", WxConsts.OAUTH2_SCOPE_BASE, null);
        response.sendRedirect(url);
    }

    @RequestMapping(value = "/sns_api_base_callback", produces = "application/json")
    @ResponseBody
    public Object wxSnsCallBack(HttpServletRequest req, HttpServletResponse response, String code) throws Exception {
        WxMpOAuth2AccessToken token = WxHelper.getWxService().oauth2getAccessToken(code);
        User user = userService.getUserByWxOpenId(token.getOpenId());
        if (user == null) {
            User userNew = new User();
            userNew.setWxOpenId(token.getOpenId());
            user = userService.createUser(userNew);
        }
        if (req.getSession().getAttribute("retUrl") != null) {
            Cookie cookieUserID = new Cookie("userId", user.getId().toString());
            Cookie cookieWxOpenId = new Cookie("wxOpenId", token.getOpenId());
            cookieUserID.setPath("/");
            cookieWxOpenId.setPath("/");

            response.addCookie(cookieUserID);
            response.addCookie(cookieWxOpenId);
        }
        response.sendRedirect("http://quiz.ronmob.com/qz/mobile/#" + req.getSession().getAttribute("retUrl").toString());
        return token;
    }

    @RequestMapping(value = "/getJsapiTicket", produces = "application/json")
    @ResponseBody
    public Object getJsapiTicket() throws Exception {
        return WxHelper.getWxService().getJsapiTicket();
    }

    @RequestMapping(value = "/createJsapiSignature", produces = "application/json")
    @ResponseBody
    public ResponseResult createJsapiSignature(String url) {
        ResponseResult result = new ResponseResult();
        try {
            result.setSuccess(true);
            result.setData(WxHelper.getWxService().createJsapiSignature(url));
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
            ex.printStackTrace();
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("/notify")
    public ResponseResult payNotify(@RequestBody String xmlData) {
        ResponseResult responseResult = new ResponseResult();

        WxPayService wxPayService = WxHelper.getPayService();
        try {
            WxPayOrderNotifyResult result = wxPayService.parseOrderNotifyResult(xmlData);

            // 结果正确
            String outTradeNo = result.getOutTradeNo();
            String orderId = result.getTransactionId();
            String totalFee = WxPayBaseResult.feeToYuan(result.getTotalFee());

            PayOrder order = payOrderService.getOrderByOutTradeNo(outTradeNo);
            order.setStatus(Util.getByte("1"));

            order.setTransactionId(orderId);


            //自己处理订单的业务逻辑，需要判断订单是否已经支付过，否则可能会重复调用
            responseResult.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.setSuccess(false);
            responseResult.setMessage("微信回调结果异常." + e.getMessage());
        }

        return responseResult;
    }
}
