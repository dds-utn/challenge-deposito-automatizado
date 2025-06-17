package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Elevar implements Comando {
  private Integer metros;

  public Elevar(Integer metros) {
    this.metros = metros;
  }

  @Override
  public void accionar(Robot robot){
    robot.elevar(metros);
  }

}
