<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html>
    <head>
        <jsp:include page="fragment/head.jsp" />
        <title>Страны</title>    
    </head>
    <body class="bg-light">  
        <jsp:include page="fragment/navbar.jsp" /> 
        <div class="container"> 
            <div class="py-5">    
                <h4 class="mb-3">Страны</h4> 
                <!--Data-->
                <table id="table-countries" class="table table-hover">
                    <thead>
                        <tr> 
                            <!--<th>ID</th>-->
                            <th>Код</th>
                            <th>Название</th>
                            <th>Краткое обозначение</th> 
                        </tr> 
                    </thead>
                    <tbody id="tbody-countries">
                        <!--Оставил в качестве примера использования JSP. Таблица обновляется через ajax-->
                        <c:forEach items="${countries}" var="country"> 
                            <tr id="table-row-${country.id}"> 
                                <td>${country.code}</td>
                                <td>${country.name}</td>
                                <td>${country.shortName}</td> 
                            </tr>
                        </c:forEach>
                    </tbody>  
                </table> 
            </div>
        </div>
        <jsp:include page="fragment/footer.jsp" />         
    </body> 
</html>
