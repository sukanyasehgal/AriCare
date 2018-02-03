<!--  ***********************************************************************
                   
	  File Name	            :     deleteDoctorForm.jsp
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	:  delete doctor
	  Date of First Release 	:  11-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  displaying form to delete Doctor


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  11-05-2016
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
		<title>Delete Doctor</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
	<script src="js/validation.js">
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
			
				<div class="col span_2_of_3">
				  <div class="contact-form">
				  	<h3>Delete Doctor Information</h3>
				  		<% 
				  	if(request.getAttribute("statusTrue")!=null){%>
				  	<p style="color:RED">Doctor profile deleted !</p>
				  	<% } else if(request.getAttribute("statusFalse")!=null){%>
				  	<p style="color:RED">Such doctor does not exists!</p>
				  	<% }%>
					    <form action="DeleteDoctor" method="post" name="form" onsubmit="return validateDeleteDoctorForm()">
					    	<div>
						    	<span><label>Name</label></span>
						    	<span><input type="text" value="" name="name"></span>
						    </div>
						    
						
                                                <div>
						     	<span><label>Specialization</label></span>
						    	<span><input type="text" value="" name="specialization"></span>
						    </div>
                                                
                                                <div>
						     	<span><label>Mobile No.</label></span>
						    	<span><input type="text" value="" name="phone"></span>
						    </div>
						  
						   <div>
						   		<span><input type="submit" value="Submit"></span>
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
