package com.controller;

import com.pojo.AllSaleDetail;
import com.pojo.OmsOrderInfo;
import com.pojo.SaleSum;
import com.service.SaleService;
import com.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/17 - 14:27
 */
@Controller
public class SaleController {
    @Autowired
    @Qualifier("SaleServiceImpl")
    private SaleService saleService;

    @RequestMapping("/toMonthSale")
    public String toMonthSalePage(Model model) {
        List<OmsOrderInfo> omsOrderInfos = saleService.selectAllOrderTotalPrice();
        float Jan = 0, Feb = 0, Mar = 0, Apr = 0, May = 0, Jun = 0, Jul = 0, Aug = 0, Sep = 0, Oct = 0, Nov = 0, Dec = 0;
        Calendar cal = Calendar.getInstance();
        Calendar nowCal = Calendar.getInstance();
        nowCal.setTime(new Date());
        for (OmsOrderInfo omsOrderInfo : omsOrderInfos) {
            Date saleTime = omsOrderInfo.getPayTime();
            cal.setTime(saleTime);
            if (nowCal.get(Calendar.YEAR)==cal.get(Calendar.YEAR)){
                if(cal.get(Calendar.MONTH)==0){
                    Jan+=omsOrderInfo.getTotalPrice();
                }else if (cal.get(Calendar.MONTH)==1){
                    Feb+=omsOrderInfo.getTotalPrice();
                }else if (cal.get(Calendar.MONTH)==2){
                    Mar+=omsOrderInfo.getTotalPrice();
                }else if (cal.get(Calendar.MONTH)==3){
                    Apr+=omsOrderInfo.getTotalPrice();
                }else if (cal.get(Calendar.MONTH)==4){
                    May+=omsOrderInfo.getTotalPrice();
                }else if (cal.get(Calendar.MONTH)==5){
                    Jun+=omsOrderInfo.getTotalPrice();
                }else if (cal.get(Calendar.MONTH)==6){
                    Jul+=omsOrderInfo.getTotalPrice();
                }else if (cal.get(Calendar.MONTH)==7){
                    Aug+=omsOrderInfo.getTotalPrice();
                }else if (cal.get(Calendar.MONTH)==8){
                    Sep+=omsOrderInfo.getTotalPrice();
                }else if (cal.get(Calendar.MONTH)==9){
                    Oct+=omsOrderInfo.getTotalPrice();
                }else if (cal.get(Calendar.MONTH)==10){
                    Nov+=omsOrderInfo.getTotalPrice();
                }else{
                    Dec+=omsOrderInfo.getTotalPrice();
                }
            }
        }
        String str = Jan+","+Feb+","+Mar+","+Apr+","+May+","+Jun+","+Jul+","+Aug+","+Sep+","+Oct+","+Nov+","+Dec;
        model.addAttribute("month",str);
        return "monthSale";
    }

    @RequestMapping("/toCatalogSale")
    public String toCatalogSale(Model model) {
        List<SaleSum> saleSums = saleService.selectSaleSum();
        model.addAttribute("saleSums", saleSums);
        return "catalogSale";
    }

    @RequestMapping("/toAllSale")
    public String toAllSale(Model model) {
        List<AllSaleDetail> allSaleDetails = saleService.selectAllSaleDetail();
        model.addAttribute("allSaleDetail",allSaleDetails);
        return "allSale";
    }

    @RequestMapping("/findSaleByName")
    @ResponseBody
    public String findSaleDetailByName(String goodsName){
        List<AllSaleDetail> allSaleDetails = saleService.selectSaleDetailByName(goodsName);
        return JsonUtils.getJson(allSaleDetails);
    }

}
