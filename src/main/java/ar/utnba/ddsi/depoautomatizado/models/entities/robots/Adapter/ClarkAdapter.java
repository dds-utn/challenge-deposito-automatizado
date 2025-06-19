package ar.utnba.ddsi.depoautomatizado.models.entities.robots.Adapter;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Clark;
import java.sql.SQLOutput;

public class ClarkAdapter implements RobotAdapter {
  private Clark clark;

  public ClarkAdapter(Clark clark) {
    this.clark = clark;
  }

  public void avanzar(int metros) {
    this.clark.avanzar(metros);
  }
  public void girar(int angulo) {
    this.clark.girar(angulo);
  }
  public void dejarPaquete(int altura) {
    this.clark.dejarPaquete(altura);
  }
  public void recogerPaquete(int altura) {
    this.clark.recogerPaquete(altura);
  }

  public void esquivarObstaculo() {
    this.clark.esquivarObstaculo();
  }


}

