package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Adapter.RobotAdapter;

public interface ActuarRobot {
  public void actuar(RobotAdapter robot);
  public void deshacer(RobotAdapter robot);
}
