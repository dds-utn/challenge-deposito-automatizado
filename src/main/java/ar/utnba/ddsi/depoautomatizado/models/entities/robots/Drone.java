package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

public class Drone extends Robot {

  public Drone(Long id) {
    super(id, new InterfazControladoraDeRobotPasiva());
  }

  @Override
  public void esquivarObstaculo() {
    super.getInterfazControladoraDeRobot().esquivarObstaculo();
  }
}