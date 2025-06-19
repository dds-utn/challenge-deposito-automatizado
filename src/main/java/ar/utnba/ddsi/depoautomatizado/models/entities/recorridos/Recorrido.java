package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos.AccionRecorrido;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import java.util.ArrayList;
import java.util.List;

public class Recorrido {
  private List<AccionRecorrido> acciones = new ArrayList<>();

  public void ejecutarRecorrido(Robot robot) {
    acciones.forEach(accionRecorrido -> {
      accionRecorrido.ejecutar(robot);
    });
  }
}