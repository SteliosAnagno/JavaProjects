import java.util.ArrayList;
import java.util.List;

public class Registry {
	private ArrayList<Suspect> suspects = new ArrayList<>();
	private ArrayList<Communication> communications = new ArrayList<>();
	private ArrayList<PhoneCall> phonecalls = new ArrayList<>();
	
	public void addSuspect(Suspect suspect) {
        suspects.add(suspect);
    }
	
	public void addCommunication(Communication communication) {
        communications.add(communication);
        communication.updateSuspects(suspects);
    }
	
	
	 public Suspect getSuspectWithMostPartners() {
	        Suspect topSuspect = null;
	        int maxPartners = 0;
	        for (Suspect suspect : suspects) {
	            if (suspect.getPartners().size() > maxPartners) {
	                maxPartners = suspect.getPartners().size();
	                topSuspect = suspect;
	            }
	        }
	        return topSuspect;
	    }

		
	
	
	public PhoneCall getLongestPhoneCallBetween(String number1, String number2) {
	    PhoneCall longestCall = null;
	    int maxDuration = 0;
	    
	    for (Communication comm : communications) {
	        if (comm instanceof PhoneCall) {
	            PhoneCall call = (PhoneCall) comm;
	            if (call.involves(number1, number2)) {
	                int duration = call.getDuration();
	                if (duration > maxDuration) {
	                    maxDuration = duration;
	                    longestCall = call;
	                }
	            }
	        }
	    }
	    
	    return longestCall;
	}

	
	public ArrayList<SMS> getMessagesBetween(String number1, String number2) {
	    ArrayList<SMS> listOfMessages = new ArrayList<>();
	    String[] hotkeys = {"Bomb", "Attack", "Explosives", "Gun"};
	    
	    for (Communication comm : communications) {
	        if (comm instanceof SMS) {
	            SMS message = (SMS) comm;
	            if (message.involves(number1, number2)) {
	                String content = message.getContent();
	                for (String word : hotkeys) {
	                    if (content.contains(word)) {
	                        listOfMessages.add(message);
	                        break;  
	                    }
	                }
	            }
	        }
	    }
	    return listOfMessages;
	}

}


