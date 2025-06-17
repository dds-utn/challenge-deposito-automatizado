package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class DejarPaquete implements Comando {
  @Override
  public void accionar(Robot robot){
    robot.dejarPaquete();
  }
}
