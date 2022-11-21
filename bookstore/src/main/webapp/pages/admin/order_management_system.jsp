<%--
  Created by IntelliJ IDEA.
  User: DAWN PHANTOM
  Date: 2022/11/15
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <%@include file="/pages/common/static.jsp" %>
    <title>订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="res/css/book_management_system_style.css">

    <script type="text/javascript">
        $(function () {
            $("a.deleteConfirm").click(
                function () {
                    return confirm("确认中止该订单？");
                }
            )
        })
    </script>

</head>
<body>
<%@include file="/pages/common/admin.jsp" %>
<div id="main">
    <table>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
<%--            <td><a class="action"--%>
<%--                   href="pages/admin/order_edit.jsp?page_No=${ requestScope.pages.page_Count }">添加订单</a></td>--%>
        </tr>

        <tr>
            <td>订单号</td>
            <td>用户id</td>
            <td>订单状态</td>
            <td>创建日期</td>
            <td>查看</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach items="${requestScope.pages.items}" var="order">
            <tr>
                <td>${order.orderid}</td>
                <td>${order.userid}</td>
                <c:if test="${order.orderStatus == 0}">
                <td>待付款</td>
                </c:if>
                <c:if test="${order.orderStatus == 1}">
                    <td>待发货</td>
                </c:if>
                <c:if test="${order.orderStatus == 2}">
                    <td>待收货</td>
                </c:if>
                <c:if test="${order.orderStatus == 3}">
                    <td>已收货</td>
                </c:if>
                <c:if test="${order.orderStatus == 4}">
                    <td>已取消</td>
                </c:if>
                <td>${order.date}</td>
                <td><a href="order/userOrderServlet?action=orderDetails&orderID=${order.orderid}&orderStatus=${order.orderStatus}">订单详情</a></td>
                <td>设置发货</td>
<%--                <td>--%>
<%--                    <a&lt;%&ndash;href="admin/bookServlet?action=query&id=${book.id}&page_No=${requestScope.pages.page_No}"&ndash;%&gt;>修改订单</a>--%>
<%--                </td>--%>
                <c:if test="${order.orderStatus == 0 || order.orderStatus == 1 || order.orderStatus == 2}">
                <td><a class="deleteConfirm"
                        href="admin/adminOrderServlet?action=cancelOrder&orderid=${order.orderid}&page_No=${requestScope.pages.page_No}">中止订单</a>
                </td>
                </c:if>
                <c:if test="${order.orderStatus == 3 || order.orderStatus == 4}">
                    <td></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>


    <%@include file="/pages/common/page_stript.jsp" %>

</body>
</html>
