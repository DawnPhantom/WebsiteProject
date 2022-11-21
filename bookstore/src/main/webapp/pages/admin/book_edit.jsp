<%--
  Created by IntelliJ IDEA.
  User: DAWN PHANTOM
  Date: 2022/11/6
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>

<head>
    <%@ include file="/pages/common/static.jsp" %>
    <title>${ empty param.id ? "添加书籍":"更新信息" }</title>
    <link type="text/css" rel="stylesheet" href="res/css/book_edit_style.css">
</head>

<body>
<%@include file="/pages/common/admin.jsp" %>

<div id="main">
    <form action="admin/bookServlet" method="post" accept-charset="UTF-8">
        <input type="hidden" name="page_No" value="${ param.page_No }">
        <input type="hidden" name="action" value="${ empty param.id ? "add":"update"}">
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="name" type="text" value="${requestScope.book.name}"/></td>
                <td><input name="price" type="text" value="${requestScope.book.price}"/></td>
                <td><input name="author" type="text" value="${requestScope.book.author}"/></td>
                <td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
                <td><input name="inventory" type="text" value="${requestScope.book.inventory}"/></td>
                <td colspan="2"><input type="submit" value="提交" /></td>
                <td><input name="id" type="hidden" value="${requestScope.book.id}"></td>
            </tr>
        </table>
    </form>


</div>


</body>

</html>