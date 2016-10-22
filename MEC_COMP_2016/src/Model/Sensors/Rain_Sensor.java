package Model.Sensors;
import Model.Weather;

public class Rain_Sensor implements ISensor {
	
	private Weather currentWeather;
	public double rain;
	
	public Rain_Sensor(Weather weatherIn) {
		this.currentWeather = weatherIn;
	}
	
	public void isItRaining() {
		this.rain = currentWeather.getRainVolume();
	}

	public void update() {
		this.isItRaining();
		currentWeather.update();
	}
}
