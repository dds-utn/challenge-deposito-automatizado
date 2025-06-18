package ar.utnba.ddsi.depoautomatizado.models.entities.command.impl;

import ar.utnba.ddsi.depoautomatizado.models.entities.command.Paso;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class RecogerPaquete implements Paso {
    private int numeroPaquete;

    public RecogerPaquete(int numeroPaquete) {
        this.numeroPaquete = numeroPaquete;
    }

    public void accionar(Robot robot) {
      robot.recogerPaquete(this.numeroPaquete);
    }
}
