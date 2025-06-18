package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.commands;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class GirarCommand implements Command{
    Integer grados;
    Robot robot;

    public GirarCommand(Robot robot, Integer grados){
        this.grados = grados;
        this.robot = robot;
    }
    @Override
    public void accionar(){
        robot.girar(grados);
    }

}
