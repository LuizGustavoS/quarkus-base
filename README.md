# quarkus-base
Projeto base em quarkus para desenvolvimento de novos apps

## Conteúdo
- Quarkus 1.6.1
- Java 11
- Postgresql
- Lombok

## Implementação
- Autenticação Basic Oauth2
- Implementação de User Session
- Anotação para nivel de autenticação
- Exemplo de CRUD simples

## Comandos básicos
#### Iniciar aplicação `$ mvn quarkus:dev`
#### Build Runnable Jar `mvn clean package`
#### Build Imagem Docker `$ docker build -f src/main/docker/Dockerfile.jvm`

## Intensões futuras
1. Implementação de documentação **[OpenApi](https://swagger.io/specification/)**
2. Implementação de relatórios/documentos usandos **[Jasper Studio](https://community.jaspersoft.com/project/jaspersoft-studio)**
2. Migração para **Java 14**
