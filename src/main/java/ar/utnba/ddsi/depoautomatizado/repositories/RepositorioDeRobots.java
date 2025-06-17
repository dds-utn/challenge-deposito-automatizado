package ar.utnba.ddsi.depoautomatizado.repositories;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.AdapterClark;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.AdapterDrone;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioDeRobots {
    private List<Robot> robots;

    public RepositorioDeRobots() {
        this.robots = new ArrayList<>();
        this.robots.addAll(List.of(new AdapterClark(1L), new AdapterClark(2L), new AdapterDrone(3L)));
    }

    public Robot buscarDisponible() {
        return this.robots.stream().filter(Robot::isDisponible).findFirst().orElse(null);
    }

    public void actualizar(Robot robot) {
        //TODO: no es necesario en esta imple porque estamos en memoria
    }
}
