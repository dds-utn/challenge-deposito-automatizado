package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.commands.Command;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

import java.util.ArrayList;
import java.util.List;

public class Recorrido {

    //ACCIONADOR
    private ArrayList<Command> comandos;

    public Recorrido (ArrayList<Command> commands){
        this.comandos = commands;
    }

    public void agregarComando(Command comando){
        this.comandos.add(comando);
    }

    public void ejecutarRecorrido(Robot robot) {
        this.comandos.forEach(Command::accionar);
    }
}