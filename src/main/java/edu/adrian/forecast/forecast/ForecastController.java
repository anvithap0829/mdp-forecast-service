package edu.adrian.forecast.forecast;

import edu.adrian.forecast.forecast.model.CountryState;
import edu.adrian.forecast.forecast.model.Forecast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This Controller is the one that handles the URL requests from the outside world, this is as "front-end" as it
 * gets when developing a back-end.
 *
 * To make this work, I annotated this as RestController, which is "wired" automatically by the Spring Framework in
 * runtime. It also contains the RequestMapping annotation which defines the url that it's going to be handling.
 *
 * Usually is undesired that a controller has logic in it, so they delegate the actual logic to Services, in this case
 * the Forecast Service is the one to provide goodies, and as you can see, the ForecastService attribute, is an instance
 * of the interface class rather than the implementations. This allows us later on to remove the actual implementation
 * class (MapForecastService) and create a MsSQLForecastService for example, which will be "transparent" for this controller.
 *
 * Created on 1/23/16.
 *
 * @author Adrian Pena
 */
@RestController
@RequestMapping(value = "/forecast")
public class ForecastController {

    private final ForecastService forecastService;

    /**
     * This Autowired annotation in the ForecastController's constructor is the one that let's spring look for a
     * class (which has to be annotated with @Service and implement the ForecastService) to satisfy the dependency.
     * @param forecastService a forecast service instance.
     */
    @Autowired
    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    /**
     * This method handles the url: <code>/forecast/{state}</code> using the GET http method. As seen in the
     * RequestMapping declaration, it doesn't specify the <code>/forecast</code> in the value because the class already
     * defined the parent url.
     * @param state The country state
     * @return a forecast for the state, <code>null</code> if there is none.
     */
    @RequestMapping(value = "/{state}", method = RequestMethod.GET)
    public Forecast getForecast(@PathVariable("state") CountryState state) {
        return forecastService.getForecast(state);
    }
}
