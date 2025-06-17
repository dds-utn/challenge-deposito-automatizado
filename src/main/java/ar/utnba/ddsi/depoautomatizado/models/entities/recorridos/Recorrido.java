package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos.ComandoRobot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recorrido {
    List<ComandoRobot> instrucciones;

    public Recorrido() {
        instrucciones = new ArrayList<ComandoRobot>();
    }

    public boolean ejecutarRecorrido(Robot robot) {
        return robot.recorrer(instrucciones);
    }

    public void agregarInstruccion(ComandoRobot instruccion) {
        this.instrucciones.add(instruccion);
    }
    public void agregarInstrucciones(List<ComandoRobot> instrucciones) {
        this.instrucciones.addAll(instrucciones);
    }

}