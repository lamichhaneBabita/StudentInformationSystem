

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%@ include file="header.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Edit Form</title>
</head>
<body>
	<div class="container">
		<div class="panel">
			<div class="panel-default">
				<div class="row">
					<div class="col-md-2"></div>

					<div class="col-md-8 jumbotron">

						<form action="update_student" method="post"
							enctype="multipart/form-data">
							<fieldset>
								<legend>Student Edit Form</legend>
								<div class="form-group">
									<label>Student Id:</label> <input type="text" name="id"
										readonly="readonly" value="${student.id}" class="form-control">
								</div>
								<div class="form-group">
									<label>Student Name:</label> <input type="text"
										name="studentName" value="${student.studentName}"
										class="form-control">
								</div>
								<div class="form-group">
									<label>Password:</label> <input type="password" name="password"
										value="${student.password}" class="form-control">
								</div>
								<div class="form-group">
									<label>Email:</label> <input type="email" name="email"
										value="${student.email}" class="form-control">

								</div>
								<div class="form-group">
									<label>Mobile No:</label> <input type="number" name="mobileNo"
										value="${student.mobileNo}" class="form-control">

								</div>
								<div class="form-group">
									<label>Dob :</label> <input type="date" name="dob"
										value="${student.dob}" class="form-control">

								</div>
								<div class="form-group">
									<label>Gender:</label> <input type="radio" name="gender"
										value="Male" ${student.gender=="Male"?"checked":""}>Male
									<input type="radio" name="gender" value="Female"
										${student.gender=="Female"?"checked":""}>Female
								</div>
								<div class="form-group">
									<label>Hobbies:</label> <input type="checkbox" name="hobbies"
										value="Reading" class="form-check"
										<c:if test = "${fn:contains(student.hobbies,'Reading')}">checked</c:if>>Reading
									<input type="checkbox" name="hobbies" value="Playing"
										class="form-check"
										<c:if test = "${fn:contains(student.hobbies, 'Playing')}">checked</c:if>>Playing
								</div>

								<div class="form-group">
									<label>nationality: </label> <select name="nationality"
										class="form-control">
										<option value="Nepali"
											${student.nationality=='Nepali'?'selected':''}>Nepali</option>
										<option value="Indian"
											${student.nationality=='Indian'?'selected':''}>Indian</option>
										<option value="American"
											${student.nationality=='American'?'selected':''}>American</option>
									</select>
								</div>
								<div>
									<div class="form-group">
										<label>Address:</label> <label>City Name: </label> <input
											type="text" name="address.cityName"
											value="${student.address.cityName}" class="form-control" />
									</div>
									<div class="form-group">
										<label>Country Name: </label> <input type="text"
											name="address.countryName"
											value="${student.address.countryName}" class="form-control" />
									</div>
								</div>
								
								<div class="form-group">
									<label>Role: </label> <input type="text" name="role"
										value="${student.role}" class="form-control" />
								</div>

								<div class="form-group">
									<label>Department: </label> <select name="department"
										class="form-control">
										<option value="IT" ${student.department=='IT'?'selected':''}>IT</option>
										<option value="COMPUTER"
											${student.department=='COMPUTER'?'selected':''}>COMPUTER</option>
										<option value="ELECTRONIC"
											${student.department=='ELECTRONIC'?'selected':''}>ELECTRONIC</option>
										<option value="ELECTRONIC"
											${student.department=='ELECTRICAL'?'selected':''}>ELECTRICAL</option>
									</select>
								</div>
								
								<div class="form-group">
									<label>Upload Photo:</label> <input type="file" name="file"
										class="form-control" value="${student.imageUrl}">

								</div>

								
								<div>
									<input type="submit" value="Submit" class="btn btn-success">
								</div>
							</fieldset>
						</form>

					</div>
					<div class="col-md-2"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>