package ar.utnba.ddsi.depoautomatizado.services;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.VolverInicioStrategy;
import org.springframework.stereotype.Service;

@Service
public class EstrategiaObstaculoFacade implements IEstrategiaObstaculoFacade {
    @Override
    public EstrategiaObstaculo getEstrategia() {
        return new VolverInicioStrategy();
    }
}
