package com.ronmob.qz.web;

import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.service.WxPayService;
import com.ronmob.qz.common.Util;
import com.ronmob.qz.service.WxHelper;
import com.ronmob.qz.service.impl.WxHelperImpl;
import com.ronmob.qz.model.PayOrder;
import com.ronmob.qz.model.User;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.PayOrderService;
import com.ronmob.qz.service.UserService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/wx")
public class WxController {
    private static Log logger = LogFactory.getLog(WxController.class);

    @Autowired
    UserService userService;

    @Autowired
    PayOrderService payOrderService;

    @Autowired
    WxHelper wxHelper;

    @Value("${wx_auth_callback_url}")
    private String wxAuthCallBackUrl;

    @Value("${host_with_app_name}")
    private String hostWithAppName;

    @Value("${mobile_app_url}")
    private String mobileAppUrl;


    @RequestMapping(value = "/getUserInfo")
    public void getUserInfo(HttpServletRequest req, HttpServletResponse response, String retUrl) throws Exception {
        req.getSession().setAttribute("retUrl", retUrl);
        String url = wxHelper.getWxService().oauth2buildAuthorizationUrl(wxAuthCallBackUrl, WxConsts.OAUTH2_SCOPE_BASE, null);
        response.sendRedirect(url);
    }

    @RequestMapping(value = "/sns_api_base_callback", produces = "application/json")
    @ResponseBody
    public Object wxSnsCallBack(HttpServletRequest req, HttpServletResponse response, String code) throws Exception {
        WxMpOAuth2AccessToken token = wxHelper.getWxService().oauth2getAccessToken(code);
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
        response.sendRedirect(hostWithAppName + "/mobile/#" + req.getSession().getAttribute("retUrl").toString());
        return token;
    }

    @RequestMapping(value = "/getJsapiTicket", produces = "application/json")
    @ResponseBody
    public Object getJsapiTicket() throws Exception {
        return wxHelper.getWxService().getJsapiTicket();
    }

    @RequestMapping(value = "/createJsapiSignature", produces = "application/json")
    @ResponseBody
    public ResponseResult createJsapiSignature(String url) {
        ResponseResult result = new ResponseResult();
        try {
            result.setSuccess(true);
            result.setData(wxHelper.getWxService().createJsapiSignature(url));
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
            ex.printStackTrace();
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("/notify")
    public String payNotify(@RequestBody String xmlData) throws Exception {
        String success = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";

        WxPayService wxPayService = wxHelper.getPayService();

        try {
            WxPayOrderNotifyResult result = wxPayService.parseOrderNotifyResult(xmlData);

            // 结果正确
            String outTradeNo = result.getOutTradeNo();
            String orderId = result.getTransactionId();
            // String totalFee = WxPayBaseResult.feeToYuan(result.getTotalFee());
            logger.info("out trade no = " + outTradeNo);

            PayOrder order = payOrderService.getOrderByOutTradeNo(outTradeNo);

            if (order.getStatus() > 0) {
                return success;
            }

            order.setStatus(Util.getByte("1"));
            order.setTransactionId(orderId);

            payOrderService.updateOrder(order);

            payOrderService.confirmOrder(order.getId());

            return success;

            //自己处理订单的业务逻辑，需要判断订单是否已经支付过，否则可能会重复调用

        } catch (Exception e) {
            logger.error(e);
        }

        return "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[FAIL]]></return_msg></xml>";
    }

    /**
     * 微信分享入口
     */
    @ResponseBody
    @RequestMapping("/share")
    public void payNotify(String path, String fromUserId, HttpServletResponse response) throws Exception {
        String retUrl = mobileAppUrl + "/#?path=" + path;
        if (fromUserId != null) {
            retUrl = retUrl + "&fromUserId=" + fromUserId;
        }
        response.sendRedirect(retUrl);
    }

}
