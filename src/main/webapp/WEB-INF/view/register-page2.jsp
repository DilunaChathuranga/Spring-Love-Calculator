<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  <!-- Spring form tag -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Register Page</title>

<link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/checkout/">

    <!-- Bootstrap core CSS -->
<link href="/LoveCalc/URLToReachResorceFolder/css/bootstrap.min.css" rel="stylesheet">

<link href="/LoveCalc/URLToReachResorceFolder/css/form-validation.css" rel="stylesheet">

<style type="text/css">
.err{
color:red;
position: fixed;
text-align: left;
margin-left: 20px;
}

.bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }}
      
</style>

</head>
<body class="bg-light">

<div id="outer" class="container">
<main>

	<div class="py-5 text-center">

      <img class="mb-4" src="/LoveCalc/URLToReachResorceFolder/assets//images/lovecalclogo.png" alt="" width="250" height="150">
      <h2>Register Here</h2>
      <p class="lead">You can provide your details here and you can easily register with this wonderful Application. Thanks</p>
    </div>

<div id="inner" class="text-center col-md-7 col-lg-8 ">
<h4 class="mb-3 ">Registration Form</h4>
<form:form action="register-success" method="get" modelAttribute="UserReg">

<div class="mb-3 ">
<label class="form-label">Full Name: </label>
<form:input path="name" class="form-control" placeholder="John Doe"/>
<form:errors path="name" cssClass="err"/>
<br>
</div>


<label>Username: </label>
<form:input path="username" />
<form:errors path="username" cssClass="err"></form:errors>
<br>

<label>Password: </label>
<form:password path="password" />
<br>

<label>Country: </label>
<form:select path="country" >
<form:option value="Sri Lanka" label="Sri Lanka"></form:option>
<form:option value="India" label="India"></form:option>
<form:option value="U.S" label="America"></form:option>
</form:select>
<br>

<label>Hobbies:</label>
Travelling<form:checkbox path="hobby" value="Traveling"/> 
Crickrt<form:checkbox path="hobby" value="Cricket" />
Programming<form:checkbox path="hobby" value="Programmming" />
<br>

<label>Gender:</label>
Male<form:radiobutton path="gender" value="Male"/>
Female<form:radiobutton path="gender" value="Female" />
<br>

<label>Age: </label>
<form:input path="age"/>
<form:errors path="age" cssClass="err"/>
<br>

<div align="center">
<h3>Communication</h3>
<label>Email</label>
<!-- nested objects  ->  getcommunicationDTO().getEmail()-->
<form:input path="communicationDTO.email"/>
<form:errors path="communicationDTO.email" cssClass="err" />


<label>Phone</label>
<!-- nested objects  ->  getcommunicationDTO().getEmail()-->
<form:input path="communicationDTO.phone"/>
</div>
<br>

<input type="submit" value="Register">

</form:form>
</div>
</main>
</div>
</body>
</html>