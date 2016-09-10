
public class stats {
	private Integer max;
	private Double average;

	
	public Integer getMax() {
		return max;
	}


	public void setMax(Integer max) {
		this.max = max;
	}


	public Double getAverage() {
		return average;
	}


	public void setAverage(Double average) {
		this.average = average;
	}


	@Override
	public String toString() {
		return average + "," + max ;
	}
	
	
}
