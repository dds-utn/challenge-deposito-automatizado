package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class AccionDeAgarrarMercaderia implements AccionRecorrido {
  private Mercaderia mercaderia;

  public AccionDeAgarrarMercaderia(Mercaderia mercaderia) {
    this.mercaderia = mercaderia;
  }

  @Override
  public void ejecutar(Robot robot) {
    robot.agarrarMercaderia(mercaderia);
  }

  @Override
  public AccionRecorrido accionInversa() {
    return new AccionPasiva();
  }
}
