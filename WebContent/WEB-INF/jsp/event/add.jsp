<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link
	href="${pageContext.request.contextPath }/assets/css/main.css"
	rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function myFunction() {
    var checkBox = document.getElementById("myCheck");
    var text = document.getElementById("text");
    if (checkBox.checked == true){
        text.style.display = "block";
    } else {
       text.style.display = "none";
    }
}
</script>
</head>
<body>
<div class="form-style-5">
	<fieldset>
		<legend>Event Info</legend>
		<s:form method="post" commandName="event"
			action="${pageContext.request.contextPath }/event/add.html">
			<table>
				<tr>
					<td>Name</td>
					<td><s:input path="name" /></td>
				</tr>
				<tr>
					<td valign="top">Description</td>
					<td><s:textarea path="description" cols="20" rows="5" /></td>
				</tr>
				<tr>
					<td>Start Date</td>
					<td><input type="text" name="startDate"  /></td>
					<td>eg:-2018/01/01</td>
				</tr>
				<tr>
					<td>End Date</td>
					<td><input type="text" name="endDate"  /></td>
					<td>eg:-2018/01/01</td>
				</tr>
				<tr>
					<td>remind me </td>
					<td><input type="checkbox" id="myCheck"  onclick="myFunction()" name="remindme"  value="true" /></td>
				</tr>
				<tr id="text" style="display:none">
					<td>remind before Time </td>
					<td><input type="time" name="time"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="Save" /></td>
				</tr>
			</table>
		</s:form>
		<a href="${pageContext.request.contextPath }/event.html">Back</a>
	</fieldset>
	</div>
</body>
</html>