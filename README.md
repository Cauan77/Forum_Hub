# Fórum Hub API

<img width="2816" height="1536" alt="Gemini_Generated_Image_pcgb52pcgb52pcgb" src="https://github.com/user-attachments/assets/d8f8958f-b7a5-4ce3-a53b-ef20b9a9a325" />

Bem-vindo ao coração do **Fórum Hub**, a espinha dorsal que gerencia e dá vida às discussões da nossa comunidade\! Este projeto é a **API backend** que orquestra autores, cursos e, claro, os tópicos de discussão. Crie tópicos, interaja e gerencie o que há de mais importante: o conhecimento compartilhado.
-----
## Sumário

*   [Tecnologias Utilizadas](#tecnologias-utilizadas)
*   [Funcionalidades](#funcionalidades)
*   [Estrutura do Projeto](#estrutura-do-projeto)
*   [Como Rodar o Projeto](#como-rodar-o-projeto)
    *   [Pré-requisitos](#pré-requisitos)
    *   [Configuração do Banco de Dados](#configuração-do-banco-de-dados)
    *   [Executando a Aplicação](#executando-a-aplicação)
*   [Endpoints da API](#endpoints-da-api)
*   [Autenticação e Autorização](#autenticação-e-autorização)
*   [Validações](#validações)
*   [Tratamento de Erros](#tratamento-de-erros)
*   [Documentação da API](#documentação-da-api)
*   [Contribuição](#contribuição)
*   [Licença](#licença)
-----

  ## ⚡ Tecnologias por Trás da Magia

![Java 21](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)

![Spring Boot 3.5.4](https://img.shields.io/badge/Spring%20Boot-3.5.4-green?style=for-the-badge&logo=spring)
![Spring Boot Starter Data JPA](https://img.shields.io/badge/Data%20JPA-Starter-blue?style=for-the-badge&logo=spring)
![Spring Boot Starter Security](https://img.shields.io/badge/Security-Starter-lightgrey?style=for-the-badge&logo=spring)
![Spring Boot Starter Validation](https://img.shields.io/badge/Validation-Starter-yellow?style=for-the-badge&logo=spring)
![Spring Boot Starter Web](https://img.shields.io/badge/Web-Starter-red?style=for-the-badge&logo=spring)
![Spring Boot DevTools](https://img.shields.io/badge/DevTools-Starter-informational?style=for-the-badge&logo=spring)
![Spring Security Test](https://img.shields.io/badge/Security%20Test-lightgrey?style=for-the-badge&logo=spring)

![MySQL Connector/J](https://img.shields.io/badge/MySQL-Connector/J-blue?style=for-the-badge&logo=mysql)

![Flyway Migration](https://img.shields.io/badge/Flyway-Migration-orange?style=for-the-badge&logo=flyway)

![Lombok](https://img.shields.io/badge/Lombok-red?style=for-the-badge&logo=lombok)

![Java JWT (Auth0)](https://img.shields.io/badge/Java%20JWT-Auth0-black?style=for-the-badge&logo=auth0)

![SpringDoc OpenAPI Starter WebMVC UI](https://img.shields.io/badge/OpenAPI-UI-green?style=for-the-badge&logo=openapi-swagger)

## ✨ Funcionalidades em Destaque

Nossa API foi desenhada para ser intuitiva e completa, oferecendo um conjunto de funcionalidades poderosas:

  * **Autenticação Segura (JWT)**: Login protegido e geração de tokens para acesso exclusivo.
  * **Gestão de Autores e Cursos**: Operações **CRUD** completas para gerenciar quem ensina e o que é ensinado.
  * **Ciclo de Vida do Tópico**:
      * **Criação** com validações de regras de negócio para evitar duplicidade.
      * **Listagem** inteligente com paginação para navegar por todos os tópicos.
      * **Atualização** de título e mensagem.
      * **Exclusão** simples e direta.
  * **Validações Robustas**: Garantimos a integridade dos dados com validações de entrada e de negócio.
  * **Tratamento de Erros Eficiente**: Respostas padronizadas para cada tipo de erro, tornando a depuração mais fácil e previsível.
  * **Documentação Interativa (Swagger UI)**: Teste e explore todos os endpoints com uma interface amigável.

-----

## 🗺️ Estrutura do Projeto

A arquitetura em camadas permite uma organização clara e modular, facilitando a manutenção e a evolução do projeto.

```
src/main/java/br/com/alura/forumhub/
├── controller/            # Controladores da API
├── domain/                # Modelos de negócio, repositórios e validações
│   ├── autor/
│   ├── curso/
│   ├── topico/
│   └── usuario/
└── infra/                 # Configurações de segurança e tratamento de erros
    ├── exception/
    ├── security/
    └── springdoc/
```

-----

## 🚀 Como Colocar o Projeto para Rodar

Pronto para mergulhar no código? Siga estes passos simples:

### Pré-requisitos

*   **Java Development Kit (JDK) 21** ou superior.
*   **Maven** (gerenciador de dependências).
*   **MySQL Server** (banco de dados).

### ⚙️ Configuração do Banco de Dados

1.  Crie um banco de dados MySQL, por exemplo: `forumhub_db`.
2.  No arquivo `src/main/resources/application.properties`, configure as suas credenciais:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/forumhub_db
    spring.datasource.username=seu_usuario_mysql
    spring.datasource.password=sua_senha_mysql
    ...
    ```
    O **Flyway** cuidará das migrações do banco de dados automaticamente\!

### 🏃 Executando a Aplicação

1.  **Clone o repositório:**
    `git clone https://github.com/Cauan77/Forum_Hub.git`
    `cd Forum_Hub`

2.  **Compile o projeto com Maven:**
    `./mvnw clean install`

3.  **Inicie a aplicação:**
    `./mvnw spring-boot:run`

    A API estará disponível em `http://localhost:8080`\!

-----

## 🔒 Autenticação e Autorização

A segurança é nossa prioridade. Para acessar a maioria dos endpoints, você precisará de um **token JWT**.

1.  **Faça Login:** Envie um **POST** para `/login` com seu `login` e `senha`.
2.  **Pegue o Token:** A resposta trará seu token JWT.
3.  **Inclua o Token:** Nas próximas requisições, adicione o cabeçalho `Authorization: Bearer <seu_token_aqui>`.

-----

## 📝 Endpoints da API

Explore os principais caminhos da nossa API e comece a interagir\!

### **Autenticação**

  * `POST /login`: Autentica o usuário e retorna o token JWT.

### **Autores**

  * `POST /autores`: Cadastra um novo autor.
  * `GET /autores`: Lista autores com paginação.
  * `GET /autores/{id}`: Detalha um autor.
  * `PUT /autores`: Atualiza um autor.
  * `DELETE /autores/{id}`: Desativa um autor.

### **Cursos**

  * `POST /cursos`: Cadastra um novo curso.
  * `GET /cursos`: Lista cursos com paginação.
  * `GET /cursos/{id}`: Detalha um curso.
  * `PUT /cursos`: Atualiza um curso.
  * `DELETE /cursos/{id}`: Desativa um curso.

### **Tópicos**

  * `POST /topicos`: Cria um tópico.
  * `GET /topicos`: Lista todos os tópicos com paginação.
  * `GET /topicos/{id}`: Detalha um tópico.
  * `PUT /topicos`: Atualiza um tópico.
  * `DELETE /topicos/{id}`: Exclui um tópico.

Para detalhes completos sobre requisições e respostas, visite a **documentação interativa** em `http://localhost:8080/swagger-ui.html`.

-----

## Autor 👨💻

| [<img loading="lazy" src="https://github.com/user-attachments/assets/b2131622-e32c-40ef-a5b5-1794c019d0c5" width=115><br><sub>Cauan Henrique</sub>](https://github.com/Cauan77) |
| :---: |

## Licença



  * **Licença:** Este projeto está sob a licença [Apache 2.0](https://www.google.com/search?q=http://forum.hub/api/licenca).

Espero que tenha gostado do projeto, até mais :)
