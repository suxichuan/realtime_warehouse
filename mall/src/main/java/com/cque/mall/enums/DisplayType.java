package com.cque.mall.enums;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/15:14:01:48
 */
public enum DisplayType {
    promotion("商品推广"),
    recommend("算法推荐商品"),
    query("查询结果商品"),
    activity("促销活动");

    private String desc;

    private DisplayType(String desc)
    {
        this.desc = desc;
    }
}
