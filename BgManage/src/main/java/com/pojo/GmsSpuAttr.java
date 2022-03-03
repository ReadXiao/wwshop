package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 肖宏武
 * @date 2020/3/21 - 17:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GmsSpuAttr {
    private int id;
    private String spuId;
    private int attrId;
    private String attrValue;
    private GmsAttr gmsAttrs;
    private GmsSpu gmsSpus;
}
