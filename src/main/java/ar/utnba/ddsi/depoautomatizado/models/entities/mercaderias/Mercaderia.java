package ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mercaderia {
    private String id;
    private String descripcion;
    private Compartimiento compartimiento;
    private boolean fueRecogido;
    
    public Mercaderia(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.fueRecogido = false;
    }

    public void serRecogidaPor(Robot robot) {
        fueRecogido = this.compartimiento.getRecorrido().ejecutarRecorrido(robot);
    }
}