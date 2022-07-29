# Desafio BHUT  Serviços Tecnologia

## Prova Java

### Instruções de Acesso

Para rodar esse projeto, deve usar esse seguinte comando:

- mvn spring-boot:run

### Tabelas

Cars
- id (String)
- title (String)
- brand (String)
- price (String)
- age (Integer)

Logs
- id (String)
- data_hora (Date)
- car_id (FK/String)

### Requisitos de API

Os requisitos de API deste projeto foram criados na base do sistema CRUD e foram testados no programa de API Client chamado Postman.

#### Cars

GetAll => http://api-test.bhut.com.br:3000/api/cars

GetById => http://api-test.bhut.com.br:3000/api/cars/{id}

Create => http://api-test.bhut.com.br:3000/api/cars
 
Update => http://api-test.bhut.com.br:3000/api/cars/{id}

Delete => http://api-test.bhut.com.br:3000/api/cars/{id}

##### Logs

GetAll => http://api-test.bhut.com.br:3000/api/logs

GetById => http://api-test.bhut.com.br:3000/api/logs/{id}

Create => http://api-test.bhut.com.br:3000/api/logs
 
Update => http://api-test.bhut.com.br:3000/api/logs/{id}

Delete => http://api-test.bhut.com.br:3000/api/logs/{id}
