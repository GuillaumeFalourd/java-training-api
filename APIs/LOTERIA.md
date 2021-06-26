# API de Loteria

Para seguir com as atividades desse arquivo, é preciso ter realizado previamente as 4 primeiras partes do arquivo [DESAFIOS.md](https://github.com/GuillaumeFalourd/java-training-api/tree/main/DESAFIOS.md).

**Após cada parte deste desafio, como entrega da atividade, enviar o link do repositório criado (no LinkedIn ou por email).**

* * *

## Loteria

#### Tarefa: Camada de Apostas

- Implementar um segundo controller `BetController` com um CRUD para cadastrar, buscar e remover apostas de usuários cadastrados.

*Essa implementação vai envolver não apenas um Controller, mas um BetService, Bet DAO e DTOS, assim que BetRepository.*

- Implementar os testes unitários das camadas de `Service` e `Controller` relacionados a entidade de `Bet`.

#### Regras de negócios (Apostas)

- A entidade de `Bet` deve ser composta dos seguintes campos:

Campo | Obrigótorio | Observação
------------ | ------------  | -------------
**id** | SIM | Identificador (único) da aposta
**numbers** | SIM | ex: `[ 1, 2, 3, 4]` (lista de números da aposta)
**createdAt** | SIM | ex: `2021/19/06` (data de criação da aposta)

- Num primeiro momento, você pode definir qualquer regra para a geração de aposta (`X` números para cada aposta, onde os números podem variar de 1 até `Y`)
- Não deve ser permitido criar uma aposta para um usuário não cadastrado.
- Uma aposta não pode conter números repetidos.
- O usuário pode ter mais do que uma aposta, sendo que 2 apostas de um mesmo usuário não podem ser iguais.
- A relação entre a entidade de usuário e a entidade de aposta deve ser feita pelo **CPF do usuário**. Seguem algumas referências abaixo:
  - [Chaves primaria e estrangeira SQL](https://www.devmedia.com.br/sql-aprenda-a-utilizar-a-chave-primaria-e-a-chave-estrangeira/37636)

### Customizar a API

Na tarefa anterior, foi permitido seguir com qualquer regra para geração de aposta (`X` números para cada aposta, onde os números podem variar de 1 até `Y`).

O objetivo dessa tarefa agora é tornar aquilo customizável, sem precisar alterar o código para gerar apostas com regras diferentes.

Para isso, sugerimos criar mais uma entidade, onde armazenaremos as configurações da nossa API para gerar apostas.

#### Tarefa: Camada de configurações

- A entidade de `Configuration` deve ser composta dos seguintes campos:

Campo | Obrigótorio | Observação
------------ | ------------  | -------------
**key** | SIM | ex: `MAX_NUMBER` (chave **única** para se referir a configuração)
**value** | SIM | ex: `100` (valor associado a chave)
**createdAt** | SIM | ex: `2021/19/06` (data de criação da configuração)
**updatedAt** | NO | ex: `2021/20/06` (data de atualização da configuração)

- Implemente um terceiro controller `ConfigurationController` com um CRUD para cadastrar, buscar, atualizar e remover configurações da API.

*Essa implementação vai envolver não apenas um Controller, mas um ConfigurationService, Configuration DAO e DTOS, assim que ConfigurationRepository.*

- Implementar os testes unitários das camadas de `Service` e `Controller` relacionados a entidade de `Configuration`.

- Atualizar a API existente para gerar as apostas buscando as configurações da API. O objetivo é de buscar na tabela de configurações 2 valores antes de gerar a aposta:
  - A quantidade de números contida em cada aposta (O `X` acima).
  - O valor máximo desses números (O `Y` acima).

#### Bônus

- Use `Headers` (cabeçalhos) para distinguir requisições gerando apostas usando configurações diferentes da tabela. Exemplo:
  - Configuração 1 = aposta com 3 números de 1 até 50
  - Configuração 2 = aposta com 5 números de 1 até 100

Para isso, mude apenas as classes de `BetController` e `BetService` (assim que os testes unitarios relacionados).

Seguem algumas referências a respeito:

- [HTTP Headers](https://www.devmedia.com.br/http-headers/41219)
- [Como adicionar cabeçalhos na chamado RESTful](https://www.ti-enxame.com/pt/java/como-adicionar-cabecalhos-na-chamada-restful-usando-api-do-cliente-jersey/1040425012/)
- [Artigo Web Services em REST usando Headers](http://www.ricardoluis.com/wp-content/uploads/2015/08/Artigo-WebServices-em-REST.pdf)
- [Como obter acesso às informações do cabeçalho HTTP no controlador Spring MVC REST?](https://qastack.com.br/programming/19556039/how-to-get-access-to-http-header-information-in-spring-mvc-rest-controller)
- [Como definir um cabeçalho "Accept:" na solicitação Spring RestTemplate?](https://qastack.com.br/programming/19238715/how-to-set-an-accept-header-on-spring-resttemplate-request)
