package Model.Sensors;
import Model.Weather;

public class Cloudiness_Sensor implements ISensor{
	private Weather currentWeather;
	public double cloudiness;
	
	public Cloudiness_Sensor(Weather weatherIn) {
		this.currentWeather = weatherIn;
	}
	
	public void getCloudiness(){
		this.cloudiness = currentWeather.getCloudiness();
	}

	public void update() {
		this.getCloudiness();
		currentWeather.update();

		
	}

}
