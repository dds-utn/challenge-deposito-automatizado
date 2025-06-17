package ar.utnba.ddsi.depoautomatizado;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Recorrido;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.acciones.Accion;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class RecorridoTest {
    @Test
    void ejecutarRecorridoDebeEjecutarTodasLasAccionesEnOrden() {
        // Arrange
        Recorrido recorrido = new Recorrido();
        Accion accion1 = mock(Accion.class);
        Accion accion2 = mock(Accion.class);
        Robot robot = mock(Robot.class);
        recorrido.agregarAccion(accion1);
        recorrido.agregarAccion(accion2);

        // Act
        recorrido.ejecutarRecorrido(robot);

        // Assert
        verify(accion1).ejecutar(robot);
        verify(accion2).ejecutar(robot);
    }
} 