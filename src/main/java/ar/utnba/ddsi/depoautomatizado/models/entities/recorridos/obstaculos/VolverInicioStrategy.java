package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class VolverInicioStrategy implements EstrategiaObstaculo {
    
    @Override
    public void manejarObstaculo(Robot robot) {
        Posicion actual = robot.getPosicion();

        int dx = actual.getX();
        int dy = actual.getY();
        int dz = actual.getZ();

        if (dz > 0) {
            System.out.println("Descendiendo " + dz + " unidades.");
            for (int i = 0; i < dz; i++) {
                robot.avanzar(-1);
            }
        }
        if (dy > 0) {
            System.out.println("Moviéndose hacia el sur " + dy + " unidades.");
            robot.girar(180); // supondremos que estaba mirando al norte
            robot.avanzar(dy);
        }

        if (dx > 0) {
            System.out.println("Moviéndose hacia el oeste " + dx + " unidades.");
            robot.girar(90);  // girar hacia la izquierda
            robot.avanzar(dx);
        }
    }
} 