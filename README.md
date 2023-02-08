# RestSpringTest
Приложение для ведения справочника
<ul>
  <li>jsp страница "Перевозчик"</li>
  <li>обновление данных через ajax (используя REST)</li>
  <li>валидации данных на сервере (CarrierValidator)</li>
  <li>RestController для CRUD операций</li>
  <li>AjaxCarrierController для работы с DTO</li>
  <li>MyBatis настроен через Spring</li>
  <li>БД MySQL (xampp, phpmyadmin)</li>
  <li>добавлены две таблицы (связаны с основной через ключ fk)</li>
  <li>в мапере "Перевозчик" настроена связь между таблицами</li>
  <li>**подключен bootstrap (через webjars)</li>
</ul>
</br>
</br>Инициализация БД:
</br>`\resources\db_init\create_insert.sql`
</br>
</br>Конфигурация БД:
</br>`\resources\database\jdbc.properties`
</br>
</br>Сервер: `apache-tomcat-9.0.71`
</br>JDK: `jdk1.8.0_231`


