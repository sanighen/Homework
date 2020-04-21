package space;

public class Asteroid {

	private String date;
	private Float diamteter;
	private Double distance;
	private Boolean isHazardous;

	public Asteroid(String date, float diamteter, double distance, boolean isHazardous) {
		super();
		this.date = date;
		this.diamteter = diamteter;
		this.distance = distance;
		this.isHazardous = isHazardous;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Float getDiamteter() {
		return diamteter;
	}

	public void setDiamteter(Float diamteter) {
		this.diamteter = diamteter;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Boolean isHazardous() {
		return isHazardous;
	}

	public void setHazardous(Boolean isHazardous) {
		this.isHazardous = isHazardous;
	}

	@Override
	public String toString() {
		return date + ", diamteter=" + diamteter + ", distance=" + distance + ", isHazardous="
				+ isHazardous + "]";
	}

}