<h1 align="center">
  Nota Fiscal System
</h1>

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JDBC](https://spring.io/projects/spring-data-jdbc)
- [Spring for Apache Kafka](https://spring.io/projects/spring-kafka)
- [Docker Compose](https://docs.docker.com/compose/)
- [MySql](https://www.mysql.com/)

## Como Executar

- Clonar repositório git:
```
https://github.com/FernandaSlomp/case-nota-fiscal-system
```
- Executar o Kafka e Mysql:
```
docker-compose up
```

- Executar o mock Spring Boot
- Acessar aplicação em `http://localhost:8080`.

- Executar a aplicação Spring Boot
- Acessar aplicação em `http://localhost:8771`.

## API

POST /api/notas-fiscais HTTP/1.1
Host: localhost:8771
Content-Type: application/json
Content-Length: 237

  {
    "cpfCnpj": "string",
    "idNotaFiscal": "string",
    "totalAmount": 0.0,
    "status": "string",
    "issuanceDate": "2023-05-16T14:25:43.511",
    "payments": [
      {
        "paymentMethodId": 1,
        "amount": 0.0
      }
    ]
  }
```
