# API de Gerenciamento de Alunos

Esta é uma API para gerenciamento de alunos, desenvolvida em Spring Boot e utilizando PostgreSQL como banco de dados. A API permite criar, buscar, listar, atualizar e excluir alunos.

## Tecnologias Utilizadas
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **PostgreSQL**: Banco de dados relacional para armazenamento dos dados.
- **Swagger**: Documentação interativa da API.

---

## Endpoints da API

Abaixo estão os endpoints disponíveis na API:

---

### 1. Salvar um novo aluno
Cria um novo aluno no banco de dados.

- **Método**: `POST`
- **URL**: `/aluno/save`
- **Corpo da Requisição** (JSON):
  ```json
  {
    "nome": "João Silva",
    "email": "joao.silva@example.com"
  }
  ```
- **Resposta de Sucesso** (Status: `201 Created`):
  ```json
  {
    "id": 1,
    "nome": "João Silva",
    "email": "joao.silva@example.com"
  }
  ```

---

### 2. Buscar um aluno pelo ID
Retorna os detalhes de um aluno com base no ID fornecido.

- **Método**: `GET`
- **URL**: `/aluno/{id}`
- **Exemplo de URL**: `/aluno/1`
- **Resposta de Sucesso** (Status: `200 OK`):
  ```json
  {
    "id": 1,
    "nome": "João Silva",
    "email": "joao.silva@example.com"
  }
  ```
- **Resposta de Erro** (Status: `404 Not Found`):
  ```json
  {
    "mensagem": "Aluno não encontrado"
  }
  ```

---

### 3. Listar todos os alunos
Retorna uma lista de todos os alunos cadastrados.

- **Método**: `GET`
- **URL**: `/aluno`
- **Resposta de Sucesso** (Status: `200 OK`):
  ```json
  [
    {
      "id": 1,
      "nome": "João Silva",
      "email": "joao.silva@example.com"
    },
    {
      "id": 2,
      "nome": "Maria Oliveira",
      "email": "maria.oliveira@example.com"
    }
  ]
  ```

---

### 4. Atualizar um aluno
Atualiza os dados de um aluno existente com base no ID fornecido.

- **Método**: `PUT`
- **URL**: `/aluno/update/{id}`
- **Exemplo de URL**: `/aluno/update/1`
- **Corpo da Requisição** (JSON):
  ```json
  {
    "nome": "João Silva Atualizado",
    "email": "joao.silva.novo@example.com"
  }
  ```
- **Resposta de Sucesso** (Status: `200 OK`):
  ```json
  {
    "id": 1,
    "nome": "João Silva Atualizado",
    "email": "joao.silva.novo@example.com"
  }
  ```

---

### 5. Excluir um aluno
Remove um aluno do banco de dados com base no ID fornecido.

- **Método**: `DELETE`
- **URL**: `/aluno/delete/{id}`
- **Exemplo de URL**: `/aluno/delete/1`
- **Resposta de Sucesso** (Status: `200 OK`):
  ```json
  {
    "mensagem": "Aluno com ID 1 excluído com sucesso."
  }
  ```

---

## Configuração do Banco de Dados (PostgreSQL)

A API utiliza o PostgreSQL como banco de dados. Abaixo estão os detalhes de configuração necessários no arquivo `application.properties` ou `application.yml` do seu projeto Spring Boot:

### Exemplo de Configuração (`application.properties`)
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/alunos_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### Explicação das Propriedades
- **`spring.datasource.url`**: URL de conexão com o banco de dados PostgreSQL. Substitua `alunos_db` pelo nome do seu banco de dados.
- **`spring.datasource.username`**: Nome de usuário do PostgreSQL.
- **`spring.datasource.password`**: Senha do PostgreSQL.
- **`spring.jpa.hibernate.ddl-auto=update`**: Configura o Hibernate para atualizar o esquema do banco de dados automaticamente.
- **`spring.jpa.show-sql=true`**: Exibe as consultas SQL no console para fins de depuração.
- **`spring.jpa.properties.hibernate.dialect`**: Define o dialeto do Hibernate para PostgreSQL.

---

## Como Executar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/api-alunos.git
   cd api-alunos
   ```

2. **Configure o PostgreSQL**:
    - Crie um banco de dados chamado `alunos_db` (ou outro nome de sua preferência).
    - Atualize as credenciais no arquivo `application.properties`.

3. **Execute o projeto**:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Acesse a documentação da API**:
    - Abra o navegador e acesse `http://localhost:8080/swagger-ui.html` para visualizar a documentação interativa da API.

---

## Exemplos de Uso

### Criar um Aluno
```bash
curl -X POST http://localhost:8080/aluno/save \
-H "Content-Type: application/json" \
-d '{
  "nome": "Carlos Souza",
  "email": "carlos.souza@example.com"
}'
```

### Buscar um Aluno pelo ID
```bash
curl -X GET http://localhost:8080/aluno/1
```

### Listar Todos os Alunos
```bash
curl -X GET http://localhost:8080/aluno
```

### Atualizar um Aluno
```bash
curl -X PUT http://localhost:8080/aluno/update/1 \
-H "Content-Type: application/json" \
-d '{
  "nome": "Carlos Souza Atualizado",
  "email": "carlos.souza.novo@example.com"
}'
```

### Excluir um Aluno
```bash
curl -X DELETE http://localhost:8080/aluno/delete/1
```

---

## Considerações Finais

Esta API é uma solução simples para gerenciamento de alunos, podendo ser expandida com funcionalidades adicionais, como validações de dados, autenticação e autorização. O uso do PostgreSQL garante robustez e escalabilidade para o armazenamento dos dados.

Para dúvidas ou sugestões, entre em contato!
```
