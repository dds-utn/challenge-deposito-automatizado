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

        this.repositorioRobots.actualizar(robotLibre);

        robotLibre.setEstrategiaObstaculo(this.estrategiaObstaculo);
        pedido.recogerMercaderiaPor(robotLibre);

        robotLibre.setDisponible(true);
        robotLibre.limpiarHistorialComandos();
        this.repositorioRobots.actualizar(robotLibre);

        this.avisarATransportistaFinalizacionDe(pedido);
    }

    private void avisarATransportistaFinalizacionDe(Pedido pedido) {
        //TODO: más adelante lo implementamos
    }


}
