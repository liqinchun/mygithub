<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/17
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="../include/fore/header.jsp"%>
商品搜索的展示页面
<table border="1px">
    <th>共多少条记录</th>
    <th>价格</th>
    <th>商城</th>
    <th>更新时间</th>
    <th>详情</th>
    <tbody>
    <tr>
        <td>url+名称</td>
        <td>price</td>
        <td>商城</td>
        <td>Date</td>
        <td>
            <a href="/product/detail">详情url</a></td>
    </tr>
    </tbody>

</table>
<%@include file="../include/fore/footer.jsp"%>
