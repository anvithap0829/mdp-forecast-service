package edu.adrian.forecast.forecast;

import edu.adrian.forecast.ForecastServiceApplication;
import edu.adrian.forecast.forecast.model.CountryState;
import edu.adrian.forecast.forecast.model.Forecast;
import edu.adrian.forecast.forecast.model.TemperatureScale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Map Forecast Service Test
 *
 * Note that in order for us to use the Spring framework in a test, we need to annotate the test class with
 * RunWith and SpringApplicationConfiguration, those classes allows us to run a test server when executing the test.
 * Created on 1/23/16.
 *
 * @author Adrian Pena
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ForecastServiceApplication.class)
public class MapForecastServiceTest {

    @Autowired
    MapForecastService forecastService;

    @Test
    public void testGetForecastWithEmptyMap() throws Exception {
        //first we set an empty "database" map to the service
        forecastService.setDatabase(new HashMap<>());

        //then we try to look for any state's forecast
        Forecast forecast = forecastService.getForecast(CountryState.MI);

        //the forecast should be null.
        assertNull("The forecast should be null for an empty database.", forecast);
    }

    @Test
    public void testGetForecast() throws Exception {
        //first we create a forecast for Michigan.
        Forecast michiganForecast = new Forecast();
        michiganForecast.setTemperature(12);
        michiganForecast.setScale(TemperatureScale.FAHRENHEIT);
        michiganForecast.setDescription("It's very cold outside!");
        michiganForecast.setState(CountryState.MI);

        //we create and set a database with Michigan's forecast.
        Map<CountryState, Forecast> database = new HashMap<>();
        database.put(CountryState.MI, michiganForecast);
        forecastService.setDatabase(database);

        //then we try to look for the Michigan's forecast.
        Forecast forecast = forecastService.getForecast(CountryState.MI);

        //the forecast shouldn't be null.
        assertNotNull("The MI forecast should be there", forecast);
        assertEquals("The temperature should be 12", 12, forecast.getTemperature());
        assertEquals("The scale should be F", TemperatureScale.FAHRENHEIT, forecast.getScale());
        assertEquals("The description should say that is very cold outside", "It's very cold outside!", forecast.getDescription());
        assertEquals("The forecast state should be MI", CountryState.MI, forecast.getState());
    }
}