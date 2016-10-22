package Model.Sensors;
import Model.Weather;

public class Condition_Sensor implements ISensor {
	private Weather currentWeather;
	public String condition;
	
	public Condition_Sensor(Weather weatherIn) {
		this.currentWeather = weatherIn;
	}
	
	public void getPressure(){
		this.condition = currentWeather.getCondition();
	}

	public void update() {
		this.getPressure();
		currentWeather.update();
	}

}
