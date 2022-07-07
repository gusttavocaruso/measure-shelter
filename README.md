<div align="center">

# Mensure Shelter

<img src="https://agropos.com.br/wp-content/uploads/2021/04/Sensores-de-Umidade.jpg" width="200px">

## Agro Techfields

</div>

---

### Contexto:
Uma cooperativa de plantação de soja decidiu automatizar parte do seu processo de cultivo para trazer mais qualidade aos grãos.

Sua equipe deve desenvolver o Back-end, batizado de measure shelter, que vai manter informações da lavoura para futuramente aplicar uma inteligência e automatizar todo o processo de plantação.

Entende-se por ilhas os dispositivos que coletam medidas da área atual. Espalhadas pela lavoura, as ilhas colhem medidas de temperatura, umidade do ar e do solo, dentre outras relevantes para o cultivo de soja. A cada 5 minutos, esses dados são enviados para o sistema measure shelter.

Esse sistema será uma API REST que receberá as medidas coletadas pelas ilhas e as armazenará em um banco de dados. A cada 20 dias, um satélite coleta imagens da plantação e as envia para a aplicação que, por sua vez, armazena o material no banco de dados.

Muitas vezes, os sensores de medições das ilhas ficam inoperantes devido às condições climáticas. Nesse caso, faz-se necessário alterar o status da ilha afetada para inoperante, garantindo assim que os dados colhidos sejam ignorados pelo sistema. Quando consertados os sensores da ilha danificada, o status voltar a ser operante. Todo o controle do status deverá ser controlado pelo Back-end.

Como a arquitetura apresentada é inicial, sua equipe tem a liberdade para eventuais melhorias e modificações na proposta arquitetural.

---

## Informações para consumo da API

Para testar as rotas você pode utilizar a API hospedada no <a href="https://mensure-shelter-group-3.herokuapp.com/" target="_blank">**Heroku**</a> ou pode clonar o projeto para sua maquina, instalar as dependencias via `mvn install` e rodar a API com o comando `mvn spring-boot:run`, assim ela ficará disponível na porta `:8080`

As rotas disponíveis são:

**/ilha/criar - requisição HTTP `POST`**:
  - A requisição deve receber um JSON no formato:

```json
  {
    "name": "String",
    "status": "String"
  }
```
---

**/ilha/ - requisição HTTP `GET`**:
  - Deve retornar todas ilhas criadas.
---

**/ilha/atualizar/:id - requisição HTTP `PUT`**:
  - Na rota, o campo `:id` deve receber o _id da ilha que se deseja atualizar.
  - A requisição deve receber um JSON no formato:

```json
  {
    "name": "String",
    "status": "String"
  }
```
---

**/ilha/remover/:id - requisição HTTP `DELETE`**:
  - Na rota, o campo `:id` deve receber o _id da ilha que se deseja remover.
---

**/ilha/:id/medidas/adicionar - requisição HTTP `POST`**:
  - Na rota, o campo `:id` deve receber o _id da ilha que se deseja adicionar medidas.
  - A requisição deve receber um JSON no formato:

```json
  {
    "descricao": "String",
    "valor": "String",
    "unidadeDeMedida": "String"
  }
```
---

**/ilha/:id/medidas - requisição HTTP `GET`**:
  - Na rota, o campo `:id` deve receber o _id da ilha que se deseja consultar as medidas.
  - Deve retornar todas medidas criadas na ilha indicada.
---

**/ilha/:idIlha/medidas/atualizar/:idMedida - requisição HTTP `PUT`**:
  - Na rota, o campo `:idIlha` deve receber o _id da ilha em que está a medida que se deseja atualizar.
  - Na rota, o campo `:idMedida` deve receber o id da medida se deseja atualizar.
  - A requisição deve receber um JSON no formato:

```json
  {
    "descricao": "String",
    "valor": "String",
    "unidadeDeMedida": "String"
  }
```
---

**/ilha/:idIlha/medidas/remover/:idMedida - requisição HTTP `DELETE`**:
  - Na rota, o campo `:idIlha` deve receber o _id da ilha que contém a medida que se deseja remover.
  - Na rota, o campo `:idMedida` deve receber o _id da medida que se deseja remover.
---


<div align="center">

Projeto final de curso de JAVA promovido pela [Trybe](https://www.betrybe.com/) em parceria com a [CI&T](https://ciandt.com/br/pt-br/home) ©

<img src="https://avatars.githubusercontent.com/u/82593112?v=4" width="60px">
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTU59qxQX-52fU_TNMxS_MkbhlgUyTkYDkkAzpSTyREZvLn6yrmbFc0I7wUWIq9IF0K1oI&usqp=CAU" width="60px">

Desenvolvido por

Gustavo Caruso | Luiz Vaccari | Ricardo Antonio

@gusttavocaruso | @LuizVaccari | @ricand7

</div>