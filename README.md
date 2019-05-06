# Backend Challenge
[![Wide Software Logo](https://raw.githubusercontent.com/cleverson-at/backend-challenge/feature-000000-song-advisor/static/wide-software-logo.png)](https://www.widesoftware.com.br)    [![Docker Hub Logo](https://raw.githubusercontent.com/cleverson-at/backend-challenge/feature-000000-song-advisor/static/docker-hub-logo.png)](https://hub.docker.com/r/cleversonteotonio/backend-challenge)

Esta aplicação foi feita como parte do processo seletivo da Wide Software. Ela está disponível como um docker container, para acessa-lo simplesmente clique no ícone do Docker Hub acima. Abaixo segue a descrição da arquitetura básica da aplicação, assim como a discriminação dos princípios que embasam as decisões técnicas tomadas no processo de desenvolvimento da mesma.

# Tecnologias
Backend challenge utiliza várias tecnologias para funcionar:

  - [Java] - a linguagem  de programação!
  - [Spring] - o framework web!
  - [Maven] - o build tool!
  - [Hamcrest] - o assertion framework!
  - [JUnit] - o Unit Test framework utilizado para TDD!
  - [Mockito] - o Test Double framework!
  - [Cucumber] - o Behaviour Test framework utilizado para BDD!
  - [SLF4J] - o Logging framework!
  - [Lombok] - para diminuir a escrita de boilerplate code!
  - [Swagger] - para documentar a API!
  - [Docker] - o Enterprise Container Application!
  - [Git] - o Version Control System!

# Desafio
## Widesoftware - Backend challenge
Crie um microserviço que aceite solicitações RESTful onde receberá por parâmetro o nome da cidade e retorne uma sugestão de músicas de acordo com a temperatura local. Apenas o nome das músicas sugeridas é o suficiente.

### Regras de negócio
- Se a temperatura (em celsius) estiver acima de 30 graus, sugerir músicas de categoria **Festa**.
- Caso a temperatura esteja entre 21 e 30 graus, sugerir músicas de categoria **Hip Hop**.
- Se estiver um pouco frio, entre 15 e 20 graus, sugira músicas de categoria **Clássica**.
- Agora, se estiver muito frio, abaixo de 15 graus, a sugestão é músicas de categoria **Rock**.

### Dicas
Você pode usar a API do **OpenWeatherMaps** (https://openweathermap.org) para pegar os dados de temperatura e a API do **Spotify** (https://developer.spotify.com) para pegar as msica que irá sugerir.

### O que avaliaremos?
- Qualidade do código.
- Testes no código (TDD).

### Será um diferencial
- Enviar o projeto em Docker.
- Teste de integração.

Gostaríamos também que descrevesse os detalhes da arquitetura e padrões utilizados na criação do projeto.
Por fim, compartilhe o seu código conosco via GitHub (público).

# Metodologia de Desenvolvimento
Devido ao escopo limitado do projeto não faria sentido a aplicação de nenhuma metodologia de desenvolvimento específica. No intuíto de ilustrar como um projeto de escopo maior teria sido feito, foi criado [este quadro no Trello] estilo Scrum/Kanban. 

O enunciado do desafio virou uma história de usuário, seguindo os princípios de [como escrever uma boa história de usuário], e as regras de negócio viraram cenários de um caso de uso. 

O cartão possui um código que exemplifica um código de um Ticket aberto em um departamento de atendimento. Ele serve como identificador que irá unificar uma issue cadastrada em um sistema de atendimento, o cartão com a história de usuário e o branch onde o desenvolvimento será efetuado. Facilitando a documentação do código e a reversão de funcionalidades completas.

Foi utilizado o esquema de versionamento descrito no artigo [Major.Minor.Patch], e o [Git Flow] para gerencia dos branchs pois ele preserva a informação relativas as branchs após o merge (Não é utilizado o Fast-Foward).

# Arquitetura
Foram utilizados os conceitos Clean Architecture descritos no livro [Clean Architecture: A Craftsman's Guide to Software Structure and Design]. Foi utilizada uma versão levemente especializada dessa arquitetura, utilizou-se como base [princípios populares no desenvolvimento Android], assim como a [expertise demonstrada por empresas nacionais]. Nem todos os princípios Clean Arch foram seguidos ao pé da letra, frameworks, por exemplo, foram amplamente utilizados.

Em linhas gerais é possível afirmar que a aplicação é dividida em três camadas:

  - Gateways - Camada de comunicação com o mundo externo. Nenhuma outra camada pode depender dessa camada, portando o princípio SOLID de Dependency Inversion é aplicado. Para clareza suas funcionalidades são aqui implementadas utilizando o Command Pattern. Quando diz respeito a uma third-party API, foi desenvolvida utilizando [Contract Tests] para garantia de que a API ainda continua como esperado e [Test Doubles] para permitir que os testes sejam feitos utilizando uma intância local da API;

  - Use Cases - Camada de casos de uso. Essa camada depende do model mas não pode depender dos gateways. Foi desenvolvida utilizando BDD. Para clareza suas funcionalidades são aqui implementadas utilizando o Command Pattern;

  - Model - Camada de modelagem de todas as entidades (entities) que armazenarão as informações e todas as regras de negócio (domain). Todas as outras camadas dependem dela mas ela não pode depender de ninguém. Foi desenvolvida com TDD. Essa é a principal camada;

# Testes
## Validation Tests
Foram feitos testes que efetuam HTTP requests de forma analoga ao que uma aplicação cliente irá fazer. Devido a isso para que todos os testes executem com sucesso é necessária uma instância da aplicação em execução.

## Integration Tests
Foram feitos testes que efetuam invoções dos geteways. Os gateways irão por sua vez invocar os [Test Doubles]. Devido a isso para que todos os testes executem com sucesso é necessária uma instância de cada um dos Test Doubles em execução. Os [Contract Tests] garantem que o Test Double é uma representação utilitariamente identica do provedor real.

## Unit Tests
Foram efetuados testes unitários ao Estilo TDD no domain e no estilo BDD nos use cases.

# Credenciais
As credenciais da aplicação foram externalizadas por questão de segurança. Portanto, elas devem ser informadas no momento da execução. Abaixo estão os arquivos e o formato em que essas credenciais devem ser informadas.

* Arquivo: openweathermap.credentials.properties
```txt
 openweathermap.authentication.key={key-value}
```

* Arquivo: spotify.credentials.properties
```txt
 spotify.authentication.client.id={client-id}
 spotify.authentication.client.secret={client-secret-value}
```

# Java
Execução da aplicação no Java:
```sh
java -jar -DCREDENTIALS_PATH=/home/user/Documents/credentials backend-challenge-0.1.jar
```
Na variável CREDENTIALS_PATH informe o endereço em que se encontram as credenciais do Spotify e do OpenWeatherMap. Elas foram externalizadas por questão de segurança e devem estar no formato descrito na seção Credenciais acima.

# Maven
## Execução da aplicação no Maven
```sh
mvn clean install -DCREDENTIALS_PATH=/home/user/Documents/credentials
```
Na variável CREDENTIALS_PATH informe o endereço em que se encontram as credenciais do Spotify e do OpenWeatherMap. Elas foram externalizadas por questão de segurança e devem estar no formato descrito na seção Credenciais acima.

## Criação do Docker container via Maven
```sh
sudo mvn clean install docker:build -DskipTests
```
Como os testes de validação requerem uma instância da aplicação em execução e os testes de integração requerem que os test doubles estejam em execução, execute a construção do container pulando os testes.

# Docker
Execução da aplicação no Docker:
```sh
sudo docker run -v /home/user/Documents/credentials:/credentials -it -p 8090:8090 63f07041549d
```
No volume informe o endereço em que se encontram as credenciais do Spotify e do OpenWeatherMap. Elas foram externalizadas por questão de segurança e devem estar no formato descrito na seção Credenciais acima.

# Endpoints
Para acessar a documentação completa, com a aplicação em execução, acesse: http://localhost:8090/swagger-ui.html

   [Java]: <https://www.oracle.com/java/>
   [Spring]: <https://spring.io>
   [Maven]: <https://maven.apache.org/>
   [Hamcrest]: <http://hamcrest.org/>
   [JUnit]: <https://junit.org/junit4/>
   [Mockito]: <https://site.mockito.org/>
   [Cucumber]: <https://cucumber.io/>
   [SLF4J]: <https://www.slf4j.org/>
   [Lombok]: <https://projectlombok.org/>
   [Swagger]: <https://swagger.io/>
   [Docker]: <https://www.docker.com/>
   [Git]: <https://git-scm.com/>
   
   [este quadro no Trello]: <https://trello.com/b/gE4Oghi2/backend-challenge>
   [como escrever uma boa história de usuário]: <https://stormotion.io/blog/how-to-write-a-good-user-story-with-examples-templates/#how-to-write-user-stories>
   [Major.Minor.Patch]: <https://medium.com/fiverr-engineering/major-minor-patch-a5298e2e1798>
   [Git Flow]: <https://nvie.com/posts/a-successful-git-branching-model/>
   [Clean Architecture: A Craftsman's Guide to Software Structure and Design]: <https://www.amazon.com.br/Clean-Architecture-Craftsmans-Software-Structure-ebook/dp/B075LRM681?tag=goog0ef-20&smid=A18CNA8NWQSYHH&ascsubtag=go_1686871380_65779544836_327582895583_aud-580930410671:pla-581169666159_c_>
   [princípios populares no desenvolvimento Android]: https://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
   [expertise demonstrada por empresas nacionais]: <https://www.infoq.com/br/presentations/transformando-sua-arquitetura-com-clean-architecture>
   [Contract Tests]: <https://martinfowler.com/bliki/ContractTest.html>
   [Test Doubles]: <https://martinfowler.com/bliki/IntegrationTest.html>
