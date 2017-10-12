package com.ronmob.qz.service;

import com.github.binarywang.wxpay.service.WxPayService;
import com.ronmob.qz.model.PayOrder;
import com.ronmob.qz.service.impl.WxHelperImpl;
import com.ronmob.qz.vo.SearchVo;
import me.chanjar.weixin.mp.api.WxMpService;

import java.util.List;
import java.util.Map;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface WxHelper {
    public void sendScoreChange(String wxOpenId, String scoreChange, String scoreTotal, String url) throws Exception;

    public void sendBuySuccess(String wxOpenId, String surveyTitle, String url) throws Exception;

    public WxPayService getPayService();

    public WxMpService getWxService();

}
