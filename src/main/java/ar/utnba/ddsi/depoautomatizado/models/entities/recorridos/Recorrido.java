package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Recorrido {
    
    public void ejecutarRecorrido(Robot robot) {
        //TODO: implementar
    }

    public void agregarComando(ComandoRobot comandoRobot, int posicionLista) {
        listaComandoRobot.add(posicionLista, comandoRobot);
    }

    public void eliminarComando(int posicionLista) {
        listaComandoRobot.remove(posicionLista);
    }
} 