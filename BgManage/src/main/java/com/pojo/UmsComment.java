package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 肖宏武
 * @date 2020/3/21 - 18:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsComment {
    private int id;
    private String spuId;
    private int userId;
    private String userName;
    private int likenum;
    private String comment;
    private int grade;
    private Date commentTime;
    private String goodsAttrs;
    private String commentPics;
    private String userPic;

}
