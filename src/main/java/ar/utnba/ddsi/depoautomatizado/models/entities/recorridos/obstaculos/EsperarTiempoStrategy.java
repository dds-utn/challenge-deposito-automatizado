package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

import java.sql.Time;

public class EsperarTiempoStrategy implements EstrategiaObstaculo{
    private  int unidadesTiempo; //En ms

    public void EsperarStrategy(int unidadesTiempo) {

        this.unidadesTiempo = unidadesTiempo;
    }

    @Override
    public void manejarObstaculo(Robot robot) {
        try {
            Thread.sleep(this.unidadesTiempo * 1000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}