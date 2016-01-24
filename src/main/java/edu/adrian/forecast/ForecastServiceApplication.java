package edu.adrian.forecast;

import edu.adrian.forecast.forecast.ForecastService;
import edu.adrian.forecast.forecast.MapForecastService;
import edu.adrian.forecast.forecast.model.CountryState;
import edu.adrian.forecast.forecast.model.Forecast;
import edu.adrian.forecast.forecast.model.TemperatureScale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Forecast Service's main application class.
 *
 * When the compiled jar is executed, this is the class that's going to initialize all the spring framework and all of
 * your classes (as long as they are appropriately annotated).
 *
 * This class usually doesn't contain any code at all, but for right now, I will be putting some fake data for our service.
 */
@SpringBootApplication
public class ForecastServiceApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ForecastServiceApplication.class, args);

        //I will create and initialize some fake data for the forecast service here.
        Map<CountryState, Forecast> database = new HashMap<>();
        database.put(CountryState.MI, new Forecast(14, TemperatureScale.FAHRENHEIT, "It's snowy and slippery!", CountryState.MI));
        database.put(CountryState.FL, new Forecast(104, TemperatureScale.FAHRENHEIT, "Who said pina colada?", CountryState.FL));
        database.put(CountryState.WA, new Forecast(64, TemperatureScale.FAHRENHEIT, "Rainy!, stereotype much?", CountryState.WA));
        database.put(CountryState.AZ, new Forecast(116, TemperatureScale.FAHRENHEIT, "Let it burn!", CountryState.AZ));
        database.put(CountryState.CA, new Forecast(95, TemperatureScale.FAHRENHEIT, "Chill out in your closest IN & OUT!", CountryState.CA));
        database.put(CountryState.MO, new Forecast(68, TemperatureScale.FAHRENHEIT, "It might be cold tonight!", CountryState.MO));
        database.put(CountryState.TX, new Forecast(102, TemperatureScale.FAHRENHEIT, "Don't forget your water bottle.", CountryState.TX));

        //I can retrieve the service (which is a singleton) through the call: context.getBean(class).
        MapForecastService forecastService = (MapForecastService) context.getBean(ForecastService.class);
        forecastService.setDatabase(database);
    }
}
