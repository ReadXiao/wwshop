package com.service.impl;

import com.mapper.SaleMapper;
import com.pojo.AllSaleDetail;
import com.pojo.OmsOrderDetail;
import com.pojo.OmsOrderInfo;
import com.pojo.SaleSum;
import com.service.SaleService;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/17 - 14:26
 */
public class SaleServiceImpl implements SaleService {
    private SaleMapper saleMapper;

    public void setSaleMapper(SaleMapper saleMapper) {
        this.saleMapper = saleMapper;
    }

    @Override
    public List<OmsOrderDetail> selectAllOrderDetailTotalPrice() {
        return saleMapper.selectAllOrderDetailTotalPrice();
    }

    @Override
    public List<OmsOrderInfo> selectAllOrderTotalPrice() {
        return saleMapper.selectAllOrderTotalPrice();
    }

    @Override
    public List<SaleSum> selectSaleSum() {
        return saleMapper.selectSaleSum();
    }

    @Override
    public List<AllSaleDetail> selectAllSaleDetail() {
        return saleMapper.selectAllSaleDetail();
    }

    @Override
    public List<AllSaleDetail> selectSaleDetailByName(String goodsName) {
        return saleMapper.selectSaleDetailByName(goodsName);
    }
}


