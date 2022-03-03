package com.service.impl;

import com.mapper.TestMapper;
import com.pojo.GmsCatalogAttr;
import com.service.TestService;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/3/20 - 13:29
 */
public class TestServiceImpl implements TestService {

    private TestMapper testMapper;

    public void setTestMapper(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    public List<GmsCatalogAttr> getAttrByCatalogId(int id) {
        return testMapper.getAttrByCatalogId(id);
    }
}
