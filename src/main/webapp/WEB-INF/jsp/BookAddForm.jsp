<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Book Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css" />");</style>
</head>
<body>

	<div id="global">
		<!-- commandName="book"中commandName已过时，现在应使用modelAttribute属性 -->
		<form:form modelAttribute="book" action="book_save" method="post">
			<fieldset>
				<legend>Add a book</legend>
				<p>
					<label for="category">Category: </label>
					<form:select id="category" path="category.id" items="${categories}" itemLabel="name" itemValue="id">
						<option value="0">--- Please Select ---</option>
						<form:option value="7" label="errrr">2345345345</form:option>
						<form:options path="category" items="${categories}" />
					</form:select>
				</p>
				<p>
					<form:errors path="*" />
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
				<%-- <p>
					<label for="password">Password: </label>
					<form:password id="password" path="password" value="2342" showPassword="true"/>
				</p>
				<p>
					<label for="password">Password: </label>
					<form:textarea id="password" rows="4" cols="80" path="password" />
				</p>
				<p>
					<label for="password">Password: </label>
					<form:checkbox id="password" label="rrrrrr" value="www" path="password" />
				</p>
				<p>
					<label for="password">Password: </label>
					<form:checkboxes path="category" items="${categories}" />
				</p>
				<p>
					<label for="password">Password: </label>
					<form:radiobutton id="password" label="ggg" value="ss" path="password" />
				</p>
				<p>
					<label for="password">Password: </label>
					<form:radiobuttons path="category" items="${categories}" />
				</p> --%>
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4"/>
					<input id="submit" type="submit" tabindex="5" value="Add Book"/>
				</p>
				<p></p>
			</fieldset>
		</form:form>
	</div>

</body>
</html>