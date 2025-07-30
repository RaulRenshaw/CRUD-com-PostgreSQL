# 🛒 Sistema de Cadastro de Produtos com Autenticação JWT

Este é um projeto Java que implementa uma API REST para cadastro de produtos com autenticação de usuários via **JWT**. A aplicação utiliza **PostgreSQL** como banco de dados e garante segurança com **criptografia de senhas**.

---

## 🔧 Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Spring Security  
- PostgreSQL  
- JWT (JSON Web Tokens)  
- BCrypt (criptografia de senhas)  
- JPA / Hibernate  
- Maven

---

## 🧠 Funcionalidades

✅ Cadastro de usuários  
✅ Login com geração de token JWT  
✅ Autenticação e autorização com token  
✅ Criptografia de senha com BCrypt  
✅ Cadastro, listagem, atualização e remoção de produtos (CRUD)  
✅ Segurança nas rotas com proteção via token JWT  

---

## 📁 Estrutura do Projeto

src/
├── main/
│ ├── java/
│ │ └── com/seuprojeto/
│ │ ├── controllers/
│ │ ├── models/
│ │ ├── repositories/
│ │ ├── security/
│ │ ├── services/
│ │ └── Application.java
│ └── resources/
│ ├── application.properties

---

## 🚀 Como executar

### Pré-requisitos

- Java 17+  
- PostgreSQL  
- Maven  

### Configuração do banco de dados

No arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seubanco
spring.datasource.username=seuusuario
spring.datasource.password=suasenha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=umasecretsecreta
jwt.expiration=86400000
Rodando o projeto
bash
Copiar
Editar
git clone https://github.com/RaulRenshaw/CRUD-com-PostgreSQL.git
cd CRUD-com-PostgreSQL
./mvnw spring-boot:run
🔐 Rotas de Autenticação
POST /auth/register → Registra um novo usuário

POST /auth/login → Login e retorna o token JWT

🛡️ Proteção com JWT
Após o login, use o token JWT retornado no header de todas as requisições protegidas:

Authorization: Bearer SEU_TOKEN_AQUI
🔄 Rotas de Produto (CRUD)
GET /produtos → Lista todos os produtos

POST /produtos → Cria um novo produto

DELETE /produtos/{id} → Remove um produto

Todas essas rotas exigem autenticação JWT.

🔒 Segurança
Senhas são criptografadas com BCrypt antes de serem salvas no banco

JWT é usado para autenticar e autorizar acesso às rotas protegidas

Usuários não autenticados não conseguem acessar funcionalidades sensíveis

📦 Exemplo de JSON para Cadastro/Login
Registro
POST /auth/register

{
  "usename": "João Silva",
  "password": "minhasenha123"
}
Login
POST /auth/login

{
  "username": "João Silva",
  "senha": "minhasenha123"
}
Resposta:
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6..."
}
🤝 Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.
