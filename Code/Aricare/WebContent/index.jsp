<!--  ***********************************************************************
                  
	  File Name	            :     index.jsp
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	:  home page
	  Date of First Release 	:  08-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  displaying home page


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  08-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change :

*********************************************************************** -->
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.aricent.pojofiles.*"%>  
 <%@page import="com.aricent.configuration.*" %>
  <% 
 	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); 

%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Home Page</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="css/responsiveslides.css">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		<script src="js/responsiveslides.min.js"></script>
		  <script>
		    // You can also use "$(window).load(function() {"
			    $(function () {
			      // Slideshow 1
			      $("#slider1").responsiveSlides({
			        maxwidth: 2500,
			        speed: 600
			      });
			});
		  </script>
	</head>
	<body>
		<!---start-wrap---->
		
			<!---start-header---->
		<!--  	<div class="header">
					<div class="top-header">
						<div class="wrap">
						<div class="top-header-left">
							
						</div>
						<div class="right-left">
							<ul>
							
							<li><a href="#"><img src="images/twitter.png" title="twitter" /></a></li>
							<li><a href="#"><img src="images/feed.png" title="Rss" /></a></li>
						    </ul>
						</div>
						<div class="clear"> </div>
					</div>
				</div> -->
					<%   session=request.getSession(false);
					if(session.getAttribute("currentSessionUser")==null){ %>
					<div class="main-header">
						<div class="wrap">
							<div class="logo">
								<a href="index.jsp"><img src="images/logo222.png" title="logo" /></a>
							</div>
							<div class="right-left">
								<ul>
								<li class="login"><a href="login.jsp">Login</a></li>
					              <li class="sign"><a href="Signup.jsp">Sign up</a></li>
									
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
					<%  }else {%>
					<div class="main-header">
						<div class="wrap">
							<div class="logo">
								<a href="index.jsp"><img src="images/logo222.png" title="logo" /></a>
							</div>
							<div class="right-left">
								<ul>
									<% 
									String userName = (String)session.getAttribute("userName");
									String forwardPage = (String)session.getAttribute("forwardPage"); 
										%>
										<style>
										.kmodify
										{font-family: 'Open Sans', sans-serif;
										color: #0073e6;
										font-weight: bold;
										}
										</style>
										<li class="kmodify"><a href="<%=forwardPage%>">Welcome <%=userName %></a></li>
									
									
									<li class="logout"><a href="logout.jsp">Logout</a></li>
					              
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
					
					<% } %>
					
					
					
					
					<div class="clear"> </div>
					<div class="top-nav">
						<div class="wrap">
							<ul>
								<li class="active"><a href="index.jsp">Home</a></li>
                                <li><a href="DisplayDoctor">Doctors</a></li>
                                <li><a href="Specialization.jsp">Specialization</a></li>
								<li><a href="services.jsp">Services</a></li>
								<li><a href="DisplayNews">News</a></li>
                                <li><a href="about.jsp">About Us</a></li>                              
							
                                                                
								<div class="clear"> </div>
							</ul>
						</div>
					</div>
			
             
			<!---End-header---->
			<!---start-images-slider---->
			<div class="image-slider">
						<!-- Slideshow 1 -->
					    <ul class="rslides rslides1" id="slider1" style="max-width: 2500px;">
					      <li id="rslides1_s0" class="" style="display: block; float: none; position: absolute; opacity: 0; z-index: 1; -webkit-transition: opacity 600ms ease-in-out; transition: opacity 600ms ease-in-out;">
					      	<img src="images/slider4.jpg" alt="">
					      	<div class="aayutray">
					      		<marquee behavior="slide" direction="right" scrollamount="13" width="180%" height="100%">AriCare - the leading multi-speciality hospital</marquee>
							
					      	</div>
					      </li>
					      <li id="rslides1_s1" class="" style="float: none; position: absolute; opacity: 0; z-index: 1; display: list-item; -webkit-transition: opacity 600ms ease-in-out; transition: opacity 600ms ease-in-out;"><img src="images/treatment.jpg" alt="">
					      	<div class="aayutray">
					      		<marquee behavior="slide" direction="right" scrollamount="14" width="200%" height="100%">You have a disease, we have a treatment</marquee>
					      		
					      		<!--  <a href="#">ReadMore</a>-->
					      	</div>
					      </li>
					      <li id="rslides1_s2" class="rslides1_on" style="float: left; position: relative; opacity: 1; z-index: 2; display: list-item; -webkit-transition: opacity 600ms ease-in-out; transition: opacity 600ms ease-in-out;"><img src="images/hospital.jpg" alt="">
					      	<div class="aayutray">
					      		<marquee behavior="slide" direction="right" scrollamount="14" width="150%" height="100%">How about a health visit? - Book your health check now</marquee>
					      		
					      		
					      	</div>
					      </li>
					    </ul>
						 <!-- Slideshow 2 -->
					</div>
			<!---End-images-slider---->
			<!----start-content----->
			<div class="content">
				<div class="content-top-grids">
					<div class="wrap">
						<div class="content-top-grid">
							
					</div>
				</div>
				<div class="clear"> </div>
				<div class="boxs">
					<div class="wrap">
						<div class="section group">
							<div style="width:45%" class="grid_1_of_3 images_1_of_3">
								  <h3>WELCOME!</h3>
								  <p>Aricare is a leading healthcare hospital located in Gurgaon,a well developed town in National Capital Region.Founded by Chairman Mr Karaman Dev,with a vision to provide medical services to patients with care and commitment.</p>
										<p>The institution aims of bringing to India the highest standards of medical care along with clinical research, education and training.</p>
								  <span>.</span>
								  
							</div>
							<div style="width:50%" class="grid_2_of_3 images_1_of_3">
								  <h3>ABOUT US</h3>
								  <span></span>
								  	
								  		<p>Aricare offers latest technology and best treatment facilities at an affordable cost.</p>
											<p>It has 650 beds and over 170 critical care beds with 25 operation theatres. </p>
											<p>AriCare is driven by patient needs, comfort and trust.</p>
								  <span></span>
								 
							</div>
						
								 <!---End-footer---->
								 </div>
					</div>
					</div>
		
		<!---End-wrap---->
		<!---start-footer---->
		<%@ include file = "footer.html" %>
	<!---End-footer---->
</body>
</html>