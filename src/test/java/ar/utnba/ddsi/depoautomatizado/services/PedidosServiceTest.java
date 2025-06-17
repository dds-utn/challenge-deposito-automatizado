package ar.utnba.ddsi.depoautomatizado.services;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Compartimiento;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Recorrido;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Clark;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Drone;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.instrucciones.*;
import ar.utnba.ddsi.depoautomatizado.repositories.RepositorioDeRobots;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class PedidosServiceTest {

    @Mock
    private RepositorioDeRobots repositorioRobots;

    @InjectMocks
    private PedidosService pedidosService;

    private Pedido pedido;
    private List<Mercaderia> mercaderias;
    private List<Compartimiento> compartimientos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Configuración de compartimientos
        compartimientos = new ArrayList<>();
        compartimientos.add(new Compartimiento("C1", new Posicion(1, 1, 1)));
        compartimientos.add(new Compartimiento("C2", new Posicion(2, 2, 2)));

        // Configuración de recorridos

         /*
        IDA:
                      M
                 →   ↑ ↓  →   →   → F
                ↑
                I

        VUELTA:
                      M
                 ←    ←   ←   ←   ← F
                ↓
                I
        */
        Recorrido recorrido1 = new Recorrido();
        List<InstruccionRobot> instrucciones1 = List.of(
            new Avanzar(5),
            new Girar(90),
            new Avanzar(5),
            new Girar(-90),
            new Avanzar(5),
            new ManejarPaquete(AccionConPaquete.RECOGER),
            new Girar(180),
            new Avanzar(5),
            new Girar(-90),
            new Avanzar(5),
            new Avanzar(5),
            new Avanzar(5),
            new Avanzar(5),
            new ManejarPaquete(AccionConPaquete.DEJAR),
            new Girar(180),
            new Avanzar(5),
            new Avanzar(5),
            new Avanzar(5),
            new Avanzar(5),
            new Avanzar(5),
            new Girar(-90),
            new Avanzar(5),
            new Girar(180)
        );
        recorrido1.agregarInstrucciones(instrucciones1);


         /*
        IDA:
                              M
                 →   →   →   ↑ ↓   → F
                ↑
                I

        VUELTA:
                              M
                 ←    ←   ←   ←   ← F
                ↓
                I
        */
        Recorrido recorrido2 = new Recorrido();
        List<InstruccionRobot> instrucciones2 = List.of(
            new Avanzar(5),
            new Girar(90),
            new Avanzar(5),
            new Girar(-90),
            new Avanzar(5),
            new Avanzar(5),
            new Avanzar(5),
            new ManejarPaquete(AccionConPaquete.RECOGER),
            new Girar(180),
            new Avanzar(5),
            new Girar(-90),
            new Avanzar(5),
            new Avanzar(5),
            new ManejarPaquete(AccionConPaquete.DEJAR),
            new Girar(180),
            new Avanzar(5),
            new Avanzar(5),
            new Avanzar(5),
            new Avanzar(5),
            new Avanzar(5),
            new Girar(-90),
            new Avanzar(5),
            new Girar(180)
        );
        recorrido2.agregarInstrucciones(instrucciones2);

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
    void atenderPedidoConClark() {
        // Arrange
        Clark clark = new Clark(1L);
        when(repositorioRobots.buscarDisponible()).thenReturn(clark);

        // Act
        pedidosService.atenderPedido(pedido);

        // Assert
        verify(repositorioRobots).buscarDisponible();
        Assertions.assertTrue(clark.isDisponible());
        Assertions.assertTrue(pedido.estaCompletado());
    }

    @Test
    void atenderPedidoConDrone() {
        // Arrange
        Drone drone = new Drone(1L);
        when(repositorioRobots.buscarDisponible()).thenReturn(drone);

        // Act
        pedidosService.atenderPedido(pedido);

        // Assert
        verify(repositorioRobots).buscarDisponible();
        Assertions.assertTrue(drone.isDisponible());
        Assertions.assertTrue(pedido.estaCompletado());
    }
} 