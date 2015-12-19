# Trabajo práctico
# Angry-Birds

Hay que hacer un sistema autónomo que aprenda a jugar, básicamente.
Lo que está codeado tiene una lógica fija y va pasando los niveles.
A veces pifia, vuelve a intentar, pero no funciona como se espera.


Nosotros tenemos que tirar esa lógica hardcodeada y hacer un sistema que tendría que partir de cosas muy básicas, tan simple como ponérsela a un cerdo, o a un bloque de madera, e ir evaluando resultados, iterando sobre un nivel hasta pasarlo. Repito, sólo tenemos que tocar la parte que decide a dónde tirar. Reconocimiento de objetos, cálculo de trayectoria, etc, granted.


Resumidamente, se modela así. Una teoría se compone de percepción inicial: condiciones iniciales, ej, cerdo1 en pos x,y, cerdo2 etc..
acción: qué se hace al respecto, ej, tirar en pos x,y, donde está el cerdo1
percepción final: es la predicción de la teoría, ej: cerdo1 muerto
k: cantidad de veces ejecutada la teoría
p: correctitud, cuántas veces la teoría tuvo éxito
score: esto es algo específico de nuestro problema, y ayuda a evaluar la teoría. En el Angry Birds queremos maximizar el puntaje => guardamos el promedio de puntaje de las ejecuciones de esta teoría


Una característica fundamental de un sistema autónomo es que tiene una predicción, y evalúa qué tan correcta es después de aplicar la acción. Dijo que lo pregunta en la defensa oral, debe ser importante :P


Dado que cada iteración de aprendizaje es lentísima (porque implica jugar el juego realmente), nos sugirió ir persistiendo cada vez que se ejecuta una teoría, así otro día no hay que empezar de cero. Puede ser un archivo de texto, o una db, whatever.


Con que pase tres niveles solo, ya está bien.


El chabón mandó un ejemplo hace un tiempo de un sistema autónomo implementado en Java. Nunca lo miré, pero sé que está ahí. También mandó un capítulo de sistemas inteligentes autónomos que, con leer eso (70 págs ¬¬) debería alcanzar.


Entregables:
1. código
2. jar archivo con las teorías corridas para que el tipo pueda ver el sistema entrenado
3. informe en formato LNCS ( template LaTeX )
4. defensa oral (léase: contar cómo fue)
