package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public interface AccionRecorrido {
  void ejecutar(Robot robot);

  AccionRecorrido accionInversa();
}

