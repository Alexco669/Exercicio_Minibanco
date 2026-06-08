# Cadastro de Clientes e Contas Bancárias (Mini Banco API)

Esta é uma API REST desenvolvida em Java com Spring Boot para o gerenciamento de clientes e contas bancárias vinculadas. O projeto armazena os dados em um banco de dados relacional MySQL.

---

## 🛠️ Tecnologias Utilizadas

*   **Java 17** ou superior
*   **Spring Boot 3.3.3**
*   **Spring Data JPA** (Persistência de dados)
*   **Hibernate** (Mapeamento Objeto-Relacional)
*   **MySQL Driver** (Conectividade com banco de dados)
*   **Jackson** (Serialização e desserialização de JSON)
*   **Maven** (Gerenciador de dependências e build)

---

## 🚀 Como Executar o Projeto

### 1. Configurar o Banco de Dados
A aplicação se conecta ao MySQL. Certifique-se de que o MySQL está rodando e crie o banco de dados:
```sql
CREATE DATABASE minibanco;
```

As configurações de conexão padrão estão em `src/main/resources/application.yaml`:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/minibanco
    username: seu_usuario
    password: sua_senha
```
*Caso sua senha ou usuário do MySQL sejam diferentes, ajuste esses campos no arquivo.*

### 2. Rodar a Aplicação
Execute o comando Maven na pasta raiz do projeto:
```bash
./mvnw spring-boot:run
```
A API iniciará na porta padrão **8080**.

---

## 🔌 Documentação da API (Rotas para Teste no Postman)

### 👥 Clientes (`/clientes`)

#### 🔹 Cadastrar Cliente (`POST /clientes`)
*   **URL:** `http://localhost:8080/clientes`
*   **Body (JSON):**
```json
{
  "name": "Maria da Silva",
  "dataNascimento": "1995-10-15",
  "email": "maria.silva@email.com",
  "telefone": "48999998888",
  "contatoAdicional": "João Silva (Pai) - 48988887777",
  "limiteCredito": 1500.00
}
```

#### 🔹 Buscar Cliente por ID (`GET /clientes/{id}`)
*   **URL:** `http://localhost:8080/clientes/1`

---

### 🏦 Contas Bancárias (`/contas-bancarias`)

#### 🔹 Criar Conta Bancária (`POST /contas-bancarias`)
*   **URL:** `http://localhost:8080/contas-bancarias`
*   **Body (JSON):**
```json
{
  "numeroConta": "1234567",
  "digitoConta": 9,
  "numeroAgencia": "0001",
  "digitoAgencia": 0,
  "banco": "NUBANK",
  "cliente": {
    "id": 1
  }
}
```
*(Valores aceitos para o campo `banco`: `NUBANK`, `ITAU`, `BRADESCO`, `BANCODOBRASIL`, `PICPAY`, `SANTANDER`)*

#### 🔹 Buscar Conta por ID (`GET /contas-bancarias/{id}`)
*   **URL:** `http://localhost:8080/contas-bancarias/1`

#### 🔹 Listar Contas com Paginação (`GET /contas-bancarias`)
*   **URL:** `http://localhost:8080/contas-bancarias?pageNumber=0&registrosPorPagina=3`
