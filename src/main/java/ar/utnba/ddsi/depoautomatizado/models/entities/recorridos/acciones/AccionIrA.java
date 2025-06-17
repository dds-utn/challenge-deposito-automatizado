package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.acciones;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class AccionIrA implements Accion {
    private Posicion destino;

    public AccionIrA(Posicion destino) {
        this.destino = destino;
    }

    @Override
    public void ejecutar(Robot robot) {
        if (hayObstaculoEn(destino)) {
            robot.getEstrategiaObstaculo().manejarObstaculo(robot);
        } else {
            robot.irA(destino);
        }
    }

    private boolean hayObstaculoEn(Posicion destino) {
        // lógica. No sabemos si iría acá pero es un ejemplo para que no tire error
        return false;
    }
}
