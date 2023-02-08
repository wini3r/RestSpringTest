<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html>
    <head>
        <jsp:include page="fragment/head.jsp" />
        <title>Перевозки</title>  
        <link rel="icon" type="image/png" sizes="32x32" href="resources/favicon/favicon-32x32.png">

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
                <table id="table-carriers" class="table table-hover" cellpadding="7">
                    <thead>
                        <tr> 
                            <!--<th>ID</th>-->
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
                                <!--<td>${carrier.id}</td>-->
                                <td>${carrier.name}</td>
                                <td>${carrier.inn}</td>
                                <td>${carrier.regAddress}</td>
                                <td>${carrier.regCountry}</td> 
                                <td>${carrier.taxSystem}</td>
                                <td> 
                                    <a class="btn btn-primary btn-sm" role="button" onclick="showModalForUpdate(${carrier.id})"> 
                                        Изменить
                                    </a>  
                                    <a class="btn btn-danger btn-sm" role="button" onclick="deleteCarrier(${carrier.id})"> 
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

        <!--<script src="form-validation.js"></script>--> 
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
                                <label for="modal-carrier-regCountry" class="col-form-label">Страна регистрации</label>
                                <!--<input type="text" class="form-control" id="modal-carrier-regCountry" class="form-control" name="regCountry">-->
                                <select class="form-control custom-select" id="modal-carrier-regCountry" name="regCountry"> 
                                    <option value="null" disabled="true">...</option>
                                    <option>Россия</option>
                                    <option>Казахстан</option>
                                    <option>Азербайджан</option>
                                    <option>Армения</option>
                                    <option>Белоруссия</option>
                                    <option>Киргизия</option>
                                    <option>Молдавия</option>
                                    <option>Таджикистан</option>
                                    <option>Узбекистан</option> 
                                </select> 
                            </div> 
                            <div class="form-group">
                                <label for="modal-carrier-taxSystem" class="col-form-label">Система налогообложения</label>
                                <select class="form-control custom-select" id="modal-carrier-taxSystem" name="taxSystem">
                                    <option value="null" disabled="true">...</option>
                                    <option value="" >Без НДС</option>
                                    <option value="0">НДС 0%</option>
                                    <option value="10">НДС 10%</option>
                                    <option value="20">НДС 20%</option> 
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
