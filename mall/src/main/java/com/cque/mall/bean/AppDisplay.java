package com.cque.mall.bean;

import com.cque.mall.enums.DisplayType;
import com.cque.mall.enums.ItemType;
import com.cque.mall.enums.PageId;
import com.cque.mall.utils.RandomNum;
import com.cque.mall.utils.RandomOptionGroup;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static com.cque.mall.config.AppConfig.*;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/15:16:11:58
 */
@Data
@AllArgsConstructor
public class AppDisplay {
    ItemType item_type;
    String item;
    DisplayType display_type;
    Integer order;
    Integer pos_id;

    public static List<AppDisplay> buildList(AppPage appPage) {
        List<AppDisplay> displayList = new ArrayList();


        if(appPage.page_id== PageId.home ||appPage.page_id == PageId.discovery
              ||appPage.page_id == PageId.category){
            int displayCount = RandomNum.getRandInt(1, max_activity_count);
            int pos_id = RandomNum.getRandInt(1, max_pos_id);
            for (int i = 1; i <= displayCount; i++) {
                int actId = RandomNum.getRandInt(1, max_activity_count);
                AppDisplay appDisplay = new AppDisplay(ItemType.activity_id,  actId + "",DisplayType.activity, i,pos_id);
                displayList.add(appDisplay);
            }
        }
        if (  appPage.page_id == PageId.good_detail  //商品明细
              ||appPage.page_id == PageId.home     //   首页
              ||appPage.page_id == PageId.category     // 分类
              ||appPage.page_id == PageId.activity     // 活动
              ||appPage.page_id == PageId.good_spec     //  规格
              ||appPage.page_id == PageId.good_list     // 商品列表
              ||appPage.page_id == PageId.discovery){    // 发现

            int displayCount = RandomNum.getRandInt(min_display_count, max_display_count);
            int  activityCount=  displayList.size() ;// 商品显示从 活动后面开始
            for (int i = 1+activityCount; i <= displayCount+activityCount; i++) {
                int skuId = RandomNum.getRandInt(1, max_sku_id);
                int pos_id = RandomNum.getRandInt(1, max_pos_id);
                RandomOptionGroup<DisplayType> dispTypeGroup = RandomOptionGroup.<DisplayType>builder().add(DisplayType.promotion, 30)
                      .add(DisplayType.query, 60).add(DisplayType.recommend, 10).build();
                DisplayType displayType =  dispTypeGroup.getValue();

                AppDisplay appDisplay = new AppDisplay(ItemType.sku_id,  skuId + "", displayType,i,pos_id);
                displayList.add(appDisplay);
            }
        }

        return displayList;
    }
}
