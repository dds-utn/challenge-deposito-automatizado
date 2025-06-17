package ar.utnba.ddsi.depoautomatizado.models.entities.robots;


import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Robot {
    private Long id;
    private boolean disponible;
    private EstrategiaObstaculo estrategiaObstaculo;

    Robot(Long id) {
        this.id = id;
        this.disponible = true;
    }

  public void recogerPaquete() {
      //TODO
  }

  public void dejarPaquete() {
      //TODO
  }

  public void girar(Integer grados) {
      //TODO
  }

  public void avanzar(Integer pasos) {
      //TODO
  }

  public void elevar(Integer elevacion) {
      //TODO
  }
}