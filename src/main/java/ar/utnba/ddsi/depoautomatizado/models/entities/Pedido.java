package ar.utnba.ddsi.depoautomatizado.models.entities;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Adapter.RobotAdapter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Pedido {
    private String id;
    private List<Mercaderia> mercaderias;
    private boolean completado;
    
    public Pedido(String id) {
        this.id = id;
        this.mercaderias = new ArrayList<>();
        this.completado = false;
    }
    
    public void agregarMercaderia(Mercaderia mercaderia) {
        this.mercaderias.add(mercaderia);
    }
    
    public boolean estaCompletado() {
        return completado;
    }
    
    public void marcarComoCompletado() {
        this.completado = true;
    }

    public void recogerMercaderiaPor(RobotAdapter robot) {
        this.mercaderias.forEach(mercaderia -> {
            mercaderia.serRecogidaPor(robot);
        });
        this.marcarComoCompletado();
        System.out.println("Completado el pedido " + this.id);
    }
}