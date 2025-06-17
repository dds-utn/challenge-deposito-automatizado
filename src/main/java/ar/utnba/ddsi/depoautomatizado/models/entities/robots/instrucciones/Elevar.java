package ar.utnba.ddsi.depoautomatizado.models.entities.robots.instrucciones;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Elevar implements InstruccionRobot {
  private final int unidades;

  public Elevar(int unidades) {
    this.unidades = unidades;
  }

  @Override
  public void ejecutar(Robot robot) {
    robot.elevar(unidades);
  }

  @Override
  public void inversa(Robot robot) {
    robot.elevar(-unidades);
  }
}
