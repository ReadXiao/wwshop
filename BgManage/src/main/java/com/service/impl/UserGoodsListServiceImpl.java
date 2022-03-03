package com.service.impl;

import com.mapper.UserGoodsListMapper;
import com.pojo.GmsCatalog;
import com.pojo.GmsSpu;
import com.service.UserGoodsListService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/25 - 20:08
 */
public class UserGoodsListServiceImpl implements UserGoodsListService {
    private UserGoodsListMapper userGoodsListMapper;

    public void setUserGoodsListMapper(UserGoodsListMapper userGoodsListMapper) {
        this.userGoodsListMapper = userGoodsListMapper;
    }

    @Override
    public List<GmsSpu> findGoodsByCatalogId(@Param("catalogId") int catalogId,@Param("page") int page) {
        return userGoodsListMapper.findGoodsByCatalogId(catalogId,page);
    }

    @Override
    public GmsCatalog findCatalogById(@Param("catalogId") int catalogId) {
        return userGoodsListMapper.findCatalogById(catalogId);
    }

    @Override
    public List<GmsSpu> findGoodsByName(@Param("goodsName") String goodsName,@Param("page") int page) {
        return userGoodsListMapper.findGoodsByName(goodsName,page);
    }
}
