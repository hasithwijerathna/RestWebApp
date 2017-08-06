Technologies  used
```
mybatis 3.2.3
jersey 1.8
mysql BD
AngularJS v1.3.1
ngDialog
tomcat server
```

``` mysql
CREATE DATABASE test_db;

CREATE TABLE STUDENT(
  student_id   INT      NOT NULL AUTO_INCREMENT,
  name VARCHAR (20)     NOT NULL,
  age  INT              NOT NULL,
  address  CHAR (25),
  PRIMARY KEY (student_id)
);
```

- I have used `mybatis` as a persistence framework to mappings database records to POJO (Plain Old Java Objects).
- `AngularJs` As front end framework. 
- `Jersey` framework used to developing RESTful Web services.
- `Apache Maven` is used as a software project management tool.

![Alt text](search.PNG?raw=true "Search window")

![Alt text](insert.PNG?raw=true "Insert Window")

![Alt text](delete.PNG?raw=true "Insert Window")

