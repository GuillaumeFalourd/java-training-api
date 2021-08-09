# DESAFIOS

Esse arquivos contem sugestões de desafios para melhorar a API contida nesse repositório.

**Após cada parte deste desafio, como entrega da atividade, enviar o link do repositório criado (no LinkedIn ou por email).**

## O que melhorar nesta API?

Antes de você começar a melhorar essa API REST, recomendo ler os artigos abaixo para alinhar o conhecimento sobre Java, REST, Spring, SOLID e o padrão MVC (Model View Controller):

- [Patterns Java Orientação a Objetos](https://www.devmedia.com.br/diferenca-entre-os-patterns-po-pojo-bo-dto-e-vo/28162)
- [Programação Orientada a Objetos (POO)](https://www.alura.com.br/artigos/poo-programacao-orientada-a-objetos)
- [Polimorfismo (Java)](https://www.devmedia.com.br/uso-de-polimorfismo-em-java/26140#:~:text=Polimorfismo%20significa%20%22muitas%20formas%22%2C,diferentes%20ao%20receber%20uma%20mensagem)
- [Herança + Interfaces (Java)](https://www.alura.com.br/conteudo/java-heranca-interfaces-polimorfismo?gclid=Cj0KCQjws-OEBhCkARIsAPhOkIYTKKe6f3i2zrECbjlY-KyQUQfT1E1mLSWcznn0gFyP7HKI0tKPfVwaAsVCEALw_wcB)
- [REST](https://www.devmedia.com.br/rest-tutorial/28912)
- [SPRING-BOOT, como começar?](https://www.zup.com.br/blog/spring-boot)
- [SOLID](https://www.eduardopires.net.br/2013/04/orientacao-a-objeto-solid/#:~:text=SOLID%20%C3%A9%20um%20acr%C3%B4nimo%20dos,poderiam%20se%20encaixar%20nesta%20palavra)
- [SOLID para Devs de alta performance](https://www.zup.com.br/blog/solid-devs-de-alta-performance)
- [MVC](https://www.devmedia.com.br/padrao-mvc-java-magazine/21995#2)
- [Introdução ao Padrão MVC](https://www.devmedia.com.br/introducao-ao-padrao-mvc/29308)
- [Evolução do MVC para REST](https://imasters.com.br/devsecops/a-evolucao-do-mvc-para-rest#:~:text=Em%20outras%20palavras%2C%20REST%20garante,sem%20acoplamento%20entre%20as%20partes.&text=Isso%20garante%20que%20podemos%20construir,quem%20vai%20usar%20estes%20dados)
- [Conceitos Spring Data Jpa](https://ulyssesuchoa.medium.com/spring-data-jpa-445dbfbb70f0)

* * *

## 1️⃣ Primeira parte

Na primeira parte desse desafio, o objetivo vai ser de atualizar a estrutura do projeto, e completar o CRUD (Create, Read, Update e Delete) do Controller.

### Versionando seu código

#### Tarefa 🔀

- O versionamento do nosso código é algo muito importante, para cada tarefa que está sendo solicitada for concluída, faça um commit para o seu repositório.

[Referência a respeito do GIT](https://rogerdudler.github.io/git-guide/index.pt_BR.html)

### Camada de Service

#### Tarefa 🔛

- Crie uma camada de `Service` para ser usada entre a camada de `Controller` e de `Repository`.
  - Atual: *Controller --> Repository*
  - Esperado: *Controller --> Service --> Repository*

*Usar uma camada de `Service` é uma boa prática para separar as responsabilidades no projeto, pois as regras de negocio serão implementada nesta camada no lugar de ficar na camada de Controller (que tem como responsabilidade de ser a camada de entrada e saida de dados).*

[Referência a respeito de separação de conceitos](https://www.profissionaisti.com.br/entendendo-a-separacao-de-conceitos-separation-of-concerns-soc/#:~:text=Na%20Programa%C3%A7%C3%A3o%20Orientada%20a%20Objetos,subclasses)

### CRUD completo

#### Tarefa 🚀

- Complete o CRUD com os endpoints de `UPDATE` e `DELETE` usando o CPF como *PathVariable*.
  - Atual: *POST + GET*
  - Esperado: *POST + GET + PUT + DELETE*

* * *

## 2️⃣ Segunda parte

### Uso de DTO

Vamos agora aplicar o conceito de DTO (Data Transfer Object) ao nosso projeto. Para não utilizar as nossas Entidades como objeto de entrada e saida do nosso projeto. Isso é geralmente considerado uma boa prática no desenvolvimento de API para evitar manipular dados desnecessarios ou retornar dados sigilosos.

Seguem algumas referências a respeito:

- [DAO e JPA](https://domineospring.wordpress.com/2015/05/11/facilite-seus-daos-com-o-spring-data-jpa/)
- [DTO](https://medium.com/@msealvial/blindando-sua-api-spring-boot-com-o-padr%C3%A3o-dto-44f97020d1a0)
- [Restrições DTOs](https://dev.to/renatasfraga/java-annotations-no-spring-crie-restricoes-em-suas-dtos-2nfj)
- [DTO e Entidade](https://cursos.alura.com.br/forum/topico-caracteristicas-das-colunas-das-entidades-nos-formularios-dtos-no-momento-da-validacao-88815)

#### Tarefa 🏗

- Crie os DTOs para usar como objetos de requisição (`UserForm`) e respostas (`UserResponse`) na camada de `Controller`, e faça a adequação dos objetos (DTO para Entidades e vice versa) na camada de `Service`.

### Uso de anotações de validações

Quando usamos DTOs, queremos aproveitar para validar que os dados enviados para nossa API sejam válidos. Para isso, podemos usar anotações que podem avaliar o formato nos quais os campos foram preenchidos.

Seguem algumas referências a respeito:

- [Validador Spring](https://www.zup.com.br/blog/spring-validation-o-que-e?utm_source=google-chat&utm_medium=interno&utm_campaign=gc-geral)
- [Validador dados com anotações](https://www.devmedia.com.br/bean-validation-1-1-validando-dados-com-anotacoes/30070)
- [Bean validation](https://emmanuelneri.com.br/2017/05/30/criando-validacoes-de-bean-validation-customizadas/)
- [Validador Hibernate](https://www.devmedia.com.br/hibernate-validator-validando-dados-no-back-end-com-anotacoes/37979)
- [Validar CPF](https://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097)
- [Regex](https://medium.com/@alexandreservian/regex-um-guia-pratico-para-express%C3%B5es-regulares-1ac5fa4dd39f)
- [Mapeamento Hibernate (DAO)](https://www.devmedia.com.br/mapeamento-hibernate-configurando-tabelas-e-colunas/29526)

#### Tarefa ♻️

- Atualize as anotações necessárias para validar o formato dos campos de `CPF`, `EMAIL` e `NOME` do DTO de requisição (UserForm).

* * *

## 3️⃣ Terceira parte

### Tratamento de Exceções

Queremos que nossa API sejam fácil de uso e clara no seu funcionamento para quem for consumir ela. Para isso, é importante garantir que os erros esperados e/ou inesperados sejam tratados de forma amigáveis. Uma boa prática é usar Exception Handlers para isso.

Seguem algumas referências:

- [Exception Handlers](https://qastack.com.br/programming/28902374/spring-boot-rest-service-exception-handling)
- [Exception Java](https://www.devmedia.com.br/trabalhando-com-excecoes-em-java/27601)
- [Tratar Exceções Java](https://www.devmedia.com.br/como-tratar-excecoes-na-linguagem-java/39163)

#### Tarefa 🔎

- Crie uma classe de `Exception Handler` para retornar `mensagens` e `http status` amigáveis caso erros esperados ou inesperados ocorram no uso da sua API.

### Testes Unitários

Testes unitários aumentam a qualidade de nosso código, eles testam o funcionamento de nossos métodos, um cenário de cada vez (sucessos e erros).

Seguem algumas referências:

- [JUnit Tutorial](https://www.devmedia.com.br/junit-tutorial/1432)
- [JUnit](https://www.devmedia.com.br/junit-tutorial/1432)\
- [JUnit e os seus primeiros testes](https://medium.com/@guilhermemarcionilo/usando-junit-e-como-come%C3%A7ar-os-seus-primeiros-testes-unit%C3%A1rios-d06db19d5688)
- [Basico Mockito](https://inside.contabilizei.com.br/conceitos-basicos-sobre-mockito-73b931ce0c2c)
- [Testando código Java com Mockito](https://medium.com/cwi-software/testando-seu-c%C3%B3digo-java-com-o-mockito-framework-8bea7287460a)
- [Testes Unitarios em Controller](https://dev.to/luizleite_/como-fazer-testes-unitarios-em-controllers-de-um-app-spring-boot-1bbm)

#### Tarefa ⚙️

- Implementar os testes unitários da camada de `Service` e de `Controller` da API.

* * *

## 4️⃣ Quarta parte

### Documentação

Uma das habilidades mais importantes que um bom profissional de software deve ter é da escrita de documentações de alta qualidade. Para muitos, essa é uma tarefa difícil e traumática. Por exemplo, se uma API não for bem documentada, provavelmente, seus usuários encontrarão dificuldades para entender o seu funcionamento. Isso certamente influenciará na utilização dos serviços oferecidos em sua API.

Seguem algumas referências a respeito do Swagger, uma ferramenta permitindo você automatizar a criação da sua documentação:

- [Dev Eficiente - Configure e utilize o Swagger para documentar e testar seus endpoints](https://www.youtube.com/watch?v=0KCuW3ntI-U)
- [Documentando uma API Spring Boot com o Swagger](https://www.treinaweb.com.br/blog/documentando-uma-api-spring-boot-com-o-swagger)
- [Spring Boot e Swagger, documentando e testando a sua API REST](http://www.ciceroednilson.com.br/spring-boot-e-swagger-documentando-e-testando-a-sua-api-rest/)

#### Tarefa 📚

- Automatizar a documentação dos endpoints da API usando `Swagger`.

* * *

## 5️⃣ Quinta Parte

Após ter implementado as 4 primeiras partes do desafio com um CRUD completo de gerenciamento de usuário, escolhe qual tipo de API desenvolver baseado nele, dentro da lista abaixo:

- Nível 1: [API de Loteria](https://github.com/GuillaumeFalourd/java-training-api/tree/main/APIs/LOTERIA.md)
- Nível 2: [API de Endereços](https://github.com/GuillaumeFalourd/java-training-api/tree/main/APIs/ENDERECO.md)
- Nível 3: [API de Vacinas](https://github.com/GuillaumeFalourd/java-training-api/tree/main/APIs/VACINA.md)
- Nível 4: [API de Banco](https://github.com/GuillaumeFalourd/java-training-api/tree/main/APIs/BANCO.md)
- Nível 5: [API de Veículos](https://github.com/GuillaumeFalourd/java-training-api/tree/main/APIs/VEICULOS.md)

* * *

## 💡 Bônus

Quando trabalhamos com Java e Banco de Dados (BDD), é muito importante ter um conhecimento básico sobre SQL pois é necessário interagir com o BDD no cotidiano para buscar informações ou resolver problemas.

Seguem algumas referências a respeito:

- [Guia completo SQL](https://www.devmedia.com.br/guia/guia-completo-de-sql/38314)
- [Dicas SQL](https://medium.com/@alexandre.malavasi/25-dicas-e-boas-pr%C3%A1ticas-de-banco-de-dados-para-desenvolvedores-7a60bfc28f1f)
- [Boas práticas SQL](https://www.devmedia.com.br/boas-praticas-de-programacao-pl-sql-e-um-pouco-de-tunning-dia-a-dia/2424)
- [FAQ SQL](https://www.luis.blog.br/20-perguntas-e-respostas-sobre-a-linguagem-sql-para-banco-de-dados.html)
