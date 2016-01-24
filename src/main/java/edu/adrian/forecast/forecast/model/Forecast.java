package edu.adrian.forecast.forecast.model;

/**
 * A Forecast represents the current weather state for a given State in the United States.
 *
 * Created on 1/23/16.
 * @author Adrian Pena
 */
public class Forecast {

    private int temperature;
    private TemperatureScale scale;
    private String description;
    private CountryState state;

    public Forecast() {
    }

    public Forecast(int temperature, TemperatureScale scale, String description, CountryState state) {
        this.temperature = temperature;
        this.scale = scale;
        this.description = description;
        this.state = state;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public TemperatureScale getScale() {
        return scale;
    }

    public void setScale(TemperatureScale scale) {
        this.scale = scale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CountryState getState() {
        return state;
    }

    public void setState(CountryState state) {
        this.state = state;
    }
}
