package ar.utnba.ddsi.depoautomatizado.models.entities.command.impl;

import ar.utnba.ddsi.depoautomatizado.models.entities.command.Paso;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class DejarPaquete implements Paso {
  private int numeroPaquete;

  public DejarPaquete(int numeroPaquete) {
    this.numeroPaquete = numeroPaquete;
  }

  public void accionar(Robot robot) {
    robot.dejarPaquete(this.numeroPaquete);
  }
}
