<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html>
    <head>
        <jsp:include page="../fragment/head.jsp" />
        <title>Ошибка</title>  
        <link rel="icon" type="image/png" sizes="32x32" href="resources/favicon/favicon-32x32.png">

        <script type="text/javascript" src="resources/js/carrier.js"></script> 
        <script type="text/javascript">
        </script>
    </head>
    <body class="bg-light">  
        <jsp:include page="../fragment/navbar.jsp" /> 
        <div class="container"> 
            <div class="py-5">    
                <h4 class="mb-3">Ошибка</h4> 
                <p>${exceptionMessage}</p>
            </div>
        </div>
        <jsp:include page="../fragment/footer.jsp" />
    </body>
</html>
