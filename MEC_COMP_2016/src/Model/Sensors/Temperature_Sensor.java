package Model.Sensors;
import Model.Weather;

public class Temperature_Sensor implements ISensor{
	private Weather currentWeather;
	public double temperature;
	
	public Temperature_Sensor(Weather weatherIn) {
		this.currentWeather = weatherIn;
	}
	
	public void getTemperature(){
		this.temperature = currentWeather.getTemperature();
	}

	public void update() {
		this.getTemperature();
		currentWeather.update();

		
	}

}
