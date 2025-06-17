package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Compartimiento;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Recorrido;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos.*;
import ar.utnba.ddsi.depoautomatizado.repositories.RepositorioDeRobots;
import ar.utnba.ddsi.depoautomatizado.services.PedidosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class VolverInicioStrategyTEST {
  private List<ComandoRobot> ida;
  private List<ComandoRobot> vuelta;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    /*
    IDA:
                  M
             →   ↑ ↓  →   →   → F
            ↑
            I

    VUELTA:
                  M
             ←    ←   ←   ←   ← F
            ↓
            I
    */
    ida = List.of(
        new Avanzar(5),
        new Girar(90),
        new Avanzar(5),
        new Girar(-90),
        new Avanzar(5),
        new ManejarPaquete(AccionConPaquete.RECOGER),
        new Girar(180),
        new Avanzar(5),
        new Girar(-90),
        new Avanzar(5),
        new Avanzar(5),
        new Avanzar(5),
        new Avanzar(5),
        new ManejarPaquete(AccionConPaquete.DEJAR)
    );

    vuelta = List.of(
        new Girar(180),
        new Avanzar(5),
        new Avanzar(5),
        new Avanzar(5),
        new Avanzar(5),
        new Avanzar(5),
        new Girar(-90),
        new Avanzar(5),
        new Girar(180)
    );
}

  @Test
  void manejarObstaculo_debeVolverAlInicioYDetener() {
    Robot robot = Mockito.mock(Robot.class);
    VolverInicioStrategy strategy = new VolverInicioStrategy();

    robot.setHistorialInstrucciones(ida);

    strategy.manejarObstaculo(robot);

    Mockito.verify(robot).volverAlInicio();
    Mockito.verify(robot).setDetener(true);
  }

}
