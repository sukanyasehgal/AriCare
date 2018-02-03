<!--  ***********************************************************************
                 
	  File Name	            :     displayDoctorDetails.jsp
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	:  display details of a doctor
	  Date of First Release 	:  07-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  displaying information of a doctor


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  07-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change :

*********************************************************************** -->
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.aricent.configuration.*" %>  
 <%@page import="java.sql.*"%>
 <%@page import="com.aricent.pojofiles.*"%>  
 
<!DOCTYPE HTML>
<html>
<head>
<title>Doctor Details</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
	<style>a:visited {color: #007DAD;}</style>
</head>
<body>
	<!---start-wrap---->

	<!---start-header---->
	
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
                               <li><a href="about.jsp">About Us</a></li>                              
							

				<div class="clear"></div>
			</ul>
		</div>
	</div>
	</div>
	<!---End-header---->
	<!----start-content----->
	<div class="content">
		<div class="wrap">
			<div class="services1">
				<h4> </h4>
				
				<div class="content-top-grids services-grids">


					<div class="content-top-grid-pic">
						<a href="#"><img src="images\<c:out value="${doctor.getImage()}"/>" title="image-name" height="80px" width="150px"></a>
					</div>
					<div class="content-top-grid-title">
						<h3 style="color: #777; font-size: 1.5em">Dr. <c:out value="${doctor.getName()}"/></h3>
					</div>

					<div class="clear"></div>
					<p
						style="font-family: 'Open Sans', sans-serif; color: #777; font-size: 1.0em;">
						Timings : &nbsp;&nbsp;&nbsp;<c:out value="${doctor.getTimingToMeet()}"/></p>
					<p
						style="font-family: 'Open Sans', sans-serif; color: #777; font-size: 1.0em;">
						Qualification : &nbsp;<c:out value="${doctor.getQualification()}"/></p>
					<p
						style="font-family: 'Open Sans', sans-serif; color: #777; font-size: 1.0em;">
						Specialization : &nbsp;<c:out value="${doctor.getSpecialization()}"/></p>
					<p
						style="font-family: 'Open Sans', sans-serif; color: #777; font-size: 1.0em; ">
						Address : &nbsp;<c:out value="${doctor.getAddress()}"/></p>
					<p
						style="font-family: 'Open Sans', sans-serif; color: #777; font-size: 1.0em; ">
						Contact no. : &nbsp;<c:out value="${doctor.getContactNumber()}"/></p>
					<%   session=request.getSession(false);
					if(session.getAttribute("currentSessionUser")==null){ %>
					<a class="grid-button" href="login.jsp">Make appointment</a>
					<%  }else {%><a class="grid-button" href="BookAppointmentFromDoctorsPage.jsp?nid=<c:out value="${doctor.getName()}"/>">Make appointment</a>
					<%} %>
					
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
