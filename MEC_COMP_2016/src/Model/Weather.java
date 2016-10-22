package Model;

public class Weather {
public Weather(){
		
	};
	private double latitude;
	private double longitude;	
	private String condition;
	private String description;
	private double temperature;
	private double minTemperature;
	private double maxTemperature;
	private double seaLevelPressure;
	private double groundLevelPressure;
	private double pressure;
	private double humidity;
	private double windSpeed;
	private double windDirection;
	private double cloudiness;
	public double rainVolume;
	private double snowVolume;
	private String dataCalcTime;
	private String countryCode;
	private String sunRise;
	private String sunSet;
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getMinTemperature() {
		return minTemperature;
	}
	public void setMinTemperature(double minTemperature) {
		this.minTemperature = minTemperature;
	}
	public double getMaxTemperature() {
		return maxTemperature;
	}
	public void setMaxTemperature(double maxTemperature) {
		this.maxTemperature = maxTemperature;
	}
	public double getSeaLevelPressure() {
		return seaLevelPressure;
	}
	public void setSeaLevelPressure(double seaLevelPressure) {
		this.seaLevelPressure = seaLevelPressure;
	}
	public double getGroundLevelPressure() {
		return groundLevelPressure;
	}
	public void setGroundLevelPressure(double groundLevelPressure) {
		this.groundLevelPressure = groundLevelPressure;
	}
	public double getPressure() {
		return pressure;
	}
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public double getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(double windDirection) {
		this.windDirection = windDirection;
	}
	public double getCloudiness() {
		return cloudiness;
	}
	public void setCloudiness(double cloudiness) {
		this.cloudiness = cloudiness;
	}
	public double getRainVolume() {
		return rainVolume;
	}
	public void setRainVolume(double rainVolume) {
		this.rainVolume = rainVolume;
	}
	public double getSnowVolume() {
		return snowVolume;
	}
	public void setSnowVolume(double snowVolume) {
		this.snowVolume = snowVolume;
	}
	public String getDataCalcTime() {
		return dataCalcTime;
	}
	public void setDataCalcTime(String dataCalcTime) {
		this.dataCalcTime = dataCalcTime;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getSunRise() {
		return sunRise;
	}
	public void setSunRise(String sunRise) {
		this.sunRise = sunRise;
	}
	public String getSunSet() {
		return sunSet;
	}
	public void setSunSet(String sunSet) {
		this.sunSet = sunSet;
	}
	
	public void update() {
		// Updates weather using API...
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
