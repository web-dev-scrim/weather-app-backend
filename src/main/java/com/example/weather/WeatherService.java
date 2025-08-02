package com.example.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

  private final WebClient webClient = WebClient.create();

  @Value("${openweather.api.url}")
  private String apiUrl;

  @Value("${openweather.api.key}")
  private String apiKey;

  public Mono<WeatherDto> getWeather(String city) {
    return webClient.get()
        .uri(apiUrl + "?q={city}&appid={key}&units=metric", city, apiKey)
        .retrieve()
        .bodyToMono(OpenWeatherResponse.class)
        .map(r -> new WeatherDto(
            city,
            r.weather().get(0).description(),
            r.main().temp()
        ));
  }

  // internal record to match JSON
  private record OpenWeatherResponse(Main main, java.util.List<Weather> weather) {
    private record Main(double temp) {}
    private record Weather(String description) {}
  }
}
