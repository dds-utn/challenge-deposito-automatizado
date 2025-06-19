package ar.utnba.ddsi.depoautomatizado.models.entities.robots;


import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Robot {
  private Long id;
  private boolean disponible;
  private EstrategiaObstaculo estrategiaObstaculo;
  private Posicion posicion;

  Robot(Long id) {
    this.id = id;
    this.disponible = true;
  }

  public void mover(Posicion posicion) {
    this.posicion = posicion;
  }

  public void agarrar(Mercaderia mercaderia) {
    //TODO
  }

  public void soltar(Mercaderia mercaderia) {
    //TODO
  }

  public void esperar(long tiempoEspera) {
    try {
      Thread.sleep(tiempoEspera);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public void reintentarUltimoMovimiento() {
    mover(this.posicion);
  }

  public abstract void esquivarObstaculo();
}