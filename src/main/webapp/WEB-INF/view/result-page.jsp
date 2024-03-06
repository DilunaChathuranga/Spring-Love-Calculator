<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
  
  

    <h1>Love Calculator Predicts !</h1>
    <p class="lead">${UserInfo.username} and ${UserInfo.crushname} are ${UserInfo.result}</p>
    <p class="lead">
     
      <a class="btn btn-primary" href= "<c:url value = "/send-mail" />">Send result to Email</a>
    </p>

</div>

  


</body>
</html>