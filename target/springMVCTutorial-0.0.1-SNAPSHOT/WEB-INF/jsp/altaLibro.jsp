<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="./altaLibro.do" modelAttribute="libro">
<form:label path="title">Title:</form:label>
<form:input path="title"/>
<form:label path="author">Author:</form:label>
<form:input path="author"/>
<form:label path="price">Price:</form:label>
<form:input path="price"/>
<input type="submit" value="Aceptar" name="submit">
</form:form>
</body>
</html>