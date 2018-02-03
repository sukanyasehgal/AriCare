<!--  ***********************************************************************

	  File Name	            :     admin.jsp
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	:  admin module
	  Date of First Release 	:  10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  displaying page particularly for admin


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
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
		<title>Admin</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		 
	</head>
	<body >
	

 
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
			
				<div class="col span_2_of_3">
				  <div class="contact-form">
				  	<h3>Functions for Admin</h3>
					    
					    	<div>
						    	
             <span><button type="button" onclick="location.href='addDoctorForm.jsp'">Add Doctor</button></span>
						    </div>
                                                <div>
						    	
                   <span><button type="button" onclick="location.href='deleteDoctorForm.jsp'">Delete Doctor</button></span>
						    </div>
						    <div>
					<span><button type="button" onclick="location.href='pillDetailsForm.jsp'">Update Pill Details</button></span>
						    </div>
						      <div>
					<span><button type="button" onclick="location.href='addnewsForm.jsp'">Add newsletter</button></span>
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
	
</body >
</html>
