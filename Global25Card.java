public class Global25Card extends PhoneCard {

	public Global25Card(long no, int passwd, double bal) {
		super(no, passwd, bal);
		super.setBalance(25);
}

     public Global25Card(long no, int passwd){
        super(no, passwd);
        bal = 25.0;
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
		return CallZone.isValidZone(zone);
	}
	
	// Overrides the abstract method costPerMin
	public double costPerMin(String zone) {
		zone = zone.toLowerCase();

		if (zone.equals("canada")) {
		return 0.05;
	   }
		else {
			if (zone.equals("europe")) {
				return 0.20;
			}
			else {
				if (zone.equals("asia") || zone.equals("africa")) {
					return 0.40;
				}
				else {
					if(zone.equals("anz") || zone.equals("latinam")) {
						return 0.30;
					}
					else {
						return 0.10;
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