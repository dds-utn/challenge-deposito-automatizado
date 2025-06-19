package ar.utnba.ddsi.depoautomatizado.services;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Compartimiento;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.AvanzarRobot;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.DejarPaqueteRobot;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.GirarRobot;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.RecogerPaqueteRobot;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Recorrido;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Clark;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Drone;
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
        Recorrido recorrido1 = new Recorrido();
        recorrido1.addAccion(new AvanzarRobot(10));
        recorrido1.addAccion(new GirarRobot(-90));
        recorrido1.addAccion(new AvanzarRobot(10));
        recorrido1.addAccion(new RecogerPaqueteRobot(10));
        recorrido1.addAccion(new AvanzarRobot(10));
        recorrido1.addAccion(new DejarPaqueteRobot(10));

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