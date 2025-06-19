package ar.utnba.ddsi.depoautomatizado.models.entities.robots.Adapter;

public interface RobotAdapter {
  public void avanzar(int metros);
  public void girar(int angulo);
  public void dejarPaquete(int distancia);
  public void recogerPaquete(int metros);
  public void esquivarObstaculo();
}
