# WS process

## 1 Create new class Test
Will get the data from the mysql

## 2 Right click on above(Test) class, and WebServices->Create a new ws
tick monitor ws
tick gen a default services.xml file

## 3 Right click on PROJECT
run as -> run on server
click services->servicename->url ?WSDL

## 4 Copy the wsdl
Click on Test class
http://localhost:8080/epl362-ws/services/Test?wsdl
New >> Other >> Web Services >> Web service Client. 

## 5 Create new class TestController
put sample code (as in TestController)
Right click on class -> run as java application
Here will be part of the GUI.
So other classes will be calling this.
# MERGE THIS