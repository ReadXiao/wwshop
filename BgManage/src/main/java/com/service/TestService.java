package com.service;

import com.pojo.GmsCatalogAttr;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/3/20 - 13:28
 */
public interface TestService {
    List<GmsCatalogAttr> getAttrByCatalogId(int id);
}
