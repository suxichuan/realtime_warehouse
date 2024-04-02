package com.cque.mall.bean;

import com.cque.mall.config.AppConfig;
import com.cque.mall.enums.DisplayType;
import com.cque.mall.enums.ItemType;
import com.cque.mall.enums.PageId;
import com.cque.mall.utils.RandomNum;
import com.cque.mall.utils.RandomNumString;
import com.cque.mall.utils.RandomOptionGroup;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/15:15:48:23
 */
@Data
@AllArgsConstructor
public class AppPage {
    PageId last_page_id; //上一页类型
    PageId page_id; //当前页id
    ItemType item_type; //目标类型
    String item; //目标id
    Integer during_time; //持续时间毫秒
    String extend1;
    String extend2;
    DisplayType source_type; //曝光类型

    public static  AppPage build(PageId pageId,PageId lastPageId,Integer duringTime){

        ItemType itemType=null;
        String item=null;
        String extend1=null;
        String extend2=null;
        DisplayType sourceType=null;


        RandomOptionGroup<DisplayType> sourceTypeGroup =   RandomOptionGroup.<DisplayType>builder().add(DisplayType.query, AppConfig.sourceTypeRate[0])
              .add(DisplayType.promotion, AppConfig.sourceTypeRate[1])
              .add(DisplayType.recommend, AppConfig.sourceTypeRate[2])
              .add(DisplayType.activity, AppConfig.sourceTypeRate[3]).build();


        if(pageId== PageId.good_detail  ||pageId== PageId.good_spec||pageId== PageId.comment||pageId== PageId.comment_list){

            sourceType =  sourceTypeGroup.getValue();

            itemType=ItemType.sku_id;
            item= RandomNum.getRandInt(1, AppConfig.max_sku_id)+"";
        }else if(pageId== PageId.good_list){
            itemType=ItemType.keyword;
            item=  new RandomOptionGroup(AppConfig.searchKeywords).getRandStringValue();
        }else if(pageId== PageId.trade||pageId== PageId.payment||pageId== PageId.payment_done) {
            itemType=ItemType.sku_ids;
            item= RandomNumString.getRandNumString(1, AppConfig.max_sku_id,RandomNum.getRandInt(1,3),",",false);
        }
        return   new AppPage(lastPageId, pageId,itemType,item, duringTime,extend1,extend2,sourceType);

    }

}
