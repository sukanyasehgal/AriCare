<!--  ***********************************************************************
     
	  File Name	            :     about.jsp
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	:  About hospital
	  Date of First Release 	:  10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  displaying information about hospital


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
<%@page import="com.aricent.configuration.*" %> 
<%@page import="com.aricent.pojofiles.*" %>
 
<!DOCTYPE HTML>
<html>
<head>
<title>About</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
</head>
<body>
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
					<div class="clear"></div>
				</ul>
				<br>
				<div class="bottom-header-right">
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;9582745714</p>
				</div>
			</div>
			<div class="clear"></div>
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
	<div class="clear"></div>
	<div class="top-nav">
		<div class="wrap">
			<ul>
				<li><a href="index.jsp">Home</a></li>
				 <li><a href="DisplayDoctor">Doctors</a></li>
				<li><a href="Specialization.jsp">Specialization</a></li>
				<li><a href="services.jsp">Services</a></li>
				<li><a href="DisplayNews">News</a></li>
				<li class="active"><a href="about.jsp">About Us</a></li>
				
				<div class="clear"> </div>
			</ul>
		</div>
	</div>
	</div>
	<!---End-header---->
	<!----start-content----->
	<div class="content">
		<div class="wrap">

			<div class="about-topgrid1">

				<img src="images/slider2.jpg" title="name">
				<!--  --<h4>LOREM IPM DOLOR SIT AMET, CONSECTETUER ADIPISCING ELIT. PRAESENT VESTIBULUM.</h4>-->
				<h3>Who We Are</h3>
				<p>AriCare is a leading healthcare hospital located in Gurgaon,
					a well developed town in National Capital Region. The institution's
					vision is to provide medical services to patients with care and
					commitment.</p>
				<p>It aims of bringing to India the highest standards of medical
					care along with clinical research, education and training. It has
					650 beds and over 170 critical care beds with 25 operation
					theatres.</p>
			</div>
			<div class="about-histore">
				<h3>Our Values</h3>
				<div class="historey-lines">
					<ul>
						<li><span>Patient Centricity </span>
							<p>Treat patients and their caregivers with compassion, care
								and understanding. Our patients' needs will come first.</p></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="historey-lines">
					<ul>
						<li><span>Integrity &nbsp;</span></li>
						<li><p>Be principled, open and honest..</p></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="historey-lines">
					<ul>
						<li><span>Teamwork &nbsp;</span></li>
						<li><p>Proactively support each other and operate as one
								team. Respect and value people at all levels with different
								opinions, experiences and backgrounds.</p></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="historey-lines">
					<ul>
						<li><span>Ownership &nbsp;</span></li>
						<li><p>Take initiative and go beyond the call of duty.
								Deliver commitment and agreement made.</p></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="historey-lines">
					<ul>
						<li><span>Innovation &nbsp;</span></li>
						<li><p>Challenge ourselves to do things differently.</p></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			
			<div class="clear"></div>
		</div>
		<!----End-content----->
	</div>
	<!---End-wrap---->
	<!---start-footer---->

	<%@ include file = "footer.html" %>
	<!---End-footer---->
</body>
</html>

