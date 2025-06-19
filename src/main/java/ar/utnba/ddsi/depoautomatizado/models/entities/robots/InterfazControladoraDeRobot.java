package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;

public interface InterfazControladoraDeRobot {
  void avanzar(Integer pasos);

  void girar(Integer grados);

  void agarrar(Mercaderia mercaderia);

  void soltar(Mercaderia mercaderia);
}
