package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.instrucciones;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public interface Instruccion {
    void ejecutar(Robot robot);
}