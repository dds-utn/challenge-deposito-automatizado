# Challenge: Depósito Automatizado

# Implementación

## Recorridos
Decidimos implementar los **recorridos** como una serie de pasos, aplicando un **Command Pattern**, donde encontramos distintos métodos como **Avanzar**, **Girar**, **RecogerPaquete** y **DejarPaquete** que se aplican al robot que ejecuta el recorrido. Las distancias de Avanzar, los grados de Girar, y el paquete de RecogerPaquete y DejarPaquete son definidos al momento de **instanciar** cada uno de los objetos que conforman la lista de pasos. Esta implementación permite facilitar la configuración de los recorridos, reutilizar los recorridos entre dsitintos robots e incluso (a pesar de no ser un requerimiento explícito) la creación de recorridos de manera dinámica (para esto sería necesario exponer por ejemplo un endpoint en una API REST). Esta implementación cumple con el principio **Open/Closed** y es **extensible**.

> A modo de aclaración, es importante destacar que decidimos que el método accionar reciba al robot, en vez de instanciarlo al crear los objetos de los pasos o de crear un método por cada robot (AvanzarClark, GirarClark, AvanzarDron, etc.). Tomamos esta decisión porque permite desacoplar los métodos del Command del robot en sí, pudiendo reutilizar recorridos entre distintos robots de ser necesario, y evita tener que asignar el robot a los pasos desde el Service al instanciarlos.

## Notificar Transportista
Para notificar al **transportista** se implementa un sistema **push based**, utilizando un **patrón Broker**. 
Dentro de cada pedido, existe una **lista de observadores**. A pesar de que ahora mismo el observador sea uno solo (el transportista), esta implementación aporta **extensibilidad**, permitiendo que el día de mañana se notifiquen más de un transportista, un cliente (como en ML), etc. al finalizar un pedido. Esto infiere la utilización de un **patrón observer**, donde la clase Transportista implementa la interfaz IObserver, aportando extensibilidad para agregar nuevos observadores. A su vez, utilizamos un **patrón adapter** para poder desacoplar la exposición de la API utilizada de la lógica del Transportador. De esta manera, si en el futuro se desea cambiar la API de notificación, solo se deberá modificar el adapter y no la lógica del transportista.

Decidimos utilizar el método _avisarATransportistaFinalizacionDe(Pedido pedido)_ en vez de implementar la lógica directamente al final de _recogerMercaderiaPor(Robot robot)_ porque gran parte de la lógica ya estaba implementada.

## Descripción
Este challenge consiste en completar el diseño e implementación de un Sistema de Depósito Automatizado. El objetivo es que se implemente la lógica necesaria para manejar la recolección de mercadería en un depósito automatizado.

## Enunciado
El enunciado completo del challenge se encuentra en el siguiente enlace:
[Enunciado del Challenge](https://drive.google.com/file/d/1ral7PhIiNDQxJSnp7kfOgPcIAfM8S4Y9/view?usp=drive_link)

## Punto de Partida
El desarrollo de la solución debe comenzar con una revisión exhaustiva del diseño implementado hasta el momento, incluyendo:
- La clase `Pedido` y su método `recogerMercaderiaPor`
- El servicio `PedidosService` y su implementación actual
- Las entidades y relaciones existentes
- Los tests implementados hasta el momento

Esta revisión es fundamental para entender el contexto y asegurar que la implementación se integre correctamente con el código existente.

## Estructura del Proyecto
El proyecto está estructurado como una aplicación Spring Boot con las siguientes características:
- Tests unitarios que deben ser completados
- Implementación base inicial del Sistema

## Tareas a Realizar
1. Leer y comprender el enunciado completo del challenge
2. Analizar el código existente, especialmente la clase `Pedido` y su método `recogerMercaderiaPor`
3. Completar la implementación del sistema según los requerimientos
4. Implementar y completar los tests unitarios
5. Asegurar que la solución cumpla con los principios SOLID y con las cualidades de diseño adecuadas.


## Entrega
Para entregar su propuesta, cada grupo deberá:

1. Clonar este repositorio
2. Crear una rama con el nombre del grupo
3. Implementar la solución
4. Realizar commits descriptivos
5. Generar una Pull Request (PR) en el repositorio original, apuntando a la rama Main

### Formato de la Pull Request
- **Título**: Debe seguir la siguiente nomenclatura:
  ```
  "Recorridos de Robots- Curso - Grupo X"
  ```
  Ejemplo: "Recorridos de Robots - K3001 - Grupo 3"

- **Descripción**: En la descripción de la PR, cada grupo deberá incluir:
  - Lista de integrantes del grupo

### Consideraciones Importantes
- La PR debe ser creada por un integrante del grupo en representación de todos
- Todos los integrantes deben ser mencionados enla descripción
- Los commits deben ser descriptivos y seguir las buenas prácticas de Git

### ¡A diseñar e implementar!
El primer equipo en entregar la solución y defender su propuesta adecuadamente, se convertirá en el equipo ganador del challenge.

¡Buena suerte! 


