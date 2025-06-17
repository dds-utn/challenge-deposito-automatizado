package ar.utnba.ddsi.depoautomatizado.models.entities.transporte;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

public class AdapterSistemaTransporte implements IAdapterSistemaTransporte{
  private final WebClient webClient;

  public AdapterSistemaTransporte(@Value("${sistema.transporte.url}") String baseUrl) {
    this.webClient = WebClient.create(baseUrl);
  }

  @Override
  public void notificar(Robot robot) {
    webClient.post()
        .uri("/robots")
        .bodyValue(robot)
        .retrieve()
        .bodyToMono(Void.class)
        .subscribe();
  }
}
