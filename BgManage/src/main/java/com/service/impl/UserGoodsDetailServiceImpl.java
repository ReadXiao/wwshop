package com.service.impl;

import com.mapper.UserGoodsDetailMapper;
import com.pojo.*;
import com.service.UserGoodsDetailService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 肖宏武
 * @date 2020/4/27 - 21:58
 */
public class UserGoodsDetailServiceImpl implements UserGoodsDetailService {
    private UserGoodsDetailMapper userGoodsDetailMapper;

    public void setUserGoodsDetailMapper(UserGoodsDetailMapper userGoodsDetailMapper) {
        this.userGoodsDetailMapper = userGoodsDetailMapper;
    }

    @Override
    public GmsSpu findSpuById(@Param("spuId") String spuId) {
        return userGoodsDetailMapper.findSpuById(spuId);
    }

    @Override
    public List<GmsSku> findSkuBySpuId(@Param("spuId") String spuId) {
        return userGoodsDetailMapper.findSkuBySpuId(spuId);
    }

    @Override
    public List<UmsComment> findCommentBySpuId(@Param("spuId") String spuId) {
        return userGoodsDetailMapper.findCommentBySpuId(spuId);
    }

    @Override
    public List<GmsDetailPics> findDetailPics(@Param("spuId") String spuId) {
        return userGoodsDetailMapper.findDetailPics(spuId);
    }

    @Override
    public int insertAddCar(Map map){
        return userGoodsDetailMapper.insertAddCar(map);
    }

    @Override
    public Addcar findGoodsBySpuIdAndSkuId(Map map) {
        return userGoodsDetailMapper.findGoodsBySpuIdAndSkuId(map);
    }

    @Override
    public int findGoodsNum(@Param("spuId") String spuId, @Param("skuId") int skuId) {
        return userGoodsDetailMapper.findGoodsNum(spuId,skuId);
    }

    @Override
    public int updateGoodsNum(Map map) {
        return userGoodsDetailMapper.updateGoodsNum(map);
    }
}
