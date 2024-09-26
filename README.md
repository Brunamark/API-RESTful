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
  <li>GET /user/id</li>
</ul>
