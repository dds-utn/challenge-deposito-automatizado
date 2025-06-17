package ar.utnba.ddsi.depoautomatizado.models.entities.command.impl;

import ar.utnba.ddsi.depoautomatizado.models.entities.command.Paso;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Avanzar implements Paso {

  private final int longitudDelPaso;
  //* Al instanciar la longitud del paso (o radio de giro) en el constructor, se maximiza la facilidad de configuración de los pasos (ya sean de avance o giro) en si.
  Avanzar(int longitudDelPaso) {
    // Al instanciar cada paso "Avanzar" del recorrido, se define el largo del paso, pudiendo haber pasos Avanzar con distintos largos( Ej "Avanzar 1 metro", Girar "90", "Avanzar 2 metros",etc.)
    this.longitudDelPaso = longitudDelPaso;
  }

  @Override
  public void accionar(Robot robot) {
    robot.avanzar(this.longitudDelPaso);
  }
}