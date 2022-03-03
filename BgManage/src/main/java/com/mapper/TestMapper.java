package com.mapper;

import com.pojo.GmsCatalogAttr;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/3/20 - 13:06
 */
public interface TestMapper {
    List<GmsCatalogAttr> getAttrByCatalogId(int id);
}
