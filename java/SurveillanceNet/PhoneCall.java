
public class PhoneCall extends Communication {
	private int duration;

	public PhoneCall(String number1, String number2, int day, int month, int year ,int duration) {
		super(number1,number2,day,month,year);
		this.duration = duration;
	}
	
	 public boolean involves(String number1, String number2) {
	        return (this.number1.equals(number1) && this.number2.equals(number2)) ||
	               (this.number1.equals(number2) && this.number2.equals(number1));
	    }


	public int getDuration() {
		return duration;
	}
	
	
	 @Override
	    public void printInfo() {
	        System.out.println("Phone Call: " + number1 + " -> " + number2);
	        System.out.println("Date: " + day + "/" + month + "/" + year);
	        System.out.println("Duration: " + duration + " seconds");
	    }
	
	

	
	
	
	
	




}
