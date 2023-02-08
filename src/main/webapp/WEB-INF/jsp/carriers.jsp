<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html>
    <head>
        <jsp:include page="fragment/head.jsp" />
        <title>Перевозки</title>   
        <script type="text/javascript" src="resources/js/carrier.js"></script> 
        <script type="text/javascript">
        </script>
    </head>
    <body class="bg-light">  
        <jsp:include page="fragment/navbar.jsp" /> 
        <div class="container"> 
            <div class="py-5">    
                <h4 class="mb-3">Перевозчики</h4>
                <button type="button" class="btn btn-primary mb-2" onclick="showModalForInsert()">Добавить</button>
                <!--Data-->
                <table id="table-carriers" class="table table-hover">
                    <thead>
                        <tr>  
                            <th>Название</th>
                            <th>ИНН</th>
                            <th>Адрес регистрации</th>
                            <th>Страна регистрации</th>
                            <th>Система налогообложения</th>
                            <th/> 
                        </tr> 
                    </thead>
                    <tbody id="tbody-carriers">
                        <!--Оставил в качестве примера использования JSP. Таблица обновляется через ajax-->
                        <c:forEach items="${carriers}" var="carrier"> 
                            <tr id="table-row-${carrier.id}"> 
                                <td>${carrier.name}</td>
                                <td>${carrier.inn}</td>
                                <td>${carrier.regAddress}</td>
                                <td>${carrier.country.name}</td> 
                                <td>${carrier.taxSystem.name}</td>
                                <td> 
                                    <a class="btn btn-primary btn-sm" role="button" onclick="showModalForUpdate(${carrier.id})"> 
                                        Изменить
                                    </a>  
                                    <a class="btn btn-danger btn-sm" role="button" onclick="showConfirmDeleteCarrier(${carrier.id})"> 
                                        Удалить
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>  
                </table> 
            </div>
        </div>
        <jsp:include page="fragment/footer.jsp" />         

        <!--Modal-->
        <div class="modal fade" id="carrierModal" tabindex="-1" data-backdrop="static"
             aria-labelledby="carrierModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="carrierModalLabel">New message</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form id="form-carrier">
                            <input type="hidden" id="modal-carrier-id" name="id" /> 
                            <div class="form-group">
                                <label for="modal-carrier-name" class="col-form-label">Название</label>
                                <input type="text" class="form-control" id="modal-carrier-name" class="form-control" name="name">
                            </div> 
                            <div class="form-group">
                                <label for="modal-carrier-inn" class="col-form-label">ИНН</label>
                                <input type="text" class="form-control" id="modal-carrier-inn" class="form-control" name="inn">
                            </div> 
                            <div class="form-group">
                                <label for="modal-carrier-regAddress" class="col-form-label">Адрес регистрации</label>
                                <input type="text" class="form-control" id="modal-carrier-regAddress" class="form-control" name="regAddress">
                            </div> 
                            <div class="form-group">
                                <label for="modal-carrier-country" class="col-form-label">Страна регистрации</label>
                                <select class="form-control custom-select" id="modal-carrier-country" name="country"> 
                                    <option value="null" disabled="true">...</option>
                                    <c:forEach items="${countries}" var="country"> 
                                        <option value="${country.id}" label="${country.name}"/>
                                    </c:forEach>  
                                </select> 
                            </div> 
                            <div class="form-group">
                                <label for="modal-carrier-taxSystem" class="col-form-label">Система налогообложения</label> 
                                <select class="form-control custom-select" id="modal-carrier-taxSystem" name="taxSystem">
                                    <option value="null" disabled="true">...</option>
                                    <c:forEach items="${taxSystems}" var="taxSystem"> 
                                        <option value="${taxSystem.id}" label="${taxSystem.name}"/>
                                    </c:forEach>
                                </select> 
                            </div>  
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button> 
                        <button type="button" class="btn btn-primary" id="modal-button-save" onclick="insertOrUpdateCarrier()">Добавить</button>
                    </div>
                </div>
            </div>
        </div>

    </body> 
</html>
