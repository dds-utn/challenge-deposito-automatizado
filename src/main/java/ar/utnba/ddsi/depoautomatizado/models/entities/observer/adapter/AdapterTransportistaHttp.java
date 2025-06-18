package ar.utnba.ddsi.depoautomatizado.models.entities.observer.adapter;

import ar.utnba.ddsi.depoautomatizado.models.entities.Pedido;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
public class AdapterTransportistaHttp implements AdapterTransportista{
  private final WebClient webClient;

  public AdapterTransportistaHttp() {
    this.webClient = WebClient.create("");//TODO: Agregar la URL de la API en application.properties
  }

  @Override
  public void notificar(Pedido pedido) {
    webClient.post()
        .uri("")
        .bodyValue(pedido)
        .retrieve()
        .bodyToMono(Void.class)
        .subscribe();
    //TODO: Implementar la URL de la API expuesta para el transportista
  }
}
