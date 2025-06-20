package ar.utnba.ddsi.depoautomatizado.models.entities.robots;


import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.instrucciones.Instruccion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public abstract class Robot {
    private Long id;
    private boolean disponible;
    private EstrategiaObstaculo estrategiaObstaculo;
    private int alturaMaxima;
    private int alturaMinima;
    @Setter
    private Posicion posicionActual;
    private List<Instruccion> accionesRealizadas;

    public Robot(Long id, EstrategiaObstaculo estrategiaObstaculo, int alturaMaxima, int alturaMinima) {
        this.id = id;
        this.estrategiaObstaculo = estrategiaObstaculo;
        this.alturaMaxima = alturaMaxima;
        this.alturaMinima = alturaMinima;
        this.disponible = true;
    }

    public abstract boolean validarPosicionInicial(Posicion posicion);

    public void ejecutarRecorrido(Posicion posInicial, List<Instruccion> instrucciones) {
        if (!validarPosicionInicial(posInicial)) {
            throw new IllegalArgumentException("Posición inicial inválida");
        }

        this.posicionActual = posInicial;
        for (Instruccion instruccion : instrucciones) {
            try {
                if(!this.validarMovimiento(instruccion))
                    this.estrategiaObstaculo.manejarObstaculo(this);

                instruccion.ejecutar(this);
                accionesRealizadas.add(instruccion);
            } catch (Exception e) {
                this.estrategiaObstaculo.manejarObstaculo(List.of(instruccion));
            }
        }
    }

    protected abstract boolean validarMovimiento(Instruccion instruccion);

    public abstract void avanzar(int i);

    public abstract void retroceder(int i);

    public abstract void girar(int i);

    public abstract void subir(int i);

    public abstract void bajar(int i);

    public abstract void recoger();

    public abstract void dejar();
}
