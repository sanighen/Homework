package astro;

public class Asteroid {

	private String date;
	private Float diameter;
	private Double distance;
	private Boolean hazardous;

	public Asteroid(String date, float diameter, double distance, boolean hazardous) {
		super();
		this.date = date;
		this.diameter = diameter;
		this.distance = distance;
		this.hazardous = hazardous;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Float getDiameter() {
		return diameter;
	}

	public void setDiameter(Float diameter) {
		this.diameter = diameter;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Boolean isHazardous() {
		return hazardous;
	}

	public void setHazardous(Boolean hazardous) {
		this.hazardous = hazardous;
	}

	@Override
	public String toString() {
		return date + ", diamteter=" + diameter + ", distance=" + distance + ", isHazardous="
				+ hazardous + "]";
	}

}