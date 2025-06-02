import java.util.ArrayList;
import java.util.List;

public class Suspect {
	private String name;
	private String CodeName;
	private String city;
	private ArrayList<String> phoneNumbers = new ArrayList<>();
	private ArrayList<Suspect> partners = new ArrayList<>();
	private ArrayList<Communication> communications = new ArrayList<>();
	
	
	public Suspect(String name, String codename, String city) {
		this.name = name;
		this.CodeName = codename;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public String getCodeName() {
		return CodeName;
	}
	
	
	public ArrayList<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void addNumber(String aNumber) {
		if(!phoneNumbers.contains(aNumber)) {
			phoneNumbers.add(aNumber);
		}
		else
			System.out.println("Number: "+ aNumber +"already exist!");
		
	}
	
	public void addPartner(Suspect suspect) {
        if (!partners.contains(suspect)) {
            partners.add(suspect);
        }
    }
	
	public boolean hasNumber(String number) {
        return phoneNumbers.contains(number);
    }
	
	
	
	public boolean isConnectedTo(Suspect otherSuspect) {
        for (String number1 : phoneNumbers) {
            for (String number2 : otherSuspect.phoneNumbers) {
                if (Communication.existsCommunicationBetween(number1, number2)) {
                    return true;
                }
            }
        }
        return false;
    }


	

	 public void addSuspects(Suspect aPartner) {
		    System.out.println("Attempting to add partner: " + aPartner.getName());
		    if (!partners.contains(aPartner)) {
		        if (isConnectedTo(aPartner)) {
		            partners.add(aPartner);
		            aPartner.addSuspects(this); 
		            System.out.println("Added partners: " + this.getName() + " <-> " + aPartner.getName());
		        } else {
		            System.out.println(this.getName() + " and " + aPartner.getName() + " have not communicated.");
		        }
		    } else {
		        System.out.println(aPartner.getName() + " has already been a partner.");
		    }
		}


	

			
		
	
	 public ArrayList<Suspect> getCommonPartners(Suspect otherSuspect) {
	        ArrayList<Suspect> commonPartners = new ArrayList<>();
	        for (Suspect partner : this.partners) {
	            if (otherSuspect.partners.contains(partner)) {
	                commonPartners.add(partner);
	            }
	        }
	        return commonPartners;
	    }
	 
	
	public void printPartners() {
		if(partners.isEmpty()) {
			System.out.println(this.name + "has no partners");
		}else {
			System.out.println(this.name + "s potential partners");
			for(Suspect partner : partners) {
				System.out.println("Name" + partner.getName() + "Codename" + partner.getCodeName() );
			}
		
		}
	}

	public ArrayList<Suspect> getPartners() {
		return partners;
	}
	
	public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Codename: " + CodeName);
        System.out.println("City: " + city);
        System.out.println("Phone Numbers: " + phoneNumbers);
    }
	
	
	
	
	
}


		
	
	
	
	
	
	
	


