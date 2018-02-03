<!--  ***********************************************************************
                   
	  File Name	            :     login.jsp
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	:  login
	  Date of First Release 	:  08-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  displaying form to login


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  08-05-2016
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
		<title>Login Page</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		<style>a:visited {color: #007DAD;}</style>
		<script src="js/validation.js">
	</script>
		</head>
	<body>
					<div class="main-header">
						<div class="wrap">
							<div class="logo">
								<a href="index.jsp"><img src="images/logo222.png" title="logo" /></a>
							</div>
							<div class="right-left">
								<ul>
									<li class="login"><a href="login.jsp">Login</a></li>
					
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
								<li><a href="index.jsp">Home</a></li>
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
				  	<h3>Login</h3>
				  	<% if(request.getAttribute("valid")!=null){%>
				  	<p style="color:RED"> Incorrect User Id or password!</p>
				  	<% }%>
					    <form action="Login" method="post" name="form" onsubmit="return validateLogin()">
					    	<div>
						    	<span><label>Username</label></span>
						    	<input type="text"  name="uname" placeholder="Enter your phone number here">
						    </div>
						    <div>
						    	<span><label>Password</label></span>
						    	<input type="password" placeholder="Enter your password here" name="ps">
						    </div>
						   <div>
						   		<span><input type="submit" value="Submit"></span>
						  </div>
						  <div>
						    	<span><p>New user?&nbsp;</p>
						    	<li class="sign"><span><a href="Signup.jsp" type="submit">Sign up</a></span></li>
						    	
						    	</span>
						    	
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

