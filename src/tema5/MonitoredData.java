package tema5;

public class MonitoredData {
	private String startTime;
	private String endTime;
	private String activityLabel;

	public MonitoredData(String linie) {
		String[] data = linie.split("\t");

		try {

			this.startTime = data[0] + " " + data[1];
			this.endTime = data[2] + " " + data[3];
			this.activityLabel = data[4];
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public MonitoredData(String startTime, String endTime, String activityLabel) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.activityLabel = activityLabel;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getDate() {
		return startTime.substring(0, 10);
	}

	public Integer getDay() {
		return Integer.parseInt(startTime.substring(8, 10));
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getActivityLabel() {
		return activityLabel;
	}

	public void setActivityLabel(String activityLabel) {
		this.activityLabel = activityLabel;
	}
}
