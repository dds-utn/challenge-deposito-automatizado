package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Comando;

public class Clark extends Robot {
    
    public Clark(Long id) {
        super(id);
    }

    @Override
    public void avanzar(int distancia) {
        System.out.println("avanzar" + distancia + " metros");
    }

    @Override
    public void girar(int grados) {
        System.out.println("girar" + grados + " grados");
    }

    @Override
    public void agarrar() {
        System.out.println("agarra");
    }

    @Override
    public void soltar() {
        System.out.println("suelta");
    }

    @Override
    public void esquivarObstaculo() {

    }

    @Override
    public void llamarAMantenimiento() {

    }

    @Override
    public boolean puedeRecorrerDistancia(int distancia) {
        return false;
    }

    @Override
    public boolean puedeGirar(int grados) {
        return false;
    }

    @Override
    public boolean puedeAgarrar() {
        return false;
    }

    @Override
    public boolean puedeSoltar() {
        return false;
    }

    @Override
    public boolean detectarObstaculo(Comando comando) {
        return false;
    }

} 