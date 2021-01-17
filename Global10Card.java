public class Global10Card extends PhoneCard{

	public Global10Card(long no, int passwd, double bal) {
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
		return CallZone.isValidZone(zone);
	    }
	
	// Overrides the abstract method costPerMin
	public double costPerMin(String zone) {
		zone = zone.toLowerCase();

		if (zone.equals("canada")) {
		return 0.07;
	   }
	
		else {
			if (zone.equals("europe")) {
				return 0.30;
			}
			else {
				if (zone.equals("asia") || zone.equals("africa")) {
					return 0.60;
				}
				else {
					if(zone.equals("anz") || zone.equals("latinam")) {
						return 0.45;
					}
					else {
						return 0.15;
					}
				}
			}
        }
	
    }
	
	// Overrides the abstract method deductWeeklyFee
	public void deductWeeklyFee() {
		bal -= 1.00;	
	}
    
}