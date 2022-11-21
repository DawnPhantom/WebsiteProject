<%--
  Created by IntelliJ IDEA.
  User: DAWN PHANTOM
  Date: 2022/11/6
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <%@include file="/pages/common/static.jsp" %>
    <title>图书管理系统</title>
    <link type="text/css" rel="stylesheet" href="res/css/book_management_system_style.css">

    <script type="text/javascript">
        $(function () {
            $("a.deleteConfirm").click(
                function () {
                    return confirm("确认删除" + $(this).parent().parent().find("td:first").text() + "？");
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
            <td><a class="action" href="pages/admin/book_edit.jsp?page_No=${ requestScope.pages.page_Count }">添加图书</a></td>
        </tr>

        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach items="${requestScope.pages.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.inventory}</td>
                <td><a href="admin/bookServlet?action=query&id=${book.id}&page_No=${requestScope.pages.page_No}">修改</a></td>
                <td><a class="deleteConfirm" href="admin/bookServlet?action=delete&id=${book.id}&page_No=${requestScope.pages.page_No}">删除</a></td>
            </tr>
        </c:forEach>
    </table>


    <%@include file="/pages/common/page_stript.jsp" %>
</div>

</body>

</html>