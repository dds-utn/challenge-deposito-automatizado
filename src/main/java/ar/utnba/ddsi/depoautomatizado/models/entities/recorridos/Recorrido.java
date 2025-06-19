package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Adapter.RobotAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Recorrido {

    private List<ActuarRobot> acciones = new LinkedList<>();

    public void addAccion(ActuarRobot accion) {
        this.acciones.add(accion);
    }

    public void ejecutarRecorrido(RobotAdapter robot) {
        acciones.forEach( a -> a.actuar(robot));
        Collections.reverse(acciones);
        this.acciones.forEach(a -> a.deshacer(robot));
        Collections.reverse(acciones);
    }
}





