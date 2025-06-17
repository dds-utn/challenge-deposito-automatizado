package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.command.Paso;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

import java.util.List;

public class Recorrido {


    //* Tener una lista de pasos en el recorrido permite crear recorridos de manera dinámica, lo cual aporta extensibilidad, y cumple con el principio Open Closed. Además, esto facilita la configuración de los recorridos para distintos robots.
    List<Paso> pasos;

    public void ejecutarRecorrido(Robot robot) {
        //Ejecuta cada uno de los pasos del recorrido, con el robot correspondiente
            pasos.forEach(paso -> paso.accionar(robot));
    }
} 