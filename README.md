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
Os campos `model name` e `column` podem ser qualquer cadeira de caracteres iniciada com uma letra e seguida de letras, números ou _, desde que não tenham sido utilizadas anteriormente no mesmo contexto. Toda classe do modelo tem, por padrão, um campo `id`, `updatedAt` e `createdAt`.

O campo `type` pode ser um entre: `number`, `string`, e `boolean` (por hora).

O campo `method` pode ser um entre: `GET`, `POST`, `PUT`, `DELETE`.

O campo `endpoint` pode ser uma cadeia de caracteres contendo a uri do recurso. Se o método for `PUT` ou `DELETE`, deve conter um identificador marcado por `:`. Se for `POST` não deve conter identificador de rota.

E aqui vai um exemplo simples:
```
// Deve compilar com sucesso
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
        GET '/students/:ra'
        POST '/students'
        PUT '/students/:ra'
        DELETE '/students/:ra'
    }
]
```

### Código Gerado
Um exemplo do código gerado ao informar a entrada acima esta contido [neste arquivo](https://github.com/joaovicmendes/ts-api-generator/blob/main/example.ts).

## Como executar
Para executar o transpilador e a API gerada, é preciso ter instalado na máquina: 
- Java 11.0.11
- Maven 3.8.2
- Node v17.0.1
- npm 8.1.0

### A partir do binario
1. Faça download do [binário](https://github.com/joaovicmendes/ts-api-generator/releases/download/latest/tsgen-0.6.jar) e do [bundle.zip](https://github.com/joaovicmendes/ts-api-generator/releases/download/latest/bundle-v0.5.zip)
2. Na pasta onde se encontra o `tsgen-0.6.jar`, execute:
```bash
java -jar tsgen-0.6.jar <path pro arquivo de entrada>
```
3. Na mesma pasta, será gerado um `index.ts`. Depois de descompactar o bundle, copie o `index.ts` para sua raíz.
4. De dentro do bundle, execute:
```bash
npm i
npm start
```

### A partir do repositório
1. A partir da raíz do repositório, execute o script:
```sh
sh scripts/build.sh
```
2. Depois que o projeto terminar sua compilação, execute o transpilador:
```bash
java -jar tsgen-0.6.jar <path pro arquivo de entrada>
```
3. Na mesma pasta será gerado um `index.ts`. Copie ele para a pasta do bundle executando:
```bash
cp index.ts bundle/index.ts
```
4. De dentro do bundle, execute:
```bash
npm i
npm start
```
5. Se quiser resetar o bundle para gerar uma nova API, basta executar o script:
```shell
sh scripts/bundle-clean.sh
```
