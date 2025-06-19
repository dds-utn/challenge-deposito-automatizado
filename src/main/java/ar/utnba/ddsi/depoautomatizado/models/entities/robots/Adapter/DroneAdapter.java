package ar.utnba.ddsi.depoautomatizado.models.entities.robots.Adapter;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Drone;

public class DroneAdapter implements RobotAdapter {
  private Drone drone;

  public DroneAdapter(Drone drone) {
    this.drone = drone;
  }

  public void avanzar(int metros) {
    this.drone.irParaAdelante(metros);
  }

  public void girar(int angulo) {
    if(angulo > 0) {
      for (int i = 0; i < (angulo*-1)%90; i++) { this.drone.voltearIzquierda(); }
    }
    else {
      for (int i = 0; i < angulo%90; i++) { this.drone.voltearDerecha(); }
    }
  }
  public void dejarPaquete(int altura) {
    this.drone.soltarPaquete(altura);
  }
  public void recogerPaquete(int altura) {
    this.drone.volarYRecogerPaquete(altura);
  }

  public void esquivarObstaculo() {
    this.drone.esquivarObstaculo();
  }
}
