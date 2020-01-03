<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-3.4.1.min.js"></script> <!-- 引进jquery文件 -->
	<script type="text/javascript">
		$(function(){
			$(".delete").click(function(){
				var href = $(this).attr("href");
				$("form").attr("action",href).submit();
				return false;  //  如果不return那么会继续执行下面的代码 
			});
		})
	</script>
</head>
<body>
	<!-- 因为传过去的是Get请求，所以利用jquery来转换下 -->
	<form action="" method="POST" id="deleteForm">
		<input type="hidden" name="_method" value="DELETE">	
	</form>

	<!-- 使用jstl标签必须导入头文件 -->
	<c:if test="${!empty requestScope.department }">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Manager</th>
				<th>修改</th>
				<th>删除</th>
			</tr>
			
			<c:forEach items="${requestScope.department }" var="dpm">
				<tr>
					<td>${dpm.id }</td>
					<td>${dpm.name }</td>
					<td>${dpm.manager }</td>
					<td><a href="dpm/${dpm.id}">Edit</a></td>
					<td><a class="delete" href="dpm/${dpm.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br><br>
	<a href="dpm">新增</a>
</body>
</html>