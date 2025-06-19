package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class AccionDeDejarMercaderia implements AccionRecorrido {
  @Override
  public void ejecutar(Robot robot) {
    robot.soltarMercaderia();
  }

  @Override
  public void ejecutarInversa(Robot robot) {

  }
}