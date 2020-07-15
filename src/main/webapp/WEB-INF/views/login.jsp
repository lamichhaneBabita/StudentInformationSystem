
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="resources/login.css" />

<script src="resources/jquery.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/login.js"></script>




<div class="container">
	<div class="card card-container">
		<!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
		<img id="profile-img" class="profile-img-card"
			src="image-display?id=${id}" />
		<p id="profile-name" class="profile-name-card"></p>
		<span style="color: red;">${forgetMsg}</span>
		<form action="login_student" method="post" class="form-signin">
			<span style="color: red;">${msg}</span> <span id="reauth-email"
				class="reauth-email"></span> <input type="text" id="inputEmail"
				class="form-control" placeholder="studentName" name="studentName"
				value="${sname}" required autofocus> <input type="password"
				id="inputPassword" class="form-control" placeholder="Password"
				name="password" value="${spass}" required>
			<div id="remember" class="checkbox">
				<label> <input type="checkbox" value="remember-me"
					name="rememberMe"> Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block btn-signin"
				type="submit">Sign In</button>
		</form>
		<!-- /form -->
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#exampleModal" >Forgot the password?</button>


	</div>
	<!-- /card-container -->
</div>
<!-- /container -->


<!-- Button trigger modal -->

<!-- Modal -->

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

				<form action="forgot-password" method="post">
					<div class="form-group">
						<label> Email: </label> <input type="email" name="email"
							placeholder="Your email" class="form-control" />
					</div>
					<div class="form-group">

						<button type="submit" class="btn btn-primary">Send</button>

					</div>

				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div>
	</div>
</div>