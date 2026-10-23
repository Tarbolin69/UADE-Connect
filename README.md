# UADE Connect

Equipo: LeyLine

Nicolas Ortega

## Especificaciones

Proyecto hecho con Maven en Java 25 usando IntelliJ IDEA.

## Funcionalidades y Soluciones

### Organización del Muro de Publicaciones

QuickSort fue elegido por ser la solución mas simple y rápida al problema que usa DyC. Se elije un pivote al medio para intentar que la complejidad del mismo siempre sea medianamente favorable. MergeSort fue brevemente considera, pero era un poco complejo para el problema a resolver.

Este algoritmo puede ordenar tanto por numero de reacciones como por fecha de publicación --- eligiendo la mas reciente en caso de que tengan la misma cantidad de reacciones. Tiene una complejidad promedia de O(n log n) y en el peor caso, O(n2)

### Cadena de Difusión Más Rápida

Dijkstra fue elegido como la solución mas apropiada para este problema, dado de es una grafo dirigido con peso, y por ser un algoritmos Greedy. Bellman hubiera sido apropiado si hubieran pesos negativos, y Floyd fue considerado innecesario.

Muestra en la terminal la distancia entre el usuario origen y todos los usuarios vinculados, y el usuario destino, así como también el tiempo que llevaría en llegar una convocatoria de usuario X a usuario Y. Su complejidad es O(A log V)

### Selección de Iniciativas Para Financiar

Este era un problema recolorado de la mochila, así que se eligio el algoritmo de mochila dinámico. El "valor" se obtienen mediante el costo de impacto de para iniciativa. Tiene una complejidad de O(n * P)
