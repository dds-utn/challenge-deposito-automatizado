package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.instrucciones.InstruccionRobot;

import java.util.ArrayList;
import java.util.List;

public class Recorrido {
    List<InstruccionRobot> instrucciones;

    public Recorrido() {
        instrucciones = new ArrayList<InstruccionRobot>();
    }

    public boolean ejecutarRecorrido(Robot robot) {
        return robot.recorrer(instrucciones);
    }

    public void agregarInstruccion(InstruccionRobot instruccion) {
        this.instrucciones.add(instruccion);
    }
    public void agregarInstrucciones(List<InstruccionRobot> instrucciones) {
        this.instrucciones.addAll(instrucciones);
    }

}