<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Book Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css" />");</style>
</head>
<body>

	<div id="global">
		<!-- commandName="book"中commandName已过时，现在应使用modelAttribute属性 -->
		<form:form modelAttribute="book" action="../book_update" method="post">
			<fieldset>
				<legend>Edit a book</legend>
				<form:hidden path="id"/>
				<p>
					<label for="category">Category: </label>
					<form:select id="category" path="category.id" items="${categories}" itemLabel="name" itemValue="id"/>
				</p>
				<p>
					<label for="title">Title: </label>
					<form:input id="title" path="title"/>
				</p>
				<p>
					<label for="author">Author: </label>
					<form:input id="author" path="author"/>
				</p>
				<p>
					<label for="isbn">ISBN: </label>
					<form:input id="isbn" path="isbn"/>
				</p>
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4"/>
					<input id="submit" type="submit" tabindex="5" value="Update Boook"/>
				</p>
			</fieldset>
		</form:form>
	</div>

</body>
</html>