package ar.utnba.ddsi.depoautomatizado.models.entities.mantenimiento;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Mantenimiento implements Iobserver{
  private final IAdapterSistemaMantenimiento adapter;

  public Mantenimiento(IAdapterSistemaMantenimiento adapter) {
    this.adapter = adapter;
  }

  @Override
  public void notificarMantenimiento(Robot robot) {
    adapter.notificar(robot);
  }
}