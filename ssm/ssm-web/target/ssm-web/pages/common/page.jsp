<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<div class="box-footer">
    <div class="pull-left">
        <div class="form-group form-inline">
           第${pageInfoo.pageNum}页，总共${pageInfoo.pages} 页，共${pageInfoo.total} 条数据。 每页
        <select id="selectPage" class="form-control" onchange="selectToPage();">
            <option value="1" <c:if test="${pageInfoo.pageSize==1}">selected</c:if>
            >1</option>
            <option value="2"  <c:if test="${pageInfoo.pageSize==2}">selected</c:if>
            >2</option>
            <option value="3" <c:if test="${pageInfoo.pageSize==3}">selected</c:if>
            >3</option>
            <option value="4" <c:if test="${pageInfoo.pageSize==4}">selected</c:if>
            >4</option>
            <option value="5" <c:if test="${pageInfoo.pageSize==5}">selected</c:if>
            >5</option>
        </select> 条
        </div>
    </div>

    <div class="box-tools pull-right">
        <ul class="pagination">
            <li><a href="#" onclick="toPage(1);" aria-label="Previous">首页</a></li>
            <li><a href="#" onclick="toPage(${pageInfoo.prePage});">上一页</a></li>
            <c:forEach items="${pageInfoo.navigatepageNums}" var="seq">
                <li><a href="#" onclick="toPage(${seq});">${seq}</a></li>
            </c:forEach>
            <li><a href="#" onclick="toPage(${pageInfoo.nextPage});">下一页</a></li>
            <li><a href="#"  onclick="toPage(${pageInfoo.pages});" aria-label="Next">尾页</a></li>
        </ul>
    </div>

</div>

<%--
    自定义javascript开始,实现分页
--%>
<script>

    // 获取菜单id
    var menuId = "${menuId}";

    function selectToPage(){
        // 获取选择的值
        var pageSize = $('#selectPage').val();
       // 请求
        window.location.href="${pageContext.request.contextPath}/"+menuId+"/list/1/"+pageSize;
    }

    function toPage(pageNum){
        window.location.href="${pageContext.request.contextPath}/"+menuId+"/list/"+pageNum+"/${pageInfoo.pageSize}";
    }
</script>
<%--
    自定义javascript结束，实现分页
--%>