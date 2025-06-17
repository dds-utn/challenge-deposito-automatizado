package ar.utnba.ddsi.depoautomatizado.services;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Compartimiento;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Recorrido;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos.Avanzar;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos.Comando;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos.DejarPaquete;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos.Girar;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.comandos.RecogerPaquete;
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
        List<Comando> comandos1 = new ArrayList<Comando>();
        comandos1.add(new Avanzar(10));
        comandos1.add(new Girar(90));
        comandos1.add(new RecogerPaquete());
        comandos1.add(new Girar(90));
        comandos1.add(new Avanzar(10));
        comandos1.add(new DejarPaquete());

        List<Comando> comandos2 = new ArrayList<Comando>();
        comandos2.add(new Girar(360));
        comandos2.add(new Avanzar(3));
        comandos2.add(new Girar(90));
        comandos2.add(new Avanzar(3));
        comandos2.add(new Girar(90));

        Recorrido recorrido1 = new Recorrido(comandos1);
        Recorrido recorrido2 = new Recorrido(comandos2);
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