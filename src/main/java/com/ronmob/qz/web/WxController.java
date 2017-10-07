package com.ronmob.qz.web;

import com.ronmob.qz.common.WxHelper;
import com.ronmob.qz.model.User;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.model.wx.SnsApiBaseReturnResult;
import com.ronmob.qz.service.UserService;
import com.ronmob.qz.vo.SearchVo;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/wx")
public class WxController {

    @Autowired
    UserService userService;

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
}
