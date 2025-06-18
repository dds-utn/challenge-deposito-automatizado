package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.commands;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class AvanzarCommand implements Command{
    Robot robot;
    Integer distancia;
    public AvanzarCommand(Robot robot, Integer distancia){
        this.robot = robot;
        this.distancia = distancia;
    }

    @Override
    public void accionar(){

        robot.avanzar(this.distancia);

    }
}
