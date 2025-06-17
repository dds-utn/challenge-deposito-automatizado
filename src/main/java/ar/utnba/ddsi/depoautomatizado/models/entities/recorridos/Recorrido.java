package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos.Avanzar;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos.Command;

import java.util.ArrayList;
import java.util.List;

public class Recorrido {


    private final List<Command> instrucciones = new ArrayList<>();
    private Posicion puntoInicio;
    private Posicion puntoFin;

    public Recorrido(Posicion puntoInicio, Posicion puntoFin) {
        
    }

    public void ejecutarRecorrido(Robot robot) {
            //TODO: implementar
            // El recorrido consiste salir de un punto de inicio designado, llegar hasta el compartimiento, recoger la mercadería, ir
            //al punto de consolidación, dejar la mercadería y volver al punto de inicio.


            //Posicion posicion = new Posicion(0,0,0);
            for (Command instruccion : instrucciones) {
                try {
                    instruccion.ejecutar(robot);
                } catch (ObstaculoDetectadoException e) {
                    robot.getEstrategiaObstaculo().manejarObstaculo(robot);
                }
            }

        }

    public void setInstrucciones(List<Object> objects) {
    }
}