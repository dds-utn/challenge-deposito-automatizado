import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Compartimiento;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Recorrido;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.LlamarMantenimientoStrategy;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Clark;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos.Avanzar;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos.DejarPaquete;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos.Girar;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos.RecojerPaquete;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class MercaderiaTest {

    @Test
    public void testRobotRecogeMercaderiaDesdeCompartimiento() {
      
        Posicion puntoInicio = new Posicion(0, 0, 0);
        Posicion posicionCompartimiento = new Posicion(3, 0, 0);
        Posicion puntoFin = new Posicion(5, 0, 0);


        Recorrido recorrido = new Recorrido(puntoInicio, puntoFin);
        recorrido.setInstrucciones(List.of(
                new Avanzar(3),
                new RecojerPaquete(),
                new Avanzar(2),
                new DejarPaquete(),
                new Girar(180),
                new Avanzar(5) // volver al inicio
        ));


        Compartimiento compartimiento = new Compartimiento("C1", posicionCompartimiento);
        compartimiento.setRecorrido(recorrido);


        Mercaderia mercaderia = new Mercaderia("M1", "Caja herramientas");
        mercaderia.setCompartimiento(compartimiento);


        Robot clark = new Clark(1L);
        clark.setPosicion(new Posicion(0, 0, 0));



        mercaderia.serRecogidaPor(clark);

        assertEquals(0, clark.getPosicion().getX());
        assertEquals(0, clark.getPosicion().getY());
        assertEquals(0, clark.getPosicion().getZ());
    }
}

