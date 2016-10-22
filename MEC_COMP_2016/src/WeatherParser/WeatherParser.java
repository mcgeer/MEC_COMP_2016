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
public class WeatherParser {{

	try {
		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=131822fb7178a06a3ccd98970f76c876");
		
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
		System.out.println(obj);
		System.out.println(elem1);
		
		Weather currWeather = new Weather();
		currWeather.setLatitude((double) elem.get("lat"));
		currWeather.setLatitude((double) elem.get("lon"));
		//currWeather.setDescription(elem1.get("description"));
		
	}catch (IOException | ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
}
