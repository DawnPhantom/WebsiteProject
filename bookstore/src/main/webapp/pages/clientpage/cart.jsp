<%--
  Created by IntelliJ IDEA.
  User: DAWN PHANTOM
  Date: 2022/11/10
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <%@include file="/pages/common/static.jsp" %>
    <title>商城</title>
    <link type="text/css" rel="stylesheet" href="res/css/cart_style.css">
    <script type="text/javascript">
        $(function () {
            $("a.deleteConfirm").click(
                function () {
                    return confirm("确认" + this.getAttribute("text") + "？");
                }
            )
        })
    </script>

    <script type="text/javascript">
        $(function () {
            $("a.create_order").click(
                function (){
                    var arr = document.getElementsByName("selected"); //通过name来获取遍历对象
                    var size = arr.length;
                    var selected = new Array();
                    var name = new Array();
                    for (i = 0; i < size; i++) {
                        if(arr[i].checked === true)
                        {
                            selected.push(arr[i].value);
                            name.push(arr[i].getAttribute("text"));
                        }
                    }
                    if(selected.length === 0){
                        alert("未选中商品");
                        return;
                    }
                    else
                    {
                        var str = "你已选中以下商品：";
                        for (i = 0; i < name.length; i++) {
                            str += "\n" + name[i];
                        }
                        if(!confirm(str))return;
                    }
                    var ret = prompt('请输入收货地址');
                    if(ret === null || ret === '') {
                        return;
                    }else selected.unshift(ret);
                    var data = { "array":selected };
                    var url = "order/userOrderServlet?action=createOrder";
                    $.ajax({
                        type: "post",
                        url: url,
                        data: data,
                        cache: false,
                        async: false,
                        dataType : 'json',
                        traditional: true
                    })
                    location.href="order/userOrderServlet?action=paging";

                }
            )
        })

    </script>
</head>

<body>
<%@include file="/pages/common/header.jsp" %>
    <div class="buttons">
        <a class="deleteConfirm" text="清空购物车" href="client/cartServlet?action=clear">清空购物车&nbsp;&nbsp;&nbsp;</a>|
        <a class="create_order">&nbsp;&nbsp;&nbsp;创建订单</a>
    </div>
    <div id="main">
    <div id="book">
        <table>
            <tr>
                <td>书名</td>
                <td>价格</td>
                <td>作者</td>
                <td>库存</td>
                <td>操作</td>
                <td>加入订单</td>
            </tr>
            <c:forEach items="${ requestScope.pages.items }" var="book">
                <tr>
                    <td>${book.name}</td>
                    <td>${book.price}</td>
                    <td>${book.author}</td>
                    <td>${book.inventory}</td>
                    <td><a class="deleteConfirm" text="从购物车中删除${book.name}"
                           href="client/cartServlet?action=delete&bookID=${book.id}&page_No=${ requestScope.pages.page_No }">删除</a>
                    </td>
                    <td><input type="checkbox" checked="checked" name="selected" value="${ book.id }" text="${book.name}"></td>
                </tr>
            </c:forEach>
        </table>
        <%@include file="/pages/common/page_stript.jsp" %>
    </div>
</div>
<%--<%@include file="/pages/common/page_stript.jsp" %>--%>
</body>

</html>