package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class EsperarNTiempoStrategy implements EstrategiaObstaculo{
    private Integer minutos;

    public EsperarNTiempoStrategy(Integer minutos) {
        this.minutos = minutos;
    }

    @Override
    public void manejarObstaculo(Robot robot) {
        try {
            Thread.sleep(minutos * 60L * 1000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
