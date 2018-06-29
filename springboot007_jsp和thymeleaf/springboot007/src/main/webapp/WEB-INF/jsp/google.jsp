<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	百度一下你就知道
	${name }
	<hr>
	<form action="<%=request.getContextPath() %>/google/jie" method="post">
		<input type="text" name="hello" />
		<input type="submit" value="点我" />
	</form>
	<hr>
	<form action="<%=request.getContextPath() %>/google/yueshu" method="post">
		<input type="text" name="haha" />
		<input type="submit" value="约束类型" />
	</form>
</body>
</html>