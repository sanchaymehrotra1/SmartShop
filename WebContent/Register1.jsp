<html>
<head>
	<title>Registration Form</title>
	<link rel="stylesheet" type="text/css" href="Register.css">
	<link href="https://fonts.googleapis.com/css?family=Aladin" rel="stylesheet">

  <script>
    function FormValidation(){
        //First Name Validation 
        var fname=document.getElementById('first_name').value;
        var lname=document.getElementById('last_name').value;
        var age=document.getElementById('age').value;
     
        var contact=document.getElementById('phone_number').value;
        
        
        var email=document.getElementById('email').value;
        var pass=document.getElementById('pass').value;
        var cpass=document.getElementById('cpass').value;
        if(fname == ""  ){
        	
      
           
        
            document.getElementById('first_name').style.borderColor = "red";
            document.getElementById('firste').innerHTML = "First name  should not be empty";
            document.getElementById('firste').focus();
            return false;
            
           }
        else{
            if (!(/^[A-Za-z]+$/.test(document.getElementById("first_name").value))) {
            	document.getElementById('firste').innerHTML = "First name can not have digits";
                
                document.getElementById('first_name').style.borderColor = "red";
                return false;
            }else{
            	 document.getElementById('firste').innerHTML = "";
                document.getElementById('first_name').style.borderColor = "green";
                
            }
            if(fname.length <=2){
            	document.getElementById('firste').innerHTML = "name is too small";
                document.getElementById('first_name').style.borderColor = "red";
                return false;
            }else{
            	document.getElementById('firste').innerHTML = "";
                document.getElementById('first_name').style.borderColor = "green";
            }
           
          
            
            
           
        }
        
        if(lname=="")
        	{
        	 
        	document.getElementById('last_name').style.borderColor = "red";
        	 document.getElementById('laste').innerHTML = "Last name  should not be empty";
             document.getElementById('laste').focus();
        	  return false;
        	}else{
        		if (!(/^[A-Za-z]+$/.test(document.getElementById("last_name").value))) {
        			document.getElementById('laste').innerHTML = "Last name  can not have digits";
                    
                    document.getElementById('last_name').style.borderColor = "red";
                    return false;
                }else{
                	document.getElementById('laste').innerHTML = "";
                    document.getElementById('last_name').style.borderColor = "green";
                }
             
        	   }
        if(age=="")
        	{
        	
        	document.getElementById('age').style.borderColor = "red";
        	document.getElementById('agee').innerHTML = "Please enter a valid age ";
      	  return false;
      	}else{
      		if(isNaN(age) || age.length<1 || age.length>3 || parseInt(age)<1 || parseInt(age)>99)
        	   {
      			document.getElementById('agee').innerHTML = "Please enter a valid age ";
               document.getElementById('age').style.borderColor = "red";
        	   return false;
        	   }else{
        		   document.getElementById('agee').innerHTML = " ";
        		   document.getElementById('age').style.borderColor = "green";
        	   }
      	   }
        if(contact=="")
        	{
        	document.getElementById('phone_number').style.borderColor =  "red";
        	document.getElementById('contacte').innerHTML = "Please enter valid contact ";
        	return false;
        	}else{
        		  if(contact.length<10 || contact.length>10)
           	   {
        				document.getElementById('contacte').innerHTML = "Please enter valid contact ";
                  document.getElementById('phone_number').style.borderColor = "red";
           	   return false;
           	   }else{
           		document.getElementById('contacte').innerHTML = " ";
           		   document.getElementById('phone_number').style.borderColor = "green";
           	   }
        		
        	}
       
        if(email=="")
        	{
        	document.getElementById('email').style.borderColor = "red";
        	document.getElementById('emaile').innerHTML = "Please enter email";
        	  return false;
        	}else{
if (!(/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/.test(document.getElementById("email").value)))  {
document.getElementById('email').style.borderColor = "red";
        	document.getElementById('emaile').innerHTML = "Please enter valid email";
        	  return false;
} 
else
{     		
document.getElementById('emaile').innerHTML = " ";   
        		document.getElementById('email').style.borderColor = "green";
        	   }
}
      
        if(pass=="")
    	{
    	document.getElementById('pass').style.borderColor = "red";
    	document.getElementById('passe').innerHTML = "Please enter password";
    	  return false;
    	}else{
if (!(/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{1,150}$/.test(document.getElementById("pass").value))) {
document.getElementById('pass').style.borderColor = "red";
    	document.getElementById('passe').innerHTML = "Password should contain atleast one numeric and one special character";
    	  return false;
}
 else if(pass.length>15)
{
document.getElementById('pass').style.borderColor = "red";
    	document.getElementById('passe').innerHTML = "Password length sholud be less than 15 character";
    	  return false;
}
else if(pass.length<4)
{
document.getElementById('pass').style.borderColor = "red";
    	document.getElementById('passe').innerHTML = "Password length sholud be greater than 4 character";
    	  return false;

}


else{

    		document.getElementById('passe').innerHTML = " ";  
    		document.getElementById('pass').style.borderColor = "green";
    	   }
}
        if(cpass=="")
    	{
    	document.getElementById('cpass').style.borderColor = "red";
    	document.getElementById('cpasse').innerHTML = "Please confirm password ";
    	  return false;
    	}else{
    		if(cpass==pass)
{

document.getElementById('cpasse').innerHTML = " ";   
    		document.getElementById('cpass').style.borderColor = "green";
}
else{
document.getElementById('cpasse').innerHTML = " Password did not match";   
    		document.getElementById('cpass').style.borderColor = "red";
    	   }
}
        
    
        
       
    }

    </script>

</head>
	<body> 
	<a href="Home.jsp">HOME</a>
	
	<% String hidden = request.getParameter("userType"); %>
		<h1>Registration Form</h1>
		<div class="register">
		  <form class="register-form" name="register-form" id="register-form" action="RegisterServlet" onsubmit="return FormValidation();" onchange="return FormValidation();"  method="POST"  modelAttribute="user">
                        <div class="form-row">
                            <div class="form-group">
                                   
                                <div class="form-input">
                                    <label for="first_name" class="required">First name</label>
                                    <input type="hidden"   name="userType" value="<%=hidden%>"></input>
                                    <input type="text" name="First_Name" id="first_name" Placeholder="First Name" />
                                    <font color='red'> <DIV id="firste"> </DIV> </font>
                         
                                </div>
                                <br>
                                <div class="form-input">
                                    <label for="last_name" class="required">Last name</label>
                                    <input type="text" name="Last_Name" id="last_name" placeholder="Last Name" />
                                    <font color='red'> <DIV id="laste"> </DIV> </font>
                                  
                                </div>
                                <br>
                                <div class="form-input">
                                    <label for="age" class="required">Age</label>
                                    <input type="number" name="Age" id="age" Placeholder="Age" />
                                    <font color='red'> <DIV id="agee"> </DIV> </font>
                                  
                                </div>
                                <br>
                                <div class="form-input">
                                        <div class="form-select">
                                                <div class="label-flex">
                                                    <label for="meal_preference">Gender</label>
                                                </div>
                                                <div class="select-list">
                                                    <select name="Gender" id="meal_preference">
                                                        <option value="Male">Male</option>
                                                        <option value="Female">Female</option>        
                                                    </select>
                                             
                                            </div>
                                            
                                            </div>
                                           
                                            </div>
                                            <br>
                                
                                <div class="form-input">
                                    <label for="phone_number" class="required">Contact number</label>
                                    <input type="number" name="cnumber" id="phone_number" placeholder="Contact Number" />
                                   <font color='red'> <DIV id="contacte"> </DIV> </font>
                                </div>
                                <br>
                            </div>
                            <div class="form-group">   
                                
                                 
                            
                                    
                                    
                                        <label for="Email" class="required">User ID</label>
                                        <input type="text" name="Email" id="email" Placeholder="enter your mail" />
                                        <font color='red'> <DIV id="emaile"> </DIV> </font>
                                        <br>
                                        <label for="password" class="required">Password</label>
                                      <input type="password" name="password" id="pass"placeholder="Enter Your Password"><br><br>
                                        <font color='red'> <DIV id="passe"> </DIV> </font>
                                       <br>
                            
                                        <label for="confirm password" class="required">Confirm Password</label>
                                        <input type="password" name="CnfPs" id="cpass" Placeholder="confirm Password"  />
                                        <font color='red'> <DIV id="cpasse"> </DIV> </font>
                                      <br>
                            </div>
                        </div>
                        <div class="form-submit">
                            <input type="submit" value="Register" class="submit" id="submit" name="register" />    
                            
                        </div>
                    </form>
		</div>	
	</body>
</html>