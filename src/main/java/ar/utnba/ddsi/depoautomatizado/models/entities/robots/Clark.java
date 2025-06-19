package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Adapter.ClarkAdapter;

public class Clark extends Robot {
    public Clark(Long id) {
        super(id);
        this.setAdapter(new ClarkAdapter(this));
    }

    public void avanzar(int metros) {
        System.out.println("Robot clark avanza " + metros + " mts");
    }
    public void girar(int angulo) {
        System.out.println("Robot clark gira " + angulo + "º");
    }
    public void dejarPaquete(int altura) {
        System.out.println("Robot clark deja paquete en la altura: " + altura + " mts");
    }
    public void recogerPaquete(int altura) {
        System.out.println("Robot recoge el paquete en la altura: " + altura + " mts");
    }
    public void esquivarObstaculo() {
        this.girar(90);
        this.avanzar(1);
        this.girar(-90);
        this.avanzar(1);
        this.girar(-90);
        this.avanzar(1);
        this.girar(90);
        System.out.println("Se esquivo el obstaculo");
    }
} 