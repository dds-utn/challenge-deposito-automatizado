package ar.utnba.ddsi.depoautomatizado.models.entities.observer;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;

public interface IObserver {
  public void notificarFinalizaCon(Pedido pedido);
}
