package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

public class Llamador {
    private final String numero;
    private final String mensaje;

    public Llamador(String numero, String mensaje) {
        this.numero = numero;
        this.mensaje = mensaje;
    }

    public void llamar() {};
}
