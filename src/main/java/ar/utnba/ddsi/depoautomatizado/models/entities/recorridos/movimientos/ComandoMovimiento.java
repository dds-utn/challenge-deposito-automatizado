package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.movimientos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import lombok.Getter;
import lombok.Setter;

public abstract class ComandoMovimiento {
  @Getter @Setter
  private Integer dato;

  public ComandoMovimiento(Integer dato) {
    this.dato = dato;
  }

  protected abstract void operar(Robot robot, Integer dato);

  public void accionar(Robot robot) {
    this.operar(robot, dato);
  }

  public void accionarInvertido(Robot robot) {
    this.operar(robot, -dato);
  }
}
