package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import static java.util.Collections.reverse;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos.AccionRecorrido;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import java.util.List;

public class Recorrido {
  private List<AccionRecorrido> acciones;

  public Recorrido(List<AccionRecorrido> acciones) {
    this.acciones = acciones;
  }

  public void ejecutarRecorrido(Robot robot) {
    acciones.forEach(accionRecorrido -> {
      accionRecorrido.ejecutar(robot);
      robot.accionEjecutada(accionRecorrido);
    });
    reverse(acciones);
    acciones.forEach(accionRecorrido -> {
      AccionRecorrido accionRecorridoInversa = accionRecorrido.accionInversa();
      accionRecorridoInversa.ejecutar(robot);
      robot.accionEjecutada(accionRecorridoInversa);
    });
    reverse(acciones);
  }
}