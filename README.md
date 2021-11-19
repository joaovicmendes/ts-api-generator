# TypeScript API Generator
Projeto Final da disciplina Construção de Compiladores (1001497) - UFSCar 2021/1 ENPE 3

## Grupo
- [Guilherme Lorençato](https://github.com/GuiLorencato), 758665
- [João Victor Mendes Freire](https://github.com/joaovicmendes), 758943
- [Julia Cinel Chagas](https://github.com/jcinel), 759314

## O que é
O `ts-api-gen` é um projeto de geração de APIs REST. A partir de uma linguagem simples, chamada `tsgen`, é possível gerar APIs construídas em TypeScript, utilizando Express, Sequelize e SQLite.

### Linguagem de Declaração
Aqui uma descrição da linguagem de declaração da api, a `tsgen`:
```
    model [
        <model name> {
            <column1>: <type>
            <column2>: <type>
            <column3>: <type>
        }
        ...
    ]
    endpoints [
        <model name> {
            <method> <endpoint>
            <method> <endpoint>
            <method> <endpoint>
        }
        ...
    ]
```
Os campos `model name` e `column` podem ser qualquer cadeira de caracteres iniciada com uma letra e seguida de letras, números ou _, desde que não tenham sido utilizadas anteriormente no mesmo contexto.

O campo `type` pode ser um entre: `number`, `string`, `boolean`, ou um tipo do modelo (`model name`).

O campo `method` pode ser um entre: `GET`, `POST`, `PUT`, `DELETE`.

O campo `endpoint` pode ser uma cadeia de caracteres contendo a uri do recurso. Se o método for `PUT` ou `DELETE`, deve conter um identificador marcado por `:`. Se for `POST` não deve conter identificador de rota.

E aqui vai um exemplo simples:
```
model [
    Student {
        name: string
        email: string
        ra: number
    }
]
endpoints [
    Student {
        GET '/students'
        GET '/students/:id'
        POST '/students/:id'
        PUT '/students/:id'
        DELETE '/students/:id'
    }
]
```

### Código Gerado
Um exemplo do código gerado ao informar a entrada acima esta contido [neste arquivo](https://github.com/joaovicmendes/ts-api-generator/blob/main/example.ts).

## Como executar
Para executar o transpilador, é preciso ter instalado na máquina: 
- Java 11.0.11
- Maven 3.8.2

Para executar o código de api gerado, é preciso ter baixado o blob.zip e ter instalado:
- npm <Versão>
