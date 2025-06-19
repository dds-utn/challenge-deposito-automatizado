package ar.utnba.ddsi.depoautomatizado.models.entities.robots;


import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Robot {
  private Long id;
  private boolean disponible;
  private EstrategiaObstaculo estrategiaObstaculo;
  private InterfazControladoraDeRobot interfazControladoraDeRobot;

  Robot(Long id, InterfazControladoraDeRobot interfazControladoraDeRobot) {
    this.id = id;
    this.disponible = true;
  }

  //NOTA: Asumimos que solo al avanzar puede detectar un obstaculo, girar lo hace sosbre su posicion
  public void avanzar(Integer pasos) {
    try {
      interfazControladoraDeRobot.avanzar(pasos);
    } catch (ExcepcionDeObstaculo e) {
      estrategiaObstaculo.manejarObstaculo(this);
    }
  }

  public void girar(Integer grados) {
    interfazControladoraDeRobot.girar(grados);
  }

  public void agarrar(Mercaderia mercaderia) {
    interfazControladoraDeRobot.agarrar(mercaderia);
  }

  public void soltar(Mercaderia mercaderia) {
    interfazControladoraDeRobot.soltar(mercaderia);
  }

  public void esperar(long tiempoEspera) {
    interfazControladoraDeRobot.esperar(tiempoEspera);
  }

  public void reintentarUltimoMovimiento() {
    mover(this.posicion);
  }

  public abstract void esquivarObstaculo();
}