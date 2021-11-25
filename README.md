# Introduction

This is a simple application for managing fake web page called "www.vinazos.org" (the page is not exist)
This repo is just using for replying my knowledge in Spring boot and deploy this microservice in K8s

# DataBase

![Drag Racing](vinazos_schema.png)

# Methods

Get All Wines:

```
GET /wines
```

| REST METHOD | URI                        | DESCRIPTION                             | RESPONSE        | DONE |
|-------------|----------------------------|-----------------------------------------|-----------------|------|
| POST        | /wine                      | This method create a new wine           | 201 for ok      | X    |
| GET         | /wine/{id}                 | This method returns one specific wine   | Wine            |      |
| GET         | /wines                     | This method returns all wines           | Array of Wine   |      |
| PUT         | /wine/{id}                 | This method update a wine               | 200 for ok      |      |
| DELETE      | /wine/{id}                 | This method delete a wine               | 200 for ok      |      |
| GET         | /region                    | This method returns all region          | Array of Region |      |
| GET         | /region/{id}               | This method returns one specific region | region          |      |
| POST        | /region                    | This method create a new region         | 201 for ok      |      |
| PUT         | /region/{id}               | This method update a region             | 200 for ok      |      |
| DELETE      | /region/{id}               | This method delete a region             | 200 for ok      |      |
| GET         | /region/{id}               | This method returns one specific region | user            |      |
| POST        | /user                      | This method create a new user           | 201 for ok      |      |
| PUT         | /user/{id}                 | This method update an user              | 200 for ok      |      |
| DELETE      | /user/{id}                 | This method delete an user              | 200 for ok      |      |
| GET         | /user/auth/{id}/{password} | This method is for authentication       | 200 for ok      |      |

# Objects

### Wine

| name      | type   |
|-----------|--------|
| Id        | Long   | 
| Name      | String | 
| Sweetness | String | 
| Acidity   | String | 
| Tannin    | String | 
| Alcohol   | String | 
| Body      | String | 

### Region

| name     | type   |
|----------|--------|
| Id       | Long   | 
| Name     | String | 
| Location | String | 
| Country  | String | 

### User

| name     | type            |
|----------|-----------------|
| Id       | String          | 
| Name     | String          | 
| Email    | String          | 
| Password | String          | 
| Region   | Array of Region |
