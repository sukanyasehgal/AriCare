function validateAddDoctor() {
			var addresslength = 100;
			var phone = 10;
    var x = document.form.name.value;
    var y = document.form.pic.value;
    var z = document.form.qualification.value;
    var a = document.form.specialization.value;
    var b = document.form.timings.value;
    var c = document.form.address.value;
    var d = document.form.phone.value;
    var e = document.form.email_id.value;
    var atpos = e.indexOf("@");
	 var dotpos = e.lastIndexOf(".");
   
    if (x == null || x == "") {
        alert("Name must be filled out");
        document.form.name.focus();
        
        return false;
    }
    if (y == null || y == "") {
        alert("pic must be uploaded");
        document.form.pic.focus();
       
        return false;
    }
   if (z == null || z == "") {
        alert("qualification must be filled out");
        document.form.qualification.focus();
        return false;
    }
    if (a == null || a == "") {
        alert("specialization must be filled out");
        document.form.specialization.focus();
        return false;
    }
    if (b == null || b == "") {
        alert("timings must be filled out");
        document.form.timings.focus();
        return false;
    }
    if (c == null || c == "") {
        alert("address must be filled out");
        document.form.address.focus();
        return false;
    }
    if (c.length > addresslength) {
        alert("address too long");
        document.form.address.focus();
        return false;
    }
    if (isNaN(d)==true) {
        alert("Phone must be in digits");
        document.form.phone.focus();
        return false;
    }
    if (d.length != phone) {
        alert("Phone must be of 10 digits");
        document.form.phone.focus();
        return false;
    }
    if (e == null || e == "") {
        alert("email_id must be filled out");
        document.form.email_id.focus();
        return false;
    }
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=e.length) {
        alert("Not a valid e-mail address");
        document.form.email_id.focus();
        return false;
    }
 
        return true;
    
}
 

function validateBookAppointment() {
	 var x = document.form.doctor_name.value;
	 var date = document.form.date.value;
	 var y = document.form.timing.value;
	 var name = document.form.doctor_name.value;
	 if ( name == null || name == 0) {
	        alert("Please select doctor");
	        document.form.doctor_name.focus();
	        
	        return false;
	    }
	 if (x == null || x == "") {
	        alert("Name must be filled out");
	        document.form.doctor_name.focus();
	        
	        return false;
	    }
	 if (date == null || date == "") {
	        alert("date must be filled out");
	        document.form.date.focus();
	        
	        return false;
	    }
	 if ( y == null || y == 0) {
	        alert("Please select timing");
	        document.form.timing.focus();
	        
	        return false;
	    }
	
	 return true;
	}


function validateDeleteDoctorForm() {
    var x = document.form.name.value;
    var a = document.form.specialization.value;
    var d = document.form.phone.value;
   
    if (x == null || x == "") {
        alert("Name must be filled out");
        document.form.name.focus();
        return false;
    }
 
    if (a == null || a == "") {
        alert("specialization must be filled out");
        document.form.specialization.focus();
        return false;
    }
    if (d == null || d == "") {
        alert("Mobile No. must be filled out");
        document.form.phone.focus();
        return false;
    }
    if (isNaN(d)==true) {
        alert("Phone must be in digits");
        document.form.phone.focus();
        return false;
    }
  
    if (d.length != 10) {
        alert("Phone must be of 10 digits");
        document.form.phone.focus();
        return false;
    }
   
 
        return true;
    
}


function validateLogin() {
	 var x = document.form.uname.value;
	 var y = document.form.ps.value;
	 if (x == null || x == "") {
	        alert("Username must be filled out");
	        document.form.uname.focus();
	        
	        return false;
	    }
	 if (isNaN(x)==true) {
	        alert("Username must be in digits");
	        document.form.uname.focus();
	        return false;
	    }
	    if (x.length != 10) {
	        alert("Username must be of 10 digits");
	        document.form.uname.focus();
	        return false;
	    }
	    if ((x.charAt(0) != 8)&&(x.charAt(0) != 7)&&(x.charAt(0) != 9)) {
	        alert("Username should start with 7,8,9");
	        document.form.uname.focus();
	        return false;
	    }
	    if (y == null || y == "") {
	        alert("Password must be filled out");
	        document.form.ps.focus();
	        
	        return false;
	    }
	 return true;
	}


function validatePillDetailsForm() {
    var dname = document.form.dname.value;
    var pname = document.form.pname.value;
    var dnumber = document.form.dnumber.value;
    var pnumber = document.form.pnumber.value;
    var sdate = document.form.startDate.value;
    var edate = document.form.endDate.value;
    var pill = document.form.pill.value;
    var timing = document.form.timing.value;
    var dosage = document.form.dosage.value;
   
    if (dname == null || dname == "") {
        alert("Doctor Name must be filled out");
        document.form.dname.focus();
        
        return false;
    }
    if (isNaN(dnumber)==true) {
        alert("Doctor Phone must be in digits");
        document.form.dnumber.focus();
        return false;
    }
    if (dnumber.length != 10) {
        alert(" Doctor Phone must be of 10 digits");
        document.form.dnumber.focus();
        return false;
    }
    if (pname == null || pname == "") {
        alert("Patient Name must be filled out");
        document.form.pname.focus();
       
        return false;
    }
    if (isNaN(pnumber)==true) {
        alert("Patient Phone must be in digits");
        document.form.pnumber.focus();
        return false;
    }
    if (pnumber.length != 10) {
        alert(" Patient Phone must be of 10 digits");
        document.form.pnumber.focus();
        return false;
    }
    if (pill == null || pill == "") {
        alert("pill name must be filled out");
        document.form.pill.focus();
        return false;
    }
    if (sdate == null || sdate == "") {
    	
        alert("start date must be filled out");
        document.form.startDate.focus();
        return false;
    }
    if (edate == null || edate == "") {
        alert("end date must be filled out");
        document.form.endDate.focus();
        return false;
    }
    if (timing == null || timing == "") {
    	
        alert("Timing must be filled out");
        document.form.timing.focus();
        return false;
    }
  
   
    if (dosage == null || dosage == "") {
        alert(" Dosage must be filled out");
        document.form.dosage.focus();
        return false;
    }
    if (isNaN(dosage)==true) {
        alert("Dosage must be in digits");
        document.form.dosage.focus();
        return false;
    }
   
    
  
        return true;
    
}


function validateSignUp() {
    var addresslength = 50;
	 var x = document.form.name.value;
	 var d = document.form.phone_number.value;
	 var c = document.form.address.value;
	 var e = document.form.email_id.value;
	 var password = document.form.password.value;
	 var rePassword = document.form.rePassword.value;
	 var atpos = e.indexOf("@");
	 var dotpos = e.lastIndexOf(".");
	 if (x == null || x == "") {
	        alert("Name must be filled out");
	        document.form.name.focus();
	        
	        return false;
	    }
	 if (isNaN(d)==true) {
	        alert("Phone must be in digits");
	        document.form.phone_number.focus();
	        return false;
	    }
	    if (d.length != 10) {
	        alert("Phone must be of 10 digits");
	        document.form.phone_number.focus();
	        return false;
	    }
	    if ((d.charAt(0) != 8)&&(d.charAt(0) != 7)&&(d.charAt(0) != 9)) {
	        alert("Phone number should start with 7,8,9");
	        document.form.phone_number.focus();
	        return false;
	    }
	    if (c == null || c == "") {
	        alert("address must be filled out");
	        document.form.address.focus();
	        return false;
	    }
	    if (c.length > addresslength) {
	        alert("address too long");
	        document.form.address.focus();
	        return false;
	    }
	    if (e == null || e == "") {
	        alert("email_id must be filled out");
	        document.form.email_id.focus();
	        return false;
	    }
	    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=e.length) {
	        alert("Not a valid e-mail address");
	        document.form.email_id.focus();
	        return false;
	    }
	    if (isNaN(password)==true) {
	        alert("Password must be in digits");
	        document.form.password.value="";
	    	 document.form.rePassword.value="";
	        document.form.password.focus();
	        return false;
	    }
	    if (password.length < 8) {
	        alert("Password must be of atleast 8 digits");
	        document.form.password.value="";
	    	 document.form.rePassword.value="";
	        document.form.password.focus();
	        return false;
	    }
	    if(password != rePassword)
	    	{
	    	 alert("Passwords don't match");
	    	 document.form.password.value="";
	    	 document.form.rePassword.value="";
		        document.form.password.focus();
		        return false;
	    	}
	 return true;
	}