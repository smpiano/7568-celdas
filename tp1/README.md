# TP 1: extracción de relaciones semánticas

## Primera parte

1. Extracción de relaciones semánticas de forma manual de 5 noticias en inglés, extraídas de forma aleatoria de la base de datos [Reuters21578](https://archive.ics.uci.edu/ml/datasets/Reuters-21578+Text+Categorization+Collection)
2. La aplicación de un algoritmo de exacción de relaciones semánticas: ClauseIE sobre las mismas noticias.
3. La comparación de ambos resultados: las extracciones realizadas de forma automática contra nuestra clasificación manual.

Este trabajo no requerirá informe, y se realizará mediante una interfaz WEB provista para tal fin.

La interfaz web para trabajar es la siguiente: http://fiuba-celdas.co.nf/
La explicación de qué es una relación semántica, como extraerla manualmente y subirla desde la interfaz web la encontrarán en la misma página: http://fiuba-celdas.co.nf/#about

Noticias a procesar:
Ids de noticias: 5019, 3353, 6828, 6490, 4155

## Segunda parte

La segunda parte consiste en ejecutar un algoritmo de extracción de relaciones semánticas, y luego comparar las extracciones realizadas por el algoritmo de forma automática, con las extracciones realizadas por ustedes de forma manual.  Con dichos datos deberán calcular la precisión y la exhaustividad (también llamada exactitud o recall en ingles) del algoritmo para una noticia dada. 
Si es posible se habilitará una nueva sección en el front web anterior para facilitar este trabajo.


El cálculo de la precisión y la exhaustividad se realiza de la siguiente forma:


_Precisión_ =  _Cantidad de extracciones realizadas que fueron correctas_
                 _Cantidad de extracciones realizadas totales_

_Exhaustividad_ =  _Cantidad de extracciones realizadas que fueron correctas_   
                _Cantidad de extracciones que tendría que haber realizado_


Cuando ambas medidas son iguales a 1, el algoritmo efectuó una extracción perfecta.


Para el caso que nos ocupa, el denominador de la Precisión es la cantidad de extracciones que realizó el algoritmo y el denominador de la Exhaustividad es la cantidad de extracciones que encontramos nosotros. 
Más información sobre estas medidas: https://es.wikipedia.org/wiki/Precisi%C3%B3n_y_exhaustividad

El algoritmo que utilizaran se llama ClausIE, uno de los algoritmos en el estado-del-arte y pueden descargar el binario en la siguiente página del Max-Planck Institute:
 https://www.mpi-inf.mpg.de/departments/databases-and-information-systems/software/clausie/?sword_list[]=ClauseIE&no_cache=1


Descarga directa: http://resources.mpi-inf.mpg.de/d5/clausie/clausie-0-0-1.zip


Para utilizarlo, sigan los siguientes pasos:
 Descompriman el ZIP en un directorio cualquiera
 Necesitan tener Java instalada, así que si no la tienen, descárguenla
 Desde la consola ejecuten: clausie.sh  -f noticia.txt -o salida.txt 
 Donde noticia.txt es un archivo de texto en donde deberán copiar la noticia correspondiente al ID que estén analizando.

NOTA: para aquellos alumnos que utilicen Windows generé un archivo “.bat” que pueden utilizar en lugar del SH. Lo adjunto en ZIP para evitar problema: archivo batch


Consideraciones sobre el TP:

No será necesario que vengan a la clase para realizar la entrega, se hará a través del front web o eventualmente por email.
No requiere un informe formal ni documentación adicional.
Respecto a la clase de ayer donde se explicaron los temas relacionados a la extracción de información, intentaré subir algún apunte en la medida que pueda dado que aún no tengo nada armado más que notas sueltas.
