package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Compartimiento;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public abstract class Recorrido {
  private Posicion puntoInicio;
  private Posicion puntoConsiliacion;
  private Mercaderia mercaderiaARecoger;

  public void ejecutarRecorrido(Robot robot) {
    salirDelPuntoDeInicio(robot, puntoInicio);
    llegarHastaElCompartimiento(mercaderiaARecoger.getCompartimiento());
    recogerLaMercaderia(robot, mercaderiaARecoger);
    irAlPuntoDeConsolidacion(robot, puntoConsiliacion);
    dejarMercaderia(robot);
    volverAlPuntoDeInicio(robot, puntoInicio);
  }

  abstract void salirDelPuntoDeInicio(Robot robot, Posicion posicion);

  abstract void llegarHastaElCompartimiento(Compartimiento compartimiento);

  abstract void recogerLaMercaderia(Robot robot, Mercaderia mercaderia);

  abstract void irAlPuntoDeConsolidacion(Robot robot, Posicion puntoConsiliacion);

  abstract void dejarMercaderia(Robot robot);

  abstract void volverAlPuntoDeInicio(Robot robot, Posicion posicion);
}