package ar.utnba.ddsi.depoautomatizado.services;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class TransportistaBroker implements ITransportistaBroker {

    @Override
    public void anunciarPedidoDisponible(Pedido pedido) {
        // TODO: enviar notificación
        log.info("pedido disponible para buscar: " + pedido);
    }
}
