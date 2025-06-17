package ar.utnba.ddsi.depoautomatizado.models.entities.observer;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;
import ar.utnba.ddsi.depoautomatizado.models.entities.observer.adapter.AdapterTransportista;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Transportista implements IObserver{
    private String nombre;
    private String telefono;
    private AdapterTransportista adapter;

    public Transportista(AdapterTransportista adapter) {
        this.adapter = adapter;
    }

    @Override
    public void notificarFinalizacion(Pedido pedido) {
        adapter.notificar(pedido);
    }
}
