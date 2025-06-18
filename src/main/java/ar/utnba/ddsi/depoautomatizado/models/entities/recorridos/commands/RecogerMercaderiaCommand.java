package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.commands;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class RecogerMercaderiaCommand implements Command {
    private final Robot robot;

    public RecogerMercaderiaCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void accionar() {
        robot.recogerMercaderia();
    }
}

