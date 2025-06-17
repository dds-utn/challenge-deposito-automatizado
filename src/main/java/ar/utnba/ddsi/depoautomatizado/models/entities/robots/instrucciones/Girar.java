package ar.utnba.ddsi.depoautomatizado.models.entities.robots.instrucciones;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Girar implements InstruccionRobot {
  private final int grados;


  public Girar(int grados) {
    this.grados = grados;
  }

  @Override
  public void ejecutar(Robot robot) {
    robot.girar(grados);
  }

  @Override
  public void inversa(Robot robot) {
    robot.girar(180+grados); // Invierte el giro pero mantiene la orientacion para hacer marcha atrás
  }
}
