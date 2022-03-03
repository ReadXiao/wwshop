package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/3/21 - 17:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GmsSpu {
    private String id;
    private int catalogId;
    private String goodsName;
    private String spuPic;
    private BigDecimal spuPrice;
    private String goodsDesc;
    private Date createTime;
    private Date deleteTime;
    private int state;
    private List<GmsDetailPics> gmsDetailPics;
    private List<GmsSku> gmsSkus;
}
