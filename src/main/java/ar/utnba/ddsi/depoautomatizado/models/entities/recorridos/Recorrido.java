package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.ComandosRobot.ComandoRobot;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

import java.util.ArrayList;
import java.util.List;

public class Recorrido {
    private final List<ComandoRobot> listaComandoRobot = new ArrayList<>();

    public void ejecutarRecorrido(Robot robot) {
        listaComandoRobot.forEach( comandoRobot -> {comandoRobot.ejecutar(robot);} );
    }

    public void agregarComando(ComandoRobot comandoRobot, int posicionLista) {
        listaComandoRobot.add(posicionLista, comandoRobot);
    }

    public void eliminarComando(int posicionLista) {
        listaComandoRobot.remove(posicionLista);
    }
} 