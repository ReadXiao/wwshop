package com.mapper;

import com.pojo.AllSaleDetail;
import com.pojo.OmsOrderDetail;
import com.pojo.OmsOrderInfo;
import com.pojo.SaleSum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/17 - 14:24
 */
public interface SaleMapper {
    List<OmsOrderDetail> selectAllOrderDetailTotalPrice();

    List<OmsOrderInfo> selectAllOrderTotalPrice();

    List<SaleSum> selectSaleSum();

    List<AllSaleDetail> selectAllSaleDetail();

    List<AllSaleDetail> selectSaleDetailByName(@Param("goodsName") String goodsName);
}
