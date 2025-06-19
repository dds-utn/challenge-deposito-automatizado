package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Adapter.RobotAdapter;

public class RecogerPaqueteRobot implements ActuarRobot {
  private int distancia;

  public RecogerPaqueteRobot(int distancia) {
    this.distancia = distancia;
  }

  public void actuar(RobotAdapter robot) {
    robot.recogerPaquete(distancia);
  }
  public void deshacer(RobotAdapter robot) {
    return;
  }
}
