package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Comando;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

import java.util.ArrayList;
import java.util.List;

public class VolverInicioStrategy implements EstrategiaObstaculo {
    @Override
    public void manejarObstaculo(Robot robot) {
        List<Comando> listaDeComandosInvertida = new ArrayList<>();
        for (int i = robot.getComandosHistorial().size() - 1; i >= 0; i--) {
            listaDeComandosInvertida.add(robot.getComandosHistorial().get(i));
        }
        for (Comando comando : listaDeComandosInvertida) {
                comando.ejecutar(robot);
        }
    }
} 