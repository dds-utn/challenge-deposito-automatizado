package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.instrucciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class VolverInicioStrategyTest {
  private List<InstruccionRobot> ida;

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

    List<InstruccionRobot> vuelta = List.of(
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
