package Model.Sensors;

import Model.Weather;

public class WindSpeed_Sensor implements ISensor {

	private Weather currentWeather;
	public double windSpeed;
	public double windDirection;
	
	public WindSpeed_Sensor(Weather weatherIn) {
		this.currentWeather = weatherIn;
	}
	
	public void whatIsWindSpeed() {
		this.windSpeed = currentWeather.getWindSpeed();
		this.windSpeed = currentWeather. getWindDirection();
	}
	
	public void update() {
		this.whatIsWindSpeed();
	}

}
