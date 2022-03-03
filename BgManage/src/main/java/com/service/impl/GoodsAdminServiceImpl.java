package com.service.impl;

import com.mapper.GoodsMapper;
import com.pojo.GmsCatalog;
import com.pojo.GmsCatalogAttr;
import com.pojo.GmsSpu;
import com.pojo.UmsComment;
import com.service.GoodsAdminService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 肖宏武
 * @date 2020/3/29 - 13:44
 */
public class GoodsAdminServiceImpl implements GoodsAdminService {
    private GoodsMapper goodsMapper;

    public void setGoodsMapper(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    public List<GmsSpu> findAllGoods() {
        List<GmsSpu> allGoods = goodsMapper.findAllGoods();
        return allGoods;
    }

    public List<GmsSpu> findGoodsByName(Map map) {
        return goodsMapper.findGoodsByName(map);
    }

    public List<GmsCatalog> findAllCatalog(){
        return goodsMapper.findAllCatalog();
    }

    public List<GmsCatalogAttr> findAttrsByCatalogId(int id) {
        return goodsMapper.findAttrsByCatalogId(id);
    }

    public int insertGoodsSpu(Map map) {
        return goodsMapper.insertGoodsSpu(map);
    }

    public int insertGoodsSku(Map map) {
        return goodsMapper.insertGoodsSku(map);
    }

    public int insertGoodsSpuAttr(Map map) {
        return goodsMapper.insertGoodsSpuAttr(map);
    }

    public int insertGoodsDetailPics(Map map) {
        return goodsMapper.insertGoodsDetailPics(map);
    }

    public int deleteSpu(@Param("id") String id, @Param("state") int state){
        return goodsMapper.deleteSpu(id,state);
    }

    public int deleteSpuSku(@Param("spuId") String spuId,@Param("state") int state){
        return goodsMapper.deleteSpuSku(spuId,state);
    }

    public int insertSpu(@Param("id") String id,@Param("state") int state){
        return goodsMapper.insertSpu(id,state);
    }

    public int insertSpuSku(@Param("spuId") String spuId,@Param("state") int state){
        return goodsMapper.insertSpuSku(spuId,state);
    }

    public List<GmsSpu> selectSpuByState(@Param("state") int state){
        return goodsMapper.selectSpuByState(state);
    }

    @Override
    public GmsSpu selectSpuById(String id) {
        return goodsMapper.selectSpuById(id);
    }

    @Override
    public List<UmsComment> selectCommentBySpuId(String spuId) {
        return goodsMapper.selectCommentBySpuId(spuId);
    }

    @Override
    public int deleteComment(int id) {
        return goodsMapper.deleteComment(id);
    }
}
