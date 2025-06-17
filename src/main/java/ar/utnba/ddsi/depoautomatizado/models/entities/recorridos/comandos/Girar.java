package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Girar implements Comando{
  private Integer grados;

  public Girar(Integer grados) {
    this.grados = grados;
  }

  @Override
  public void accionar(Robot robot){
    robot.girar(grados);
  }
}
