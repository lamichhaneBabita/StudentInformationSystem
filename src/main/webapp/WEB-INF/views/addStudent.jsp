<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Information System</title>


<%@ include file="header.jsp"%>

</head>
<body>
	<div class="container">
		<div class="panel">
			<div class="panel-default">
				<div class="row">
					<div class="col-md-2"></div>

					<div class="col-md-8 jumbotron">

						<form action="save_student" method="post" class="form-horizontal"
							enctype="multipart/form-data">
							<fieldset>
								<legend>Student Registration System</legend>
								<div class="form-group">
									<label>Student Name:</label> <input type="text"
										name="studentName" class="form-control">
								</div>
								<div class="form-group">
									<label>Password:</label> <input type="password" name="password"
										class="form-control">
								</div>
								<div class="form-group">
									<label class="g">Email:</label> <input type="email"
										name="email" class="form-control">

								</div>
								<div class="form-group">
									<label class="g">Mobile No:</label> <input type="number"
										name="mobileNo" class="form-control">

								</div>
								<div class="form-group">
									<label class="g">Dob :</label> <input type="date" name="dob"
										class="form-control">

								</div>
								<div class="form-group">
									<label class="g">Gender:</label> <input type="radio"
										name="gender" value="Female">Female <input
										type="radio" name="gender" value="Male">Male

								</div>
								<div class="form-group">
									<label class="g">Hobbies:</label> <input type="checkbox"
										class="form-check" name="hobbies" class="g" value="Reading">Reading
									<input type="checkbox" name="hobbies" value="Playing"
										class="form-check">Playing

								</div>

								<div class="form-group">
									<label>Nationality</label> <Select name="nationality"
										class="form-control">
										<option value="nepali">Nepali</option>
										<option value="indian">Indian</option>
										<option value="American">American</option>

									</Select>
								</div>
								<div>
								<div class="form-group">
									<label class="g">City:</label> <input type="text"
										name="address.cityName" class="form-control">
								</div>		

									<div class="form-group">
										<label class="g">Country Name</label> <input type="text"
											name="address.countryName" class="form-control">

									</div>

								</div>
								
								<div class="form-group">
									<label class="g">Role:</label> <input type="text" name="role"
										class="form-control">

								</div>

								<div class="form-group">
									<label>Department</label> <Select name="department"
										class="form-control">
										<option value="it">IT</option>
										<option value="computer">COMPUTER</option>
										<option value="electrical">ELECTRICAL</option>
										<option value="electrical">ELECTRONIC</option>

									</Select>
								</div>
								
								<div class="form-group">
									<label>Upload Photo:</label> <input type="file" name="file"
										class="form-control">

								</div>

								<div class="form-group">
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