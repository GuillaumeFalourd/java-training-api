# API de Imobiliária

Para seguir com as atividades desse arquivo, é preciso ter realizado previamente as 4 primeiras partes do arquivo [DESAFIOS.md](https://github.com/GuillaumeFalourd/java-training-api/tree/main/DESAFIOS.md) assim que ter feito o exercício do nível 2: [API de Endereços](https://github.com/GuillaumeFalourd/java-training-api/tree/main/APIs/ENDERECO.md)

**Após cada parte deste desafio, como entrega da atividade, enviar o link do repositório criado (no LinkedIn ou por email).**

* * *

## Imobiliária

#### Tarefa: Camada de Imobiliária

- Implementar um segundo controller `PropertyController` com um CRUD para cadastrar, buscar, atualizar e remover imóveis.

*Essa implementação vai envolver não apenas um Controller, mas um PropertyService, Property DAO e DTOS, assim que PropertyRepository.*

- Implementar os testes unitários das camadas de `Service` e `Controller` relacionados a entidade de `Property`.

#### Regras de negócios (Imobiliária)

- A entidade de `Property` deve ser composta dos seguintes campos:

Campo | Obrigótorio | Observação
------------ | ------------  | -------------
**id** | SIM | Identificador (único) do imóvel
**addressId** | SIM | Identificador (único) do endereço do imóvel (cf, classe `Address` criada no desafio Nível 2)
**aluguel** | NO | ex: `1500.00` (valor do aluguel do imóvel)
**venda** | NO | ex: `700000.00` (valor de venda do imóvel)
**status** | NO | ex: `VENDENDO` (estado em qual o imóvel se encontra: `VENDENDO` - `ALUGANDO` - `VENDIDO` - `ALUGADO`)
**active** | NO | ex: `true` (se o imóvel está no mercado ou não)
**constructedAt** | NO | ex: `2021/18/06` (data de construção do imóvel)
**createdAt** | SIM | ex: `2021/19/06` (data de cadastro do imóvel)
**updatedAt** | NO | ex: `2021/20/06` (data de atualização do imóvel)

- Não deve ser possível ter 2 imóveis com o mesmo endereço.
- Um imóvel precisa ter um valor de aluguel ou de venda (não pode estar com os 2 campos vazios).
- Ao cadastrar um imóvel, é preciso informar seu `status` (inicialmente, só pode ser `VENDENDO` ou `ALUGANDO`) com o campo `active` ativado (_true_).
- Ao remover um imóvel, o campo `active` deve ser desativado (`false`). Não deve apagar os dados do banco.
- Não é possível fazer uma busca de um imóvel desativado (`active` = `false`).
- Além do CRUD, é preciso desenvolver um serviço para buscar todos os imóveis **ativos** de acordo com filtros: `CEP`, `VENDENDO`, `ALUGANDO`

* * *

#### Tarefa: Contrato

- Implementar um terceiro controller `ContractController` com um conjunto de endpoints permitindo:
  - criar um contrato associando um imóvel a um usuário.
  - buscar um contrato (pelo id do imóvel)
  - buscar um contrato (pelo CPF de um usuário)
  - atualizar um contrato
  - encerrar um contrato

*Essa implementação vai envolver não apenas um Controller, mas um ContractService, Contract DAO e DTOS, assim que ContractRepository.*

- Implementar os testes unitários das camadas de `Service` e `Controller` relacionados a entidade de `Contract`.

#### Regras de negócios (Contrato)

- A entidade de `Contract` deve ser composta dos seguintes campos:

Campo | Obrigótorio | Observação
------------ | ------------  | -------------
**id** | SIM | Identificador (único) do contrato
**userId** | SIM | Identificador (único) do usuário
**propertyId** | YES | Identificador (único) do imóvel
**valor** | YES |  ex: `1500.00` (valor do contrato)
**aluguel** | NO | ex: `true` (se é um contrato de aluguel ou não)
**venda** | NO | ex: `true` (se é um contrato de venda ou não)
**active** | NO | ex: `true` (se o contrato ainda está válido ou não)
**createdAt** | SIM | ex: `2021/19/06` (data da criação do contrato)
**updatedAt** | SIM | ex: `2021/19/06` (data da atualização do contrato)

- Não pode ter 2 contratos ativos entre um imóvel e um usuário.
- Um contrato não pode ser de aluguel e de venda ao mesmo tempo.
- O valor do contrato é o mesmo que o valor associado ao imóvel caso seja de aluguel ou de venda.
- Ao cadastrar um contrato, seu campo `active` deve ser ativado (`true`) e o imóvel associado deve ter seu estado atualizado (para `ALUGADO` ou `VENDIDO`).
- Não pode encerrar um contrato de venda.
- Ao encerrar um contrato de alguel, o campo `active` deve ser desativado (`false`) - _Não deve apagar os dados do banco_ - e caso era um contrato de aluguel, o imóvel associado deve ter seu estado atualizado para `ALUGANDO`.