package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 肖宏武
 * @date 2020/3/20 - 13:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GmsCatalogAttr {
    private int id;
    private int catalogId;
    private int attrId;
    private String value;
    private String attrName;

/*    private int id;
    private int catalogId;
    private int attrId;
    private GmsAttr gmsAttr;
    private GmsCatalog gmsCatalog;*/
}
