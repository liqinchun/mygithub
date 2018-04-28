<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/17
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="../include/fore/header.jsp"%>
<%@include file="../include/fore/top.jsp"%>
商品的详情展示页面
<div>
    <img width="400px" src="${product.imageurl}"/>
</div>
<div>
    ${product.productName}
    <a href="#" title="历史价格" data-toggle="popover" data-placement="bottom" data-content="价格信息">历史价格</a>
    <a href="#">全网比价</a>
    <br>
    <button type="button" class="btn btn-sm" data-toggle="modal" data-target="#myModal">
        直达链接:
    </button>

    <!-- 模态框 -->
    <div class="modal fade" id="myModal">
        <div class="modal-dialog" id="history_price">
            <div class="modal-content">
                <div>
                    <h6 class="modal-title">您正在去往第三方网站，点击前往</h6>
                </div>

                <div class="modal-body">
                    <a href="${product.url}">${product.productName}</a>
                </div>

            </div>
        </div>
    </div>
    ${product.descripton}
</div>

<br>
<%--商品历史价格信息--%>
<div>
    <table class="table table-dark table-striped">
        <tr>
            <c:forEach items="${history_price}" var="price">
                <td>价格${price.price}&nsbp</td>

            </c:forEach>
        </tr>
        <tr>
            <c:forEach items="${history_price}" var="price">
                <td>时间${price.crateTime}</td>
            </c:forEach>
        </tr>

    </table>
</div>

<script>
    $(document).ready(function(){
        $('[data-toggle="popover"]').popover();
    });
</script>
<%@include file="../include/fore/footer.jsp"%>

