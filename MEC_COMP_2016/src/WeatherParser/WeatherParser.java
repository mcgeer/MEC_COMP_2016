package WeatherParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Model.Weather;
public class WeatherParser {
	public Weather getWeather(String lat, String lon){
		Weather currWeather = null;

		try {
			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=131822fb7178a06a3ccd98970f76c876");
		
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
		
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ connection.getResponseCode());
			}				
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(connection.getInputStream())));
		
			String s = br.readLine();
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(s);
		
			JSONObject elem = (JSONObject)(obj.get("coord"));
			JSONArray elem1 = (JSONArray)(obj.get("weather"));
			JSONObject elem2 = (JSONObject)(obj.get("main"));
			JSONObject elem3 = (JSONObject)(obj.get("wind"));
		
			System.out.println(obj);
			System.out.println(elem1);
			System.out.println(((JSONObject)elem1.get(0)).get("description"));
			System.out.println(((JSONObject)elem1.get(0)).get("main"));
			System.out.println(elem2.get("temp"));
			System.out.println(elem2.get("temp_min"));
			System.out.println(elem2.get("temp_max"));
			System.out.println(elem2.get("sea_level"));
			System.out.println(elem2.get("grnd_level"));
			System.out.println(elem2.get("humidity"));
			System.out.println(elem3.get("deg"));
			System.out.println(elem3.get("speed"));
		
			currWeather = new Weather();
			currWeather.setLatitude((double) elem.get("lat"));
			currWeather.setLatitude((double) elem.get("lon"));
			currWeather.setDescription((String) ((JSONObject)elem1.get(0)).get("description"));
			currWeather.setTemperature((double) (elem2.get("temp")));
			currWeather.setMinTemperature((double)elem2.get("temp_min"));
			currWeather.setMinTemperature((double)elem2.get("temp_max"));
			currWeather.setGroundLevelPressure((double)elem2.get("grnd_level"));
			currWeather.setSeaLevelPressure((double)elem2.get("sea_level"));
			currWeather.setHumidity((long)elem2.get("humidity"));
			currWeather.setWindDirection((double)elem3.get("deg"));
			currWeather.setWindDirection((double)elem3.get("speed"));
		}catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currWeather;
	}
}