package ar.utnba.ddsi.depoautomatizado.repositories;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public interface IRepositorioDeRobots {
    Robot buscarDisponible();
    void actualizar(Robot robot);
}
