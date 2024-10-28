# Library Management System API

Gradle version 8.5

JAVA version 17.0.6

## Integrate API


**Git clone  https://github.com/zoalfikar/library_managment_system.git**

**Cd library_managment_system**

**Gradle build**or **.\ gradlew build**
  
## Setup
#### Connecting with Mysql and Redis

Run Mysql server **net start mysql** or **net start mysql80** according to your Mysql version Create **new database .**

Set up the **application.properties** add [ datasource.username and datasource.password and database.name] .

**gradle :utilities:run --args=migrate** or **gradle :utilities:run --args=migrate:refresh**

to Create a migration Go  *utilities\src\main\java\migrations\tables* add file **{migration_name}.migration** .

**gradle :utilities:run --args=migrate:triggers**

**gradle :utilities:run --args=seed:library**

start **redis-server** for caching
## start the application

**Gradle bootrun**

## Testing th Api

**Gradle test**
## Usage

**curl http://localhost:7788**

{"message":"Welcome in library managment system"}

## APIs

#### Auth

post **api/auth/signup**      request {firstName ,lastName , email .password }     register a new user

post **api/auth/login**     request {email ,password }     response {token}      token type is bearer token


#### CURD Patron

get **api/patrons** all patrons

get **api/patrons/{patronId}** retrieve patron
        
post **api/patrons** add new patron
        
put **api/patrons/{patronId}** update patron
        
delete **api/patrons/{patronId}** delete patron
        
#### CURD Book

get **api/books** all books
        
get **api/books/{bookId}** retrieve book
        
post **api/books** add new book
        
put **api/books/{bookId}** update book
        
delete **api/books/{bookId}** delete book
        
#### Library Managment

post **/api/borrow/{bookId}/patron/{patronId}** patron borrow a book
        
put **/api/return/{bookId}/patron/{patronId}** patron return a book
        
Get **/api/borrowing/records/patron/{patronId}** get patron borrowing records
        
Get **/api/borrowing/records/book/{bookId}** get book borrowing records
        

