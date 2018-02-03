<!--  ***********************************************************************

	  File Name	            :     Signup.jsp
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	:  Signup
	  Date of First Release 	:  11-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  displaying form to signup


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  11-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change :

*********************************************************************** -->
<% 
 	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); 

	if(session.getAttribute("currentSessionUser")!=null)
	{
		response.sendRedirect("index.jsp");
	}
%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>Sign Up</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		

		
	</head>
<script src="js/validation.js">
	
	</script>
	<body>
		<!---start-wrap---->
		
			<!---start-header---->
			
					
					<div class="main-header">
						<div class="wrap">
							<div class="logo">
								<a href="index.jsp"><img src="images/logo222.png" title="logo" /></a>
							</div>
							<div class="right-left">
								<ul>
									<li class="login"><a href="http://localhost:8080/Aricare/login.jsp">Login</a></li>
									<div class="clear"> </div>
								</ul>
								<br>
								<div class="bottom-header-right">
							<p> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;9582745714</p>
							</div>
							</div>
							<div class="clear"> </div>
						</div>
					</div>
					<div class="clear"> </div>
					<div class="top-nav">
						<div class="wrap">
							<ul>
								<li ><a href="index.jsp">Home</a></li>
                                <li><a href="DisplayDoctor">Doctors</a></li>
                                <li><a href="Specialization.jsp">Specialization</a></li>
								<li><a href="services.jsp">Services</a></li>
								<li><a href="DisplayNews">News</a></li>
								<li><a href="about.jsp">About Us</a></li>
								<div class="clear"> </div>
							</ul>
						</div>
					</div>
			</div>
			<!---End-header---->
			<!----start-content----->
			<div class="content">
				<div class="wrap">
					<!---start-contact---->
					<div class="contact">
						<div class="section group">				
				<div class="col span_1_of_3">
					<div class="contact-form">
				  	<h3>Create Your Account</h3>
				  		<% 
				  	if(request.getAttribute("statusTrue")!=null){%>
				  	<p style="color:RED">Already registered user!</p>
				  	<% } else if(request.getAttribute("statusFalse")!=null){%>
				  	<p style="color:RED">Registered successfully !</p>
				  	<% }%>
					    <form action="Signup" method="post" name="form" onsubmit="return validateSignUp()">
						    <div>
						    	<span><label>Name</label></span>
						    	<span><input type="text" placeholder="Enter your name here" name="name"></span>
						    	<span><label>Contact Number</label></span>
						    	<span><input type="text" placeholder="Enter your Mobile Number" name="phone_number"></span>
						    	<span><label>Address</label></span>
						    	<span><input type="text" placeholder="Enter your Address" name="address"></span>
						    	<span><label>Email ID</label></span>
						    	<span><input type="text" placeholder="Enter your email id" name="email_id"></span>
						    	<br>
						    	
						    	<span><label>Password</label></span>
						    	<span><input type="password" placeholder="Enter your password here" name ="password"></span>
						    	<span><label>Reenter Password</label></span>
						    	<span><input type="password" placeholder="Re-enter your password here" name="rePassword"></span>
						    	<input type="submit" value="submit" name="b1">
						    </div>
					    </form>
				    </div>
				</div>				
				<div class="col span_2_of_3">
				  
  				</div>				
			  </div>
					</div>
					<!---End-contact---->
				<div class="clear"> </div>
				</div>
			<!----End-content----->
		</div>
		<!---End-wrap---->
		<!---start-footer---->
		<%@ include file = "footer.html" %>
	<!---End-footer---->
	
</body>
</html>
