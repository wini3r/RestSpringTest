<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> 
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample" aria-controls="navbarsExample" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/RestSpringTest/">Перевозчики</a>
            </li> 
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="" id="dropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Справочники</a>
                <div class="dropdown-menu" aria-labelledby="dropdown">
                    <a class="dropdown-item" href="taxSystems">Налог</a>
                    <a class="dropdown-item" href="countries">Страны</a> 
                </div>
            </li>
        </ul>
    </div>
</nav>