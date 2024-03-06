<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  <!-- Spring form tag -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/cover/">
    <!-- Custom styles for this template -->
 <link href="/LoveCalc/URLToReachResorceFolder/css/cover.css" rel="stylesheet">
    

    <!-- Bootstrap core CSS -->
<link href="/LoveCalc/URLToReachResorceFolder/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


</head>
<body>
 <div align="center">
<h1>Hi ${UserInfo.username}</h1>
<p class="lead">Send result to given Email</p>
<!-- Here in action we have to provide class path also -->
<form:form action="/LoveCalc/process-mail" method="GET" modelAttribute="emailDTO">
<label>Email ID :</label>
<form:input path="userEmail"/>
<input type="submit" value="send" class="btn btn-primary">

</form:form>
</div>
</body>
</html>


