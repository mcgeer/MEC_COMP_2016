package Model;

import com.sun.speech.freetts.*;
import Model.Sensors.Humidity_Sensor;
import Model.Sensors.Pressure_Sensor;
import Model.Sensors.Rain_Sensor;
import Model.Sensors.Temperature_Sensor;
import Model.Sensors.WindInfo_Sensor;
import WeatherParser.WeatherParser;

public class Transmitter {
	private static Weather currentWeather;
	public final int range = 500;
	private static final String VOICENAME = "kevin16";
	
	public Transmitter(String lat, String lon) {
				
		Transmitter.currentWeather = new WeatherParser().getWeather(lat, lon);
		
		Transmitter.currentWeather = new Weather();
	}
	
	private static String printRain() {
		Rain_Sensor rain = new Rain_Sensor(currentWeather);
		
		if (rain.rain > 0 ) {
			return ("It is currently not raining.");
		}
		
		else {
			return("It is currently raining.");
		}
	}
	
	private static String printHumidity() {
		Humidity_Sensor humidity = new Humidity_Sensor(currentWeather);
		
		return ("There is currently " + humidity.humidity + " percent humidity.");
		
	}
	
	private static String printTemperature() {
		Temperature_Sensor temperature = new Temperature_Sensor(currentWeather);
		
		return ("The temperature is currently " + temperature.temperature + " degrees.");
	}
	
	private static String printWindInfo() {
		WindInfo_Sensor windInfo = new WindInfo_Sensor(currentWeather);
		
		return ("The wind is currently blowing at " + windInfo.windSpeed + 
				" km/h and in the direction" + windInfo.windDirection);
	}
	
	private static String printPressure() {
		Pressure_Sensor pressure = new Pressure_Sensor(currentWeather);
		
		return ("The pressure is currently " + pressure.pressure);
	}
	
	public static void transmit() {
		Voice transmitterVoice;
		VoiceManager tVM = VoiceManager.getInstance();
		
		transmitterVoice = tVM.getVoice(VOICENAME);
		transmitterVoice.allocate();
		
		try {
			transmitterVoice.speak(printTemperature());
			transmitterVoice.speak(printHumidity());
			// transmitterVoice.speak(printRain());
			// transmitterVoice.speak(printWindInfo());
			// transmitterVoice.speak(printPressure());
		}
		
		catch (Exception e) {
			System.out.println(e);
		}
		
		//currentWeather.update();
		
	}
	
}
