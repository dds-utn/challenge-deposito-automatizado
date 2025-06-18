package ar.utnba.ddsi.depoautomatizado.models.entities.command;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

//*Command pattern
public interface Paso {
  void accionar(Robot robot); //? Podríamos hacer que accionar no reciba nada y directamente se instancie el robot cada vez que se instancia una de las clases (y encargarnos de que los pasos sean siempre para el mismo robot en el service al orquestar los casos de uso), pero elegimos hacerlo así porque nos permite forzar el uso del robot sin tener que pasar por el service, lo que facilita la reutilización y modificación de recorridos a futuro
}
