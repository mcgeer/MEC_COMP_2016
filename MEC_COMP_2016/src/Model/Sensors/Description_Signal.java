package Model.Sensors;
import Model.Weather;

public class Description_Signal implements ISensor {
	private Weather currentWeather;
	public String description;
	
	public Description_Signal(Weather weatherIn) {
		this.currentWeather = weatherIn;
	}
	
	public void getPressure(){
		this.description = currentWeather.getDescription();
	}

	public void update() {
		this.getPressure();
		currentWeather.update();
	}

}
