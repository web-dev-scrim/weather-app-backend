package com.example.weather;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "http://localhost:5173") // Vite default
public class WeatherController {

  private final WeatherService service;

  public WeatherController(WeatherService service) {
    this.service = service;
  }

  @GetMapping
  public Mono<WeatherDto> weather(@RequestParam String city) {
    return service.getWeather(city);
  }
}
