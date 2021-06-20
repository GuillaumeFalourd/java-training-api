# API de Banco

Para seguir com as atividades desse arquivo, é preciso ter realizado previamente as 4 primeiras partes do arquivo [DESAFIOS.md](https://github.com/GuillaumeFalourd/java-training-api/tree/main/DESAFIOS.md).

**Após cada parte deste desafio, como entrega da atividade, enviar o link do repositório criado (no LinkedIn ou por email).**

* * *

## Banco

### Integrações

Integrações entre APIs são frequentes, e existem varias maneiras de fazer isso, usando `Rest Template` ou `FeignClient` por exemplo.

Seguem algumas referências a respeito:

- [Feign](https://domineospring.wordpress.com/2017/06/02/feign-uma-forma-simples-para-consumir-servicos/)
- [Rest Template](https://www.ti-enxame.com/pt/java/como-post-forma-dados-com-spring-resttemplate/825640550/)
- [Diferenças Feign e Rest Template](https://www.ti-enxame.com/pt/spring-boot/quais-sao-vantagens-e-desvantagens-do-uso-de-simulacao-em-relacao-ao-resttemplate/835724322/)

#### Tarefa: Camada de Contas

- Implementar um segundo controller `AccountController` com um CRUD para cadastrar, buscar, atualizar e remover contas de usuários cadastrados num banco, usando o [serviço da BrasilAPI](https://brasilapi.com.br/docs#tag/BANKS/paths/~1banks~1v1/get) para buscar os dados de um banco baseado no seu `código (code)`.

*Essa implementação vai envolver não apenas um Controller, mas um AccountService, Account DAO e DTOS, assim que AccountRepository.*

- Implementar os testes unitários das camadas de `Service` e `Controller` relacionados a entidade de `Account`.

#### Regras de negócios (Contas)

- A entidade de `Account` deve ser composta dos seguintes campos:

Campo | Obrigótorio | Observação
------------ | ------------  | -------------
**id** | SIM | Identificador (único) da conta
**bank** | SIM | ex: `Banco do Brasil S.A.` (`fullname` da resposta da [Bank API](https://brasilapi.com.br/docs#tag/BANKS/paths/~1banks~1v1/get))
**balance** | SIM | ex: `100.00` (saldo da conta)
**createdAt** | SIM | ex: `2021/19/06` (data de criação da conta)

- Não deve ser permitido criar uma conta para um usuário não cadastrado.
- O usuário só pode ter uma conta.
- A relação entre a entidade de usuário e a entidade de conta deve ser feita pelo **CPF do usuário**. Seguem algumas referências abaixo:
  - [Chaves primaria e estrangeira SQL](https://www.devmedia.com.br/sql-aprenda-a-utilizar-a-chave-primaria-e-a-chave-estrangeira/37636)

* * *

#### Tarefa: Camada de Operações

- Implementar um terceiro controller `OperationController` com um conjunto de endpoints permitindo:
  - depositar dinheiro numa conta
  - saquar dinheiro de uma conta
  - transferir dinheiro para uma outra conta
  - consultar o histórico de operações da conta (listar as operações)

*Essa implementação vai envolver não apenas um Controller, mas um OperationService, Operation DAO e DTOS, assim que OperationRepository.*

- Implementar os testes unitários das camadas de `Service` e `Controller` relacionados a entidade de `Operation`.

#### Regras de negócios (Operações)

- A entidade de `Operation` deve ser composta dos seguintes campos:

Campo | Obrigótorio | Observação
------------ | ------------  | -------------
**id** | SIM | Identificador (único) da operação
**operationType** | SIM | ex: `DEPOSIT` ou `CASHOUT` ou `TRANSFER`
**value** | SIM | ex: `100.00`
**date** | SIM | ex: `2021/19/06` (data em qual a operação foi realizada)
**originAccountId** | SIM | Identificador (único) da conta de origem
**destinationAccountId** | YES | Identificador (único) da conta de destino

- O saldo da conta não pode ficar negativo após uma operação.
- Não deve ser possível fazer saques ou transferências quando o saldo da conta é insuficiente.
- As contas envolvidas em qualquer operação devem ser válidas.
- O ID da conta de destino de uma transferência deve ser incluído na resposta do pedido de transferência.
- Um extrato deve retornar todos os movimentos da conta (transferências, depósitos e saques).
- Não deve ser possível fazer uma transferência para você (a conta de origem não pode ser igual à conta de destino **quando for uma transferência** (pode ser para depósitos ou saques)).
- Apagar um usuário deve apagar sua conta, mas não o seu histórico de operações.
