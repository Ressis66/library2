package ru.otus.library2;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.Socket;


@Component
public class MyHealthIndicator implements HealthIndicator {

  private static final String URL
      = "https://localhost:8080/addBook";

  @Override
  public Health health() {
    try (Socket socket =
             new Socket(new java.net.URL(URL).getHost(), 0)) {
    } catch (Exception e) {
      System.out.println("Failed to connect to " + URL);
      return Health.down()
          .withDetail("error", e.getMessage())
          .build();
    }
    return Health.up().build();

  }
}