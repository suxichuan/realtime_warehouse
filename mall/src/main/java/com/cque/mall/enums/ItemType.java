package com.cque.mall.enums;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/15:14:02:19
 */
public enum ItemType {
    sku_id("商品skuId"),
    keyword("搜索关键词"),
    sku_ids("多个商品skuId"),
    activity_id("活动id"),
    coupon_id("购物券id");

    String desc;

    private ItemType(String desc)
    {
        this.desc = desc;
    }
}
