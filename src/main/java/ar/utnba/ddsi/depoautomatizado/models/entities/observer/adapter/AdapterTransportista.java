package ar.utnba.ddsi.depoautomatizado.models.entities.observer.adapter;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;

public interface AdapterTransportista{
  void notificar(Pedido pedido);
}
