package edu.adrian.forecast;

import edu.adrian.forecast.forecast.ForecastController;
import edu.adrian.forecast.forecast.ForecastService;
import edu.adrian.forecast.forecast.MapForecastService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * In this particular test class, I'll just verify that the components
 * that my service require are appropriately created by Spring.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ForecastServiceApplication.class)
@WebAppConfiguration
public class ForecastServiceApplicationTests {

	@Autowired
	ForecastService forecastService;

	@Autowired
	ForecastController forecastController;

	@Test
	public void contextLoads() {
		assertNotNull("The ForecastService shouldn't be null", forecastService);

		//NOTE: This particular assertion shouldn't be here, but for the sake of
		//showing you what's going on, I'll assert whether the forecastService is
		//an instance of the MapForecastService.
		assertTrue("The ForecastService should be a MapForecastService", forecastService instanceof MapForecastService);

		assertNotNull("The ForecastController shouldn't be null", forecastController);
	}
}
