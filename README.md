# Attornatus TESTE API

Este repositório contém uma aplicação desenvolvida para o teste técnico da vaga de desenvolvedor BackEnd da Attornatus.
A API implementa disponibiliza um serviço de cadastro e edição de Pessoas e Endereços. 
A API foi desenvolvida com Spring, utilizando o banco H2 em mémoria e JUNIT para aplicação de Testes Unitarios.

A aplicação desenvolvida permite o cadastro e edição de Pessoas e Endereços Vinculados as mesmas.

Uma Pessoa deve ter:
* Nome
* Data de nascimento
* Endereço


Um endereço é composto por:
* Logradouro
* CEP
* Número
* Cidade 


A API oferece as seguintes funcionalidades:

* Criar uma pessoa
* Editar uma pessoa
* Consultar uma pessoa
* Listar pessoas
* Criar Endereço para Pessoas
* Listar Endereços da pessoa
* Definir endereço principal da pessoa



Requisitos:
* Todas as respostas da API são no formato JSON
* Utilização do banco de dados H2
* Implementação de testes unitários
* Adoção de Clean Code

# ENDPOINTS

### Listar Pessoas Cadastradas

Para a buscar a lista de todas as pessoas cadastradas na aplicação, deve se fazer uma solicitação GET para o seguinte caminho:


GET /pessoa

A solicitação, ira retornar uma mensagem semelhante a resposta abaixo:

```javascript
[
    {
        "nome": "Carlos",
        "dataNascimento": "12/12/2022",
        "id": 1
    },
    {
        "nome": "Sergio",
        "dataNascimento": "12/12/2022",
        "id": 2
    }
]
```

### Buscar por uma Pessoa

Para a buscar uma pessoa dentro da lista cadastrada na aplicação, deve se fazer uma solicitação GET para o seguinte caminho:


GET /pessoa/{ Id }

Onde o Id da pessoa que será buscada, deve ser informada dentro do caminho da requisiçao.

A solicitação, ira retornar uma mensagem semelhante a resposta abaixo, caso a pessoa seja encontrada:

```javascript
    {
        "nome": "Carlos",
        "dataNascimento": "12/12/2022",
        "id": 1
    }
```

Caso o Id informado não pertenca a nenhuma pessoa, a respoosta retornada será um `404 NOT FOUND`.



### Criar Uma Pessoa

A criação de pessoas dentro da API é feita atráves de uma requisição POST para o seguinte caminho:

POST   /pessoa

onde o corpo da requisição deve conter os seguintes campos:

```javascript
    {
        "nome": "Carlos",
        "dataNascimento": "12/12/2022"
    }
```

A resposta para a requisição, será da seguinte forma:

```javascript
    { 
        "id": 1,
        "nome": "Carlos",
        "dataNascimento": "12/12/2022",
    }
```


### Editar Uma Pessoa cadastrada

A edição de pessoas dentro da API é feita atráves de uma requisição PATCH para o seguinte caminho:

PATCH /pessoa/{id}

onde o Id, da pessoa que tera suas informaçãos atualizadas, deve ser informado no caminho da requisiçao.

O corpo da requisição poderá conter o novo nome ou nova data de nascimento que será atribuida a aquela pessoa.
Exemplo:

PATCH /pessoa/1

```javascript
    {
        "nome": "Antonio"
    }
```

A resposta para a requisição, será da seguinte forma:

```javascript
    { 
        "id": 1,
        "nome": "Antonio",
        "dataNascimento": "12/12/2022",
    }
```
