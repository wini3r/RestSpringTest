# RestSpringTest
Приложение для ведения справочника
- jsp страница "Перевозчик"
- обновление данных через ajax (используя REST)
- валидации данных на сервере (CarrierValidator)
- RestController для CRUD операций
- AjaxCarrierController для работы с DTO
- MyBatis настроен через Spring
- БД MySQL (xampp, phpmyadmin)
- добавлены две таблицы (связаны с основной через ключ fk)
- в мапере "Перевозчик" настроена связь между таблицами<
- подключен bootstrap (через webjars)

</br>Инициализация БД
</br>`\resources\db_init\create_insert.sql`
</br>
</br>Конфигурация БД
</br>`\resources\database\jdbc.properties`
</br>
</br>Сервер: `apache-tomcat-9.0.71`
</br>JDK: `jdk1.8.0_231`


