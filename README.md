Тестовое задание выполнил Гамов Игорь Александрович.
Запустить проект можно через Docker следующей командой:
docker run -d -p 8080:8080 --name shop resst/shop-test-task:task-image

Альтернативно можно установить проект и запустить через точку входа com.resst.testtask.TestTaskApplication

Я использую 17 версию java.

Описание API можно посмотреть здесь или на главной странице проекта (например localhost:8080)

Проект использует базу данных H2, для доступа к консоли можно использовать относительный путь по умолчанию **/h2-console** 

Для подключения к БД используются следующие данные:

Saved Settings: Generic H2 (Embedded)
Setting Name: Generic H2 (Embedded)
  
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:
(пароль не установлен)

Для взаимодействия с проектам используются следующие эндпоинты:
**Относительный путь:** /api/product
**Эндпоинты:**
**GET** - список всех продуктов
**POST** - добавить новый продукт в список

**Относительный путь:** /api/product/{**id**}
**Эндпоинты:**
**GET** - получить продукт по **id**
**PUT** - полностью обновить продукт по **id**
**PATCH** - частично обновить продукт по **id**
**DELETE** - удалить продукт поby **id**

**Относительный путь:** /api/product/type/{**type-name**}
**Эндпоинты:**
**GET** - список продуктов с типом **type-name** (**enum Type**). **type-name** записывается заглавными буквами с _ разделителем

**Относительный путь:** /h2-console
Подключение к БД H2

**enum Type** содержит следующие значения: **PC**, **LAPTOP**, **MONITOR**, **HARD_DRIVE**

JSON объект продукта имеет следующую структуру:
{
    "productId": Long,
    "serialNumber": "String",
    "manufacturer": String,
    "price": BigDecimal,
    "type": enum Type,
    "quantity": Integer,
    "properties": {
        "property1-name": property1-value,
        "property2-name": property2-value
    }
}

**price** и **serialNumber** не могут быть пустыми или null при использовании методов **/api/product POST** и **/api/product/{id} PUT**.

/api/product/{**id**} при обновлении не будет учитывать null значения.
