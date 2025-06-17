package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class LlamarMantenimientoStrategy implements EstrategiaObstaculo {
    private Llamador llamador;
    
    @Override
    public void manejarObstaculo(Robot robot) {
        //alguna logica para que el robot se quede quieto
        this.llamador.llamar();
    }
} 