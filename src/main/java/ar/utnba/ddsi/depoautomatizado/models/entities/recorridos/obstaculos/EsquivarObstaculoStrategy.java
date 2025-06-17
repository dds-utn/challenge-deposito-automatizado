package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class EsquivarObstaculoStrategy implements EstrategiaObstaculo {
    private Long cantidadDeTiempo;
    @Override
    public void manejarObstaculo(Robot robot) throws InterruptedException {
        Thread.sleep(this.cantidadDeTiempo);
        //que el robot reintente?
    }
}