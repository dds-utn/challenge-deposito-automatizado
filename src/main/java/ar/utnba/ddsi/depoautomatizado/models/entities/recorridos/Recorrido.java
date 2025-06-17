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

    public void ejecutarRecorrido(Robot robot) {
        for(ComandoRobot comando : instrucciones) {
            comando.ejecutar(robot);
            if (robot.isObstaculizado()){
                robot.manejarObstaculo();
            }
        }
    }

    public void agregarInstruccion(ComandoRobot comando) {
        this.instrucciones.add(comando);
    }

    public List<ComandoRobot> volverAInicio() {
        List<ComandoRobot> copiaInvertida= new ArrayList<>(this.instrucciones);
        Collections.reverse(copiaInvertida);
        return copiaInvertida;
    }

}