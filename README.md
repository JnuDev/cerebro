# CEREBRO
Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men.

Te ha contratado a ti para que desarrolles un proyecto que detecte si un
humano es mutante basándose en su secuencia de ADN.

------
## PRE-requisitos 


[Git] - Software de control de versiones 

[GitHub] -  Host para alojar proyectos utilizando el sistema de control de versiones Git

[IDE Spring Tool Suite 4]  ó IDE compatible con java 8

[Java 8] 

[Spring Boot] 

[MongoBD]

## Construido con 

[Apache Maven] - Manejador de dependencias.

[JUnit 5] - Pruebas unitarias.

[Mockito] - Marco de pruebas.

[Open clover 4] 

[Swagger] - Conjunto de herramientas para diseñar, construir, documentar, y utilizar servicios web RESTful. 

[Javadoc] -  utilidad para la generación de documentación de APIs en formato HTML.

[Docker] - Automatizador de despliegue de aplicaciones dentro de contenedores de software.


## Servidor de alojamiento 

[Google App Engine]

------

## Estrategia de la solución  
[/mutant]:  Mediante una secuencia de ADN (array de nucleotidos) se determina si el sujeto es un mutante,
consideraciones del servicio:

- La entrada es un String[]  ejm: {"ATCG","ATCG","ATCG","ATCG"}
- Los únicos valores permitidos son (A,T,C,G)
- Se considera humano mutante si se encuentra más de una secuencia de cuatro letras iguales, de forma oblicua, horizontal o vertical.
- El tamaño de array(N) debe ser N >= 4.
- El array de entrada debe generar una matriz de NxN

|A|T|C|G|
|---|---|---|---|
|A|T|C|G|
|A|T|C|G|
|A|T|C|G|

- El algoritmo busca secuencias con el siguiente flujo
	- búsqueda en horizontal 
	- 	recorre y valida si encuentra secuencias se acumula (secuencia + 1)
	-	se valida: si las secuencias acumuladas son mayores a 1, termina la ejecución y se considera mutante, 
	-	si no continua hasta recorrer la matriz 
	- se valida: si las secuencias acumuladas son mayores a 1, termina la ejecución y se considera mutante, 
	- si no continua búsqueda en vertical
	-	recorre y valida si encuentra secuencias se acumula (secuencia + 1)
	- 	se valida: si las secuencias acumuladas son mayores a 1, termina la ejecución y se considera mutante, 
	-	si no continua hasta recorrer la matriz 
	- se valida: si las secuencias acumuladas son mayores a 1, termina la ejecución y se considera mutante, 
	- si no continua búsqueda en Diagonal Primaria 
	-	recorre y valida si encuentra secuencias se acumula (secuencia + 1)
	-	se valida: si las secuencias acumuladas son mayores a 1, termina la ejecución y se considera mutante, 
	-	si no continua hasta recorrer la matriz 
	- se valida: si las secuencias acumuladas son mayores a 1, termina la ejecución y se considera mutante, 
	- si no continua búsqueda en Diagonal Secundaria 
	-	recorre y valida si encuentra secuencias se acumula (secuencia + 1)
	-	se valida: si las secuencias acumuladas son mayores a 1, termina la ejecución y se considera mutante, 
	-	si no continua hasta recorrer la matriz 
	- se valida: si las secuencias acumuladas son mayores a 1, termina la ejecución y se considera mutante, 
	- si no es un humano.

[/stats]: Responde la cantidad de Mutantes, Humanos y la ratio entre los dos, de todos los humanos testeados no repetidos.


------
## Ejecución de pruebas

[Ver Documentación](https://cerebro-321923.ue.r.appspot.com/swagger-ui.html)

![](https://github.com/jnudev/cerebro/blob/develop/media/swagger_doc.png)

![](https://github.com/jnudev/cerebro/blob/develop/media/swagger_methods.png)


## App Engine 

Servicio :

- [TYPE POST; HEADER Content-Type: application/json] [Mutant](https://cerebro-321923.ue.r.appspot.com/mutant)	- Consumir con Herramientas (SoapUI/Katalon/etc..)

```Json
{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

``` 
- [Statas](https://cerebro-321923.ue.r.appspot.com/stats)	-  [TYPE GET]
------

##  Code coverage OPEN CLOVER

![](https://github.com/jnudev/cerebro/blob/develop/media/clover_dashboard.png)

![](https://github.com/jnudev/cerebro/blob/develop/media/clover_stats.png)







