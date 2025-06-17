package ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Girar implements Command{
    int distancia;

    public Girar(int i) {
    }

    @Override
    public void ejecutar(Robot robot){
       robot.girar(distancia);
    }
}
