<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/transferServlet">
	转出账号<input type="text" name="outAcc"/><br/>
	转入账号<input type="text" name="inAcc"/><br/>
	转出金额<input type="text" name="amount"/><br/>
	<input type="submit"  value="转账"/><br/>
	<c:if test="${empty result }">
	
	</c:if>
	<c:if test="${!empty result }">
		<c:if test="${result==true}">
		转账成功！
		</c:if><br/>
		<c:if test="${result==false}">
		转账失败！
		</c:if><br/>
	</c:if>
	
</form>	
</body>
</html>