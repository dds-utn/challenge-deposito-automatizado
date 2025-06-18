package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.commands;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class SoltarMercaderiaCommand implements Command {
    Robot robot;
public SoltarMercaderiaCommand(Robot robot){
    this.robot = robot;
}
    @Override
    public void accionar(){
        robot.soltarMercaderia();
    }
}
