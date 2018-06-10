<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>


	<c:if test="${not empty toppers}">
		<table border=1>
			<CAPTION ><b> Toppers in ${location} age between ${agegroup} </b> </CAPTION>
			<col width="100">
			<col width="100">
			<col width="100">
			<tr>
				<TH>Student id</TH>
				<TH>Name</TH>
				<TH>Marks</TH>
				<c:forEach var="listValue" items="${toppers}">
					<tr>
						<td><c:out value="${listValue.id}" /></td>
						<td><c:out value="${listValue.name}" /></td>
						<td><c:out value="${listValue.marks}" /></td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	</c:if>
</body>
</html>