package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

import java.util.ArrayList;
import java.util.List;

public class Recorrido {

    List<IMovimiento> movimientos = new ArrayList<>();

    public void addMovimineto(IMovimiento mov) {
        movimientos.add(mov);
    }
    
    public void ejecutarRecorrido(Robot robot) {
        movimientos.forEach(movimiento -> movimiento.moverRobot(robot));
    }
} 