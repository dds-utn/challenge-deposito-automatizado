package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

public class ObstaculoDetectadoException extends RuntimeException {

    public ObstaculoDetectadoException() {
        super("Se detectó un obstáculo durante la ejecución de la instrucción.");
    }

    public ObstaculoDetectadoException(String mensaje) {
        super(mensaje);
    }

    public ObstaculoDetectadoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public ObstaculoDetectadoException(Throwable causa) {
        super(causa);
    }
}
