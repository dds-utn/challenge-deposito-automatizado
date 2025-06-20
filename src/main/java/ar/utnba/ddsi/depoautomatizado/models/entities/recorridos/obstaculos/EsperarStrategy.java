package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class EsperarStrategy implements EstrategiaObstaculo {
  private static final long TIEMPO_ESPERA = 10;

  @Override
  public void manejarObstaculo(Robot robot) {
    robot.esperar(TIEMPO_ESPERA);
    robot.reintentarUltimoMovimiento();
  }
}
