# API de Endereços

Para seguir com as atividades desse arquivo, é preciso ter realizado previamente as 4 primeiras partes do arquivo [DESAFIOS.md](https://github.com/GuillaumeFalourd/java-training-api/tree/main/DESAFIOS.md).

**Após cada parte deste desafio, como entrega da atividade, enviar o link do repositório criado (no LinkedIn ou por email).**

* * *

## Endereços

### Integrações

Integrações entre APIs são frequentes, e existem varias maneiras de fazer isso, usando `Rest Template` ou `FeignClient` por exemplo.

Seguem algumas referências a respeito:

- [Feign](https://domineospring.wordpress.com/2017/06/02/feign-uma-forma-simples-para-consumir-servicos/)
- [Rest Template](https://www.ti-enxame.com/pt/java/como-post-forma-dados-com-spring-resttemplate/825640550/)
- [Diferenças Feign e Rest Template](https://www.ti-enxame.com/pt/spring-boot/quais-sao-vantagens-e-desvantagens-do-uso-de-simulacao-em-relacao-ao-resttemplate/835724322/)

#### Tarefa: Camada de Endereços

- Implementar um segundo controller `AddressController` com um CRUD para cadastrar, buscar, atualizar e remover endereços de usuários cadastrados, usando o [serviço da VIACEP](https://viacep.com.br/) para buscar os dados de um endereço baseado no seu **CEP**.

*Essa implementação vai envolver não apenas um Controller, mas um AddressService, Address DAO e DTOS, assim que AddressRepository.*

- Implementar os testes unitários das camadas de `Service` e `Controller` relacionados a entidade de `Address`.

#### Regras de negócios

- A entidade de `Address` deve ser composta dos seguintes campos:

Campo | Obrigótorio | Observação
------------ | ------------  | -------------
**id** | SIM | Identificador (único) do endereço
**cep** | SIM | ex: `00000-111`
**logradouro** | SIM | ex: `Rua João`
**numero** | SIM | ex: `12`
**complemento** | NÃO | ex: `apartamento 101`
**bairro** | SIM | ex: `Santa Maria`
**cidade** | SIM | ex: `São Paulo`
**estado** | SIM | ex: `SP`

- Não deve ser permitido cadastrar um endereço para um usuário não cadastrado.
- Um usuário pode ter mais de um endereço.
- A relação entre a entidade de usuário e a entidade de endereço deve ser feita pelo **ID do usuário**. Seguem algumas referências abaixo:
  - [Chaves primaria e estrangeira SQL](https://www.devmedia.com.br/sql-aprenda-a-utilizar-a-chave-primaria-e-a-chave-estrangeira/37636)
  - [Relacionamento @OneToMany e @ManyToOne](https://imasters.com.br/banco-de-dados/como-criar-relacionamento-onetomany-com-hibernate)
- Apagar um usuário deve apagar seus endereços também.
