package ar.utnba.ddsi.depoautomatizado.services;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Compartimiento;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Recorrido;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.movimientos.Avanzar;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.movimientos.Girar;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.AdapterClark;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.AdapterDrone;
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
        Recorrido recorrido2 = new Recorrido();
        compartimientos.get(0).setRecorrido(recorrido1);
        compartimientos.get(1).setRecorrido(recorrido2);
        recorrido2.agregarAccionPrerecoger(new Avanzar(10));
        recorrido2.agregarAccionPrerecoger(new Girar(-90));
        recorrido2.agregarAccionPrerecoger( new Avanzar(10));
        recorrido2.agregarAccionPreentregar( new Avanzar(10));

        recorrido1.agregarAccionPrerecoger(new Avanzar(10));
        recorrido1.agregarAccionPrerecoger(new Girar(-90));
        recorrido1.agregarAccionPrerecoger( new Avanzar(5));
        recorrido1.agregarAccionPreentregar( new Avanzar(15));


        
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
        AdapterClark adapterClark = new AdapterClark(1L);
        when(repositorioRobots.buscarDisponible()).thenReturn(adapterClark);

        // Act
        pedidosService.atenderPedido(pedido);

        // Assert
        verify(repositorioRobots).buscarDisponible();
        Assertions.assertTrue(adapterClark.isDisponible());
        Assertions.assertTrue(pedido.estaCompletado());
    }

    @Test
    void atenderPedidoConDrone() {
        // Arrange
        AdapterDrone adapterDrone = new AdapterDrone(1L);
        when(repositorioRobots.buscarDisponible()).thenReturn(adapterDrone);

        // Act
        pedidosService.atenderPedido(pedido);

        // Assert
        verify(repositorioRobots).buscarDisponible();
        Assertions.assertTrue(adapterDrone.isDisponible());
        Assertions.assertTrue(pedido.estaCompletado());
    }
} 