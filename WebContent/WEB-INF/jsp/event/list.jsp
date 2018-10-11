<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath }/assets/css/main2.css"
	rel="stylesheet" />
	<link
	href="${pageContext.request.contextPath }/assets/css/main.css"
	rel="stylesheet" />
</head>
<body>
<div class="container">
	
	  <div class="container2">
		<center><h1>Event List</h1></center>
		<div class="form-style-5">
	       <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search Event by names.." title="Type in a name"><br><br>
		</div>
		<table border="1" cellpadding="5" cellspacing="5" class="table"  id="myTable" >
			<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Remind me</th>
				<th>Remind Time </th>
				<th>Option</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="event" items="${events}">
				<tr class="table-row">
					<td>${event.id }</td>
					<td>${event.name }</td>
					<td>${event.startDate }</td>
					<td>${event.endDate }</td>
					<td>${event.remindme }</td>
					
					<td>${event.time}</td>
					<td>
						<a href="${pageContext.request.contextPath }/event/edit/${event.id }.html">Edit</a> | 
						<a href="${pageContext.request.contextPath }/event/delete/${event.id }.html">Delete</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<br>
		<div class="form-style-5">
		<a href="${pageContext.request.contextPath }/event.html">Back</a>
		</div>
	
	<script>
	function myFunction() {
		  var input, filter, table, tr, td, i;
		  input = document.getElementById("myInput");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("myTable");
		  tr = table.getElementsByTagName("tr");
		  for (i = 0; i < tr.length; i++) {
		    td = tr[i].getElementsByTagName("td")[1];
		    if (td) {
		      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
		        tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    }       
		  }
		}
</script>
</div>	
</body>
</html>