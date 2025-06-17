package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.instrucciones.InstruccionRobot;
import org.mockito.Mockito;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public class ClarkTest {
  private Clark clark;

  private EstrategiaObstaculo estrategiaMock;
  private InstruccionRobot instruccion1;
  private InstruccionRobot instruccion2;

  @BeforeEach
  void setUp() {
    clark = new Clark(1L);
    estrategiaMock = Mockito.mock(EstrategiaObstaculo.class);
    clark.setEstrategiaObstaculo(estrategiaMock);

    instruccion1 = Mockito.mock(InstruccionRobot.class);
    instruccion2 = Mockito.mock(InstruccionRobot.class);
  }

  @Test
  void recorrer_sinObstaculo_ejecutaTodoYDevuelveTrue() {
    clark.setObstaculizado(false);

    boolean resultado = clark.recorrer(List.of(instruccion1, instruccion2));

    assertTrue(resultado);
    verify(instruccion1).ejecutar(clark);
    verify(instruccion2).ejecutar(clark);
    verifyNoInteractions(estrategiaMock);
  }

  @Test
  void recorrer_conObstaculoYDetener_devuelveFalseYAplicaEstrategia() {
    // Simulamos que se obstaculiza después del primer instruccion
    doAnswer(invocation -> {
      clark.setObstaculizado(true);
      return null;
    }).when(instruccion1).ejecutar(clark);

    // Estrategia decide detener
    doAnswer(invocation -> {
      clark.setDetener(true);
      return null;
    }).when(estrategiaMock).manejarObstaculo(clark);

    boolean resultado = clark.recorrer(List.of(instruccion1, instruccion2));

    assertFalse(resultado);
    verify(estrategiaMock).manejarObstaculo(clark);
    verify(instruccion1).ejecutar(clark);
    verify(instruccion2, never()).ejecutar(clark); // No llega al segundo
  }

  @Test
  void volverAlInicio_invocaInversasEnOrdenInverso() {
    clark.getHistorialInstrucciones().addAll(List.of(instruccion1, instruccion2));

    clark.volverAlInicio();

    verify(instruccion2).inversa(clark);
    verify(instruccion1).inversa(clark);
  }
}
