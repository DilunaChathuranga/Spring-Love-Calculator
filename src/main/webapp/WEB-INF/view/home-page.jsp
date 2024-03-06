<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Love Calculator</title>

<link rel="canonical"
	  href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

<!-- Bootstrap core CSS -->
<link href="/LoveCalc/URLToReachResorceFolder/css/bootstrap.min.css"
	  rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/LoveCalc/URLToReachResorceFolder/css/signin.css"
	  rel="stylesheet">
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.err {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 20px;
}
</style>

<!-- Client side validation with JS -->
<script type="text/javascript">
function validate(){
var yn=document.getElementById("yn").value;
var cn=document.getElementById("cn").value;
var val=document.getElementById("check").checked;


if(yn.length<3 ||cn.length<3){
	alert("Your Name & Crush Name should have length of 3 charcters...");
	return false;
}
else if(val==false){
	alert("I think you forget to put a tik");
	return false;
}
else{
	return true;
	}
}
</script>
</head>
<body class="d-flex h-100 text-center .bg-light">

	<main class="form-signin">
		<form:form action="process-homepage" method="get"
			modelAttribute="UserInfo">
			<img class="mb-4"
				src="/LoveCalc/URLToReachResorceFolder/assets/images/lovecalclogo.png"
				alt="" width="250" height="150">
			<h1 class="h3 mb-3 fw-normal">Welcome to Love Calculator !</h1>

			<div class="form-floating">
			
			<p>
			<!-- We use path instead of name inside form tag to read default value from DTO put those values on Form  -->
				<label id="label-1" for="yn" >Your Name :</label> 
				<form:input  id="yn" path="username" class="form-control"/>
				<form:errors path="username" cssClass="err"/>
			</p>
			
			<p>
				<label id="label-2" for="cn">Crush Name:</label> 
				<form:input id="cn" path="crushname" class="form-control"/>
				<form:errors path="crushname" cssClass="err"/>
				
			</p>
			
			<P>
			<form:checkbox path="termAndCondition" id="check"/>
			<label >I am Agreeing this is for fun !!!</label>
			<form:errors  path="termAndCondition" cssClass="err"/>
			</P>
			
			<input type="submit" value="Calculate" class="w-100 btn btn-lg btn-primary" >
			
			</div>
			
			
		</form:form>
	</main>



</body>
</html>
