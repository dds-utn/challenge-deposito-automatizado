package ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Recorrido;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos.ComandoRobot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class MercaderiaTest {

  private Robot robot;
  private ComandoRobot comando;
  private Recorrido recorrido;
  private Compartimiento compartimiento;
  private Mercaderia mercaderia;

  @BeforeEach
  void setUp() {
    // Mocks
    robot = mock(Robot.class);
    comando = mock(ComandoRobot.class);

    recorrido = new Recorrido();
    recorrido.agregarInstruccion(comando);

    compartimiento = new Compartimiento("C1", new Posicion(1, 2, 3));
    compartimiento.setRecorrido(recorrido);

    mercaderia = new Mercaderia("M1", "Caja de prueba");
    mercaderia.setCompartimiento(compartimiento);
  }

  @Test
  void serRecogidaPorEjecutaRecorridoYComandoSobreRobot() {
    // Simular que no hay obstáculo
    when(robot.isObstaculizado()).thenReturn(false);

    // Acción
    mercaderia.serRecogidaPor(robot);

    // Verificar que el comando fue ejecutado una vez
    verify(comando, times(1)).ejecutar(robot);

    // Verificar que no se llamó a manejar obstáculo
    verify(robot, never()).manejarObstaculo();
  }

  @Test
  void serRecogidaPorConObstaculoInvocaManejarObstaculo() {
    // Simular que hay obstáculo
    when(robot.isObstaculizado()).thenReturn(true);

    // Acción
    mercaderia.serRecogidaPor(robot);

    // Verificar ejecución normal y manejo de obstáculo
    verify(comando).ejecutar(robot);
    verify(robot).manejarObstaculo();
  }
}
