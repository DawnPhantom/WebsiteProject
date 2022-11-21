<%--
  Created by IntelliJ IDEA.
  User: DAWN PHANTOM
  Date: 2022/11/9
  Time: 12:25
  分页条
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="res/css/common/page_stript.css">
<script type="text/javascript">
    $(function () {
        $("#set_page").click(function () {
            var page_No = $("#pd_input").val();
            var page_count = ${ requestScope.pages.page_Count };
            if (page_No > page_count) page_No = page_count;
            if (page_No < 1) page_No = 1;
            location.href = "${ requestScope.pages.url }&page_No=" + page_No;
        })
    })
</script>

<div id="page_nav">
    <br>
    <a href="${ requestScope.pages.url }&page_No=1">首页</a>
    <c:if test="${requestScope.pages.page_No>1}">
        <a href="${ requestScope.pages.url }&page_No=${requestScope.pages.page_No-1}">上一页</a>
    </c:if>
    【第 ${ requestScope.pages.page_No } 页】
    <c:if test="${requestScope.pages.page_No<requestScope.pages.page_Count}">
        <a href="${ requestScope.pages.url }&page_No=${requestScope.pages.page_No+1}">下一页</a>
    </c:if>
    <a href="${ requestScope.pages.url }&page_No=${ requestScope.pages.page_Count }">尾页</a>
    <br>
    共${ requestScope.pages.page_Count }页，${ requestScope.pages.counter }条记录
    转到第<input value="${ param.page_No }" name="pn" id="pd_input" style="width: 50px">页
    <input id="set_page" type="button" value="确定">
</div>