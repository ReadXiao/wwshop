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
    <script src="../../static/js/updateAttr.js" type="text/javascript"></script>
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
            <div align="center" id="ds">商品属性表</div>
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
                        <div align="left">商品原价</div>
                    </td>
                    <td height="35" class="STYLE1">
                        <div align="left">
                            <input type="text" id="skuPrice" value="${skuPrice}">
                        </div>
                    </td>
                    <td height="35" class="STYLE1">
                        <div align="center" nowrap="nowrap">
                            会员价
                        </div>
                    </td>
                    <td height="35" class="STYLE1">
                        <div align="left">
                            <input type="text" id="discountPrice" value="${discountPrice}"/>
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
                            <input type="text" id="amount" value="${amount}"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height="40" class="STYLE1">&nbsp;</td>
                    <td height="35" colspan="3" class="STYLE1">
                        <input hidden id="skuId" value="${id}">
                        <input hidden id="spuId" value="${spuId}">
                        <input type="button" id="updateAttr" value="修改"/>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
