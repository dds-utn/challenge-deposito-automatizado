package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Adapter.DroneAdapter;

public class Drone extends Robot {
    
    public Drone(Long id) {
        super(id);
        this.setAdapter(new DroneAdapter(this));
    }

    public void irParaAdelante(int metros) {
        System.out.println("Robot drone avanza " + metros + " mts");
    }
    public void voltearIzquierda() {
        System.out.println("Robot drone gira a la izquierda");
    }
    public void voltearDerecha() {
        System.out.println("Robot drone gira a la derecha");
    }
    public void soltarPaquete(int altura) {
        System.out.println("Robot drone deja paquete en la altura: " + altura + " mts");
    }
    public void volarYRecogerPaquete(int altura) {
        System.out.println("Robot drone el paquete en la altura: " + altura + " mts");
    }

    public void esquivarObstaculo() {
        this.voltearDerecha();
        this.irParaAdelante(1);
        this.voltearIzquierda();
        this.irParaAdelante(1);
        this.voltearIzquierda();
        this.irParaAdelante(1);
        this.voltearDerecha();
    }
} 