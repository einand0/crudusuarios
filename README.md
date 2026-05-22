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
- Paginação na busca de usuários

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

**Listar usuários com paginação**

`GET /users/paginacao?page=0&size=10`

**Parâmetros**
- `page` → número da página
- `size` → quantidade de registros por página

### ⚠️ Regras
- Email deve ser único
- Usuário inexistente retorna erro 404
- Email duplicado retorna erro 409

### ▶️ Execução

`git clone https://github.com/seu-usuario/repo.git
cd crud-usuarios
./mvnw spring-boot:run`

### 📘 Swagger

A API possui documentação interativa utilizando Swagger/OpenAPI, permitindo visualizar e testar os endpoints diretamente pelo navegador.

Após iniciar a aplicação, acesse:

`http://localhost:8080/swagger-ui/index.html`

Recursos implementados
- Organização dos endpoints com @Tag
- Documentação detalhada com @Operation
- Responses HTTP documentadas
-Exemplos de dados nos DTOs utilizando @Schema
- Descrição de parâmetros utilizando @Parameter

O Swagger foi utilizado para tornar a API mais intuitiva, facilitando o consumo e entendimento dos endpoints.
