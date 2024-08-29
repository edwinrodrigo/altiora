
# Creacion de Ordendes Altiora - APP

Creacion de ordenes para la prueba tecnica de altiora app

## Objetivo
Desarrollar una API RESTful utilizando Spring Boot que gestione la creacion de ordenes, articulos y clientes. El proyecto debe seguir buenas prácticas de desarrollo, aplicar principios SOLID, y utilizar las tecnologías especificadas a continuación.

## Requisitos Técnicos

### Java
- Utilizar **Java 17** para la implementación.
- Aprovechar las características avanzadas de Java 17, como lambdas y streams, cuando sea apropiado.
- Utilizar **Maven** como gestor de dependencias.

### Spring Boot
- Construir la aplicación utilizando la **última versión** disponible de Spring Boot.

### Base de Datos
- Utilizar una base de datos **POSTGRES** para almacenar la data
- Crear 4 tablas tablas: `articulo`, `cliente`, `orden`, `orden_detalle`.

### Front End
- Se utilizo Angular 18
- Bootstrap

### JPA
- Implementar una capa de persistencia utilizando **JPA** para manejar el almacenamiento y la recuperación la data.

### OpenAPI y Swagger
- Documentar la API utilizando **OpenAPI** y **Swagger**.

## Funcionalidades

Se puede verificar las funcionalidades en el entorno de pruebas de swagger

Proyecto levantado de manera localhost  http://127.0.0.1:8080/altiora-api/swagger-ui/index.html
Proyecto levantado mediante docker      http://127.0.0.1:8081/altiora-api/swagger-ui/index.html


## Documentación
- Se utilizo **OpenAPI** y **Swagger** para documentar de manera clara la API.

## Entregables

### Aplicacion BackEnd Repositorio en GitHub
-El proyecto esta compartido la siguiente ubicacion de Github

### Aplicacion FrontEnd
-Se encuentra en la ruta 
/altiora-api/front/altiora-app
Se utiliza Angular 18
Para levantar la aplicacion utilizar el siguiente comando ng serve
