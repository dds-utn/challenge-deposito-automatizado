package ar.utnba.ddsi.depoautomatizado.models.entities.robots.instrucciones;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public interface InstruccionRobot {
  void ejecutar(Robot robot);
  void inversa(Robot robot);
}
