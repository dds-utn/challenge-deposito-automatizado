package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.instrucciones.InstruccionRobot;

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
  private InstruccionRobot instruccion1;
  private InstruccionRobot instruccion2;

  @BeforeEach
  void setUp() {
    drone = new Drone(1L);
    estrategiaMock = Mockito.mock(EstrategiaObstaculo.class);
    drone.setEstrategiaObstaculo(estrategiaMock);

    instruccion1 = Mockito.mock(InstruccionRobot.class);
    instruccion2 = Mockito.mock(InstruccionRobot.class);
  }

  @Test
  void recorrer_sinObstaculo_ejecutaTodoYDevuelveTrue() {
    drone.setObstaculizado(false);

    boolean resultado = drone.recorrer(List.of(instruccion1, instruccion2));

    assertTrue(resultado);
    verify(instruccion1).ejecutar(drone);
    verify(instruccion2).ejecutar(drone);
    verifyNoInteractions(estrategiaMock);
  }

  @Test
  void recorrer_conObstaculoYDetener_devuelveFalseYAplicaEstrategia() {
    // Simulamos que se obstaculiza después del primer instruccion
    doAnswer(invocation -> {
      drone.setObstaculizado(true);
      return null;
    }).when(instruccion1).ejecutar(drone);

    // Estrategia decide detener
    doAnswer(invocation -> {
      drone.setDetener(true);
      return null;
    }).when(estrategiaMock).manejarObstaculo(drone);

    boolean resultado = drone.recorrer(List.of(instruccion1, instruccion2));

    assertFalse(resultado);
    verify(estrategiaMock).manejarObstaculo(drone);
    verify(instruccion1).ejecutar(drone);
    verify(instruccion2, never()).ejecutar(drone); // No llega al segundo
  }

  @Test
  void volverAlInicio_invocaInversasEnOrdenInverso() {
    drone.getHistorialInstrucciones().addAll(List.of(instruccion1, instruccion2));

    drone.volverAlInicio();

    verify(instruccion2).inversa(drone);
    verify(instruccion1).inversa(drone);
  }
}
