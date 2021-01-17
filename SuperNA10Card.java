public class SuperNA10Card extends PhoneCard {

    public SuperNA10Card(long no, int passwd, double bal) {
		super(no, passwd, bal);
		super.setBalance(10.0);
}
	
    // Overrides the getLimit method in PhoneCard
	public int getLimit(String zone) {
    return (int)(super.getBalance() / costPerMin(zone));
	}
	
	// Overrides the charge method in PhoneCard
	public boolean charge (int minutes, String zone) {
		minutes = (int)(super.getBalance() / costPerMin(zone));
		 	return (minutes > 0);
    }
	
	// Overrides the abstract method allowed
	public boolean allowed(String zone) {
		 zone = zone.toLowerCase();
	        return (zone.equals("canada") ||
	            zone.equals("usa"));
	}
	
	// Overrides the abstract method costPerMin
	public double costPerMin(String zone) {
		zone = zone.toLowerCase();
		if (zone.equals("canada")) {
			return 0.05;
		}
		else {
			return 0.10;
		}
	}
	
	// Overrides the abstract method deductWeeklyFee
	public void deductWeeklyFee() {
		bal -= 0.50;
		
	}
}