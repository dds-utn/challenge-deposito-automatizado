package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

import java.util.List;

public class Recorrido {

    private List<Comando> comandos;

    public Recorrido(List<Comando> comandos) {
        this.comandos = comandos;
    }

    public void ejecutarRecorrido(Robot robot) {
        for (Comando comando : comandos) {
            robot.agregarComandoHistorial(comando);
            if(!robot.detectarObstaculo(comando))
                comando.ejecutar(robot);
        }
    }
} 