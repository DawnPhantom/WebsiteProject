<%--
  Created by IntelliJ IDEA.
  User: DAWN PHANTOM
  Date: 2022/11/21
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/pages/common/static.jsp" %>
    <title></title>
    <link type="text/css" rel="stylesheet" href="res/css/cart_style.css">
    <script type="text/javascript">
        $(function () {
            $("button.add_cart").click(function () {
                var bookID = $(this).attr("bookID");
                location.href = "client/cartServlet?action=add&bookID=" + bookID;
            })
        })
    </script>
</head>
<body>
<%@include file="/pages/common/header.jsp" %>
<div id="main">
    <div id="book">
        <table>
            <tr>
                <td>书名</td>
                <td>${requestScope.book.name}</td>
            </tr>
            <tr>
                <td>作者</td>
                <td>${requestScope.book.author}</td>
            </tr>
            <tr>
                <td>单价</td>
                <td>${requestScope.book.price}</td>
            </tr>
            <tr>
                <td>库存</td>
                <td>${requestScope.book.inventory}</td>
            </tr>
            <tr>
                <td>销量</td>
                <td>${requestScope.book.sales}</td>
            </tr>
        </table>
        <div class="book_add">
            <button style="margin-left: 75px" bookID="${requestScope.book.id}" class="add_cart">加入购物车</button>
        </div>
    </div>
</div>
</body>
</html>
