package com.aaa.infomation.service;

import com.aaa.infomation.dao.thePrimaryClassificationDao;
import com.aaa.infomation.entity.thePrimaryClassification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 一级课程分类 service层
 */
@Service
public class thePrimaryClassificationService {
    @Resource
    private thePrimaryClassificationDao thePrimaryClassificationdao;

    /**
     * 查询一级课程分类
     *
     * @return
     */
    public List<thePrimaryClassification> showAllthePrimaryClassification() {
        return thePrimaryClassificationdao.showAllthePrimaryClassification();
    }

}
