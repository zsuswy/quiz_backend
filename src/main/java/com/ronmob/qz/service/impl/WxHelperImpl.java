package com.ronmob.qz.service.impl;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.ronmob.qz.service.WxHelper;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 创建时间：07/10/2017
 * 创建人：sunwuyang
 */
@Service
public class WxHelperImpl implements WxHelper {
    private static Log logger = LogFactory.getLog(WxHelperImpl.class);

    private WxMpService wxService = null;
    private WxPayService wxPayService = null;

    @Value("${score_change_mgs_template_id}")
    private String scoreChangeMsgTemplateId;

    @Value("${buy_success_msg_template_id}")
    private String buySuccessMsgTemplateId;

    @Value("${host_with_app_name}")
    private String hostWithAppName;

    @Value("${app_id}")
    private String appId;

    @Value("${app_secret}")
    private String appSecret;

    @Value("${app_token}")
    private String appToken;

    @Value("${app_aes_key}")
    private String appAesKey;

    @Value("${mch_key}")
    private String mchKey;

    @Value("${mch_id}")
    private String mchId;

    @Value("${wx_pay_notify_url}")
    private String wxPayNotifyUrl;

    @Override
    public WxMpService getWxService() {
        logger.info("====" + appId + "====" + wxPayNotifyUrl + "====");

        if (wxService == null) {
            wxService = new WxMpServiceImpl();

            WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
            config.setAppId(appId); // 设置微信公众号的appid
            config.setSecret(appSecret); // 设置微信公众号的app corpSecret
            config.setToken(appToken); // 设置微信公众号的token
            config.setAesKey(appAesKey); // 设置微信公众号的EncodingAESKey
            wxService.setWxMpConfigStorage(config);
        }
        return wxService;
    }

    @Override
    public WxPayService getPayService() {
        logger.info("====" + appId + "====" + wxPayNotifyUrl + "====");

        if (wxPayService == null) {
            wxPayService = new WxPayServiceImpl();
            WxPayConfig payConfig = new WxPayConfig();
            payConfig.setAppId(appId);
            payConfig.setMchId(mchId);
            payConfig.setMchKey(mchKey);
            payConfig.setNotifyUrl(wxPayNotifyUrl);
            wxPayService.setConfig(payConfig);
        }
        return wxPayService;
    }

    /**
     * 购买成功后的模版消息
     */
    @Override
    public void sendBuySuccess(String wxOpenId, String surveyTitle, String url) throws Exception {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setToUser(wxOpenId);
        templateMessage.setTemplateId(buySuccessMsgTemplateId);
        templateMessage.setUrl(url);
        templateMessage.getData().add(new WxMpTemplateData("name", surveyTitle, "red"));
        templateMessage.getData().add(new WxMpTemplateData("remark", "您已经购买成功！", "blue"));

        this.wxService.getTemplateMsgService().sendTemplateMsg(templateMessage);
    }

    /**
     * 积分变动的模版消息
     */
    @Override
    public void sendScoreChange(String wxOpenId, String scoreChange, String scoreTotal, String url) throws Exception {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setToUser(wxOpenId);
        templateMessage.setTemplateId(scoreChangeMsgTemplateId);
        templateMessage.setUrl(url);
        templateMessage.getData().add(new WxMpTemplateData("first", "您有积分到账", "black"));
        templateMessage.getData().add(new WxMpTemplateData("keyword1", scoreChange, "blue")); // 积分
        templateMessage.getData().add(new WxMpTemplateData("keyword2", (new Date()).toString(), "black")); // 时间
        templateMessage.getData().add(new WxMpTemplateData("keyword3", "剩余总积分" + scoreTotal, "black")); // 备注
        templateMessage.getData().add(new WxMpTemplateData("remark", "每1个积分，可以抵扣1元现金。积分不能提现。", "red"));  //

        this.wxService.getTemplateMsgService().sendTemplateMsg(templateMessage);
    }
}
