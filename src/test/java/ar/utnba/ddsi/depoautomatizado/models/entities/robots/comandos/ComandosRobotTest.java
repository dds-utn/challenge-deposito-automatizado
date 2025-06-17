package ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos;

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
    Avanzar comando = new Avanzar(5);
    comando.ejecutar(robot);
    verify(robot).avanzar(5);

    comando.inversa(robot);
    verify(robot).avanzar(-5);
  }

  @Test
  void elevarEjecutaElevarEnRobot() {
    Elevar comando = new Elevar(3);
    comando.ejecutar(robot);
    verify(robot).elevar(3);

    comando.inversa(robot);
    verify(robot).elevar(-3);
  }

  @Test
  void girarEjecutaGirarEnRobot() {
    Girar comando = new Girar(90);
    comando.ejecutar(robot);
    verify(robot).girar(90);

    comando.inversa(robot);
    verify(robot).girar(270); // 180 + 90
  }

  @Test
  void manejarPaqueteEjecutarYInversa_Dejar() {
    ManejarPaquete comando = new ManejarPaquete(AccionConPaquete.DEJAR);
    comando.ejecutar(robot);
    verify(robot).dejarPaquete();

    comando.inversa(robot);
    verify(robot).recogerPaquete();
  }

  @Test
  void manejarPaqueteEjecutarYInversa_Recoger() {
    ManejarPaquete comando = new ManejarPaquete(AccionConPaquete.RECOGER);
    comando.ejecutar(robot);
    verify(robot).recogerPaquete();

    comando.inversa(robot);
    verify(robot).dejarPaquete();
  }
}
