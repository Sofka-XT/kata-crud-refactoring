## KATA Full Stack

En el siguiente proyecto se presenta algunos conceptos de Full Stack, trabajando con Spring Boot + ReactJS.

### Caso de Uso

Se tiene presente un formulario donde se registra unas tareas basadas en una lista agrupadas. Esta lista se crea para poder tener una grupos de TO-DOs. 
La lista se tiene una parte funcional y una parte que se presenta con fallas. 

#### Perspectiva Front-end
Se tiene un archivo con toda la lógica, se presenta algunas inconcistencias y el funcionamiento no es tan adecuada. Se debe resolver los problemas internos y se debe refactorizar en donde se separe los componentes en archivos. 

Aplicar las mejores practicas y buscar el mejor diseño para presentar los datos.


#### Perspectiva Back-end

Dentro del back-end no se tiene una base de datos basada en servidor, no se tiene una separación adecuada de relaciones para las entidades de persistencias. Se debe aplicar un buen diseño de modelo entidad relación y aplicar una base de datos como servidor, ejemplo MySQL.

### Issues

- Resolver el diseño gráfico
- Separar bien los elementos gráficos como componentes, store, reducer y providers.
- Resolver el problema que no se persisten los elementos de la lista agrupada, se debe persistir la lista agrupada en una entidad que relacione la lista con la sublista.
- La base de datos debe esta en un servidor como MySQL.
- Aplicar reglas para no guardar elementos vácios.
- Validar carácteres y demás para guardar las entidades de los TO-DO.

## Reto

Hacer un fork en su propio namespace y presentar la solución mas valida para ser discutida, argumentar los aspectos de mejora y aplicar algunas técnica de refactorización. Resolverlo de forma individual, aplicar los commit para cada paso que se realice en la refactorización. 
