package ar.utnba.ddsi.depoautomatizado.models.entities.mantenimiento;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public interface IAdapterSistemaMantenimiento {
  void notificar(Robot robot);
}
