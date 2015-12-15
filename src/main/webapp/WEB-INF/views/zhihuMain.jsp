<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- We don't need full layout here, because this page will be parsed with Ajax-->
<!-- Top Navbar-->
<div class="navbar">
  <div class="navbar-inner">
    <div class="left"><a href="#" class="back link"> <i class="icon icon-back"></i><span>Back</span></a></div>
    <div class="center sliding">Zhihu</div>
    <div class="right">
      <!-- Right link contains only icon - additional "icon-only" class--><a href="#" class="link icon-only open-panel"> <i class="icon icon-bars"></i></a>
    </div>
  </div>
</div>
<div class="pages">
  <!-- Page, data-page contains page name-->
  <div data-page="about" class="page">
    <!-- Scrollable page content-->
    <div class="page-content">
        <c:choose>
        	<c:when test="${not empty zhihuList }">
        		<c:forEach var="item" items="${zhihuList }">
        			<div class="card">
        				<div class="card-header">${item.name }${item.qtype }${item.qtitle }</div>
        				<c:if test="${not empty item.acontent }">
        					<div class="card-content">
                        		<div class="card-content-inner">${item.acontent}</div>
                        	</div>
        				</c:if>
        				<div class="card-footer">于 ${item.qtime }</div>
                      </div>
        		</c:forEach>
        	</c:when>
        	<c:otherwise>
        		<p>ERROR</p>
        	</c:otherwise>
        </c:choose>
    </div>
  </div>
</div>