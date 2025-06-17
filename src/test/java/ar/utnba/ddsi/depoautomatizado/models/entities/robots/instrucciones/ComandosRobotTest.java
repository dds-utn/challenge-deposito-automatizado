package ar.utnba.ddsi.depoautomatizado.models.entities.robots.instrucciones;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class ComandosRobotTest {

  private Robot robot;

  @BeforeEach
  void setUp() {
    robot = mock(Robot.class);
  }

  @Test
  void avanzarEjecutaAvanzarEnRobot() {
    Avanzar instruccion = new Avanzar(5);
    instruccion.ejecutar(robot);
    verify(robot).avanzar(5);

    instruccion.inversa(robot);
    verify(robot).avanzar(-5);
  }

  @Test
  void elevarEjecutaElevarEnRobot() {
    Elevar instruccion = new Elevar(3);
    instruccion.ejecutar(robot);
    verify(robot).elevar(3);

    instruccion.inversa(robot);
    verify(robot).elevar(-3);
  }

  @Test
  void girarEjecutaGirarEnRobot() {
    Girar instruccion = new Girar(90);
    instruccion.ejecutar(robot);
    verify(robot).girar(90);

    instruccion.inversa(robot);
    verify(robot).girar(270); // 180 + 90
  }

  @Test
  void manejarPaqueteEjecutarYInversa_Dejar() {
    ManejarPaquete instruccion = new ManejarPaquete(AccionConPaquete.DEJAR);
    instruccion.ejecutar(robot);
    verify(robot).dejarPaquete();

    instruccion.inversa(robot);
    verify(robot).recogerPaquete();
  }

  @Test
  void manejarPaqueteEjecutarYInversa_Recoger() {
    ManejarPaquete instruccion = new ManejarPaquete(AccionConPaquete.RECOGER);
    instruccion.ejecutar(robot);
    verify(robot).recogerPaquete();

    instruccion.inversa(robot);
    verify(robot).dejarPaquete();
  }
}
