package com.ronmob.qz.vo;

import com.ronmob.qz.model.UserDistribution;
import com.ronmob.qz.model.common.Page;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
public class UserDistributionListSearchVo {
    private Page page;
    private UserDistribution userDistribution;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public UserDistribution getUserDistribution() {
        return userDistribution;
    }

    public void setUserDistribution(UserDistribution userDistribution) {
        this.userDistribution = userDistribution;
    }
}
