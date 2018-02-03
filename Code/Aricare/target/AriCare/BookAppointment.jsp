<!--  ***********************************************************************
  
	  File Name	            :     BookAppointment.jsp
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	:  Book Appointment
	  Date of First Release 	:  08-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  displaying form to take appointment


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
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.aricent.configuration.*" %>  
 <%@page import="com.aricent.pojofiles.*"%>  
  <%@page import="com.aricent.daointerfaces.DisplayDoctorsInterface"%>
  <%@page import="com.aricent.daofiles.DisplayDoctorsDAO"%>
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
		<title>Book Appointment</title>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" type="text/css" href="css/jquery.datepick.css">
		<script type="text/javascript" src="js/jquery.plugin.js"></script> 
		<script type="text/javascript" src="js/jquery.datepick.js"></script>
		<link href="http://code.jquery.com/ui/1.10.4/themes/ui-darkness/jquery-ui.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
				<script src="js/validation.js">				
		</script>
		<script src="js/calendar.js">				
		</script>
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
			<div class="contact-form">
				  	<h3><span>Fill in the details to book your appointment</span></h3>
				  	 <% 
				  	if(request.getAttribute("duplicacystatus")!=null){%>
				  	<p style="color:RED">You already had an appointment at this time and date!</p>
				  	 <% } else if(request.getAttribute("doctorstatus")!=null){%>
				  	<p style="color:RED">doctor not available!</p>
				  	<% } else if(request.getAttribute("timestatus")!=null){%>
				  	<p style="color:RED">time slot already booked!</p>
				  	<% } else if(request.getAttribute("bookstatus")!=null){%>
				  	<p style="color:RED">Appointment booked!</p>
				  	<% }%>
					    <form action="BookAppointment" method="post" name="form" onsubmit="return validateBookAppointment()">
						    <div>
						    	<span><label>Doctor Name</label></span>
						    	<select name="doctor_name">
						    	<option value="0"  selected disabled> Choose any doctor</option>
						    	<%
				DisplayDoctorsInterface doctor = new DisplayDoctorsDAO();
				List<AddDoctorBean> doctorList = doctor.displayDoctor();
				request.setAttribute("doctorList",doctorList);
			
						
				%>
				<c:forEach items="${doctorList}"  var="doctor">
				  <option value = "<c:out value="${doctor.getId()}"/>"><c:out value="${doctor.getName()}"/> (<c:out value="${doctor.getSpecialization()}"/>)</option>
				 </c:forEach>
						    	</select>
						    	<br>
						    	<br>
						    	<span><label>Date</label></span>
						    	
						    	<input type="text" id="datepicker-13" onmouseover="calendarpick()" name="date" > 
						    	<br>
						    	<span><label>Time</label></span>
						    	<select name="timing" id="time" size="1" class="text_input">
						    	<option value="0"  selected disabled> Select Time</option>
		     					<option value="09:00:00"> 09:00 AM</option>
                     			<option value="09:30:00"> 09:30 AM</option>
                     			<option value="10:00:00"> 10:00 AM</option>
                     			<option value="10:30:00"> 10:30 AM</option>
                     			<option value="11:00:00"> 11:00 AM</option>
                     			<option value="11:30:00"> 11:30 AM</option>
		                     	<option value="12:00:00"> 12:00 AM</option>
		                     	<option value="12:30:00"> 12:30 AM</option>
		                     	<option value="02:30:00"> 02:30 PM</option>
		                     	<option value="03:00:00"> 03:00 PM</option>
		                     	<option value="03:30:00"> 03:30 PM</option>
		                     	<option value="04:00:00"> 04:00 PM</option>
		                     	<option value="04:30:00"> 04:30 PM</option>
		                     	<option value="05:00:00"> 05:00 PM</option>
		                     	<option value="05:30:00"> 05:30 PM</option>
		                     	<option value="06:00:00"> 06:00 PM</option>
                       </select>
						    	
						    	
						    	<input type="submit" value="submit" name="b1">
						    </div>
					    </form>
				    </div>
		</div>
		<!---End-wrap---->
		<!---start-footer---->
	<%@ include file = "footer.html" %>
	<!---End-footer---->
	
</body>
</html>
