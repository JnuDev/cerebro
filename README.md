# CEREBRO
Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men.

Te ha contratado a ti para que desarrolles un proyecto que detecte si un
humano es mutante basándose en su secuencia de ADN.


##HERRAMIENTAS 


[Git]
[GitHub]

[IDE Spring Tool Suite 4] 
[Java 8]
[Spring Boot 2]
[Apache Maven 3.2.5]
[JUnit 5]
[Mockito]
[Open clover 4](https://openclover.org/)
[Swagger 9]
[Javadoc]

[MongoBD]

[Docker]
[App Engine]


##SERVICIOS
/mutant:  Mediante una secuencia de ADN (cadena de caracteres n*n) se determina si el sujeto es un mutante,
consideraciones del servicio:

1) la entrada es un String[]  ejm: {"ATCG","ATCG","ATCG","ATCG"}
2) los únicos valores permitidos son (A,T,C,G)
3) se considera humano mutante si se encuentra más de una secuencia de cuatro letras iguales, de forma oblicua, horizontal o vertical.
4) el tamaño de array(N) debe ser N >= 4.

/stats: Responde la cantidad de Mutantes, Humanos y la ratio entre los dos, de todos los humanos testeados no repetidos. 

---
#App Engine

Servicio : (cerebro-321923.appspot.com/)




# Documentación API

/swagger-ui.html

#Documentación Técnica 

/javadoc/index.html

#
