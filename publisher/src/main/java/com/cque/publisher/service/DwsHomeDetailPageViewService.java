package com.cque.publisher.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cque.publisher.domain.DwsHomeDetailPageView;

import java.util.List;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2023/03/06:15:47:23
 */
public interface DwsHomeDetailPageViewService{
    List<DwsHomeDetailPageView> getDwsHomeDetailPageViewList();
}
