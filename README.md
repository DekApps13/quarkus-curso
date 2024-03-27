# app-api

Este projecto esta construido utilizando el Framework de Java: Quarkus

## ¿Cómo ejecutar la aplicación en mode Dev?

Para ejecutar el modo Dev y poder ver los cambios en tiempo real, ejecuta lo siguiente:

En Windows:
```shell script
.\mvnw.cmd quarkus:dev
```

En macOS/Linux:
```shell script
./mvnw quarkus:dev
```

Usando quarkus-cli:
```shell script
quarkus dev
```

> **_NOTA:_**  El Dev UI está disponible solo en modo Dev, aquí: http://localhost:8080/q/dev/.

# Endpoints

## Base URL
Recomiendo agregar esta variable en tu Cliente para hacer peticiones HTTP:
> {{base_url}} = http://localhost:8080 

## Eco (Saludar)

### GET /saludar?mensaje="aquí va el mensaje"
Muestra en pantalla el mensaje que el usuario haya escrito.

### GET /saludar/{nombre}
Concatena el nombre dado por PathParam `{nombre}` y muestra un saludo.

### GET /saludar/{nombre}/mayusculas
Concatena el nombre dado por PathParam `{nombre}` y muestra un saludo en MAYÚSCULAS.

## Temperaturas

### GET /temperaturas
Devuelve una lista de tipo List de las temperaturas almacenadas en memoria.

### POST /temperaturas
Inserta una nueva temperatura.

**_Plantilla:_**
````json
{
    "ciudad": "ciudad",
    "minima": 0,
    "maxima": 0
}
````

### GET /temperaturas/m1
Devuelve un ejemplo de temperatura.

No se utiliza la anotación @Produces(MediaType.APPLICATION_JSON).

### GET /temperaturas/m2
Devuelve un ejemplo de temperatura.

Se utiliza la anotación @Produces(MediaType.APPLICATION_JSON).

### GET /temperaturas/maxima
Devuelve la temperatura máxima almacenada en memoria. 
En el caso de no haber temperaturas almacenadas, devuelve: "No hay temperaturas"

### GET /temperaturas/{ciudad}
Devuelve la temperatura de una ciudad dada.
En el caso de no haber temperatura para esta ciudad, devuelve: "No hay registros para la ciudad: {ciudad}"

## Books

Esta Entidad se diseñó bajo el patrón **Repository** que _implementa_ la Interface `PanacheRepository`.

### GET /books
Lista todos los libros registrados en la DDBB.

### POST /books
Inserta un nuevo libro a la DDBB.

**_Plantilla:_**

```json
{
    "title": "",
    "numPages": 0,
    "pubDate": "yyyy-mm-dd",
    "description": ""
}
```

## Magazine

Esta Entidad se diseñó bajo el patrón **Active Record** que _hereda_ de la clase abstracta `PanacheEntity`.

### GET /magazine
Lista todas las revistas registradas en la DDBB.

### POST /magazine
Inserta una nueva revista a la DDBB.

**_Plantilla:_**

```json
{
  "title": "",
  "numPages": 0,
  "pubDate": "yyyy-mm-dd",
  "description": ""
}
```