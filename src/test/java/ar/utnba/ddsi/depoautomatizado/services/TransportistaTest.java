package ar.utnba.ddsi.depoautomatizado.services;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;
import ar.utnba.ddsi.depoautomatizado.models.entities.observer.adapter.AdapterTransportista;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.utnba.ddsi.depoautomatizado.models.entities.observer.Transportista;

import static org.mockito.Mockito.*;

class TransportistaTest {

  private AdapterTransportista adapterMock;
  private Transportista transportista;
  private Pedido pedido;

  @BeforeEach
  void setUp() {
    adapterMock = mock(AdapterTransportista.class);
    transportista = new Transportista(adapterMock);
    pedido = new Pedido("PED-123");
  }

  @Test
  void notificarFinalizacionDePedidoLlamaAlAdapter() {
    // Act
    transportista.notificarFinalizacion(pedido);

    // Assert
    verify(adapterMock, times(1)).notificar(pedido);
  }
  @Test
  void nombreYtelefonoCorrectos() {
    transportista.setNombre("Mauro Ambrosio");
    transportista.setTelefono("1123344556");

    Assertions.assertEquals("Mauro Ambrosio", transportista.getNombre());
    Assertions.assertEquals("1123344556", transportista.getTelefono());
  }

}

