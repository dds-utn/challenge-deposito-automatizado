package ar.utnba.ddsi.depoautomatizado.models.entities.transporte;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;
import ar.utnba.ddsi.depoautomatizado.models.entities.mantenimiento.IAdapterSistemaMantenimiento;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Transporte implements IObserverTransporte{
  private final IAdapterSistemaTransporte adapter;

  public Transporte(IAdapterSistemaTransporte adapter) {
    this.adapter = adapter;
  }

  @Override
  public void notificarTransporte(Robot robot) {
    adapter.notificar(robot);
  }
}
