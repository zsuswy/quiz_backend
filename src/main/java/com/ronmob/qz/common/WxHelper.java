package com.ronmob.qz.common;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.util.Date;

/**
 * 创建时间：07/10/2017
 * 创建人：sunwuyang
 */
public class WxHelper {
    private static WxMpService wxService;
    private static WxPayService wxPayService;
    private static final String SCORE_CHANGE_TEMPLATE_ID = "n8vit1t5P9B-8iMtryDj3Qg30Yy8f0GHRsnF8K8yfSQ";
    private static final String BUY_SUCCESS_TEMPLATE_ID = "H5-7i3LFYdb2Zu0UWK9JOgvr-fZYLDLTyHTnE01Lwu0";

    static {
        wxService = new WxMpServiceImpl();
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId("wxfad0891e1a70421c"); // 设置微信公众号的appid
        config.setSecret("e659387e8c350e775bf571908ff512cf"); // 设置微信公众号的app corpSecret
        config.setToken("ronmob"); // 设置微信公众号的token
        config.setAesKey("CDtSSu2BW9qmGTZXEinhWleml0oDJuin1w8ZOJMDNk7"); // 设置微信公众号的EncodingAESKey
        wxService.setWxMpConfigStorage(config);


        wxPayService = new WxPayServiceImpl();
        WxPayConfig payConfig = new WxPayConfig();
        payConfig.setAppId("wxfad0891e1a70421c");
        payConfig.setMchId("1261829701");
        payConfig.setMchKey("db4ccd7781e76bc556e2b05aa0e2bd5d");
        payConfig.setNotifyUrl("http://quiz.ronmob.com/qz/wx/notify");
        wxPayService.setConfig(payConfig);
    }

    public static WxMpService getWxService() {
        return wxService;
    }

    public static WxPayService getPayService() {
        return wxPayService;
    }

    /**
     * 购买成功后的模版消息
     */
    public static void sendBuySuccess(String wxOpenId, String surveyTitle, String url) throws Exception {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setToUser(wxOpenId);
        templateMessage.setTemplateId(BUY_SUCCESS_TEMPLATE_ID);
        templateMessage.setUrl(url);
        templateMessage.getData().add(new WxMpTemplateData("name", surveyTitle, "red"));
        templateMessage.getData().add(new WxMpTemplateData("remark", "您已经购买成功！", "blue"));

        WxHelper.getWxService().getTemplateMsgService().sendTemplateMsg(templateMessage);
    }

    /**
     * 积分变动的模版消息
     */
    public static void sendScoreChange(String wxOpenId, String scoreChange, String scoreTotal, String url) throws Exception {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setToUser(wxOpenId);
        templateMessage.setTemplateId(SCORE_CHANGE_TEMPLATE_ID);
        templateMessage.setUrl(url);
        templateMessage.getData().add(new WxMpTemplateData("first", "您有积分到账", "black"));
        templateMessage.getData().add(new WxMpTemplateData("keyword1", scoreChange, "blue")); // 积分
        templateMessage.getData().add(new WxMpTemplateData("keyword2", (new Date()).toString(), "black")); // 时间
        templateMessage.getData().add(new WxMpTemplateData("keyword3", "剩余总积分" + scoreTotal, "black")); // 备注
        templateMessage.getData().add(new WxMpTemplateData("remark", "每1个积分，可以抵扣1元现金。积分不能提现。", "red"));  //

        WxHelper.getWxService().getTemplateMsgService().sendTemplateMsg(templateMessage);
    }

}
