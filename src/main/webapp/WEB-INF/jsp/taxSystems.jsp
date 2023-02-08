<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html>
    <head>
        <jsp:include page="fragment/head.jsp" />
        <title>Система налогообложения</title>    
    </head>
    <body class="bg-light">  
        <jsp:include page="fragment/navbar.jsp" /> 
        <div class="container"> 
            <div class="py-5">    
                <h4 class="mb-3">Система налогообложения</h4> 
                <!--Data-->
                <table id="table-taxSystem" class="table table-hover">
                    <thead>
                        <tr> 
                            <!--<th>ID</th>--> 
                            <th>Название</th>
                            <th>Налог</th> 
                        </tr> 
                    </thead>
                    <tbody id="tbody-taxSystem">
                        <!--Оставил в качестве примера использования JSP. Таблица обновляется через ajax-->
                        <c:forEach items="${taxSystems}" var="taxSystem"> 
                            <tr id="table-row-${taxSystem.id}"> 
                                <td>${taxSystem.name}</td>
                                <td>${taxSystem.taxValue}</td> 
                            </tr>
                        </c:forEach>
                    </tbody>  
                </table> 
            </div>
        </div>
        <jsp:include page="fragment/footer.jsp" />         
    </body> 
</html>
