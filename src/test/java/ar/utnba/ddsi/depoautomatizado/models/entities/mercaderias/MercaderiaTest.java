package ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Recorrido;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.instrucciones.InstruccionRobot;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class MercaderiaTest {

  private Robot robot;
  private InstruccionRobot instruccion;
  private Recorrido recorrido;
  private Compartimiento compartimiento;
  private Mercaderia mercaderia;

  @BeforeEach
  void setUp() {
    // Mocks
    robot = mock(Robot.class);
    instruccion = mock(InstruccionRobot.class);

    recorrido = new Recorrido();
    recorrido.agregarInstruccion(instruccion);

    compartimiento = new Compartimiento("C1", new Posicion(1, 2, 3));
    compartimiento.setRecorrido(recorrido);

    mercaderia = new Mercaderia("M1", "Caja de prueba");
    mercaderia.setCompartimiento(compartimiento);
  }

  @Test
  void serRecogidaPorEjecutaRecorridoSobreRobot() {
    // Simular que no hay obstáculo
    when(robot.isObstaculizado()).thenReturn(false);

    // Acción
    mercaderia.serRecogidaPor(robot);

    Mockito.verify(robot, Mockito.times(1)).recorrer(List.of(instruccion));
  }
}
