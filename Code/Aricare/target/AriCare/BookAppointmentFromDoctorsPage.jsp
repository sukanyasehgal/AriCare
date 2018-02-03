<!--  ***********************************************************************
    
	  File Name	            :     appointDoctor.jsp
	  Principal Author      	: Sakshi Kansal
	  Subsystem Name        :
	  Module Name           	:  booking appointment
	  Date of First Release 	:  08-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  displaying form to take appointment for selected doctor


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  08-05-2016
	  Modified by		:  Sakshi Kansal
	  Description of change :

*********************************************************************** -->
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.aricent.configuration.*" %>  
 <%@page import="com.aricent.pojofiles.*"%>  
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
		<title>Book Your Appointment</title>
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
								<script>
								$(
										function() 
										{
									   			$( "#datepicker-13" ).datepicker({
									   				dateFormat: "yy-mm-dd",
									   				minDate:1,
									   				maxDate:"14D",
									                beforeShowDay : function (date)
									                {
									                   var dayOfWeek = date.getDay ();
									                   // 0 : Sunday, 1 : Monday, ...
									                   if (dayOfWeek == 0 || dayOfWeek == 6) return [false];
									                   else return [true];
									                }
									     });
								});
								
								
		</script>
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
				<div class="wrap">
					<!---start-contact---->
					<div class="contact">
						<div class="section group">				
				<div class="col span_2_of_3">
				  <div class="contact-form">
				  <%String name= request.getParameter("nid"); %>
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
						    	<span><input type="text"  name="doctor_name" value="<%=name %>"></span>
						    	<br>
						    	
						    	<span><label>Date</label></span>
						    
						    	<input type="text" id="datepicker-13" name="date"> 
						    	<br>
						    	<span><label>Time</label></span>
						    	<select name="timing" size="1" class="text_input">
						    	<option value="0" selected disabled> Select Time</option>
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
