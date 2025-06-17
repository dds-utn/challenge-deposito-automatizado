package ar.utnba.ddsi.depoautomatizado.models.entities;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.observer.IObserver;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Pedido {
    private String id;
    private List<Mercaderia> mercaderias;
    private boolean completado;
    private List<IObserver> observers; //? Los observadores que serán notificados al finalizar el pedido. Actualmente es solo el transportista, pero implementar la lista hace que sea extensible en caso de necesitar agregar más observadores en el futuro.
    
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

    public void recogerMercaderiaPor(Robot robot) {
        this.mercaderias.forEach(mercaderia -> {
            mercaderia.serRecogidaPor(robot);
        });
        this.marcarComoCompletado();
    }

    public void agregarObservers(IObserver... observers){
        Collections.addAll(this.observers, observers);
    }

    public void eliminarObserver(IObserver observer){
        this.observers.remove(observer);
    }

}