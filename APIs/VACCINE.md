# API de Vacinas

Para seguir com as atividades desse arquivo, é preciso ter realizado previamente as 4 primeiras partes do arquivo [DESAFIOS.md](https://github.com/GuillaumeFalourd/java-training-api/tree/main/DESAFIOS.md).

**Após cada parte deste desafio, como entrega da atividade, enviar o link do repositório criado (no LinkedIn ou por email).**

* * *

## Vacinas

### Integrações

Integrações entre APIs são frequentes, e existem varias maneiras de fazer isso, usando `Rest Template` ou `FeignClient` por exemplo.

Seguem algumas referências a respeito:

- [Feign](https://domineospring.wordpress.com/2017/06/02/feign-uma-forma-simples-para-consumir-servicos/)
- [Rest Template](https://www.ti-enxame.com/pt/java/como-post-forma-dados-com-spring-resttemplate/825640550/)
- [Diferenças Feign e Rest Template](https://www.ti-enxame.com/pt/spring-boot/quais-sao-vantagens-e-desvantagens-do-uso-de-simulacao-em-relacao-ao-resttemplate/835724322/)

#### Tarefa: Camada de Vacinas

- Implementar um segundo controller `VaccineController` com um CRUD para cadastrar, buscar, atualizar e remover vacinas, usando o [serviço da MediaWiki](https://documenter.getpostman.com/view/4692440/RWEmKHEN#1279e688-9a11-424b-bd15-be1ca9e4cf7f) para buscar a descrição de uma doença baseada no seu **nome**.

*Essa implementação vai envolver não apenas um Controller, mas um VaccineService, Vaccine DAO e DTOS, assim que VaccineRepository.*

- Implementar os testes unitários das camadas de `Service` e `Controller` relacionados a entidade de `Vaccine`.

#### Regras de negócios (Vacinas)

- A entidade de `Vaccine` deve ser composta dos seguintes campos:

Campo | Obrigótorio | Observação
------------ | ------------  | -------------
**id** | SIM | Identificador (único) da vacina
**name** | SIM | ex: `Pfizer` (nome da vacina)
**disease** | SIM | ex: `Covid-19` (nome da doença que a vacina cura)
**diseaseDescription** | NO | ex: `Coronavirus disease (COVID-19) is an infectious disease caused by a newly discovered coronavirus.` (descrição da doença)
**minimumAge** | SIM | ex: `5` (idade mínima *em anos* para usuário receber a vacina)
**dosesAmount** | SIM | ex: `2` (quantidade de doses necessárias da vacina)
**createdAt** | SIM | ex: `2021/19/06` (data de criação da vacina)
**updatedAt** | NO | ex: `2021/20/06` (data de atualização da vacina)

- Não deve ser possível ter 2 vacinas com o mesmo nome.
- Pode ter várias vacinas para a mesma doença.
- A descrição da doença que a vacina cura deve ser preenchida se retornada pelo serviço da [MediaWiki](https://documenter.getpostman.com/view/4692440/RWEmKHEN#1279e688-9a11-424b-bd15-be1ca9e4cf7f), senão deve ser salvo com o valor `N/A`.

* * *

#### Tarefa: Aplicação de Vacinas

- Implementar um terceiro controller `VaccineApplicationController` com um conjunto de endpoints permitindo:
  - aplicar uma vacina a um usuário.
  - listar todas as vacinas que foram aplicadas para um usuário.

*Essa implementação vai envolver não apenas um Controller, mas um VaccineApplicationService, VaccineApplication DAO e DTOS, assim que VaccineApplicationRepository.*

- Implementar os testes unitários das camadas de `Service` e `Controller` relacionados a entidade de `VaccineApplication`.

#### Regras de negócios (Aplicação de Vacinas)

- A entidade de `VaccineApplication` deve ser composta dos seguintes campos:

Campo | Obrigótorio | Observação
------------ | ------------  | -------------
**id** | SIM | Identificador (único) da aplicação da dose da vacina
**date** | SIM | ex: `2021/19/06` (data em qual a dose da vacina foi aplicada ao usuário)
**userId** | SIM | Identificador (único) do usuário
**vaccineId** | YES | Identificador (único) da vacina

- Não deve ser permitido aplicar uma vacina não cadastrada para um usuário.
- Não deve ser permitido aplicar uma vacina para um usuário não cadastrado.
- Um mesmo usuário não pode receber mais aplicações da mesma vacina do que a quantidade de doses informada na entidade da vacina.
- Um usuário não pode receber 2 aplicações da mesma vacina **dentro de 30 dias**.
- A relação entre a entidade de aplicação de vacinas e as entidades de usuário e vacina deve ser feita pelo **ID do usuário** e o **ID da vacina**. Seguem algumas referências abaixo:
  - [Chaves primaria e estrangeira SQL](https://www.devmedia.com.br/sql-aprenda-a-utilizar-a-chave-primaria-e-a-chave-estrangeira/37636)
  - [Relacionamento @OneToMany e @ManyToOne](https://imasters.com.br/banco-de-dados/como-criar-relacionamento-onetomany-com-hibernate)
- Apagar um usuário deve apagar seus endereços também.
