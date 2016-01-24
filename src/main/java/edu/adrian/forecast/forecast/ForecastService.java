package edu.adrian.forecast.forecast;

import edu.adrian.forecast.forecast.model.CountryState;
import edu.adrian.forecast.forecast.model.Forecast;

/**
 * This is the Forecast Service's interface, this interface allows me to define all the different "actions" (methods)
 * that can be performed in the Forecast Service without having to write the code in them.
 *
 * When you have the interface written, and the basic implementation, then you can write the tests, assume scenarios
 * and assert for your expected results.
 *
 * After having all the tests in place, we can proceed to create a class that implements this service and put the actual
 * logic in it, when the logic is in place, all the tests should pass and your service should be (more) reliable.
 *
 * Created on 1/23/16.
 *
 * @author Adrian Pena
 */
public interface ForecastService {

    /**
     * Gets the forecast for the given state.
     * @param state a country state.
     * @return the current forecast if there's one, <code>null</code> otherwise.
     */
    Forecast getForecast(CountryState state);
}
