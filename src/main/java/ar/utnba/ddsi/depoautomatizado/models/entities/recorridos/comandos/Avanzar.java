package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Avanzar implements Comando {
  private Integer pasos;

  public Avanzar(Integer pasos) {
    this.pasos = pasos;
  }

  @Override
  public void accionar(Robot robot) {
    robot.avanzar(pasos);
  }
}
