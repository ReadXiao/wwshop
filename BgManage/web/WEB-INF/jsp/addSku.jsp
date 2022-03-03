<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../../static/css/bootstrap.min.css">
    <link href="../../static/css/bootstrap-theme.min.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <link href="../../static/css/fileUp.css" rel="stylesheet" type="text/css">
    <script src="../../static/js/addSku.js" type="text/javascript"></script>
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
<span id="spuId" hidden>${goodsId}</span>
<table width="100%" height="100%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="d5d4d4">
    <tr>
        <td height="22" colspan="4" background="../../images/bg.gif" bgcolor="#FFFFFF" class="STYLE3">
            <div align="center" id="ds">商品sku表</div>
        </td>
    </tr>

    <tr>
        <td colspan="4" bgcolor="#FFFFFF" class="STYLE1">
            <table width="70%" height="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="142" colspan="4" height="35" class="STYLE1" nowrap="nowrap">
                        商品名：${goodsName}
                    </td>
                </tr>
                <tr>
                    <td width="142" height="35" class="STYLE1" nowrap="nowrap">
                        <div align="left" class="dd">商品属性</div>
                    </td>
                    <td height="35" colspan="3" class="STYLE1">
                        <%--此处添加商品属性--%>
                        <div align="left" id="attrs">
                            <c:forEach var="attrs" items="${attrs}">
                                <span class="attrName">${attrs.attrName}:</span>
                                <input type="hidden" class="attrId" value="${attrs.attrId}">
                                <input type="text" class="attrValue">
                            </c:forEach>
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
