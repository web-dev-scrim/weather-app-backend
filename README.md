# Weather App Backend

A Spring Boot application that provides weather information using the OpenWeather API.

## Setup

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- OpenWeather API key (get one at https://openweathermap.org/api)

### Environment Configuration

1. Create a `.env` file in the root directory:
```bash
OPENWEATHER_API_KEY=your_api_key_here
```

2. Alternatively, set the environment variable directly:
```bash
export OPENWEATHER_API_KEY=your_api_key_here
```

### Running the Application

1. Clone the repository
2. Set up your environment variables (see above)
3. Run the application:
```bash
./mvnw spring-boot:run
```

The application will start on port 8686.

### API Endpoints

- `GET /weather?city={cityName}` - Get current weather for a city

### Security Notes

- Never commit API keys to version control
- Use environment variables for sensitive configuration
- The `.env` file is ignored by git for security
