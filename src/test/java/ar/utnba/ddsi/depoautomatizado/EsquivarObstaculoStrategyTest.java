package ar.utnba.ddsi.depoautomatizado;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EsquivarObstaculoStrategy;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class EsquivarObstaculoStrategyTest {
    @Test
    void manejarObstaculoDebeLlamarEsquivarObstaculoEnRobot() {
        // Arrange
        EsquivarObstaculoStrategy estrategia = new EsquivarObstaculoStrategy();
        Robot robot = mock(Robot.class);

        // Act
        estrategia.manejarObstaculo(robot);

        // Assert
        verify(robot).esquivarObstaculo();
    }
} 