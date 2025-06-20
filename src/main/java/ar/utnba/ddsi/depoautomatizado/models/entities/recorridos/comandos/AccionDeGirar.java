package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class AccionDeGirar implements AccionRecorrido {
  private Integer grados;

  public AccionDeGirar(Integer grados) {
    this.grados = grados;
  }

  @Override
  public void ejecutar(Robot robot) {
    robot.girar(grados);
  }

  @Override
  public AccionRecorrido accionInversa() {
    return new AccionDeGirar(this.grados * -1);
  }
}