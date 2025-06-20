package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

public class Clark extends Robot {

  public Clark(Long id) {
    super(id, new InterfazControladoraDeRobotPasiva());
  }

  @Override
  public void esquivarObstaculo() {
    super.getInterfazControladoraDeRobot().esquivarObstaculo();
  }
}