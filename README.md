**Desafio Backend Java Exactaworks**


Descrição:

Este projeto, desenvolvido em Java 17 com Spring Boot, foi criado para o processo de seleção da Exactaworks. A aplicação oferece uma API RESTful para gerenciar gastos.


Funcionalidades:

Registro de Gastos: Adicione novos gastos com nome, descrição, data, valor e tags.
Consulta de Gastos: Obtenha uma lista de todos os seus gastos ou consulte um gasto específico por ID.


Tecnologias:

Linguagem de Programação: Java 17
Framework: Spring Boot
Banco de Dados: PostgreSQL
Contêinerização: Docker Compose


Execução:

Clone o projeto para o seu computador.
Na raiz do projeto, execute o comando **docker-compose up**.
A aplicação estará disponível em **localhost:8080**.


Teste da API:

Utilize ferramentas como Postman ou Insomnia para enviar requisições HTTP aos endpoints da API.

Três endpoints estão disponíveis:

GET /gastos: Retorna uma lista de todos os gastos.

GET /gastos/{id}: Retorna um gasto específico pelo ID.

POST /gastos: Registra um novo gasto.

Exemplo de Requisição POST:



```JSON
{
  "nome": "Gasto Exemplo",
  "descricao": "Descrição do meu gasto",
  "data": "2024-03-14T12:00:00",
  "valor": 100.50,
  "tags": "TAG1"
}

```


Exemplo de Resposta GET:


```JSON
[
  {
    "id": 1,
    "nome": "Gasto Exemplo",
    "descricao": "Descrição do meu gasto",
    "data": "2024-03-14T12:00:00",
    "valor": 100.50,
    "tags": "TAG1"
  }
]

```
