package ar.utnba.ddsi.depoautomatizado.repositories;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Clark;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Drone;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioDeRobots {
    private final List<Robot> robots;

    public RepositorioDeRobots() {
        this.robots = new ArrayList<>();
        this.robots.addAll(List.of(new Clark(1L), new Clark(2L), new Drone(3L)));
    }

    public Robot buscarDisponible() {
        return this.robots.stream().filter(Robot::isDisponible).findFirst().orElse(null);
    }

    public void actualizar(Robot robot) {
        //TODO: no es necesario en esta imple porque estamos en memoria
    }
}
