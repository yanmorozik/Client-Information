# Endpoint assignments

### 1. Add new client:

* POST http://localhost:8080/clients

### 2. Add a new client contact (phone or email):

* POST http://localhost:8080/mails
* POST http://localhost:8080/phones

### 3. Get a list of clients:

* GET http://localhost:8080/clients

### 4. Get a certain client by id:

* GET http://localhost:8080/clients/{id}

### 5. Retrieving a list of contacts for a given client:

* GET http://localhost:8080/clients/{id}/contacts

### 6. Retrieving a list of contacts of a given type for a given client:

* GET http://localhost:8080/clients/{id}/contacts?type={type}