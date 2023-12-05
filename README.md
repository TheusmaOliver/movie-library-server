# Projeto Spring Boot: Biblioteca de Filmes

Este é um projeto Spring Boot para uma biblioteca de filmes, que utiliza um banco de dados PostgreSQL para armazenamento, implementa autenticação e autorização com Spring Security usando JWT Token, permite a criação de contas de usuário com as roles 'user' e 'admin', consome [esse microserviço](https://github.com/TheusmaOliver/email-service-rabbitmq) de envio de e-mail utilizando RabbitMQ esse e-mail é disparado quando o usuário cria uma conta e o projeto utiliza o Swagger para documentação da API.
## Tecnologias Utilizadas

- Spring Boot
- PostgreSQL
- RabbitMQ
- Spring Security
- JWT (JSON Web Token)
- Swagger

## Pré-requisitos

- Java 8 ou superior
- PostgreSQL
- Maven

## Configuração do Banco de Dados

Certifique-se de configurar as propriedades do banco de dados no arquivo `application.properties`.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nome-do-banco
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
```

## Microserviço de Envio de E-mail

O projeto consome um microserviço de envio de e-mail utilizando RabbitMQ. Certifique-se de ter o RabbitMQ configurado e atualize as informações no arquivo `application.properties`.

```properties
# Configurações do RabbitMQ
spring.rabbitmq.addresses=seu_addresses
spring.rabbitmq.queue=sua_queue
```

## Autenticação e Autorização

A autenticação e autorização são tratadas pelo Spring Security com JWT Token. Os usuários podem ser registrados com as roles "user" ou "admin". Certifique-se de configurar as propriedades JWT no arquivo `application.properties`.

```properties
# Configurações JWT
jwt.secret=sua_secret_key
```

## Funcionalidades

1. **Autenticação e Autorização:** O projeto utiliza o Spring Security para autenticação e autorização. As rotas são protegidas com base nas funções do usuário (user ou admin).

2. **JWT Token:** A autenticação é feita através de JWT Token, que é gerado no momento do login e utilizado para autorizar requisições subsequentes.

3. **Criação de Conta de Usuário:** Os usuários podem se registrar no sistema, especificando se são usuários comuns (user) ou administradores (admin).

4. **Roles de Usuário:** As contas de usuário têm diferentes roles (funções) que determinam suas permissões. As roles disponíveis são "user" e "admin".

5. **Documentação da API com Swagger:** A API é documentada usando o Swagger, permitindo que os desenvolvedores visualizem e interajam com os endpoints de forma fácil e eficiente.

## Como Executar o Projeto

1. Clone o repositório: 
   ```bash
   git clone https://github.com/TheusmaOliver/movie-library-server.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd movie-library-server
   ```

3. Execute o projeto usando o Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Acesse a documentação da API Swagger em [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

## Endpoints Principais

- `/auth/login`: Endpoint para autenticação e obtenção do token JWT.
- `/auth/register`: Endpoint para registro de novos usuários.
- `/auth/admin/register`: Endpoint para registro de novos usuários com a role admin.
- `/movies`: Endpoints para operações relacionadas a filmes (ex: listagem, criação, atualização, exclusão).

## Exemplo de Requisição para Autenticação

```http
POST /auth/login
Content-Type: application/json

{
  "username": "seu-usuario",
  "password": "sua-senha"
}
```

## Exemplo de Requisição para Registro de Usuário

```http
POST /auth/register
Content-Type: application/json

{
  "username": "novo-usuario",
  "email": "email",
  "password": "senha",
  "role": "user_role"
}
```

## Autor
  
 <img style="border-radius: 50%;" src="https://avatars3.githubusercontent.com/u/81190214?s=460&u=61b426b901b8fe02e12019b1fdb67bf0072d4f00&v=4" width="100px;" alt="Avatar"/>
 <br />
 <b width="36px">Matheus Rodrigues 🚀</b>


Feito com ❤️ por Matheus Rodrigues 👋🏽 Entre em contato!

[![Linkedin Badge](https://img.shields.io/badge/-Matheus-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/theusmaoliver/)](https://www.linkedin.com/in/theusmaoliver/) 
[![Gmail Badge](https://img.shields.io/badge/-matheusrodriguesoliveira273@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:matheusrodriguesoliveira273@gmail.com)](mailto:matheusrodriguesoliveira273@gmail.com)
