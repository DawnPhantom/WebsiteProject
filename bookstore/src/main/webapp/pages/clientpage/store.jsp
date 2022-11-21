<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <%@include file="/pages/common/static.jsp" %>
    <title>商城</title>
    <link type="text/css" rel="stylesheet" href="res/css/store_style.css">

    <script type="text/javascript">
        $(function () {
            $("button.detail").click(function () {
                var bookID = $(this).attr("bookID");
                location.href = "client/clientServlet?action=detail&bookID=" + bookID;
            })
        })
    </script>
</head>

<body>
<%@include file="/pages/common/header.jsp" %>

<div id="main">
    <div id="book">
        <div style="text-align: center">
            <span></span>
        </div>
        <div class="book_cond">
            <form action="client/clientServlet" method="get">
                <input type="hidden" name="action" value="pagingByPrice">
                价格：<input type="text" name="lower_bound" value="${ param.lower_bound }">
                元 - <input type="text" name="upper_bound" value="${ param.upper_bound }"> 元
                <button>查询</button>
            </form>
        </div>

        <c:forEach items="${requestScope.pages.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.img_path}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <c:if  test="${fn:length(book.name)>9}">
                            <span class="sp2">${(fn:substring(book.name,0,9)).concat('...')}</span>
                        </c:if>
                        <c:if  test="${fn:length(book.name)<=9}">
                            <span class="sp2">${book.name}</span>
                        </c:if>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.inventory}</span>
                    </div>
<%--                    <div class="book_add">--%>
<%--                        <button style="margin-left: 75px" bookID="${book.id}" class="add_cart">加入购物车</button>--%>
<%--                    </div>--%>
                    <div class="book_detail">
                        <button style="margin-left: 75px" bookID="${book.id}" class="detail">查看详情</button>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>

</div>
<%@include file="/pages/common/page_stript.jsp" %>
</body>

</html>