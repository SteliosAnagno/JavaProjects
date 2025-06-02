
public class SMS extends Communication {
	private String content;

	public SMS(String number1, String nummber2, int day, int month, int year, String content) {
		super(number1, nummber2, day, month, year);
		this.content = content;
	}
	
	public boolean involves(String number1, String number2) {
        return (this.number1.equals(number1) && this.number2.equals(number2)) ||
               (this.number1.equals(number2) && this.number2.equals(number1));
    }
	
	public boolean isSuspicious() {
        return content.contains("Bomb") || content.contains("Attack") ||
               content.contains("Explosives") || content.contains("Gun");
    }
	
	

	public String getContent() {
		return content;
	}
	
	

	
	
	@Override
    public void printInfo() {
        System.out.println("SMS: " + number1 + " -> " + number2);
        System.out.println("Date: " + day + "/" + month + "/" + year);
        System.out.println("Message: " + content);
    }
	
	
	
	

}
