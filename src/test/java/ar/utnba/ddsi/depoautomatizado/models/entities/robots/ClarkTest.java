package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos.ComandoRobot;
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
  private ComandoRobot comando1;
  private ComandoRobot comando2;

  @BeforeEach
  void setUp() {
    clark = new Clark(1L);
    estrategiaMock = Mockito.mock(EstrategiaObstaculo.class);
    clark.setEstrategiaObstaculo(estrategiaMock);

    comando1 = Mockito.mock(ComandoRobot.class);
    comando2 = Mockito.mock(ComandoRobot.class);
  }

  @Test
  void recorrer_sinObstaculo_ejecutaTodoYDevuelveTrue() {
    clark.setObstaculizado(false);

    boolean resultado = clark.recorrer(List.of(comando1, comando2));

    assertTrue(resultado);
    verify(comando1).ejecutar(clark);
    verify(comando2).ejecutar(clark);
    verifyNoInteractions(estrategiaMock);
  }

  @Test
  void recorrer_conObstaculoYDetener_devuelveFalseYAplicaEstrategia() {
    // Simulamos que se obstaculiza después del primer comando
    doAnswer(invocation -> {
      clark.setObstaculizado(true);
      return null;
    }).when(comando1).ejecutar(clark);

    // Estrategia decide detener
    doAnswer(invocation -> {
      clark.setDetener(true);
      return null;
    }).when(estrategiaMock).manejarObstaculo(clark);

    boolean resultado = clark.recorrer(List.of(comando1, comando2));

    assertFalse(resultado);
    verify(estrategiaMock).manejarObstaculo(clark);
    verify(comando1).ejecutar(clark);
    verify(comando2, never()).ejecutar(clark); // No llega al segundo
  }

  @Test
  void volverAlInicio_invocaInversasEnOrdenInverso() {
    clark.getHistorialInstrucciones().addAll(List.of(comando1, comando2));

    clark.volverAlInicio();

    verify(comando2).inversa(clark);
    verify(comando1).inversa(clark);
  }
}
