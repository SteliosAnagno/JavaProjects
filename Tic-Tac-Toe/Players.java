
public class Players {
	
	private String name;
	private String symbol;
	
	
	public Players(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getSymbol() {
		
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	//Static για να μπορω να αλλαξω τους παιχτες
	public static Players SwitchPlayer(Players Current, Players p1, Players p2) {
		return Current == p1 ? p2 : p1;
	}
	


}
