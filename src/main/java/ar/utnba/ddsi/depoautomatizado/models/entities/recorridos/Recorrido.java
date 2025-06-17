package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.movimientos.ComandoMovimiento;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recorrido {
    private final List<ComandoMovimiento> accionesPrerecogerMaterial;
    private final List<ComandoMovimiento> accionesPreentregaMaterial;

    public Recorrido() {
        this.accionesPrerecogerMaterial = new ArrayList<>();
        this.accionesPreentregaMaterial = new ArrayList<>();
    }

    public void agregarAccionPrerecoger(ComandoMovimiento accion) {
        this.accionesPrerecogerMaterial.add(accion);
    }

    public void agregarAccionPreentregar(ComandoMovimiento mov){
        this.accionesPreentregaMaterial.add(mov);
    }

    public void ejecutarRecorrido(Robot robot) {
        this.accionesPrerecogerMaterial.forEach( comando-> comando.accionar(robot));
        robot.recogerPaquete();
        this.accionesPreentregaMaterial.forEach( comando-> comando.accionar(robot));
        robot.dejarPaquete();

        List<ComandoMovimiento> accionesInversasPreentrega = new ArrayList<>(this.accionesPreentregaMaterial);
        List<ComandoMovimiento> accionesInversasPrerecoger = new ArrayList<>(this.accionesPrerecogerMaterial);

        //Damos vuelta las listas para realizar el recorrido inverso y volver al punto de partida (?
        Collections.reverse(accionesInversasPreentrega);
        Collections.reverse(accionesInversasPrerecoger);

        accionesInversasPreentrega.forEach( comando-> comando.accionarInvertido(robot));
        accionesInversasPrerecoger.forEach( comando-> comando.accionarInvertido(robot));
    }
}
