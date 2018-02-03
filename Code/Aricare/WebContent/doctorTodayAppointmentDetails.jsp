<!--  ***********************************************************************

	  File Name	            :     doctorTodayAppointmentDetails.jsp
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	:  Appointment details
	  Date of First Release 	:  12-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  displaying current day's appointments to doctor


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  12-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change :

*********************************************************************** -->
<%@page
	import="java.sql.*,java.text.SimpleDateFormat,java.text.DateFormat,java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.aricent.configuration.*" %>  
<%@page import="com.aricent.pojofiles.*"%>  
<%@page import="java.sql.*"%>
<%@page import="com.aricent.daofiles.*"%>
<%@page import="com.aricent.daointerfaces.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Today's Appointment Details</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/responsiveslides.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="js/responsiveslides.min.js"></script>
<script>
	// You can also use "$(window).load(function() {"
	$(function() {
		// Slideshow 1
		$("#slider1").responsiveSlides({
			maxwidth : 2500,
			speed : 600
		});
	});
</script>
<style type="text/css">
table.gridtable {
	position : absolute;
	top : 28%;
	left: 24%;
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}

table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}

table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
h4 {
	font-size: 1.5em;
	color: rgba(31, 31, 31, 0.99);
	font-family: 'Open Sans', sans-serif;
	padding: 10px 0px 0px 350px;
	margin-bottom: 13px;
	text-transform: uppercase;
}
</style>
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
							    height:380px;
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
								<tr><td><a href="http://localhost:8080/Aricare/doctorProfile.jsp">My Profile</a></td></tr>
								<tr><td><a href="doctorTodayAppointmentDetails.jsp">Today's Appointment</a></td></tr>	
								<tr><td><br></td></tr>	
								<tr><td><br></td></tr>
								<tr><td><br></td></tr>		
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
			<h4>Today's Appointments</h4>
	<div style="padding: 21em 10em 7em 0em">
		

		
          
		<!-- Table goes in the document BODY -->
		<span style="float: center">
			<table class="gridtable" ;  width="800" ;>
				
				<tr>
					<th style="text-align: center; font-weight: bold;"><b>Patient Name</b></th>
					<th style="text-align: center; font-weight: bold;"><b>Date</b></th>
		
					<th style="text-align: center; font-weight: bold;"><b>Timing</b></th>
					
				</tr>

					<%
				    LoginBean user=(LoginBean)session.getAttribute("currentSessionUser");
					 DisplayTodayAppointmentInterface appointment=new DisplayTodayAppointmentDAO();
				request.setAttribute("appointmentList",appointment.todayAppointment(user)); %>

				 <c:forEach items="${appointmentList}"  var="appointment">
				<tr>
					<td style="text-align: center"><c:out value="${appointment.getP_name()}"/></td>
					
					<td style="text-align: center"><c:out value="${appointment.getDate()}"/></td>
					
					
					<td style="text-align: center"><c:out value="${appointment.getTime()}"/></td>
					
					
				</tr>
				</c:forEach>
				</table>
		</span>
		

	</div>
			
		</div>
		<!---End-wrap---->
		<!---start-footer---->
		<%@ include file = "footer.html" %>
	<!---End-footer---->
</body>
</html>






		