package Model.Sensors;
import Model.Weather;

public class Humidity_Sensor implements ISensor{
	private Weather currentWeather;
	public double humidity;
	
	public Humidity_Sensor(Weather weatherIn) {
		this.currentWeather = weatherIn;
		getHumidity();
	}
	
	public void getHumidity(){
		this.humidity = currentWeather.getHumidity();
	}

	public void update() {
		this.getHumidity();
		
	}

}
