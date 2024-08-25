Тестовое задание выполнил Гамов Игорь Александрович.
<br> <br>
Запустить проект можно через Docker следующей командой:
<br> <br>
**docker run -d -p 8080:8080 --name shop resst/shop-test-task:task-image**
<br> <br>
Альтернативно можно установить проект и запустить через точку входа com.resst.testtask.TestTaskApplication
<br> <br>
Я использую 17 версию java.
<br> <br>
Описание API можно посмотреть здесь или на главной странице проекта (например localhost:8080)
<br> <br>
Проект использует базу данных H2, для доступа к консоли можно использовать относительный путь по умолчанию **/h2-console** 
<br>
Для подключения к БД используются следующие данные:
<br>
Saved Settings: Generic H2 (Embedded) <br>
Setting Name: Generic H2 (Embedded) <br>
Driver Class: org.h2.Driver <br>
JDBC URL: jdbc:h2:mem:testdb <br>
User Name: sa <br>
Password: <br>
(пароль не установлен) <br>

Для взаимодействия с проектам используются следующие эндпоинты: 
<br> <br>
**Относительный путь:** /api/product 
<br>
**Эндпоинты:** 
<br>
**GET** - список всех продуктов 
<br>
**POST** - добавить новый продукт в список 
<br> <br>
**Относительный путь:** /api/product/{**id**}
 <br>
**Эндпоинты:**
 <br>
**GET** - получить продукт по **id**
 <br>
**PUT** - полностью обновить продукт по **id**
 <br>
**PATCH** - частично обновить продукт по **id**
 <br>
**DELETE** - удалить продукт поby **id**


**Относительный путь:** /api/product/type/{**type-name**}
 <br>
**Эндпоинты:**
 <br>
**GET** - список продуктов с типом **type-name** (**enum Type**). **type-name** записывается заглавными буквами с _ разделителем

 
**Относительный путь:** /h2-console
 <br>
Подключение к БД H2

 
**enum Type** содержит следующие значения: **PC**, **LAPTOP**, **MONITOR**, **HARD_DRIVE**


JSON объект продукта имеет следующую структуру: <br>
{ <br>
&emsp;"productId": Long, <br>
&emsp;"serialNumber": "String", <br>
&emsp;"manufacturer": String, <br>
&emsp;"price": BigDecimal, <br>
&emsp;"type": enum Type, <br>
&emsp;"quantity": Integer, <br>
&emsp;"properties": { <br>
&emsp;&emsp;"property1-name": property1-value, <br>
&emsp;&emsp;"property2-name": property2-value <br>
&emsp;} <br>
} <br>


**price** и **serialNumber** не могут быть пустыми или null при использовании методов **/api/product POST** и **/api/product/{id} PUT**.


/api/product/{**id**} при обновлении не будет учитывать null значения.
