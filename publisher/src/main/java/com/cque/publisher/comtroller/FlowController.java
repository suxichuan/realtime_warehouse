package com.cque.publisher.comtroller;


import com.cque.publisher.domain.DwsHomeDetailPageView;
import com.cque.publisher.service.DwsHomeDetailPageViewService;
import com.cque.publisher.service.impl.DwsHomeDetailPageViewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2023/03/06:15:31:52
 */
@Controller
public class FlowController {


    @Autowired
    private DwsHomeDetailPageViewServiceImpl dwsHomeDetailPageViewService;

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        return "test";
    }

    @RequestMapping("getDwsHomeDetailPageViewList")
    @ResponseBody
    public List<DwsHomeDetailPageView> getDwsHomeDetailPageViewList(){
        return dwsHomeDetailPageViewService.getDwsHomeDetailPageViewList();
    }
}
