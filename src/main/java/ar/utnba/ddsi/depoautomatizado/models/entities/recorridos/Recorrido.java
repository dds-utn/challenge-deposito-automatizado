package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.acciones.Accion;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

import java.util.ArrayList;
import java.util.List;

public class Recorrido {
    /*
    * El recorrido consiste salir de un punto de inicio designado, llegar hasta el compartimiento, recoger la mercadería, ir al punto de consolidación, dejar la mercadería y volver al punto de inicio.
    */
    private List<Accion> acciones = new ArrayList<>();

    public void agregarAccion(Accion accion) {
        acciones.add(accion);
    }

    public void ejecutarRecorrido(Robot robot) {
        for (Accion accion : acciones) {
            accion.ejecutar(robot);
        }
    }
} 