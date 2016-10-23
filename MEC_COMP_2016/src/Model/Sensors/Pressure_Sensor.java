package Model.Sensors;
import Model.Weather;

public class Pressure_Sensor implements ISensor {
	private Weather currentWeather;
	public double pressure;
	
	public Pressure_Sensor(Weather weatherIn) {
		this.currentWeather = weatherIn;
	}
	
	public void getPressure(){
		this.pressure = currentWeather.getPressure();
	}

	public void update() {
		this.getPressure();
	}

}
