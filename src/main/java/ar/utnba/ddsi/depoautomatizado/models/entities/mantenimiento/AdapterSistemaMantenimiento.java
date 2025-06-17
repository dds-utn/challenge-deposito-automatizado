package ar.utnba.ddsi.depoautomatizado.models.entities.mantenimiento;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AdapterSistemaMantenimiento implements IAdapterSistemaMantenimiento {

  private final WebClient webClient;

  public AdapterSistemaMantenimiento(@Value("${sistema.mantenimiento.url}") String baseUrl) {
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