<!--  ***********************************************************************
         
	  File Name	            :     patientProfile.jsp
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	:  Show patient Details
	  Date of First Release 	:  15-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  displaying all information of patient


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  15-05-2016
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
  <%@page import="com.aricent.daofiles.*"%> 
  <%@page import="com.aricent.daointerfaces.*"%>
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
<title>Patient Profile</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
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
							
								<div class="clear"> </div>
							</ul>
						</div>
					</div>
			</div>
			<!---End-header---->
			<!----start-content----->
			<div class="content">
					<!---start-contact---->
					<div class="contact">
						<div class="section group">	
												
			  			</div>
			  			
							</div>
					</div>
					<style>
							.nav 
							{
    							line-height:45px;
							    background-color:#808080;
							    height:fixed;
							    width:230px;
							    float:left;
							    padding:5px;
							    padding-top: 30px;
							    	      
							}	
							.nav a 
							{
								padding: 8px 8px 8px 32px;
								text-decoration: none;
								font-size: 20px;
								color: #ffffff;
								display: block;
								transition: 0.3s
							}
							.nav a:hover, .offcanvas a:focus
							{
								 color: #007DAD;
								 font-weight:bold;
							}	
							</style>
							<div class="nav">
							<table style="width:100">
								<tr><td><a href="http://localhost:8080/Aricare/patientProfile.jsp">My Profile</a></td></tr>
								<tr><td><a href="BookAppointment.jsp">Book Appointment</a></td></tr>	
								<tr><td><a href="displayPillDetails.jsp">Medicine Details</a></td></tr>	
								<tr><td><a href="displayAppointmentHistory.jsp">Appointment History</a></td></tr>
							</table>
							<br><br><br>
					<!---End-contact---->
				<div class="clear"> </div>
				<style>
				#section_to_work 
				{
		    			width:70%;
		    			height:50%;
		   	 			float:left;
		   				padding:10px;	 	 
				}
				</style>
				
			<!----End-content----->
		</div>
		<div id="section_to_work" style="width:1000px;height:395px;background:#F6F6F6">
			<div class="services1">
				<h4>My Profile</h4>
			
				<div class="content-top-grids services-grids">

				<%
				    LoginBean user=(LoginBean)session.getAttribute("currentSessionUser");
					PatientProfileInterface obj=new PatientProfileDAO();
				request.setAttribute("patient",obj.displayPatient(user)); %>

					<div class="clear"></div>
					<p
						style="font-family: 'Open Sans', sans-serif; color: #777; font-size: 1.0em; ">
						Name : &nbsp;<c:out value="${patient.getP_name()}"/></p><br>
					<p
						style="font-family: 'Open Sans', sans-serif; color: #777; font-size: 1.0em; ">
						Address : &nbsp;<c:out value="${patient.getAddress()}"/></p><br>
					<p
						style="font-family: 'Open Sans', sans-serif; color: #777; font-size: 1.0em; ">
						Contact no. : &nbsp;<c:out value="${patient.getPhone_number()}"/></p><br>
						<p
						style="font-family: 'Open Sans', sans-serif; color: #777; font-size: 1.0em; ">
						Email-id : &nbsp;<c:out value="${patient.getEmail_id()}"/></p><br>
					
					<div class="clear"></div>
				</div>
				

				<!----End-content----->
			</div>
		</div>
		<!---End-wrap---->
		<!---start-footer---->
		<%@ include file = "footer.html" %>
	<!---End-footer---->
</body>
</html>
