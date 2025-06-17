package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.acciones;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class AccionDejarMercaderia implements Accion{
    private Mercaderia mercaderia;

    public AccionDejarMercaderia(Mercaderia mercaderia) {
        this.mercaderia = mercaderia;
    }

    @Override
    public void ejecutar(Robot robot) {
        robot.dejar(mercaderia);
    }
}
