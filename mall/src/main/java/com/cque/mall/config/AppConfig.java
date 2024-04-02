package com.cque.mall.config;

import com.cque.mall.utils.ParamUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/15:14:03:38
 */
@Configuration
public class AppConfig {
    public static String mock_date = "";

    public static Integer mock_count = Integer.valueOf(1000);

    public static String mock_type = "log";

    public static String mock_url = "http://node01:80/applog";
//    public static String mock_url =null;

    public static Integer max_mid = Integer.valueOf(500);

    public static Integer max_uid = Integer.valueOf(500);

    public static Integer max_coupon_id = Integer.valueOf(3);

    public static Integer max_sku_id = Integer.valueOf(10);

    public static Integer page_during_max_ms = Integer.valueOf(20000);

    public static Integer error_rate = Integer.valueOf(3);

    public static Integer log_sleep = Integer.valueOf(100);

    public static Integer if_favor_rate = Integer.valueOf(30);

    public static Integer if_favor_cancel_rate = Integer.valueOf(10);

    public static Integer if_cart_rate = Integer.valueOf(10);

    public static Integer if_cart_add_num_rate = Integer.valueOf(10);

    public static Integer if_cart_minus_num_rate = Integer.valueOf(10);

    public static Integer if_cart_rm_rate = Integer.valueOf(10);

    public static Integer if_add_address = Integer.valueOf(15);

    public static Integer if_get_coupon = Integer.valueOf(25);

    public static Integer max_display_count = Integer.valueOf(10);

    public static Integer min_display_count = Integer.valueOf(4);

    public static Integer max_activity_count = Integer.valueOf(2);
    public static Integer max_pos_id = Integer.valueOf(5);
    public static Integer[] sourceTypeRate;
    public static String[] searchKeywords;
    public static String kafka_server;
    public static String kafka_topic;

    @Value("${mock.type}")
    public void setMock_type(String mock_type)
    {
        this.mock_type = mock_type;
    }

    @Value("${mock.url}")
    public void setMock_url(String mock_url) {
        this.mock_url = mock_url;
    }

    @Value("${mock.kafka-server}")
    public void setKafka_server(String kafka_server) {
        this.kafka_server = kafka_server;
    }
    @Value("${mock.kafka-topic}")
    public void setKafka_topic(String kafka_topic) {
        this.kafka_topic = kafka_topic;
    }

    @Value("${mock.startup.count}")
    public void setMock_count(String mock_count)
    {
        this.mock_count = ParamUtil.checkCount(mock_count);
    }
    @Value("${mock.max.mid}")
    public void setMax_mid(String max_mid) {
        this.max_mid = ParamUtil.checkCount(max_mid);
    }
    @Value("${mock.max.uid}")
    public void setMax_uid(String max_uid) {
        this.max_uid = ParamUtil.checkCount(max_uid);
    }
    @Value("${mock.max.sku-id}")
    public void setMax_sku_id(String max_sku_id) {
        this.max_sku_id = ParamUtil.checkCount(max_sku_id);
    }
    @Value("${mock.page.during-time-ms}")
    public void setPage_during_max_ms(String page_during_max_ms) {
       this.page_during_max_ms = ParamUtil.checkCount(page_during_max_ms);
    }
    @Value("${mock.error.rate}")
    public void setError_rate(String error_rate) {
        this.error_rate = ParamUtil.checkRatioNum(error_rate);
    }
    @Value("${mock.log.sleep}")
    public void setLog_sleep(String log_sleep) {
        this.log_sleep = ParamUtil.checkCount(log_sleep);
    }

    public static void setIf_favor_rate(Integer _if_favor_rate) {
        if_favor_rate = _if_favor_rate;
    }

    public static void setIf_favor_cancel_rate(Integer _if_favor_cancel_rate) {
        if_favor_cancel_rate = _if_favor_cancel_rate;
    }

    public static void setIf_cart_rate(Integer _if_cart_rate) {
        if_cart_rate = _if_cart_rate;
    }

    public static void setIf_cart_add_num_rate(Integer _if_cart_add_num_rate) {
        if_cart_add_num_rate = _if_cart_add_num_rate;
    }

    public static void setIf_cart_minus_num_rate(Integer _if_cart_minus_num_rate) {
        if_cart_minus_num_rate = _if_cart_minus_num_rate;
    }

    public static void setIf_cart_rm_rate(Integer _if_cart_rm_rate) {
        if_cart_rm_rate = _if_cart_rm_rate;
    }

    public static void setIf_add_address(Integer _if_add_address) {
        if_add_address = _if_add_address;
    }

    public static void setMax_display_count(Integer _max_display_count) {
        max_display_count = _max_display_count;
    }

    public static void setMin_display_count(Integer _min_display_count) {
        min_display_count = _min_display_count;
    }

    public static void setMax_activity_count(Integer _max_activity_count) {
        max_activity_count = _max_activity_count;
    }

    @Value("${mock.date}")
    public void setMockDate(String _mockDate)
    {
        mock_date = _mockDate;
    }

    @Value("${mock.detail.source-type-rate}")
    public void setSourceType(String sourceTypeRate)
    {
        Integer[] sourceTypeRateArray = ParamUtil.checkRate(sourceTypeRate, 4);
        this.sourceTypeRate = sourceTypeRateArray;
    }

    @Value("${mock.search.keyword}")
    public void setSearchKeywords(String keywords)
    {
        searchKeywords = ParamUtil.checkArray(keywords);
    }

    @Value("${mock.if_get_coupon_rate}")
    public void setIf_get_coupon(String if_get_coupon_ratio)
    {
        if_get_coupon = ParamUtil.checkRatioNum(if_get_coupon_ratio);
    }

    @Value("${mock.max.coupon-id}")
    public void setMaxCouponId(String couponId) {
        max_coupon_id = ParamUtil.checkCount(couponId);
    }
}
