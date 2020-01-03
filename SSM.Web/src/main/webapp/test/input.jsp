<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="sp" value="<%=request.getContextPath() %>"></c:set>	
	<br><br>
	<form:form action="${sp }/dpm" modelAttribute="department" method="POST">
		
		<!-- 将修改和添加放在一个页面，如果id为null则表示新增 -->
		<c:if test="${department.id == 0}">
			Name:<form:input path="name"/>
		</c:if>
		<!-- 如果id不为null则表示修改 -->
		<c:if test="${department.id != 0}">
			<form:hidden path="id"/>
			<input type="hidden" name="_method" value="PUT"> <!-- 将post请求经过jquery转换之后再转换成PUT -->
			<%-- 对于_method不能使用form:hidden标签，因为modelAttribute对应的bean中没有_method这个属性 
				<form:hidden path="_method" value="PUT">
			--%>
		</c:if>
		<br>
		Manager:<form:input path="manager"/>
		<br>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>