# CRUD Usuários API - Spring Boot

API REST desenvolvida com Spring Boot para gerenciamento de usuários, aplicando boas práticas de arquitetura em camadas, uso de DTOs, Mapper e tratamento global de exceções.

### 🚀 Funcionalidades
- Criar usuário
- Listar todos os usuários
- Buscar usuário por ID
- Atualizar usuário
- Deletar usuário
- Validação de e-mail único
- Tratamento de erros personalizados

### 🧱 Arquitetura

Controller → Service → Repository → Database

DTOs são utilizados para entrada e saída de dados, evitando exposição da Entity.

### 🛠️ Tecnologias
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation
- Lombok
- H2
- Swagger

### 📡 Endpoints

**Criar usuário**

`POST /users`

`Request:
{
"name": "João Silva",
"email": "joao@email.com",
"password": "123456"
}`

**Listar usuários**

`GET /users`

**Buscar por ID**

`GET /users/{id}`

**Atualizar usuário**

`PUT /users/{id}`

`Request:
{
"name": "João Atualizado",
"email": "novo@email.com",
"password": "123456"
}`

**Deletar usuário**

`DELETE /users/{id}`

### ⚠️ Regras
- Email deve ser único
- Usuário inexistente retorna erro 404
- Email duplicado retorna erro 409

### ▶️ Execução

`git clone https://github.com/seu-usuario/repo.git
cd crud-usuarios
./mvnw spring-boot:run`
