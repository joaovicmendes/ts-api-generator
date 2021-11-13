# TypeScript API Generator
Projeto Final da disciplina Construção de Compiladores (1001497) - UFSCar 2021/1 ENPE 3

## Grupo
- [Guilherme Lorençato](https://github.com/GuiLorencato), 758665
- [João Victor Mendes Freire](https://github.com/joaovicmendes), 758943
- [Julia Cinel Chagas](https://github.com/jcinel), 759314

## O que é
O `ts-api-gen` é um projeto de geração de APIs REST. A partir de uma linguagem simples, chamada `tsgen`, é possível gerar APIs construídas em TypeScript, utilizando Express, Sequelize e SQLite.

## Como executar
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

## Como contribuir

## Créditos
