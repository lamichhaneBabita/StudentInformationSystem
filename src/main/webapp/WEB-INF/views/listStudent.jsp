
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>

</head>
<body>

	<div>
		<a href="add_student">Add Student</a>
	</div>
	<div>
		<h1>Student List</h1>
	</div>

	<c:if test="${!empty students}">
		<table class="table table-striped" border="3" style="color: blue;">
			<thead>
				<tr>
					<th>SN</th>
					<th>Id</th>
					<th>User Name</th>
					<th>Password</th>
					<th>Gender</th>
					<th>Hobbies</th>
					<th>Email</th>

					<th>DOB</th>
					<th>Mobile No</th>
					<th>Nationality</th>
					<th>Address</th>
					<th>Role</th>
					<th>Department</th>
					<th>Photo</th>

					<th>Actions</th>


				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student" varStatus="i">
					<tr>
						<td>${i.count}</td>
						<td>${student.id}</td>
						<td>${student.studentName}</td>
						<td>${student.password}</td>
						<td>${student.gender}</td>
						<td>${student.hobbies}</td>
						<td>${student.email}</td>


						<td>${student.dob}</td>

						<td>${student.mobileNo}</td>

						<td>${student.nationality}</td>

						<td>${student.address.cityName},${student.address.countryName}</td>
						<td>${student.role}</td>
						<td>${student.department}</td>
						<td><img src="image-display?id=${student.id}" width="50px"
							height="50px" alt="No picture"></td>

						<td><a href="edit_student?id=${student.id}">Edit</a>|<a
							href="delete_student?id=${student.id}">Delete</a></td>

					</tr>

				</c:forEach>
			</tbody>

		</table>
	</c:if>

</body>
</html>