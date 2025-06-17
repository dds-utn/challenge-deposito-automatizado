package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Compartimiento;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.instrucciones.*;
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
