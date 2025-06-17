# Justificación de diseño

Tomando en consideración los principios SOLID, atributos de calidad de diseño y patrones, decidimos estructurar la solución de la siguiente manera

En cuanto a:
- Patrones:
  - 
  - Nos inspiramos en el patrón Command para modelar los movimientos del robot, utilizando la clase abstracta MovimientoCommand como base común. Esta clase encapsula la lógica general de ejecución e inversión de un movimiento a partir de un dato. A partir de ella, definimos clases concretas como Avanzar, Elevar y Girar, que sobrescriben el método operar para especificar la acción concreta que debe realizar el robot en cada caso 
  - Al Recorrido lo vimos como un accionador en el patrón Command, que tiene dos conjuntos de acciones unas que se hacen para antes de agarrar el paquete y otras antes para entregar el paquete. Decidimos separarlo en dos porque la acción de agarrar el paquete y entregarlo nunca cambian y a su vez porque esto también nos permitió que haga los movimientos inversos con mayor facilidad. De esta forma el recorrido solo tiene una sola responsabilidad y a su vez permite una configuración mas sencilla de los movimientos
  - También implementamos el patrón Strategy para el comportamiento de esquivar obstáculos. Definimos la interfaz EstrategiaObstaculo, y luego están las clases EsquivarObstaculoStrategy, LlamarMantenimientoStrategy y VolverInicioStrategy que la implementan
  - Aplicamos también el patrón Adapter para adaptar distintos tipos de robots al modelo esperado por el recorrido. Tenemos una clase abstracta Robot con métodos genéricos como avanzar, girar o recogerPaquete, y luego clases como AdapterClark o AdapterDrone que extienden de Robot y adaptan su funcionamiento particular. Esto nos permite que el recorrido trabaje siempre con la misma interfaz, sin importar el tipo específico de robot que se esté usando
  
- Principios SOLID:
  - 
  - Podemos ver reflejado que se cumplen por ejemplo en la implementación de los 'movimientos'
    - S: cada clase tiene una única función 
    - O: se pueden agregar nuevos movimientos sin tocar lo existente
    - L: las subclases se comportan como sus padres sin romper nada
    - I: cada clase concreta solo implementa la lógica que necesita, sin tener que definir métodos que no usa
    - D: el recorrido trabaja con la clase abstracta MovimientoCommand, sin depender directamente de las clases concretas como Avanzar o Girar

- Atributos de calidad:
  -
  - Extensibilidad: se pueden agregar nuevas estrategias o movimientos sin modificar lo ya implementado
  - Mantenibilidad: los cambios son localizados y no afectan otras partes del sistema gracias a la responsabilidad única y el bajo acoplamiento
  - Testeabilidad: el diseño basado en interfaces facilita el testing unitario
  - Modularidad: las responsabilidades están separadas en componentes independientes
  - Disponibilidad: cada robot tiene su propio estado de disponibilidad, lo que permite saber si está listo para ejecutar tareas o no
  - Performance: los recorridos están divididos en pasos claros y reutilizables, lo que evita trabajo redundante y mejora la eficiencia del sistema
  - Simplicidad: el diseño es claro, evita lógica innecesaria y permite entender el flujo de ejecución sin esfuerzo
