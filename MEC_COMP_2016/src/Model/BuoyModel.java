package Model;

import Model.Sensors.Temperature_Sensor;
import Model.Sensors.WindInfo_Sensor;

public class BuoyModel extends Thread{
	
	private static int CLOCK = 20000;
	private String lat, lon;
	public BuoyModel(String lat, String lon){
		this.lat = lat;
		this.lon = lon;
	}
	
	
	@Override
	public void run() {
		try {
			sleep(CLOCK);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.run();
	}
	
	public static double getTemperature(Weather currentWeather) {
		Temperature_Sensor temperature = new Temperature_Sensor(currentWeather);
		
		return temperature.temperature;
	}
	
	public static double getWindSpeed(Weather currentWeather) {
		WindInfo_Sensor windInfo = new WindInfo_Sensor(currentWeather);
		
		return windInfo.windSpeed;
	}
	
	
	private synchronized void speak(){
		Transmitter toTransmit = new Transmitter(this.lat, this.lon);
		toTransmit.transmit();
		
	}
	
	public static double getWindDirection(Weather currentWeather) {
		WindInfo_Sensor windInfo = new WindInfo_Sensor(currentWeather);
		
		return windInfo.windDirection;
	}
}
