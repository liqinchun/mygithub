<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/17
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="../include/fore/header.jsp"%>
<%@include file="../include/fore/top.jsp"%>
商品搜索的展示页面

    <table class="table table-dark">
        <th>搜索商品：${allProduct.size()}</th>
        <th>价格</th>
        <th>商城</th>
        <th>更新时间</th>
        <th>详情</th>
        <tbody>
<c:forEach  items="${allProduct}" var="product">
        <tr>
            <td>url+名称</td>
            <td>${product.productName}</td>
            <td>商城</td>
            <td>${product.createTime}</td>
            <td>
                <a href="/product/detail?productId=${product.productId}">${product.productName}详情</a></td>
        </tr>
</c:forEach>
        </tbody>

    </table>




<%@include file="../include/fore/footer.jsp"%>
