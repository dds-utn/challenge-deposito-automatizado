package ar.utnba.ddsi.depoautomatizado;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.VolverInicioStrategy;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class VolverInicioStrategyTest {
    @Test
    void manejarObstaculoDebeLlamarVolverAlInicioEnRobot() {
        // Arrange
        VolverInicioStrategy estrategia = new VolverInicioStrategy();
        Robot robot = mock(Robot.class);

        // Act
        estrategia.manejarObstaculo(robot);

        // Assert
        verify(robot).volverAlInicio();
    }
} 