package ar.utnba.ddsi.depoautomatizado.services;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.VolverInicioStrategy;
import ar.utnba.ddsi.depoautomatizado.repositories.RepositorioDeRobots;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidosService {
    @Autowired
    private RepositorioDeRobots repositorioRobots;

    @Setter
    private EstrategiaObstaculo estrategiaObstaculo;



    PedidosService() {
        this.estrategiaObstaculo = new VolverInicioStrategy();
    } //?No entiendo la idea de hardcodear la estrategia así. En realidad haría falta tener un controller que permita pedir la atención de un pedido con un robot que tenga x estrategia.

    //TODO: Crear (y persistir pedidos)

    public void atenderPedido(Pedido pedido) { //* Se infiere que el pedido ya viene con el/los observadores asignados. La clase transportista existe para permitir crear los pedidos en sí.
        Robot robotLibre = this.repositorioRobots.buscarDisponible();
        robotLibre.setDisponible(false);

        this.repositorioRobots.actualizar(robotLibre);

        robotLibre.setEstrategiaObstaculo(this.estrategiaObstaculo);
        pedido.recogerMercaderiaPor(robotLibre);
        robotLibre.setDisponible(true);
        this.repositorioRobots.actualizar(robotLibre);

        this.avisarATransportistaFinalizacionDe(pedido);
    }

    private void avisarATransportistaFinalizacionDe(Pedido pedido) {
        if (pedido.estaCompletado()){
            pedido.getObservers().forEach(observer -> {
                observer.notificarFinalizacion(pedido);
            });
        }
    }

}
