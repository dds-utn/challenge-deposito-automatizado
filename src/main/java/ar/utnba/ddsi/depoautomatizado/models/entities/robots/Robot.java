package ar.utnba.ddsi.depoautomatizado.models.entities.robots;


import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Mercaderia;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Robot {
    private Long id;
    private boolean disponible;
    private EstrategiaObstaculo estrategiaObstaculo;

    Robot(Long id) {
        this.id = id;
        this.disponible = true;
    }

    public void irA(Posicion destino) {
        // lógica para moverse
    }

    public void recoger(Mercaderia mercaderia) {
        // lógica para recoger mercadería
    }

    public void dejar(Mercaderia mercaderia) {
        // lógica para entregar mercadería
    }

    public void esquivarObstaculo() {
        // lógica para esquivar
    }

    public void volverAlInicio() {
        // lógica para volver al inicio
    }

    public void llamarMantenimiento() {
        // lógica para llamar al mantenimiento
    }
} 