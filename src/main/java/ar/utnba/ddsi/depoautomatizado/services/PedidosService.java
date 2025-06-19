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
    }

    public void atenderPedido(Pedido pedido) {
        Robot robotLibre = this.repositorioRobots.buscarDisponible();
        robotLibre.setDisponible(false);
        System.out.println("Se ocupa al robot " + robotLibre.getId() + " con pedido " + pedido.getId());

        this.repositorioRobots.actualizar(robotLibre);

        robotLibre.setEstrategiaObstaculo(this.estrategiaObstaculo);
        pedido.recogerMercaderiaPor(robotLibre.getAdapter());

        robotLibre.setDisponible(true);
        this.repositorioRobots.actualizar(robotLibre);

        System.out.println("Se libera al robot " + robotLibre.getId() + "\n");

        this.avisarATransportistaFinalizacionDe(pedido);
    }

    private void avisarATransportistaFinalizacionDe(Pedido pedido) {
        //TODO: más adelante lo implementamos
    }

}
