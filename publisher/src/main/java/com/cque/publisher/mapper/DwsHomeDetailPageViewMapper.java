package com.cque.publisher.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cque.publisher.domain.DwsHomeDetailPageView;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2023/03/06:15:46:17
 */
public interface DwsHomeDetailPageViewMapper  {
    @Select("select * from dws_home_detail_page_view")
    List<DwsHomeDetailPageView> selectAllDwsHomeDetailPageView();
}
