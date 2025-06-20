package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.instrucciones;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Avanzar implements Instruccion{
    private int distancia;

    Avanzar(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public void ejecutar(Robot robot) {
        robot.avanzar(distancia);
    }
}
