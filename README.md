# Board de Tarefas! com Spring Boot

Um sistema de gerenciamento de boards, colunas e tarefas, desenvolvido em **Java** com **Spring Boot**. Permite criar boards, organizar colunas e gerenciar tarefas com CRUD completo. 

## 🔹 Funcionalidades

- CRUD de **Boards** (quadro de tarefas)
- CRUD de **Columns** (colunas dentro de um board)
- CRUD de **Tasks** (tarefas dentro de uma coluna)
- Listagem de tarefas por coluna ou todos os boards
- Validação de entrada usando **Jakarta Validation**
- Documentação de API com **Swagger/OpenAPI**
- Relacionamentos entre entidades usando **JPA/Hibernate**

## 🔹 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Swagger/OpenAPI
- Jakarta Validation (Bean Validation)
- Lombok

## 🔹 Estrutura do Projeto

src/main/java
└─ br.com.projetos.Board_De_Tarefas
├─ controllers # Endpoints REST
├─ services # Lógica de negócio
├─ mappers # Conversão entre entidades e DTOs
├─ repositories # Interfaces JPA
├─ entities # Entidades JPA
└─ dto # Requests e Responses (DTOs)

##🔹 Documentação da API

- O projeto utiliza Swagger/OpenAPI

A documentação está disponível em:
http://localhost:8080/swagger-ui.html

## 🔹 Configuração do Banco de Dados

No `application.properties` ou `application.yml`:

---
`spring.application.name=Board-De-Tarefas`

`spring.datasource.url=jdbc:mysql://localhost:3306/kanban_db?useSSL=false&serverTimezone=UTC`

`spring.datasource.username=root`
`spring.datasource.password=password`

`spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver`

`spring.jpa.hibernate.ddl-auto=update`
`spring.jpa.show-sql=true`
`spring.jpa.properties.hibernate.format_sql=true`
`spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect`

- Certifique-se de criar o banco kanban_db no MySQL antes de iniciar a aplicação:
- Substitua root e password pelas credenciais corretas do seu MySQL.

##🔹 Contato

Desenvolvido por Vinicius T. Stefaneli
- Email: vinicius.stefaneli@fatec.sp.gov.br
- LinkedIn: www.linkedin.com/in/vinicius-tomaz-stefaneli

<img width="897" height="471" alt="image" src="https://github.com/user-attachments/assets/875f8ad0-6781-41b1-a009-97d486b048eb" />

