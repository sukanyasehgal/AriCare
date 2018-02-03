<!--  ***********************************************************************

	  File Name	            :     logout.jsp
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	:  logout
	  Date of First Release 	:  14-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  displaying page after log out


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  14-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change :

*********************************************************************** -->
<% 
 	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); 

	if(session.getAttribute("currentSessionUser")==null)
	{
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Logged Out</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
	</head>
	<body>
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
						<div class="clear"> </div>
						</div>
					</div>
					<div class="clear"> 
					</div>
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
				<div class="col span_2_of_3">
					<div class="contact-form">
				  	<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;You have logged out successfully</h3>
				  	<br><br><br><br><br><br><br><br><br>
						    </div>
				    </div>
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
		<% 

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.

response.setHeader("Pragma", "no-cache"); // HTTP 1.0.

response.setDateHeader("Expires", 0); // Proxies.

        session.setAttribute("currentSessionUser",null);

        session.invalidate();

     

%>

		
	</body>
</html>

