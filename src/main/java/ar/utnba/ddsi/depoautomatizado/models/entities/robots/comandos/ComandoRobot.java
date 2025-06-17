package ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public interface ComandoRobot {
  void ejecutar(Robot robot);
  void inversa(Robot robot);
}
