package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos.ComandoRobot;

import java.util.List;

import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DroneTest {
  private Drone drone;

  private EstrategiaObstaculo estrategiaMock;
  private ComandoRobot comando1;
  private ComandoRobot comando2;

  @BeforeEach
  void setUp() {
    drone = new Drone(1L);
    estrategiaMock = Mockito.mock(EstrategiaObstaculo.class);
    drone.setEstrategiaObstaculo(estrategiaMock);

    comando1 = Mockito.mock(ComandoRobot.class);
    comando2 = Mockito.mock(ComandoRobot.class);
  }

  @Test
  void recorrer_sinObstaculo_ejecutaTodoYDevuelveTrue() {
    drone.setObstaculizado(false);

    boolean resultado = drone.recorrer(List.of(comando1, comando2));

    assertTrue(resultado);
    verify(comando1).ejecutar(drone);
    verify(comando2).ejecutar(drone);
    verifyNoInteractions(estrategiaMock);
  }

  @Test
  void recorrer_conObstaculoYDetener_devuelveFalseYAplicaEstrategia() {
    // Simulamos que se obstaculiza después del primer comando
    doAnswer(invocation -> {
      drone.setObstaculizado(true);
      return null;
    }).when(comando1).ejecutar(drone);

    // Estrategia decide detener
    doAnswer(invocation -> {
      drone.setDetener(true);
      return null;
    }).when(estrategiaMock).manejarObstaculo(drone);

    boolean resultado = drone.recorrer(List.of(comando1, comando2));

    assertFalse(resultado);
    verify(estrategiaMock).manejarObstaculo(drone);
    verify(comando1).ejecutar(drone);
    verify(comando2, never()).ejecutar(drone); // No llega al segundo
  }

  @Test
  void volverAlInicio_invocaInversasEnOrdenInverso() {
    drone.getHistorialInstrucciones().addAll(List.of(comando1, comando2));

    drone.volverAlInicio();

    verify(comando2).inversa(drone);
    verify(comando1).inversa(drone);
  }
}
