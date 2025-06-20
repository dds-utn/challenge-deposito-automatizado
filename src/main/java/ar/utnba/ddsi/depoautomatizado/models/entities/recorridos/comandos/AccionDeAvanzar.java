package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class AccionDeAvanzar implements AccionRecorrido {

  private Integer cantidadPasos;

  public AccionDeAvanzar(Integer cantidadPasos) {
    this.cantidadPasos = cantidadPasos;
  }

  @Override
  public void ejecutar(Robot robot) {
    robot.avanzar(cantidadPasos);
  }

  @Override
  public AccionRecorrido accionInversa() {
    return new AccionDeAvanzar(this.cantidadPasos * -1);
  }
}
