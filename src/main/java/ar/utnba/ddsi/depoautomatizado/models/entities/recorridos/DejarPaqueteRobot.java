package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Adapter.RobotAdapter;

public class DejarPaqueteRobot implements ActuarRobot {
  private int distancia;

  public DejarPaqueteRobot(int distancia) {
    this.distancia = distancia;
  }

  public void actuar(RobotAdapter robot) {
    robot.dejarPaquete(distancia);
  }
  public void deshacer(RobotAdapter robot) {
    return;
  }
}
