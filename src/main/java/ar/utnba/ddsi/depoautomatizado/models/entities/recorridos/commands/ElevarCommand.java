package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.commands;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class ElevarCommand implements Command{
    private Integer altura;
    private Robot robot;
    public void ElevarCommand(Robot robot, Integer altura){
        this.altura = altura;
        this.robot = robot;
    }


    @Override
    public void accionar(){
        this.robot.elevar(this.altura);
    }
}
