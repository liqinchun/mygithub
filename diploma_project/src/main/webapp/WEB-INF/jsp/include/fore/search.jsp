
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"
         pageEncoding="UTF-8" %>
<style>

    div.searchDiv{
        background-color: #e6ebef ;
        width: 640px;
        margin: 50px auto;
        height: 36px;
        display: block;
    }
    div.searchDiv input{
        width: 540px;
        margin-top: 0px;
        margin-left: 1px;
        border: 1px solid transparent;
        height: 34px;
    }
    div.searchDiv input.searchButton{
        width: 94px;
        background-color: #42a1ff ;
        height: 33px;
        color: white;
        border: 1px solid transparent;
        font-size: 15px;
        font-family: arial;
    }
</style>


<h1>Logo</h1>
<%--主页搜索栏--%>
<form action="foresearch" method="post" >
    <div class="searchDiv">
        <input name="keyword" type="text" value="">
        <input  type="submit" name="searchButton" class="searchButton" value="搜    索"/>
        <%--<div class="searchBelow">--%>
            <%--<c:forEach items="${cs}" var="c" varStatus="st">--%>
                <%--<c:if test="${st.count>=5 and st.count<=8}">--%>
						<%--<span>--%>
							<%--<a href="forecategory?cid=${c.id}">--%>
                                    <%--${c.name}--%>
                            <%--</a>--%>
							<%--<c:if test="${st.count!=8}">--%>
                                <%--<span>|</span>--%>
                            <%--</c:if>--%>
						<%--</span>--%>
                <%--</c:if>--%>
            <%--</c:forEach>--%>
        <%--</div>--%>
    </div>
</form>

<h1>下面展示网站基本信息，类似百度</h1>