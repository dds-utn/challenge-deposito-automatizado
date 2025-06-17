package ar.utnba.ddsi.depoautomatizado.models.entities.command.impl;

import ar.utnba.ddsi.depoautomatizado.models.entities.command.Paso;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Girar implements Paso {

    private final int grados;

  //* Al instanciar la longitud del paso (o radio de giro) en el constructor, se maximiza la facilidad de configuración de los pasos (ya sean de avance o giro) en si.
    public Girar(int grados, Robot robot) {
        //Al instanciar cada paso "Girar" del recorrido, se define el angulo de giro, pudiendo haber pasos Girar con distintos angulos (Ej "Girar 90 grados", "Avanzar 2 metros", "Girar 180 grados", etc.)
        this.grados = grados;
    }

    @Override
    public void accionar(Robot robot) {
        robot.girar(this.grados);
    }
}
