<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <%@include file="/pages/common/static.jsp"%>
    <link type="text/css" rel="stylesheet" href="res/css/login_success_style.css">
    <title>书城登录页面</title>
</head>

<body>
    <jsp:forward page="/client/clientServlet?action=paging"></jsp:forward>
<%--    <%@include file="/pages/common/header.jsp"%>--%>
<%--    <div id="header">--%>
<%--        <div>--%>
<%--            <span>欢迎光临书城</span>--%>
<%--            <a href="/pages/order/order.jsp">查看订单</a>--%>
<%--            <a href="/pages/cart/cart.jsp">购物车</a>--%>
<%--            <a href="pages/main/bookstore.jsp">进入书城</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div id="main">--%>
<%--        <h1 href="/index.jsp">返回首页</h1>--%>
<%--    </div>--%>
</body>

</html>