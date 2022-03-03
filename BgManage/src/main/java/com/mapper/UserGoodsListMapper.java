package com.mapper;

import com.pojo.GmsCatalog;
import com.pojo.GmsSpu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/25 - 20:04
 */
public interface UserGoodsListMapper {
    List<GmsSpu> findGoodsByCatalogId(@Param("catalogId") int catalogId,@Param("page") int page);

    GmsCatalog findCatalogById(@Param("catalogId") int catalogId);

    List<GmsSpu> findGoodsByName(@Param("goodsName") String goodsName,@Param("page") int page);
}
