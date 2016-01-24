package edu.adrian.forecast.forecast;

import edu.adrian.forecast.ForecastServiceApplication;
import edu.adrian.forecast.forecast.model.CountryState;
import edu.adrian.forecast.forecast.model.Forecast;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created on 1/23/16.
 *
 * @author Adrian Pena
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ForecastServiceApplication.class)
public class ForecastControllerTest {

    @Test
    public void testGetForecast() throws Exception {
        //I will verify in this test that the service is being called when the controller receives a request.

        //First I will create a Mock of the service
        ForecastService forecastService = Mockito.mock(ForecastService.class);

        //Now I will create a ForecastController instance.
        ForecastController forecastController = new ForecastController(forecastService);

        //I will simulate a request for the /forecast/{state} url.
        forecastController.getForecast(CountryState.MI);

        //The forecast service's getForecast(State) should have been invoked.
        verify(forecastService, times(1)).getForecast(CountryState.MI);
    }
}