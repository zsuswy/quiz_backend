package com.ronmob.qz.vo;

import com.ronmob.qz.model.UserDistribution;
import com.ronmob.qz.model.common.Page;

import java.util.List;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
public class UserDistributionListResultVo {
    private Page page;
    private List<UserDistribution> userDistributionList;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<UserDistribution> getUserDistributionList() {
        return userDistributionList;
    }

    public void setUserDistributionList(List<UserDistribution> userDistributionList) {
        this.userDistributionList = userDistributionList;
    }
}