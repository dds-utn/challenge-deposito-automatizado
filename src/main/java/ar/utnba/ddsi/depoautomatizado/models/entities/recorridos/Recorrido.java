package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos.Comando;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

import java.util.List;

public class Recorrido {
    private List<Comando> comandos;         // Representa a las posibles acciones del robot

    public Recorrido(List<Comando> comandos) {
        this.comandos = comandos;
    }

    public void ejecutarRecorrido(Robot robot) {
        try {
            comandos.forEach(c -> c.accionar(robot));
        }catch(DetenerRecorridoException e) {
            System.out.println(e.getMessage());
        }
    }
} 