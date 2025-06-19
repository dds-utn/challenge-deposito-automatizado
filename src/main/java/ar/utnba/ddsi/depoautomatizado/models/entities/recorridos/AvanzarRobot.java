package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Adapter.RobotAdapter;

public class AvanzarRobot implements ActuarRobot {
  private int metros;

  public AvanzarRobot(int metros) {
    this.metros = metros;
  }

  public void actuar(RobotAdapter robot) {
    robot.avanzar(metros);
  }
  public void deshacer(RobotAdapter robot) {
    robot.avanzar(metros * -1);
  }
}
