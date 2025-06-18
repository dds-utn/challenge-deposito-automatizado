package ar.utnba.ddsi.depoautomatizado.models.entities.robots;


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


    //Asumo que un sensor llama a este metodo cuando detecta a un obstaculo mediante un pub/sub
    public void  manejarObstaculo(){

        this.estrategiaObstaculo.manejarObstaculo(this);
    }

    public void detener() {
    }

    public void volverAInicio() {
        //TODO: No sabría como implementar esta lógica
    }

    public void esquivarObstaculo() {
    }


    public void avanzar(Integer distancia) {
    }

    public void girar(Integer grados) {
    }

    public void recogerMercaderia() {
    }

    public void soltarMercaderia() {
    }

    public void elevar(Integer altura){}
}