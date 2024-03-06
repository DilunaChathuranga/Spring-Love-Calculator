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

* {
  box-sizing: border-box;
}

input[type=text], input[type=password], select, textarea {
  width: 50%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
 
}

input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row::after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}




.err{
color:red;
position: fixed;
text-align: left;
margin-left: 20px;
}

#name{
  align-self: center;
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
<body>

<div id="outer" class="container">
<main>

	<div class="py-5 text-center">

      <img class="mb-4" src="/LoveCalc/URLToReachResorceFolder/assets//images/lovecalclogo.png" alt="" width="250" height="150">
      <h2>Register Here</h2>
      <p class="lead">You can provide your details here and you can easily register with this wonderful Application. Thanks</p>



<h4 class="mb-3 ">- Personal Info -</h4>
<form:form action="register-success" method="get" modelAttribute="UserReg">


<label class="form-label">Full Name : </label>
<form:input path="name" placeholder="John Doe"/>
<form:errors path="name" cssClass="err"/>
<br>


<label class="form-label">Username : </label>
<form:input path="username" />
<form:errors path="username" cssClass="err"></form:errors>
<br>

<label class="form-label">Password : </label>
<form:password path="password" />
<br>

<label class="form-label">Country : </label>
<form:select path="country" >
<form:option value="Sri Lanka" label="Sri Lanka"></form:option>
<form:option value="India" label="India"></form:option>
<form:option value="U.S" label="America"></form:option>
</form:select>
<br>

<label class="form-label">Hobbies :</label>
<div class="form-check form-check-inline">
  <form:checkbox path="hobby" value="Traveling" class="form-check-input" />
  <label class="form-check-label">Traveling</label>
</div>

<div class="form-check form-check-inline">
  <form:checkbox path="hobby" value="Cricket" class="form-check-input" />
  <label class="form-check-label" for="inlineCheckbox2">Cricket</label>
</div>

<div class="form-check form-check-inline">
  <form:checkbox path="hobby" value="Programmming" class="form-check-input" />
  <label class="form-check-label" for="inlineCheckbox2">Programming</label>
</div>

<br>

<label class="form-label">Gender:</label>

<div class="form-check form-check-inline">
  <form:radiobutton path="gender" value="Male"  class="form-check-input" />
  <label class="form-check-label" for="inlineRadio1">Male</label>
</div>
<div class="form-check form-check-inline">
  <form:radiobutton path="gender" value="Female" class="form-check-input" />
  <label class="form-check-label" for="inlineRadio2">Female</label>
</div>

<br>

<label class="form-label"> Age : </label>
<form:input path="age"/>
<form:errors path="age" cssClass="err"/>
<br>


<h4 class="mb-3 ">- Contact Info -</h4>

<label class="form-label">Email</label>
<!-- nested objects  ->  getcommunicationDTO().getEmail()-->
<form:input path="communicationDTO.email"/>
<form:errors path="communicationDTO.email" cssClass="err" />
<br>

<label class="form-label">Phone</label>
<!-- nested objects  ->  getcommunicationDTO().getEmail()-->
<form:input path="communicationDTO.phone"/>

<br>


<input type="submit" value="Register" class="btn-primary" >

</form:form>
</div>
</main>
</div>
</body>
</html>