package edu.adrian.forecast.forecast;

import edu.adrian.forecast.forecast.model.CountryState;
import edu.adrian.forecast.forecast.model.Forecast;
import edu.adrian.forecast.forecast.model.TemperatureScale;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * This is an implementation of the ForecastService interface. This particular implementation will use a Map to "hold"
 * the forecast information (as if it was a database). Note that the service classes have the @Service annotation.
 *
 * Later on, we could create another implementation of the ForecastService interface that uses an actual database and
 * just disable this class without worrying that something bad happens.
 *
 * This is because when we use the ForecastService in the Controllers, we will use a reference of the interface and not
 * this class and Spring will internally create an instance of whoever class implements the interface and "inject it"
 * at runtime. This is called "Dependency Injection".
 *
 * Created on 1/23/16.
 *
 * @author Adrian Pena
 */
@Service
public class MapForecastService implements  ForecastService {

    /**
     * We will use a Map in this implementation to hold the forecasts.
     */
    private Map<CountryState, Forecast> database;

    @Override
    public Forecast getForecast(CountryState state) {
        if(database != null && database.containsKey(state)) {
            return database.get(state);
        }
        return null;
    }

    public void setDatabase(Map<CountryState, Forecast> database) {
        this.database = database;
    }
}
