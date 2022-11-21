<%--
  Created by IntelliJ IDEA.
  User: DAWN PHANTOM
  Date: 2022/11/24
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <%@include file="/pages/common/static.jsp" %>
    <title>用户浏览历史管理系统</title>
    <link type="text/css" rel="stylesheet" href="res/css/book_management_system_style.css">

    <script type="text/javascript">
        $(function () {
            $("a.deleteConfirm").click(
                function () {
                    return confirm("确认删除" + $(this).parent().parent().find("td:first").text() + "号历史记录？");
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
            <td>编号</td>
            <td>用户id</td>
            <td>书籍id</td>
            <td>书名</td>
            <td>作者</td>
            <td>日期</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach items="${requestScope.pages.items}" var="history">
            <tr>
                <td>${history.id}</td>
                <td>${history.userid}</td>
                <td>${history.bookid}</td>
                <td>${history.bookname}</td>
                <td>${history.author}</td>
                <td>${fn:substring(history.time,0,19)}</td>
                <td><a class="deleteConfirm" href="history/historyServlet?action=deleteHistory&id=${history.id}&page_No=${requestScope.pages.page_No}">删除</a></td>
            </tr>
        </c:forEach>
    </table>


    <%@include file="/pages/common/page_stript.jsp" %>
</div>

</body>

</html>