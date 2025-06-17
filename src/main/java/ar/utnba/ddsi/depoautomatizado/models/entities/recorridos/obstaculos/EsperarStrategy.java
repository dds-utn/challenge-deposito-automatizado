package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

import java.util.concurrent.TimeUnit;

public class EsperarStrategy implements EstrategiaObstaculo{
    private int tiempoAEsperar;

    @Override
    public void manejarObstaculo(Robot robot) {
        try {
            TimeUnit.SECONDS.sleep(tiempoAEsperar);
            //desplazarse
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
