package com.cque.publisher.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2023/03/06:15:44:25
 */
@Data
@TableName("dws_home_detail_page_view")
public class DwsHomeDetailPageView {
    private Long homeCt;
    private Long detailCt;
}
