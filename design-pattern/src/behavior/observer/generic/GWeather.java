package behavior.observer.generic;

import behavior.observer.WeatherType;

/**
 * GWeather
 */
public class GWeather extends Observable<GWeather, Race, WeatherType> {

    private WeatherType currentWeather;

    public GWeather() {
        currentWeather = WeatherType.SUNNY;
    }

    /**
     * Makes time pass for weather
     */
    public void timePasses() {
        WeatherType[] enumValues = WeatherType.values();
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        System.out.printf("The weather changed to %s .\n", currentWeather);
        notifyObservers(currentWeather);
    }
}
