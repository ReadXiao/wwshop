package com.service;

import com.pojo.GmsCatalogAttr;
import com.pojo.GmsSku;
import com.pojo.GmsSpu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 肖宏武
 * @date 2020/4/8 - 19:44
 */
public interface SkuService {
    List<GmsSku> findSkuBySpuId(String id);

    int updateState(String spuId, int id,int state);

    int insertState(String spuId, int id,int state);

    int insertSpuState(@Param("spuId") String spuId,@Param("state") int state);

    GmsSku selectSku(String spuId, int id);

    int updateAttr(@Param("skuPrice") String skuPrice, @Param("discountPrice") String discountPrice, @Param("amount") String amount, @Param("id") String id, @Param("spuId") String spuId);

    int selectSkuCount(@Param("spuId") String spuId);

    int selectSkuDeCount(@Param("spuId") String spuId,@Param("state") int state);

    int updateSpuState(@Param("spuId") String spuId,@Param("state") int state);

    GmsSpu selectCatalogIdBySpu(@Param("spuId")String spuId);

    List<GmsCatalogAttr> findAttrsByCatalogId(@Param("id") int id);

    int insertGoodsSpuAttr(Map map);

    int insertGoodsSku(Map map);

}
