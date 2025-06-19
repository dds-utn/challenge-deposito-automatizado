package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Adapter.RobotAdapter;

public class GirarRobot implements ActuarRobot {
  private int angulo;

  public GirarRobot(int angulo) {
    this.angulo = angulo;
  }

  public void actuar(RobotAdapter robot) {
    robot.girar(angulo);
  }

  public void deshacer(RobotAdapter robot) {
    robot.girar(angulo * -1);
  }
}
