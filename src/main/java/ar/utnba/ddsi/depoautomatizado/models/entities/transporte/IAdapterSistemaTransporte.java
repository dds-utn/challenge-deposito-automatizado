package ar.utnba.ddsi.depoautomatizado.models.entities.transporte;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public interface IAdapterSistemaTransporte {
  void notificar(Robot robot);
}
