# API de Veículos

Para seguir com as atividades desse arquivo, é preciso ter realizado previamente as 4 primeiras partes do arquivo [DESAFIOS.md](https://github.com/GuillaumeFalourd/java-training-api/tree/main/DESAFIOS.md).

**Após cada parte deste desafio, como entrega da atividade, enviar o link do repositório criado (no LinkedIn ou por email).**

* * *

## Vehicle

### Integrações

Integrações entre APIs são frequentes, e existem varias maneiras de fazer isso, usando `Rest Template` ou `FeignClient` por exemplo.

Seguem algumas referências a respeito:

- [Feign](https://domineospring.wordpress.com/2017/06/02/feign-uma-forma-simples-para-consumir-servicos/)
- [Rest Template](https://www.ti-enxame.com/pt/java/como-post-forma-dados-com-spring-resttemplate/825640550/)
- [Diferenças Feign e Rest Template](https://www.ti-enxame.com/pt/spring-boot/quais-sao-vantagens-e-desvantagens-do-uso-de-simulacao-em-relacao-ao-resttemplate/835724322/)

#### Tarefa: Camada de Vehicle

- Implementar um segundo controller `VehicleController` com um CRUD para cadastrar, buscar, atualizar e remover veículos, usando o [serviço da FIPE](https://deividfortuna.github.io/fipe) para buscar os dados de um veículo.

*Essa implementação vai envolver não apenas um Controller, mas um VehicleService, Vehicle DAO e DTOS, assim que VehicleRepository.*

- Implementar os testes unitários das camadas de `Service` e `Controller` relacionados a entidade de `Vehicle`.

#### Regras de negócios (Veículos)

- A entidade de `Vehicle` deve ser composta dos seguintes campos:

Campo | Obrigótorio | Observação
------------ | ------------  | -------------
**id** | SIM | Identificador (único) do veículo
**brand** | SIM | ex: `VW - VolksWagen` (`marca` do veículo)
**model** | SIM | ex: `AMAROK High.CD 2.0 16V TDI 4x4 Dies. Aut` (modelo do veículo)
**year** | SIM | ex: `2014` (ano no veículo)
**price** | SIM | ex: `R$ 109.888,00` (valor do veículo de acordo com a API da FIPE)
**createdAt** | SIM | ex: `2021/19/06` (data de adição do veículo ao banco de dados)

- Os dados informados devem ser confirmados na API da FIPE (para comprovar que são válidos)
- Não deve ser permitido cadastrar 2 vezes o mesmo veículo.
- O preço do veículo deve ser calculado de acordo com os outros dados obrigatórios na FIPE.

#### Bônus

No endpoint que irá listar os veículos, devemos considerar algumas configurações a serem exibidas para o usuário final (no DTO de Response). 
Para isso, vamos criar dois novos atributos no objeto do carro, sendo eles:

1. `Dia do rodízio` do carro, baseado no último número do ano do veículo, considerando as condicionais:
  - Final 0-1: segunda-feira
  - Final 2-3: terça-feira
  - Final 4-5: quarta-feira
  - Final 6-7: quinta-feira
  - Final 8-9: sexta-feira

2. Também devemos criar um atributo de `rodízio` ativo, onde a data atual do sistema será comparada com as condicionais anteriores, onde, quando for o dia ativo do rodizio retornar true, caso contrario, false.

Campo | Obrigótorio | Observação
------------ | ------------  | -------------
**rotationDay** | SIM | ex: `segunda-feira` (dia que o carro não pode andar na rua)
**rotation** | SIM | ex: `true` (se é (ou não) o dia do carro não poder andar na rua)

* * *

#### Tarefa: Camada de Ownership

- Atualizar o controller `OwnershipController` com um CRUD para cadastrar, buscar, atualizar e remover `veículos de usuários`, usando o [serviço da FIPE](https://deividfortuna.github.io/fipe) através da classe de Service criada na tarefa anterior para validar os dados de um veículo.

*Essa implementação vai envolver não apenas um Controller, mas também OwnershipService, Ownership DAO e DTOS, assim que OwnershipRepository.*

- Atualizar os testes unitários das camadas de `Service` e `Controller` relacionados a entidade de `Ownership`.

#### Regras de negócios (Ownership)

- A entidade de `Ownership` deve ser composta dos seguintes campos:

Campo | Obrigótorio | Observação
------------ | ------------  | -------------
**id** | SIM | Identificador (único) da relação de propriedade entre o veículo e um usuário
**id_vehicle** | SIM | Identificador (único) do veículo
**cpf_user** | SIM | ex: `111.222.333-44` (`cpf` do dono do veículo (usuário))
**createdAt** | SIM | ex: `2021/19/06` (data de adição da relação no banco de dados)
**updatedAt** | NÃO | ex: `2021/20/06` (data de atualização da relação no banco de dados)

- Não deve ser permitido associar um veículo a um usuário não cadastrado.
- Deve ser permitido associar um usuário a um veículo não cadastrado, neste caso, o veículo devo ser cadastrado na hora (caso os dados sejam validados pela FIPE).
- Um usuário pode cadastrar quantos veículos quiser.
- Um veículo não pode pertencer a 2 usuários ao mesmo tempo.
- A relação de propriedade entre a entidade de usuário e a entidade de veículos deve ser feita pelo **CPF do usuário**. Seguem algumas referências abaixo:
  - [Chaves primaria e estrangeira SQL](https://www.devmedia.com.br/sql-aprenda-a-utilizar-a-chave-primaria-e-a-chave-estrangeira/37636)

No Controller `UserController`
- Quando retornar os dados de um usuário, será necessário retornar todos os dados dos seus veículos cadastrados (inclusive `rotation` e `rotationDay`). Retornar uma lista vazia caso não tenha nenhum veículo cadastrado.
