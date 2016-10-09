package com.example.android.sunshine.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by shmakova on 10.10.16.
 */

public class WeatherDataParser {
    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        final String LIST = "list";
        final String TEMPERATURE = "temp";
        final String MAX_TEMPERATURE = "max";
        JSONObject weatherJsonObject = new JSONObject(weatherJsonStr);
        JSONArray daysJsonArray = weatherJsonObject.getJSONArray(LIST);
        JSONObject dayJsonObject = daysJsonArray.getJSONObject(dayIndex);
        JSONObject tempJsonObject = dayJsonObject.getJSONObject(TEMPERATURE);
        double maxTemperature = tempJsonObject.getDouble(MAX_TEMPERATURE);
        return maxTemperature;
    }


}