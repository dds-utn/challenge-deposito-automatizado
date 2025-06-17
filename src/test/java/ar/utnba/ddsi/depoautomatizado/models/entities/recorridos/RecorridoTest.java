package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Compartimiento;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RecorridoTest {

  private Pedido pedido;
  private List<Mercaderia> mercaderias;
  private List<Compartimiento> compartimientos;

  private Robot robot;
  private Recorrido recorrido;


  @BeforeEach
  void setUp() {

    robot = mock(Robot.class);
    MockitoAnnotations.openMocks(this);

    // Configuración de compartimientos
    compartimientos = new ArrayList<>();
    compartimientos.add(new Compartimiento("C1", new Posicion(1, 1, 1)));
    compartimientos.add(new Compartimiento("C2", new Posicion(2, 2, 2)));

    // Configuración de recorridos
    Recorrido recorrido1 = new Recorrido();
    Recorrido recorrido2 = new Recorrido();
    compartimientos.get(0).setRecorrido(recorrido1);
    compartimientos.get(1).setRecorrido(recorrido2);

    // Configuración de mercaderías
    mercaderias = new ArrayList<>();
    Mercaderia mercaderia1 = new Mercaderia("M1", "Producto 1");
    Mercaderia mercaderia2 = new Mercaderia("M2", "Producto 2");
    mercaderia1.setCompartimiento(compartimientos.get(0));
    mercaderia2.setCompartimiento(compartimientos.get(1));
    mercaderias.add(mercaderia1);
    mercaderias.add(mercaderia2);

    // Configuración del pedido
    pedido = new Pedido("PED-001");
    mercaderias.forEach(pedido::agregarMercaderia);
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
