package ar.utnba.ddsi.depoautomatizado;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.acciones.AccionIrA;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class AccionIrATest {
    @Test
    void ejecutarDebeLlamarIrAEnRobot() {
        // Arrange
        Posicion destino = new Posicion(1, 2, 3);
        AccionIrA accion = new AccionIrA(destino);
        Robot robot = mock(Robot.class);

        // Act
        accion.ejecutar(robot);

        // Assert
        verify(robot).irA(destino);
    }
} 