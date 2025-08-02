package com.example.weather;

public record WeatherDto(String city,
                         String description,
                         double tempC) { }
