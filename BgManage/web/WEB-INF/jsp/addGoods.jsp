<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/3/30
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../../static/css/bootstrap.min.css">
    <link href="../../static/css/bootstrap-theme.min.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/addGoods.js" type="text/javascript"></script>
    <link href="../../static/css/fileUp.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        body {
            margin-left: 5px;
            margin-top: 5px;
            margin-right: 5px;
            margin-bottom: 5px;
        }

        .STYLE1 {
            font-size: 12px
        }

        .STYLE3 {
            font-size: 12px;
            font-weight: bold;
        }
    </style>

</head>
<body>
<span id="allCatalog" hidden>${allCatalog}</span>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="d5d4d4">
    <tr>
        <td height="22" colspan="4" background="../../images/bg.gif" bgcolor="#FFFFFF" class="STYLE3">
            <div align="center" id="ds">商品表</div>
        </td>
    </tr>
    <tr>
        <td colspan="4" bgcolor="#FFFFFF" class="STYLE1">
            <table width="70%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="142" height="35" class="STYLE1" nowrap="nowrap">
                        <div align="left">商品类别</div>
                    </td>
                    <td width="352" height="35" class="STYLE1">
                        <div align="left" id="catalog">
                            <select name='catalog' class='selectCatalog' style='width:200px; height:17px; font-size:12px;'>
                            <option value="0"></option>
                            </select>
                        </div>
                    </td>
                    <td width="173" height="35" class="STYLE1" nowrap="nowrap">
                        <div align="left">商品名称</div>
                    </td>
                    <td width="188" height="35" class="STYLE1">
                        <div align="left">
                            <input type="text" id="goodsName" name="goodsName"
                                   style="width:200px; height:17px; font-size:12px; border:solid 1px #ccc; "/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="100" height="50" class="STYLE1" nowrap="nowrap" colspan="4">
                        <div align="left">上传商品图片</div>
                    </td>
                </tr>
                <tr>
                    <td height="70" colspan="4" class="STYLE1">
                        <div align="left">
                            <div class="d1" style="width: 50px"><b>图片：</b></div>
                            <div class="div">
                                <form enctype="mutipart/form-data">
                                <input type="text" class="mo">
                                <input type="file" class="file goodsPic"  name="file" id="spuPic" multiple="multiple" accept="image/*" onchange="showUploadImg('spuPic','showImg')"">
                                <button class="liuLan" style="">浏览</button>
                                </form>
                            </div>
                            <div><img id="showImg" style="width: 70px;height: 70px"><span style="width: 20px"></div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="142" height="35" colspan="4" class="STYLE1" nowrap="nowrap">
                        <div align="left">上传商品详情图</div>
                    </td>
                </tr>
                <form enctype="mutipart/form-data">
                <tr>
                    <td height="35" colspan="4" class="STYLE1">
                        <div align="left">
                            <div class="d1"><b>图片一：</b></div>
                            <div class="div">
                                <input type="text" class="mo">
                                <input type="file" class="file detailPic"  name="file1" id="detailPic1" multiple="multiple" accept="image/*" onchange="showUploadImg('detailPic1','showImg1')">
                                <button class="liuLan" style="">浏览</button>
                            </div>
                            <div><img id="showImg1" style="width: 70px;height: 70px"></div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="4"  height="70">
                        <div class="d1"><b>图片二：</b></div>
                        <div class="div">
                            <input type="text" class="mo">
                            <input type="file" class="file detailPic"  name="file1" id="detailPic2" multiple="multiple" accept="image/*" onchange="showUploadImg('detailPic2','showImg2')">
                            <button class="liuLan" style="">浏览</button>
                        </div>
                        <div><img id="showImg2" style="width: 70px;height: 70px"></div>

                        <div class="d1"><b>图片三：</b></div>
                        <div class="div">
                            <input type="text" class="mo">
                            <input type="file" class="file detailPic"  name="file1" id="detailPic3" multiple="multiple" accept="image/*" onchange="showUploadImg('detailPic3','showImg3')">
                            <button class="liuLan" style="">浏览</button>
                        </div>
                        <div><img id="showImg3" style="width: 70px;height: 70px"></div>
                    </td>
                </tr>
                </form>
                <tr>
                    <td width="142" height="35" class="STYLE1" nowrap="nowrap">
                        <div align="left">商品价格</div>
                    </td>
                    <td height="35" class="STYLE1">
                        <div align="left">
                            <input type="text" id="spuPrice" name="spuPrice">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="142" height="35" class="STYLE1">
                        <div align="center" nowrap="nowrap">
                            <div align="left">商品描述</div>
                        </div>
                    </td>
                    <td height="35" colspan="3" class="STYLE1">
                        <div align="left">
                            <textarea name="goodsDesc" id="goodsDesc" style=" width:600px; height:100px;"></textarea>
                            <span><span id="textNum">0</span>/100</span>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="142" height="35" class="STYLE1">
                        <div align="center" nowrap="nowrap">
                        </div>
                    </td>
                </tr>
            </table>
        </td>

    </tr>
    <tr>
        <td colspan="4" bgcolor="#FFFFFF" class="STYLE1">
            <table width="70%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="142" height="35" class="STYLE1" nowrap="nowrap"></td>
                    <td width="173" height="35" class="STYLE1" nowrap="nowrap"></td>
                </tr>
                <tr>
                    <td width="142" height="35" class="STYLE1" nowrap="nowrap">
                        <div align="left" class="dd">商品属性</div>
                    </td>
                    <td height="35" colspan="3" class="STYLE1">
                        <%--此处添加商品属性--%>
                        <div align="left" id="attrs">

                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="142" height="35" class="STYLE1" nowrap="nowrap">
                        <div align="left">商品原价</div>
                    </td>
                    <td height="35" class="STYLE1">
                        <div align="left">
                            <input type="text" id="skuPrice">
                        </div>
                    </td>
                    <td height="35" class="STYLE1">
                        <div align="center" nowrap="nowrap">
                            会员价
                        </div>
                    </td>
                    <td height="35" class="STYLE1">
                        <div align="left">
                            <input type="text" id="discountPrice"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="142" colspan="4" height="35" class="STYLE1">
                        <div align="center" nowrap="nowrap">
                            <div align="left">上传商品属性图</div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height="80" colspan="4" class="STYLE1" style="text-align: center">
                        <div align="left">
                            <div class="d1" style="width: 50px"><b>图片：</b></div>
                            <div class="div">
                                <form enctype="mutipart/form-data">
                                <input type="text" class="mo">
                                <input type="file" class="file attrPic"  name="file1" id="attrPic" multiple="multiple" accept="image/*" onchange="showUploadImg('attrPic','showImg4')">
                                <button class="liuLan" style="">浏览</button>
                                </form>
                            </div>
                            <div><img id="showImg4" style="width: 70px;height: 70px"></div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="142" height="35" class="STYLE1">
                        <div align="center" nowrap="nowrap">
                            <div align="left">商品数量</div>
                        </div>
                    </td>
                    <td height="35" colspan="3" class="STYLE1">
                        <div align="left">
                            <input type="text" id="amount"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height="40" class="STYLE1">&nbsp;</td>
                    <td height="35" colspan="3" class="STYLE1"><input type="button" id="uploadGoods" value="上传商品"/></td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
