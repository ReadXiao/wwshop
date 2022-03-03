package com.mapper;

import com.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 肖宏武
 * @date 2020/4/27 - 21:57
 */
public interface UserGoodsDetailMapper {
    GmsSpu findSpuById(@Param("spuId") String spuId);

    List<GmsSku> findSkuBySpuId(@Param("spuId") String spuId);

    List<UmsComment> findCommentBySpuId(@Param("spuId") String spuId);

    List<GmsDetailPics> findDetailPics(@Param("spuId") String spuId);

    int insertAddCar(Map map);

    Addcar findGoodsBySpuIdAndSkuId(Map map);

    int findGoodsNum(@Param("spuId") String spuId,@Param("skuId") int skuId);

    int updateGoodsNum(Map map);
}
