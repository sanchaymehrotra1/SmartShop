<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
	<title>Registration Form</title>
	<link rel="stylesheet" type="text/css" href="Register.css">
	<link href="https://fonts.googleapis.com/css?family=Aladin" rel="stylesheet">
	<script type="text/javascript"> 
function FormValidation()
{ 
 password=document.getElementById('lname').value;
 CnfPs=form.CnfPs.value;
 First_Name= document.getElementById('name').value;
 Last_Name= document.getElementById('lname').value;
 Age=document.getElementById('age').value;
 MobileNumber=document.getElementById('cnumber').value;
 Email=document.getElementById('email').value;
 password=document.getElementById('pass').value;
 if(First_Name=='')
 {

     document.getElementById('name').style.borderColor = "red";
     document.getElementById('name').innerHTML = "First name  should not be empty";
     document.getElementById('name').focus();
     return false;
 }
 else if(Last_Name=='')
 {

	 document.getElementById('lname').style.borderColor = "red";
     document.getElementById('lname').innerHTML = "First name  should not be empty";
     document.getElementById('lname').focus();
 }
 else if(Age=='')
 {

	 document.getElementById('age').style.borderColor = "red";
     document.getElementById('age').innerHTML = "First name  should not be empty";
     document.getElementById('age').focus();
 }
 else if(Email=='')
 {

	 document.getElementById('email').style.borderColor = "red";
     document.getElementById('email').innerHTML = "First name  should not be empty";
     document.getElementById('email').focus();
 }
 else if(MobileNumber=='')
	 {
	 document.getElementById('cnumber').style.borderColor = "red";
     document.getElementById('cnumber').innerHTML = "First name  should not be empty";
     document.getElementById('cnumber').focus();
	 }
 else if(password=='')
 {

	 document.getElementById('pass').style.borderColor = "red";
     document.getElementById('pass').innerHTML = "First name  should not be empty";
     document.getElementById('pass').focus();
 }
 else if(CnfPs=='')
		 {

     document.getElementById('pass').style.borderColor = "red";
	 alert("please confirm password");
		 }
 else if(password!=CnfPs)
	 {

     
	 alert("password did not match");
 return false;
	 }
 
 } 
</script> 

</head>
	<body> 
	<c:if test="${not empty info}">
	
	
	<script>
    alert("Sucessfully Registerd");
	</script>
	</c:if>
	<a href="index.jsp">HOME</a>

	
	<% String hidden = request.getParameter("userType"); %>
		<h1>Registration Form</h1>
		<div class="register">
		<form onsubmit="return FormValidation();" onchange="return FormValidation();" method="post" id="register" action="RegisterServlet">
		<h2>Register Here</h2>
		<label> First Name :</label><br><br>
		<input type="hidden"   name="userType" value="<%=hidden%>"></input>
		<input type="text" required="required" name="First_Name" id="name" placeholder="Enter Your First Name"><br><br>
		<label> Last Name :</label><br><br>
		<input type="text"  name="Last_Name" id="lname" placeholder="Enter Your Last Name"><br><br>
		<label>Age :</label><br><br>
		<input type="number" required="required" name="Age" id="age"placeholder="Enter your age"><br><br>
		<label>Gender :</label>
		<select id="gen" name="Gender">
			<option>Male</option>
			<option>Female</option>
			<option>Other</option>
		</select><br>
	<!-- 	<input type="text"  id="gen"placeholder="Enter Gender"><br><br> -->
		<label>Contact Number :</label><br><br>
		<input type="text" required="required" name="cnumber" id="cnumber"placeholder="Enter your Number"><br><br>
		<label> User ID: </label><br><br>
		<input type="email" required="required" name="Email" id="email"placeholder="Enter Your Email"><br><br>
		<label> Password: </label><br><br>
		<input type="password" required name="password" id="pass"placeholder="Enter Your Password"><br><br>
		<label> Re-enter Your Password: </label><br><br>
		<input type="password" required name="CnfPs" id="pass"placeholder="Confirm Your Password"><br><br>

		<input type="submit" value="Submit" id="sub">
	    </form>
		</div>	
	</body>
</html>