package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.movimientos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Girar extends ComandoMovimiento{
  public Girar(Integer dato) {
    super(dato);
  }

  @Override
  protected void operar(Robot robot, Integer grados){
    robot.girar(grados);
  }

}
