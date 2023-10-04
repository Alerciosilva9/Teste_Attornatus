# Attornatus TESTE API

Este repositório contém uma aplicação desenvolvida para o teste técnico da vaga de desenvolvedor BackEnd da Attornatus.
A API disponibiliza um serviço de cadastro e edição de Pessoas e Endereços. 
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
        "dataNascimento": "12-12-2022",
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
        "dataNascimento": "12-12-2022"
    }
```

A resposta para a requisição, será da seguinte forma:

```javascript
    { 
        "id": 1,
        "nome": "Carlos",
        "dataNascimento": "12-12-2022",
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
        "dataNascimento": "12-12-2022",
    }
```



### Criar Endereço

A criação de endereços dentro da aplicação é feita atráves de uma requisição POST para o seguinte caminho:

POST   /pessoa/ { id } /endereco

onde o Id da pessoa a quem pertence o novo endereço, deve ser informado no caminho da requisição:

O corpo da requisição deverá conter as seguintes propriedades:

```javascript
    {
       "logradouro":"Rua do Sol",
       "cep":"67899-000",
       "numero":75,
       "cidade":"São João"
    }
```

A resposta para a requisição retornará um código `201 CREATED` , e o corpo da resposta será da seguinte forma:

```javascript
    {
       "logradouro":"Rua do Sol",
       "cep":"67899-000",
       "numero":75,
       "cidade":"São João"
    }
```

Caso o Id informado não pertença a nenhuma pesssoa requisição retornara uma resposta contendo o código `404 NOT FOUND`, caso o corpo
da requisiçao não contenha os campos nescessarios, a resposta será `404 BAD REQUEST`.

### Listar Endereços de uma Pessoa

Para a buscar a lista de todos os endereços de uma pessoa cadastradas  na aplicação, deve se fazer uma solicitação GET para o seguinte caminho:


GET /pessoa/ { id } /endereco

A solicitação irá retornar o código `200 OK`caso a requisição obtenha sucesso, contendo uma mensagem semelhante a resposta abaixo:

```javascript
{
        "logradouro": "Rua da Luz",
        "cep": "56345-011",
        "numero": "12",
        "cidade": "São lUis"
    },
    {
        "logradouro": "Rua do Sol",
        "cep": "63333-333",
        "numero": "62",
        "cidade": "São lUis"
    },
    {
        "logradouro": "Rua da Lua",
        "cep": "676767-777",
        "numero": "45",
        "cidade": "São Paulo"
    }
```

Caso o Id informado não pertença a nenhuma pessoa cadastrada, a resposta retornada será um `404 NOT FOUND`, caso ainda não exista nenhum endereço cadastrado para aquela pessoa a resposta será um 200 OK`contendo um objeto vazio.





### Definir endereço principal de uma pessoa

Para definir o endereço principal de uma pessoa, deve se fazer uma requição informado o Id da Pessoa e o Id do endereço, utilizando o seguinte caminho:

PATCH /pessoa/ { id } /principal

Onde o Id da pessoa a quem deseja-se definir o endereço principal, deve ser informado no caminho da requisição.

O id do Endereço ao qual deseja-se definir como principal para aquela pessoa é informado no corpo da requisição, semelhante a requisição abaixo:


```javascript
    {
        "id_endereco":1
    }
```

A solicitação irá retornar o código `204 NO CONTENT`caso a requisição obtenha sucesso.


Caso o Id informado não pertença a nenhuma pessoa cadastrada ou o endereço não exista, a resposta retornada será um `404 NOT FOUND`, bem como quando o endereço informado não pertença a aquela pessoa.