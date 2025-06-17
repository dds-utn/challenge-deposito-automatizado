package ar.utnba.ddsi.depoautomatizado.models.entities;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PedidoTest {
  private Pedido pedido;
  private Robot robot;

  @BeforeEach
  void setUp() {
    pedido = new Pedido("pedido-1");
    robot = Mockito.mock(Robot.class);
  }

  @Test
  void agregarMercaderia_laAgregaCorrectamente() {
    Mercaderia mercaderia = Mockito.mock(Mercaderia.class);

    pedido.agregarMercaderia(mercaderia);

    assertEquals(1, pedido.getMercaderias().size());
    assertTrue(pedido.getMercaderias().contains(mercaderia));
  }

  @Test
  void marcarComoCompletado_seteaFlag() {
    assertFalse(pedido.estaCompletado());

    pedido.marcarComoCompletado();

    assertTrue(pedido.estaCompletado());
  }

  @Test
  void recogerMercaderiaPor_recogeMercaderiasNoRecogidasYMarcaCompletado() {
    Mercaderia m1 = Mockito.mock(Mercaderia.class);
    Mercaderia m2 = Mockito.mock(Mercaderia.class);

    when(m1.isFueRecogido()).thenReturn(false).thenReturn(true); // Antes y después de ser recogida
    when(m2.isFueRecogido()).thenReturn(false).thenReturn(true);

    pedido.agregarMercaderia(m1);
    pedido.agregarMercaderia(m2);

    pedido.recogerMercaderiaPor(robot);

    verify(m1).serRecogidaPor(robot);
    verify(m2).serRecogidaPor(robot);
    assertTrue(pedido.estaCompletado());
  }

  @Test
  void recogerMercaderiaPor_noMarcaCompletadoSiFaltaRecoger() {
    Mercaderia m1 = Mockito.mock(Mercaderia.class);
    Mercaderia m2 = Mockito.mock(Mercaderia.class);

    when(m1.isFueRecogido()).thenReturn(true);
    when(m2.isFueRecogido()).thenReturn(false);

    pedido.agregarMercaderia(m1);
    pedido.agregarMercaderia(m2);

    pedido.recogerMercaderiaPor(robot);

    verify(m2).serRecogidaPor(robot);
    verify(m1, never()).serRecogidaPor(robot);
    assertFalse(pedido.estaCompletado());
  }
}
