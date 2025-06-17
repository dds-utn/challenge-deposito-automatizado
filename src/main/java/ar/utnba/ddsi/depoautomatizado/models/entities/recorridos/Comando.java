package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

import java.awt.event.ComponentAdapter;

public interface Comando {
    void ejecutar(Robot robot);
    boolean esRealizable(Robot robot);
}
