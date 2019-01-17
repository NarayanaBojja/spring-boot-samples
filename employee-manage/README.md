#Steps to run the application

1. Download this project as zip file 
2. Take the sql file "empmanage.sql" file  from "src/main/resources" folder and execute in MYSQL work bench
3. Import the project to Eclipse
4. Run below commands

maven clean install spring-boot:run

or 

maven clean install

Next run as a java application 


#Employee-Crud App-Rest API doc

Add Employee 

Url : http://localhost:2020/employee/add

Method type : Post

Content-Type : "application/json"

Request body :

{
	"name":"Narayana Bojja",
	"email":"narayana@gmail.com",
	"phone":9848012345,
	"married": false
}

Response :

{
    "status": 201,
    "message": "Employee is created successfully",
    "data": {
        "id": 3,
        "name": "Narayana Bojja",
        "email": "narayana@gmail.com",
        "phone": 9848012345,
        "married": false
    }
}












2. Get by name
Url : http://localhost:2020/employee/get/Narayana Bojja

Method type : Get

Response :

{
    "status": 200,
    "message": "Getting Employee by full name is successful",
    "data": {
        "id": 3,
        "name": "Narayana Bojja",
        "email": "narayana@gmail.com",
        "phone": 9848012345,
        "married": false
    }
}


3. Get All employees

Url : http://localhost:2020/employee/all

Method type : Get
Response :
{
    "status": 200,
    "message": "Getting All Employees is successful",
    "data": [
        {
            "id": 2,
            "name": "Narayaha",
            "email": "hg@gmail.com",
            "phone": 89872122,
            "married": false
        },
        {
            "id": 3,
            "name": "Narayana Bojja",
            "email": "narayana@gmail.com",
            "phone": 9848012345,
            "married": false
        }
    ]
}


4. Update Employee

Url : http://localhost:2020/employee/update

Content-Type : "application/json"

Method type : Put

Request:
{
	"id": 3,
	"name":"Narayana B",
	"email":"narayana@gmail.com",
	"phone":9848012345,
	"married": false
}

Response body:
{
    "status": 200,
    "message": "Employee is updated successfully",
    "data": {
        "id": 3,
        "name": "Narayana B",
        "email": "narayana@gmail.com",
        "phone": 9848012345,
        "married": false
    }
}







5. Delete employee

Url : http://localhost:2020/employee/delete?id=2

 Method type : Delete

Response body:

{
    "status": 200,
    "message": "Employee is deleted successfully",
    "data": null
}


