import java.util.ArrayList;

public abstract class Communication {
	protected String number1;
	protected String number2;
	protected int day;
	protected int month;
	protected int year;
	
	
	public Communication(String number1, String number2, int day, int month, int year) {
		this.number1 = number1;
		this.number2 = number2;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public boolean involves(Suspect suspect) {
        return suspect.hasNumber(number1) || suspect.hasNumber(number2);
    }
	
	 public static boolean existsCommunicationBetween(String number1, String number2) {
	        
	        return false; 
	    }
	 
	 public void updateSuspects(ArrayList<Suspect> suspects) {
	        Suspect suspect1 = findSuspectByNumber(number1, suspects);
	        Suspect suspect2 = findSuspectByNumber(number2, suspects);
	        if (suspect1 != null) suspect1.addPartner(suspect2);
	        if (suspect2 != null) suspect2.addPartner(suspect1);
	    }
	 
	 private Suspect findSuspectByNumber(String number, ArrayList<Suspect> suspects) {
	        for (Suspect suspect : suspects) {
	            if (suspect.hasNumber(number)) {
	                return suspect;
	            }
	        }
	        return null;
	    }

	
	 public abstract void printInfo();
	

}
