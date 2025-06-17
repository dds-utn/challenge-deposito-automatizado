package ar.utnba.ddsi.depoautomatizado.services;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.VolverInicioStrategy;
import ar.utnba.ddsi.depoautomatizado.repositories.IRepositorioDeRobots;
import ar.utnba.ddsi.depoautomatizado.repositories.RepositorioDeRobots;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidosService {
    private IRepositorioDeRobots repositorioRobots;

    private IEstrategiaObstaculoFacade estrategiaFacade;

    @Setter
    private EstrategiaObstaculo estrategiaObstaculo;

    private ITransportistaBroker transportistaBroker;

    public PedidosService(IRepositorioDeRobots repositorioRobots, IEstrategiaObstaculoFacade estrategiaFacade, ITransportistaBroker transportistaBroker) {
        this.repositorioRobots = repositorioRobots;
        this.estrategiaFacade = estrategiaFacade;
        this.transportistaBroker = transportistaBroker;

        this.estrategiaObstaculo = estrategiaFacade.getEstrategia();
    }

    public void atenderPedido(Pedido pedido) {
        Robot robotLibre = this.repositorioRobots.buscarDisponible();
        robotLibre.setDisponible(false);

        this.repositorioRobots.actualizar(robotLibre);

        robotLibre.setEstrategiaObstaculo(this.estrategiaObstaculo);
        pedido.recogerMercaderiaPor(robotLibre);

        if (pedido.estaCompletado()) {
            robotLibre.setDisponible(true);
            this.repositorioRobots.actualizar(robotLibre);

            this.avisarATransportistaFinalizacionDe(pedido);
        } else {
            // TODO: para después
        }
    }

    private void avisarATransportistaFinalizacionDe(Pedido pedido) {
        transportistaBroker.anunciarPedidoDisponible(pedido);
    }


}
