<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Font -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600%7CUbuntu:300,400,500,700" rel="stylesheet">

	<!-- CSS -->

	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
	<link rel="stylesheet" href="css/nouislider.min.css">
	<link rel="stylesheet" href="css/plyr.css">
	<link rel="stylesheet" href="css/photoswipe.css">
	<link rel="stylesheet" href="css/default-skin.css">
	<link rel="stylesheet" href="css/plugins.css">
	<link rel="stylesheet" href="css/new.css">
	<link rel="stylesheet" href="css/bootstrap-reboot.min.css">
	<link rel="stylesheet" href="css/bootstrap-grid.min.css">
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="css/ionicons.min.css">
	<link rel="stylesheet" href="css/new2.css">

	<!-- Favicons -->
	<link rel="icon" type="image/png" href="icon/favicon-32x32.png" sizes="32x32">
	<link rel="apple-touch-icon" href="icon/favicon-32x32.png">
	<link rel="apple-touch-icon" sizes="72x72" href="icon/apple-touch-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="114x114" href="icon/apple-touch-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="144x144" href="icon/apple-touch-icon-144x144.png">

	<meta name="description" content="">
	<meta name="keywords" content="">
	<meta name="author" content="Dmitry Volkov">
	<title>FlixGo – Online Movies, TV Shows</title>

</head>
<body class="body">
<!-- header -->

	<header class="header">
		<div class="header__wrap">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div class="header__content">
							<!-- header logo -->
							<a href="index.html" class="header__logo">
								<img src="img/logo.svg" alt="">
							</a>
							<!-- end header logo -->

							<!-- header nav -->
							<ul class="header__nav">

								<li class="header__nav-item">
									<a href="pricing.html" class="header__nav-link">Movies</a>
								</li>

								<li class="header__nav-item">
									<a href="pricing.html" class="header__nav-link">TV Series</a>
								</li>

								<li class="header__nav-item">
									<a href="pricing.html" class="header__nav-link">Articals</a>
								</li>

								<li class="header__nav-item">
									<a href="faq.html" class="header__nav-link">About Us</a>
								</li>

								<!-- dropdown -->
								<li class="dropdown header__nav-item">
									<a class="dropdown-toggle header__nav-link header__nav-link--more" href="#" role="button" id="dropdownMenuMore" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="icon ion-ios-more"></i></a>

									<ul class="dropdown-menu header__dropdown-menu" aria-labelledby="dropdownMenuMore">
										<li><a href="about.html">Contact Us</a></li>
										<li><a href="signin.html">Sign In</a></li>
										<li><a href="signup.html">Sign Up</a></li>
									</ul>
								</li>
								<!-- end dropdown -->
							</ul>
							<!-- end header nav -->

							<!-- header auth -->
							<div class="header__auth">
								<button class="header__search-btn" type="button">
									<i class="icon ion-ios-search"></i>
								</button>

								<li class="header__nav-item" id="login">
									<a href="faq.html" class="header__nav-link">log in</a>
								</li>
								<a href="signin.html" class="header__sign-in" id="signin">
									<i class="icon ion-ios-log-in"></i>
									<span>sign in</span>
								</a>
							</div>
							<!-- end header auth -->

							<!-- header menu btn -->
							<button class="header__btn" type="button">
								<span></span>
								<span></span>
								<span></span>
							</button>
							<!-- end header menu btn -->
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- header search -->
		<form action="#" class="header__search">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div class="header__search-content">
							<input type="text" placeholder="Search for a movie, TV Series that you are looking for">

							<button type="button">search</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		<!-- end header search -->
	</header>
	<!-- end header -->


	<!-- page title -->
	<section class="section section--first section--bg" data-bg="img/section/section.jpg">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section__wrap">
						<!-- section title -->
						<h2 class="section__title">${REGISTERED_USER.name }'s Profile</h2>
						<!-- end section title -->

						<!-- breadcrumb -->
						<ul class="breadcrumb">
							<li class="breadcrumb__item"><a href="#">Home</a></li>
							<li class="breadcrumb__item breadcrumb__item--active">Account</li>
						</ul>
						<!-- end breadcrumb -->
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- end page title -->

	
	<div class="page-single">
		<div class="container">
			<div class="row ipad-width">
				<div class="col-md-3 col-sm-12 col-xs-12">
					<div class="user-information">
						<div class="user-img">
							<a href="#"><img src="images/uploads/user-img.png" alt=""><br></a>
							<a href="#" class="yellowbtn" id="account">Registered User</a>
						</div>
						<div class="user-fav">
							<p>Account Details</p>
							<ul>
								<li  class="active"><a href="userprofile.html">Profile</a></li>
								<li><a href="userfavoritelist.html">Favorite movies</a></li>
								<li><a href="userrate.html">Rated movies</a></li>
							</ul>
						</div>
						<div class="user-fav">
							<p>Others</p>
							<ul>
								<li><a href="login">Log out</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-9 col-sm-12 col-xs-12">
					<div class="form-style-1 user-pro" id="editform">
						<form action="user" method="post" class="user" id="form">
							<h4>Profile details</h4>
							<div class="row">
								<div class="col-md-6 form-it">
									<label>Username</label>
									<input type="text" placeholder="User Name" value="${REGISTERED_USER.username }" name="userName">
								</div>
								<div class="col-md-6 form-it">
									<label>Email Address</label>
									<input type="text" placeholder="Email" value="${REGISTERED_USER.email }" name="email">
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 form-it">
									<label>Name</label>
									<input type="text" placeholder="Name " value="${REGISTERED_USER.name }" name="name">
								</div>
								<div class="col-md-6 form-it">
									<label>Phone Number</label>
									<input type="text" placeholder="Phone Number" value="${REGISTERED_USER.mobile }" name="mobile">
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 form-it">
									<label>New Password</label>
									<input type="password" placeholder="***************" id="newPass1" name="newPassword">
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 form-it">
									<label>Confirm New Password</label>
									<input type="password" placeholder="*************** " id="newPass2" name="newPassword2">
								</div>
							</div>
							<div class="row">
								<div class="alert col-12" id="alert">
									  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
									  <strong>Something Wrong!</strong> Your passwords doesn't match.
									</div>							
								</div>
							<div class="row">
								<div class="col-md-2">
									<input class="submit" type="submit" value="save" id="submit">
								</div>
							</div>
							<input type="hidden" name="command" value="UPDATE">
							<input type="hidden" name="userId" value="${REGISTERED_USER.id }">	
							<input type="hidden" name="password" value="${REGISTERED_USER.password }">
						</form>
						
						<div class="row">
								<a class="submit" id="delete" href="user?command=DELETE&UserId=${REGISTERED_USER.id }">Delete Account</a>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	
	<a href="http://localhost:8091/Oop_demo1/RUserControllerServlet?command=DELETE&UserId=${REGISTERED_USER.id }">Delete account</a>


	
	<!-- footer -->
	<footer class="footer">
		<div class="container">
			<div class="row">
				<!-- footer list -->
				<div class="col-12 col-md-3">
					<h6 class="footer__title">Download Our App</h6>
					<ul class="footer__app">
						<li><a href="#"><img src="img/Download_on_the_App_Store_Badge.svg" alt=""></a></li>
						<li><a href="#"><img src="img/google-play-badge.png" alt=""></a></li>
					</ul>
				</div>
				<!-- end footer list -->

				<!-- footer list -->
				<div class="col-6 col-sm-4 col-md-3">
					<h6 class="footer__title">Resources</h6>
					<ul class="footer__list">
						<li><a href="#">Movies</a></li>
						<li><a href="#">TV Series</a></li>
						<li><a href="#">Articals</a></li>
					</ul>
				</div>
				<!-- end footer list -->

				<!-- footer list -->
				<div class="col-6 col-sm-4 col-md-3">
					<h6 class="footer__title">Legal</h6>
					<ul class="footer__list">
						<li><a href="#">About Us</a></li>
						<li><a href="#">Terms of Use</a></li>
						<li><a href="#">Privacy Policy</a></li>
						<li><a href="#">Security</a></li>
						<li><a href="#">Help</a></li>
					</ul>
				</div>
				<!-- end footer list -->

				<!-- footer list -->
				<div class="col-12 col-sm-4 col-md-3">
					<h6 class="footer__title">Contact</h6>
					<ul class="footer__list">
						<li><a href="tel:+18002345678">+1 (800) 234-5678</a></li>
						<li><a href="mailto:support@moviego.com">support@flixgo.com</a></li>
					</ul>
					<ul class="footer__social">
						<li class="facebook"><a href="#"><i class="icon ion-logo-facebook"></i></a></li>
						<li class="instagram"><a href="#"><i class="icon ion-logo-instagram"></i></a></li>
						<li class="twitter"><a href="#"><i class="icon ion-logo-twitter"></i></a></li>
						<li class="vk"><a href="#"><i class="icon ion-logo-vk"></i></a></li>
					</ul>
				</div>
				<!-- end footer list -->

				<!-- footer copyright -->
				<div class="col-12">
					<div class="footer__copyright">
						<small><a target="_blank" href="https://www.templateshub.net">Web Team</a></small>

						<ul>
							<li><a href="#">Terms of Use</a></li>
							<li><a href="#">Privacy Policy</a></li>
						</ul>
					</div>
				</div>
				<!-- end footer copyright -->
			</div>
		</div>
	</footer>
	<!-- end footer -->
	<!-- JS -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.mousewheel.min.js"></script>
	<script src="js/jquery.mCustomScrollbar.min.js"></script>
	<script src="js/wNumb.js"></script>
	<script src="js/nouislider.min.js"></script>
	<script src="js/plyr.min.js"></script>
	<script src="js/jquery.morelines.min.js"></script>
	<script src="js/photoswipe.min.js"></script>
	<script src="js/photoswipe-ui-default.min.js"></script>
	<script src="js/main.js"></script>
<!-- 	<script src="js/jquery.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/plugins2.js"></script>
	<script src="js/custom.js"></script> -->
	<script src="js/new.js"></script>

</body>

</html>