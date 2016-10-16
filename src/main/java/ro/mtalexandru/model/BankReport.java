package ro.mtalexandru.model;

public class BankReport {

	private int bankMinutes;
	private int exerciseMinutes;
	private String exerciseActivity;

	public BankReport(int bankMinutes, int exerciseMinutes, String exerciseActivity) {
		this.bankMinutes = bankMinutes;
		this.exerciseMinutes = exerciseMinutes;
		this.exerciseActivity = exerciseActivity;
	}
	
	public String getExerciseActivity() {
		return exerciseActivity;
	}
	public int getExerciseMinutes() {
		return exerciseMinutes;
	}
	public int getBankMinutes() {
		return bankMinutes;
	}
	public void setExerciseActivity(String exerciseActivity) {
		this.exerciseActivity = exerciseActivity;
	}
	public void setExerciseMinutes(int exerciseMinutes) {
		this.exerciseMinutes = exerciseMinutes;
	}
	public void setBankMinutes(int bankMinutes) {
		this.bankMinutes = bankMinutes;
	}
	
	
	
}
