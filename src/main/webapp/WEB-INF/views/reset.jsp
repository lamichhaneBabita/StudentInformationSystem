<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="resources/resetPassword.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="resources/jquery.js"></script>
<script type="text/javascript"
	src="resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/resetPassword.js"></script>




<div class="container">
	<div class="row">
		<div class="col-sm-4">
			<form class="form-signin" action="reset-pass" method=post>

				<span style="color: red;">${passwordNotMatched}</span> <label>Current
					Password</label>
				<div class="form-group pass_show">
					<input id="inputPassword" placeholder="Old Password"
						type="password" name="oldPassword" value="${student.password}"
						class="form-control">
				</div>
				<label>New Password</label>
				<div class="form-group pass_show">
					<input id="newPassword" type="password" placeholder="New Password"
						name="newPassword" class="form-control">
				</div>
				<button class="btn btn-info btn-block btn-signin" type="submit">Reset</button>
			</form>


		</div>
	</div>
</div>