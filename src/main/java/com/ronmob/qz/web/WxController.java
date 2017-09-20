package com.ronmob.qz.web;

import com.ronmob.qz.model.wx.SnsApiBaseReturnResult;
import com.ronmob.qz.service.CommonService;
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

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/wx")
public class WxController {
    WxMpService wxService = new WxMpServiceImpl();

    public WxController() {
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId("wxfad0891e1a70421c"); // 设置微信公众号的appid
        config.setSecret("e659387e8c350e775bf571908ff512cf"); // 设置微信公众号的app corpSecret
        config.setToken("ronmob"); // 设置微信公众号的token
        config.setAesKey("CDtSSu2BW9qmGTZXEinhWleml0oDJuin1w8ZOJMDNk7"); // 设置微信公众号的EncodingAESKey

        wxService.setWxMpConfigStorage(config);
    }

    @RequestMapping(value = "/getUserInfo")
    public void getSurveyClasses(HttpSession httpSession, HttpServletResponse response) throws Exception {
        String url = wxService.oauth2buildAuthorizationUrl("http://quiz.ronmob.com/qz/wx/sns_api_base_callback", WxConsts.OAUTH2_SCOPE_BASE, null);

        response.sendRedirect(url);
    }

    @RequestMapping(value = "/sns_api_base_callback", produces = "application/json")
    @ResponseBody
    public Object getSurveyClasses(HttpSession httpSession, String code) throws Exception {
        WxMpOAuth2AccessToken token = wxService.oauth2getAccessToken(code);
        return token;
    }

}
