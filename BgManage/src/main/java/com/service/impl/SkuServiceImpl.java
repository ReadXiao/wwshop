package com.service.impl;

import com.mapper.SkuMapper;
import com.pojo.GmsCatalogAttr;
import com.pojo.GmsSku;
import com.pojo.GmsSpu;
import com.service.SkuService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 肖宏武
 * @date 2020/4/8 - 19:44
 */
public class SkuServiceImpl implements SkuService {
    private SkuMapper skuMapper;

    public void setSkuMapper(SkuMapper skuMapper) {
        this.skuMapper = skuMapper;
    }

    public List<GmsSku> findSkuBySpuId(String id) {
        return skuMapper.findSkuBySpuId(id);
    }

    public int updateState(@Param("spuId") String spuId, @Param("id") int id,@Param("state") int state) {
        return skuMapper.updateState(spuId, id,state);
    }

    public int insertState(@Param("spuId") String spuId, @Param("id") int id,@Param("state") int state) {
        return skuMapper.insertState(spuId, id,state);
    }

    public int insertSpuState(@Param("spuId") String spuId,@Param("state") int state){
        return skuMapper.insertSpuState(spuId,state);
    }

    public GmsSku selectSku(@Param("spuId") String spuId, @Param("id") int id) {
        return skuMapper.selectSku(spuId,id);
    }

    public int updateAttr(@Param("skuPrice") String skuPrice, @Param("discountPrice") String discountPrice, @Param("amount") String amount, @Param("id") String id, @Param("spuId") String spuId){
        return skuMapper.updateAttr(skuPrice,discountPrice,amount,id,spuId);
    }

    public int selectSkuCount(@Param("spuId") String spuId) {
        return skuMapper.selectSkuCount(spuId);
    }

    public int selectSkuDeCount(@Param("spuId") String spuId, @Param("state") int state) {
        return skuMapper.selectSkuDeCount(spuId,state);
    }

    public int updateSpuState(String spuId, int state) {
        return skuMapper.updateSpuState(spuId,state);
    }

    public GmsSpu selectCatalogIdBySpu(@Param("spuId")String spuId){
        return skuMapper.selectCatalogIdBySpu(spuId);
    }

    public List<GmsCatalogAttr> findAttrsByCatalogId(int id) {
        return skuMapper.findAttrsByCatalogId(id);
    }

    public int insertGoodsSpuAttr(Map map) {
        return skuMapper.insertGoodsSpuAttr(map);
    }

    public int insertGoodsSku(Map map) {
        return skuMapper.insertGoodsSku(map);
    }


}
