<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<link
	href="${pageContext.request.contextPath }/assets/css/main.css"
	rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="form-style-5">
	<fieldset>
		<legend>Event Info</legend>
		<s:form method="post" commandName="event"
			action="${pageContext.request.contextPath }/event/edit.html">
			<table>
				<tr>
					<td>Name</td>
					<td><s:input path="name"/></td>
				</tr>
				<tr>
					<td valign="top">Description</td>
					<td><s:textarea path="description" cols="20" rows="5" /></td>
				</tr>
				<tr>
					<td>Start Date</td>
					<td>
						<fmt:formatDate var="startDate" 
							value="${event.startDate }" 
							pattern="yyyy/MM/dd"/>
						<input type="text" 
							name="startDate" 
							value="${startDate }" /></td>
				</tr>
				<tr>
					<td>End Date</td>
					<td>
						<fmt:formatDate var="endDate" 
							value="${event.endDate }" 
							pattern="yyyy/MM/dd"/>
						<input type="text" 
							name="endDate" 
							value="${endDate}" /></td>
				</tr>
								<tr>
					<td>Remind Before Time</td>
					
					<td><s:input type="time" path="time" value="${time}"/></td>
						
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>
						<input type="submit" value="Save" />
						<s:hidden path="id"/>
					</td>
				</tr>
			</table>
		</s:form>
		<a href="${pageContext.request.contextPath }/event/list.html">Back</a>
	</fieldset>
	</div>
</body>
</html>