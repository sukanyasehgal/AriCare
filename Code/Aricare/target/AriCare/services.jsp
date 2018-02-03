<!--  ***********************************************************************
                    
	  File Name	            :     services.jsp
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	:  services
	  Date of First Release 	:  06-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  displaying all services provided by hospital


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  06-05-2016
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
 
<!DOCTYPE HTML>
<html>
	<head>
		<title>Services</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
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
									<li ><a href="index.jsp">Home</a></li>
                              <li><a href="DisplayDoctor">Doctors</a></li>
                                <li><a href="Specialization.jsp">Specialization</a></li>
								<li class="active"><a href="services.jsp">Services</a></li>
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
			<div class="services1">
				<h4>Our services</h4><br>
				<div class="clear"></div>
			</div>

			<div class="content-top-grid services-grid1">

				<!-- <div class="content-top-grid-header"> -->
				<!-- <div class="content-top-grid-pic"> -->
				<a href="#"><img src="images/mother.png" title="image-name"></a>
				<!--</div>  -->
				<!--  <div class="content-top-grid-title">-->
				<h3>Mother and Childcare</h3>
				<!-- </div> -->
				<!-- <div class="clear"></div> -->
				<!-- </div> -->
				<p>Birthing is the most beautiful moment in a woman's life. At
					AriCare we understand this and as you journey into motherhood our
					maternity services will make your experience a pleasant and
					enjoyable one.</p>
				<p>
					Our services Include:<br> • Preconceptional assessment and
					counseling<br> • Comprehensive Antenatal care<br> • Pain
					relief during labour<br> • Postnatal care<br> • Tertiary
					level nursery and neo-natal Intensive Care Unit (NICU).
				</p>
				<!-- <div class="clear"></div>
			</div> -->

				<br>
				<br>

				<!-- <div class="content-top-grid services-grid1"> -->
				<a href="#"><img src="images/joint.png" title="image-name"></a>
				<h3>AriCare Orthopaedics, Joint Replacement & Spinal Surgery
					Centre</h3>
				<p>AriCare Orthopedics, Joint Replacement & Spinal Surgery
					Centre specializes in the treatment of musculo-skeletal system
					disorders.</p>
				<p>
					Our treatments and services include:<br> • Spine Surgery<br>
					• MIS for Joint Replacement<br> • Arthroscopy<br> •
					Sports Injuries
				</p>
				<!-- <div class="clear"></div>
			</div> -->

				<br>
				<br>
				<!-- <div class="content-top-grid services-grid1"> -->
				<a href="#"><img src="images/kidney.png" title="image-name"></a>
				<h3>Centre for Kidney Transplantation & Renal Diseases</h3>
				<p>When the kidneys stop working, renal failure occurs. If this
					renal failure continues (chronically), end-stage renal disease
					results, with accumulation of toxic waste products in the body. In
					this case, either dialysis or transplantation is required.</p>
				<p>
					We provide following treatments and services in this area:<br>
					• Renal Replacement therapy<br> • Dialysis<br> • Kidney
					Transplant
				</p>
				<!-- <div class="clear"></div>
			</div> -->

				<br>
				<br>
				<!-- <div class="content-top-grid services-grid1"> -->
				<a href="#"><img src="images/fem.png" title="image-name"></a>
				<h3>AriCare Well Women Check</h3>
				<p>A HEALHY WOMAN IS YOUR FAMILY'S BACKBONE</p>
				<p>
					Recommended for women who desire screening for gynecology related
					problems:<br> • Blood Grouping & RH Typing<br> • Breast
					Examination<br> • Blood sugar (fasting & PP)<br> • Pap
					Smear<br> • Urine Routine<br> • Stool Routine<br> •
					X-Ray (Chest)<br> • Ultrasound Breast (Screening)<br> •
					Ultrasound Pelvic(Screening)<br> • High Resolution Mammography<br>
					• Clinical Examination & Advice by Gynecologist
				</p>
				<!-- <div class="clear"></div>
			</div> -->

				<br>
				<br>
				<!-- 	<div class="content-top-grid services-grid1"> -->
				<a href="#"><img src="images/child.png" title="image-name"></a>
				<h3>AriCare Child Health Check</h3>
				<p>CHILD IS THE FATHER OF MEN</p>
				<p>We all want to keep our children healthy, physically and
					mentally. The AriCare child Health Check helps you child grow into
					a healthy and balanced individual.</p>
				<p>
					Our services include:<br> • Blood Grouping & Rh Typing<br>
					• Mantoux Test<br> • Complete haemogram<br> • Complete
					Urine Analysis<br> • Xray Chest<br> • ENT Consultation<br>
					• Eye examination<br> • Dental Examination
				</p>
				<!-- <div class="clear"></div>
			</div>
 -->
				<br>
				<br>
				<!-- <div class="content-top-grid services-grid1"> -->
				<a href="#"><img src="images/bcc.png" title="image-name"></a>
				<h3>AriCare Breast Check</h3>
				<p>
					Our services include: <br>(Empty stomach not required)<br> • High
					Resolution mammography<br> • Ultra sound breasts (screening)<br>
					• FNAC/Exfoliative Cytology (if required)<br> • Complete
					Physical Examination by specialized Breast Surgeon
				</p>
				<!-- <div class="clear"></div>
			</div> -->

				<br>
				<br>
				<!-- <div class="content-top-grid services-grid1"> -->
				<a href="#"><img src="images/diabetes.png" title="image-name"></a>
				<h3>AriCare Diabetic Check</h3>
				<p>
					We have a provision for these tests:<br> (Empty stomach required)<br>
					• BLOOD SUGAR F & PP<br> • CREATININE<br> • SGOT<br>
					• SGPT<br> • HBAIC<br> • MAU (MICROALBUMIN, SPOT URINE)-
					URINE<br> • LIPID PROFILE SERUM<br> • URINE ROUTINE &
					MICROSCOPY<br> • EYE CHECKUP<br> • DIET CONSULTANT<br>
					• ECG<br> • XRAY CHEST PA
				</p>
				<!-- <div class="clear"></div>
			</div> -->

				<br>
				<br>
				<!-- <div class="content-top-grid services-grid1"> -->
				<a href="#"><img src="images/rehab.png" title="image-name"></a>
				<h3>Rehabilitation Services at AriCare</h3>
				<p>We provide a full range of rehabilitation services designed
					to help patients regain function and independence following injury
					or illness. Our licensed therapists create rehabilitation plans to
					address each patient’s individual needs.</p>
				<p>
					Our services include:<br> • Cancer Rehabilitation Cardiac
					Rehabilitation<br> • Inpatient Rehabilitation<br> •
					Lymphatic Therapy<br> • Neurologic Therapy<br> •
					Occupational Therapy<br> • Outpatient Rehabilitation<br>
					• Pediatric Rehabilitation<br> • Physical Therapy<br> •
					Speech Therapy
				</p>
				<!-- <div class="clear"></div>
			</div> -->

				<br>
				<br>
				<!-- <div class="content-top-grid services-grid1"> -->
				<a href="#"><img src="images/pharmacy.png" title="image-name"></a>
				<h3>Pharmacy and Dispensary</h3>
				<p>Our pharmacy at the Centre dispenses drugs to the patients
					admitted in wards and to the out patients. The Pharmacy
					Manufacturing Section manufactures eye drops under strict quality
					control measures using the modern technology of micropore
					filtration.</p>
				<!-- <div class="clear"></div>
			</div> -->
				<br>
				<br>
				<!-- <div class="content-top-grid services-grid1"> -->
				<a href="#"><img src="images/Aricent.png" title="image-name"></a>
				<h3>Company Panel</h3>
				<p>We are privileged to be on panel of: Aricent.</p>
				<!-- <div class="clear">-->
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
