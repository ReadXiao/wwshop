package com.service;

import com.pojo.GmsCatalog;
import com.pojo.GmsCatalogAttr;
import com.pojo.GmsSpu;
import com.pojo.UmsComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 肖宏武
 * @date 2020/3/29 - 13:43
 */
public interface GoodsAdminService {
    List<GmsSpu> findAllGoods();

    List<GmsSpu> findGoodsByName(Map map);

    List<GmsCatalog> findAllCatalog();

    List<GmsCatalogAttr> findAttrsByCatalogId(int id);

    int insertGoodsSpu(Map map);

    int insertGoodsSku(Map map);

    int insertGoodsSpuAttr(Map map);

    int insertGoodsDetailPics(Map map);

    int deleteSpu(@Param("id") String id, @Param("state") int state);

    int deleteSpuSku(@Param("spuId") String spuId,@Param("state") int state);

    int insertSpu(@Param("id") String id,@Param("state") int state);

    int insertSpuSku(@Param("spuId") String spuId,@Param("state") int state);

    List<GmsSpu> selectSpuByState(@Param("state") int state);

    GmsSpu selectSpuById(@Param("id") String id);

    List<UmsComment> selectCommentBySpuId(@Param("spuId") String spuId);

    int deleteComment(@Param("id") int id);
}
