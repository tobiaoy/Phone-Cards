
import java.text.*;
abstract public class PhoneCard {

	private long no;
	private int passwd;
	private double bal;
	
	//constructor
	public PhoneCard(long no, int passwd, double bal) {
		if (no < 0) {
			System.out.println("that value is invalid");
		}
		else {
			this.no = no;
		}
		
		if (passwd < 0) {
			System.out.println("that value is invalid");
		}
		else {
			this.passwd = passwd;
		}
		
		this.bal = bal;
	}
	
// ACCESSORS
	
	//an accessor returning the card number
	public long getNumber () {
		return no;
	}
	
	//an accessor returning the card password
	public int getPassword() {
		return passwd;
	}
	
	//an accessor returning the card balance
	public double  getBalance() {
		return bal;
	}
	
	//a mutator to set the card balance
	public void setBalance(double b) {
		b = bal;
	}
	
// ABSTRACT METHODS	
	
	//a predicate that returns true if a call to the argument zone is allowed for the card 
	public abstract boolean allowed (String zone);

	//returns the cost per minute of a call to the argument zone 
	public abstract double costPerMin(String zone);
		
	//deducts the appropriate weekly fees from the card's balance, leaving it non-negative
	public abstract void deductWeeklyFee();
	
// METHODS TO BE OVERIDDEN	
	
	//returns the maximum number of minutes that can be charged for a call to the argument zone given the card's balance (truncated down to the next integer)
	public int getLimit(String zone) {

	return 0;
	}
	
	//tries to charge a call to the given zone with the given number of minutes to the card; if the balance is sufficient to cover it, it returns true and if the balance is not sufficient, it leaves it unchanged and returns false (precondition: minutes must be positive)
	public boolean charge(int minutes, String zone) {
	return true;
	}
	

	
	//returns the string "card no no has a balance of X.XX"
	public String toString() {
		NumberFormat DF = new DecimalFormat("0.##");
		return "card no " + getNumber() + " has a balance of " + DF.format(getBalance());
	}
}