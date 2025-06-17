package ar.utnba.ddsi.depoautomatizado;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.LlamarMantenimientoStrategy;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class LlamarMantenimientoStrategyTest {
    @Test
    void manejarObstaculoDebeLlamarLlamarMantenimientoEnRobot() {
        // Arrange
        LlamarMantenimientoStrategy estrategia = new LlamarMantenimientoStrategy();
        Robot robot = mock(Robot.class);

        // Act
        estrategia.manejarObstaculo(robot);

        // Assert
        verify(robot).llamarMantenimiento();
    }
} 