package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class EsperarYReintentarStrategy implements EstrategiaObstaculo {

  private final int tiempoEspera;

  public EsperarYReintentarStrategy(int tiempoEspera) {
    this.tiempoEspera = tiempoEspera;
  }

  @Override
  public void manejarObstaculo(Robot robot) {
    System.out.println("Esperando " + tiempoEspera + " unidades de tiempo...");
    // Simula espera
    try {
      Thread.sleep(tiempoEspera * 100L); // Opcional, simula el delay
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    System.out.println("Reintentando avanzar...");
    robot.setObstaculizado(false); // Reintenta
  }
}

