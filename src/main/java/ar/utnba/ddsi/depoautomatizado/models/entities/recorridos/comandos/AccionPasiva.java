package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class AccionPasiva implements AccionRecorrido {
  @Override
  public void ejecutar(Robot robot) {
    //No hace nada.
  }

  @Override
  public AccionRecorrido accionInversa() {
    return new AccionPasiva();
  }
}
