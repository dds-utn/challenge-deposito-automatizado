package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.movimientos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Elevar extends ComandoMovimiento {
  public Elevar(Integer dato) {
    super(dato);
  }

  @Override
  protected void operar(Robot robot, Integer elevacion) {
    robot.elevar(elevacion);
  }

}
