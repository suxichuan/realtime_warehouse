package com.cque.publisher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cque.publisher.domain.DwsHomeDetailPageView;
import com.cque.publisher.mapper.DwsHomeDetailPageViewMapper;
import com.cque.publisher.service.DwsHomeDetailPageViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2023/03/06:15:48:00
 */
@Service()
public class DwsHomeDetailPageViewServiceImpl implements DwsHomeDetailPageViewService {


    @Autowired
    private DwsHomeDetailPageViewMapper dwsHomeDetailPageViewMapper;

    @Override
    public List<DwsHomeDetailPageView> getDwsHomeDetailPageViewList() {
        return dwsHomeDetailPageViewMapper.selectAllDwsHomeDetailPageView();
    }
}
