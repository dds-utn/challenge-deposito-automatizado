package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class EsperarYReintentarStrategy implements EstrategiaObstaculo {

  private final int tiempoEspera;

  public EsperarYReintentarStrategy(int tiempoEspera) {
    this.tiempoEspera = tiempoEspera;
  }

  @Override
  public void manejarObstaculo(Robot robot) {
    try {
      Thread.sleep(tiempoEspera * 100L);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    robot.ultimaInstruccion().ejecutar(robot);
    robot.setObstaculizado(false);
  }
}

