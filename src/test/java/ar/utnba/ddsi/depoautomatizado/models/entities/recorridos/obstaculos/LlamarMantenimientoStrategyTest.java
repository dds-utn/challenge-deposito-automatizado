package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.mantenimiento.Iobserver;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LlamarMantenimientoStrategyTest {
  @Test
  void manejarObstaculo_debeNotificarYDetener() {
    Robot robot = Mockito.mock(Robot.class);
    Iobserver observer = Mockito.mock(Iobserver.class);
    LlamarMantenimientoStrategy strategy = new LlamarMantenimientoStrategy();

    // Inyectamos el observer usando reflexión (porque no hay constructor ni setter)
    java.lang.reflect.Field field = null;
    try {
      field = LlamarMantenimientoStrategy.class.getDeclaredField("observer");
      field.setAccessible(true);
      field.set(strategy, observer);
    } catch (Exception e) {
      throw new RuntimeException("No se pudo setear el observer", e);
    }

    strategy.manejarObstaculo(robot);

    Mockito.verify(observer).notificarMantenimiento(robot);
    Mockito.verify(robot).setDetener(true);
  }
}
