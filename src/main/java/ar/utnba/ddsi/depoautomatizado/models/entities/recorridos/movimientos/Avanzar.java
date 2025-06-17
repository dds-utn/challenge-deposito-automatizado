package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.movimientos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Avanzar extends ComandoMovimiento{
  public Avanzar(Integer dato) {
    super(dato);
  }

  @Override
  protected void operar(Robot robot, Integer pasosPuestos) {
    robot.avanzar(pasosPuestos);
  }

}
