# **Ejercicio MercadoLibre - Backend (ES)**

## Descripción
Este es un ejercicio técnico de entrevista que suele ser solicitado en MercadoLibre para el puesto de desarrollador backend. 
En mi caso, lo programé para la materia "Desarrollo de Software" en la universidad.

En este repositorio encontrarás mi solución, la cual intentaré explicar con algunos gráficos simples y comentarios.

En el documento `code_explanation.md` encontrarás una breve explicación del enunciado del problema y la solución que implementé.
Además en la carpeta **"Diagramas"** encontraras archivos PDF del diagrama de la arquitectura utilizada para este proyecto, además de diagramas de 
secuencia que explican el funcionamiento de los servicios centrales del proyecto

## Pre-requisitos

- JDK (17)
- IntelliJ IDEA (o cualquier IDE de tu preferencia)
- Gradle (Gestor de Dependencias)
- H2 (Base de Datos)

## Dependencias

### Tecnologías Utilizadas

Este proyecto utiliza las siguientes dependencias y tecnologías:

- Spring Boot Starter Data JPA: Para interactuar con bases de datos usando JPA.
- Spring Boot Starter Web: Para crear APIs RESTful y manejar solicitudes web.
- Lombok: Para reducir código repetitivo como getters, setters y constructores.
- Spring Boot DevTools: Para acelerar el desarrollo habilitando la recarga automática de la aplicación.
- H2 Database: Base de datos en memoria para desarrollo y pruebas.
- JUnit Platform Launcher: Para ejecutar pruebas unitarias con JUnit.
- Spring Boot Starter Test: Herramientas y librerías necesarias para realizar pruebas unitarias en el proyecto.

## ¿Como ejecutar?

1. Descargar el proyecto
2. Esperar a que se descarguen las dependencias (El IDE lo suele hacer automático)
3. Ejecutar el proyecto
4. Levantar la base de datos H2, navegando a: `http://localhost:8080/h2-console/`
5. Probá la API con Postman o cualquier otro software de tu preferencia
   *   POST (guardar persona local) `http://localhost:8080/persona/mutant`
   *   POST (guardar persona render) `https://examen-mercadolibre.onrender.com/persona/mutant`
   *   GET (recuperar estadisticas) `http://localhost:8080/persona/stats`

### Ejecutar en consola

1. dirigirse a la carpeta del proyecto con `cd`
2. construir el proyecto y descargar las dependencias: `gradlew build`
3. ejecutar el proyecto: `gradlew bootRun`

Si se ejecuta correctamente deberia imprimir `funcionando` en consola



## Code Coverage

Utilizando **JUnit** se hicieron los test unitarios para probar el 80% de las instrucciones totales del proyecto, lo que se puede ver a continuación, en el gráfico generado
por la librería **Jacoco**:
![<code_coverage>](<imgs/code_coverage.png>)

## Pruebas de estrés con JMeter

### servicio `/persona/mutant`
Corriendo el proyecto localmente:
![<jmeter_mutants>](<imgs/jmeter_mutant.png>)

### servicio `/persona/mutant`
Corriendo el proyecto localmente:
![<jmeter_stats>](<imgs/jmeter_stats.png>)

Cada una de las pruebas fue realizada con 10000 peticiones hechas al mismo tiempo

---
# **MercadoLibre Exercise - Backend (EN)**

## Description
This is an technical interview exercise that is usually asked in MercadoLibre for the position of backend developer.
In mi case, I coded it for the subject "Software Development" in university.

In this repo you´ll find my solution that I´ll try to explain it with some simple graphics and comments.

In the document `code_explanation.md` you´ll find a brief explanation of the problem statement, and the solution I implemented

## Pre-requirements

- **JDK** (17)
- **InteliJ IDEA** (or any IDE of your preference)
- **Gradle** (Dependencies Manager)
- **H2** (Database)

## Dependencies
  
### Technologies Used

This project uses the following dependencies and technologies:

- **Spring Boot Starter Data JPA**: For interacting with databases using JPA.
- **Spring Boot Starter Web**: To create RESTful APIs and handle web requests.
- **Lombok**: To reduce boilerplate code such as getters, setters, and constructors.
- **Spring Boot DevTools**: To speed up development by enabling automatic application reloads.
- **H2 Database**: In-memory database for development and testing. 
- **JUnit Platform Launcher**: To run unit tests with JUnit.
- **Spring Boot Starter Test**: Tools and libraries required for unit testing in the project.

## How to run?
1. Download the project
2. Download the necessary dependencies to run the project
3. Run the project
4. Start the H2 Database, navegating to: http://localhost:8080/h2-console/
7. Try the API with Postman or any other software of your preference
   *   POST (post a person local) http://localhost:8080/persona/mutant
   *   POST (post a person render) https://examen-mercadolibre.onrender.com/persona/mutant
   *   GET (get statistics) http://localhost:8080/persona/stats
