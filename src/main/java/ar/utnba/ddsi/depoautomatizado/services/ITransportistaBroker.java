package ar.utnba.ddsi.depoautomatizado.services;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;
import org.springframework.stereotype.Service;

public interface ITransportistaBroker {
    void anunciarPedidoDisponible(Pedido pedido);
}
