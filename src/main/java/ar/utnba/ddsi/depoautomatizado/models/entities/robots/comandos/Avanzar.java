package ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Avanzar implements ComandoRobot {
  private final int pasos;

  public Avanzar(int pasos) {
    this.pasos = pasos;
  }

  @Override
  public void ejecutar(Robot robot) {
    robot.avanzar(pasos);
  }

  @Override
  public void inversa(Robot robot) {
    robot.avanzar(-pasos);
  }
}
