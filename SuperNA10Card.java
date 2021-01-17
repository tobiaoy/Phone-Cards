public class SuperNA10Card extends PhoneCard {

    public SuperNA10Card(long no, int passwd, double bal) {
		super(no, passwd, bal);
		super.setBalance(10.0);
}
    public SuperNA10Card(long no, int passwd){
        super(no, passwd);
        bal = 10.0;
    }
	
    // Overrides the getLimit method in PhoneCard
	public int getLimit(String zone) {
    return (int)(super.getBalance() / costPerMin(zone));
	}
	
	// Overrides the charge method in PhoneCard
	public boolean charge (int minutes, String zone) {
	double charge = minutes * costPerMin(zone);
        if (charge > bal){
            return false;
        }
        else{
            return true;
        }
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
	 double p = super.getBalance();
        p -= 0.50;
		
	}
}