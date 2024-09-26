# API RESTful

## Overview
This RESTful API follows the Model-View-Controller (MVC) architecture, which structures the application in a clear and manageable way.
<ul>
  <li><strong>Model </strong>: Manages the data and business logic. It interacts with the database to fetch and manipulate data.</li>
  <li><strong>View </strong>: In the context of a RESTful API, the "view" is the data representation (usually JSON) sent back to the client.</li>
  <li><strong>Controller </strong>: Handles incoming requests from clients, processes them by invoking the appropriate methods on the Model, and returns the data response to the client.</li>
</ul>


## Table of Contents
<ol>
  <li>Technologies Used</li>
  <li>Getting Started</li>
  <li>API Endpoints</li>
  <li>Authentication</li>
  <li>Error Handling</li>
  <li>Running the Application</li>
</ol>

### 1. Technologies Used

<ul>
  <li> Java 22</li>
  <li> Spring Boot 3.3.4</li>
  <li> Maven 3.9.9</li>
  <li> MySQL database</li>
</ul>

### 2. Getting started

### Prerequisites
<ul>
  <li>Java JDK 17+</li>
  <li>Maven</li>
</ul>

### Instalation

<ol>
  <li>Clone the repository:</li>
  
```bash
  $ git clone https://github.com/Brunamark/API-RESTful.git
````
<li>Navigate into the project directory:</li>

```bash
  $ cd <path-to-repo>
````
<li>Build the project:</li>

```bash
  $ mvn install
````
</ol>

### API Endpoints

<ul>
  <li>GET /user/{id}</li>
      Response: 

      
          [
            {
              id: 2,
              username: "pedro",
              password: "strongpassword"
            }
          ]
          
    
</ul>
<ul>
  <li>GET /task/{id}</li>
      Response: 

      
          [
            {
              id: 1,
              user_id: 2,
              description: "this is a description writed by pedro"
            }
          ]
          
</ul>
<ul>
  <li>POST /user</li>
      Response: 
  
       Status Code: 201 Created
       Location Header: he URL of the newly created user resource (e.g., `/user/{id}`).
   
</ul>
<ul>
  <li>POST /task</li>
      Response: 
  
       Status Code: 201 Created
       Location Header: he URL of the newly created user resource (e.g., `/task/{id}`).
   
</ul>
<ul>
  <li>PUT /user/{id}</li>
      Response: 

      
          [
            {
              id: 2,
              username: "pedro",
              password: "newpassword"
            }
          ]
          
</ul>
<ul>
  <li>PUT /task/{id}</li>
      Response: 

      
          [
            {
              id: 1,
              user_id: 2,
              description: "this is a new description writed by pedro"
            }
          ]
          
</ul>

<ul>
  <li>DELTE /user/{id}</li>
      Response: 

      
      Status Code: 204  No Content
          
</ul>

<ul>
  <li>DELTE /task/{id}</li>
      Response: 

      
      Status Code: 204  No Content
          
</ul>

### 4. Authentication

Not yet implemented. In the future it will be implemented JWT Auth.

### 5. Error Handling

Not yet implemented.

### 6. Running the Application

As soon as the project finishes, it will be available.
