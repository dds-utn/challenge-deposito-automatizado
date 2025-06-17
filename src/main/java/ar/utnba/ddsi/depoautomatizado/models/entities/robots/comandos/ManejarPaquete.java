package ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class ManejarPaquete implements ComandoRobot {
  private final AccionConPaquete accion;

  public ManejarPaquete(AccionConPaquete accion) {
    this.accion = accion;
  }

  @Override
  public void ejecutar(Robot robot) {
    if(accion.equals(AccionConPaquete.DEJAR)) {
      robot.dejarPaquete();
    }
    else {
      robot.recogerPaquete();
    }
  }
  @Override
  public void inversa(Robot robot) {
    if(accion.equals(AccionConPaquete.DEJAR)) {
      robot.recogerPaquete();
    }
    else {
      robot.dejarPaquete();
    }
  }
}
