
import java.text.*;
import java.util.Scanner;

public class SuperPhoneCardInc {
    public static void main(String[] args) {
        CardTable ct = new CardTable();
        Scanner in = new Scanner(System.in);
        String line = null;
        boolean done = false;
      
        if (! in .hasNextLine()) {
            done = true;
        } else {
            line = in .nextLine();
        }
        
        if (!done && line.length() >= 4 && line.substring(0, 4).equals("quit")) {
            done = true;
        }
       
        // COMMAND PROMPTS
        
        while (!done) {
            System.out.println("Input: " + line);
            Scanner inl = new Scanner(line);
            String command = "";
            if (inl.hasNext()) {
                command = inl.next();
            }
            
            // 'ADD' COMMAND TO ADD PHONE CARDS
            
            if (command.equals("add")) {
                boolean invalidArgs = false;
                long no = 0;
                int passwd = 0;
                String cardType = null;
                if (inl.hasNextLong()) {
                    no = inl.nextLong();
                } 
                else {
                    invalidArgs = true;
                }
                
                if (!invalidArgs && inl.hasNextInt()) {
                    passwd = inl.nextInt();
                } 
                else {
                    invalidArgs = true;
                }
                
                if (!invalidArgs && inl.hasNext()) {
                    cardType = inl.next();
                } 
                else {
                    invalidArgs = true;
                }
               
                if (!invalidArgs && (no <= 0 || passwd <= 0)) {
                    invalidArgs = true;
                }
                PhoneCard card = null;
               
                if (!invalidArgs && cardType.equals("SuperNA10")) {
                    card = new SuperNA10Card(no, passwd);
                } else 
                	if (!invalidArgs && cardType.equals("Global10")) {
                    card = new Global10Card(no, passwd);
                } else
                	if (!invalidArgs && cardType.equals("Global25")) {
                    card = new Global25Card(no, passwd);
                } else {
                    invalidArgs = true;
                }
                
                
                if (invalidArgs) {
                    System.out.println("Error: invalid arguments for add command");
                } else if (ct.get(no) != null) {
                    System.out.println("Error: card no " + no + " already exists");
                } else if (!ct.add(card)) {
                    System.out.println("Error: card table full");
                } else {
                    System.out.println("Result: added card " + no);
                }
            
                // 'GET BALANCE' COMMAND TO GET THE BALANCE OF A PHONE CARD
                
            } else if (command.equals("getBalance")) {
                
            	boolean invalidArgs = false;
                long no = 0;
                int passwd = 0;
                if (inl.hasNextLong()) {
                    no = inl.nextLong();
                } else {
                    invalidArgs = true;
                }
                
                if (!invalidArgs && inl.hasNextInt()) {
                    passwd = inl.nextInt();
                } 
                else {
                    invalidArgs = true;
                }
                
                if (!invalidArgs && (no <= 0 || passwd <= 0)) {
                    invalidArgs = true;
                }
                
                if (invalidArgs) {
                    System.out.println("Error: invalid arguments for getBalance command");
                }
                	else {
                    PhoneCard card = ct.get(no);
                    if (card == null) {
                        System.out.println("Error: card no " + no + " does not exist");
                    } else 
                    	if (card.getPassword() != passwd) {
                        System.out.println("Error: password " + passwd + " incorrect");
                    } 		
                    	else {
                        System.out.printf("Result: card %d balance is %.2f%n",
                            no, card.getBalance());
                    }
                }
            
            // 'GET LIMIT' COMMAND TO GET THE NUMBER OF MINUTES A PHONE CARD HAS IN A PARTICULAR CALL ZONE
            
            } else if (command.equals("getLimit")) { // YOU MUST FILL THIS PART
                // OF THE DEFINITION
            	boolean invalidArgs = false;
                long no = 0;
                int passwd = 0;
                String callZone = "";
                if (inl.hasNextLong()) {
                    no = inl.nextLong();
                } else {
                    invalidArgs = true;
                }
                
                if (!invalidArgs && inl.hasNextInt()) {
                    passwd = inl.nextInt();
                } 
                else {
                    invalidArgs = true;
                }
                
                if (!invalidArgs && inl.hasNext()) {
                	callZone = inl.next();
                }
                else {
                	invalidArgs = true;
                }
                
                if (invalidArgs) {
                	System.out.println("Error: invalid arguments for getLimit command");
                }
                
                else {
                    PhoneCard card = ct.get(no);
                    if (card == null) {
                        System.out.println("Error: card no " + no + " does not exist");
                    } else 
                    	if (card.getPassword() != passwd) {
                        System.out.println("Error: password " + passwd + " incorrect");
                    } 		
                    	else
                    		if (!card.allowed(callZone)) {
                    			System.out.println("Error: card " + no + " not allowed for zone " + callZone );
                    		}
                    		else {
                    			System.out.println("Result: card " + no + " limit for zone " + callZone + " is " +  card.getLimit(callZone) +  " minutes");
                    		}
                }
                
                // CHARGE COMMAND TO DETERMINE WHETHER A PHONE CARD SHOULD BE CHARGED AND WHAT THE CHARGE IS
                   
            } else if (command.equals("charge")) { // YOU MUST FILL THIS PART
                // OF THE DEFINITION
            	boolean invalidArgs = false;
                long no = 0;
                int passwd = 0;
                String callZone = "";
                int minutes = 1;
                
                if (inl.hasNextLong()) {
                    no = inl.nextLong();
                } else {
                    invalidArgs = true;
                }
                
                if (!invalidArgs && inl.hasNextInt()) {
                    passwd = inl.nextInt();
                } 
                else {
                    invalidArgs = true;
                }
                
                if (!invalidArgs && inl.hasNext()) {
                	callZone = inl.next();
                }
                else {
                    invalidArgs = true;
                }
                
                if (!invalidArgs && inl.hasNextInt()){
                    minutes = inl.nextInt();
                }
                else {
                    invalidArgs = true;
                }
                
                if (invalidArgs){
                    System.out.println("Invalid arguments for charge command.");
                }
                
                else {
                    PhoneCard card = ct.get(no);
                    boolean isAllowed = true;
                    
                    if (card == null){
                        System.out.println("Error: card no " + no + "does not exist");
                        isAllowed = false;
                    }
                    else if (card.getPassword() != passwd){
                        System.out.println("Error: password " + passwd + " incorrect");
                        isAllowed = false;
                    }
                    else if (!card.allowed(callZone)){
                        System.out.println("Error: card " + no + " not allowed for zone " + callZone );
                        isAllowed = false;
                    }
                    else 
                       
                      if  (isAllowed)
                      {
                        double charge = minutes * card.costPerMin(callZone);
                    double newBal = card.getBalance() - charge;
                    NumberFormat DF = new DecimalFormat("0.##");
                     
                        if (!card.charge(minutes, callZone)){
                         System.out.println("Error: card " +  no +  " limit for zone " + callZone + " is " + card.getLimit(callZone) +  " minutes");
                    } else {
                    
                        System.out.println("Result: card " + no +  " charged " + DF.format(charge) +", new balance is " + DF.format(newBal));
                        }
                        }
                }
                // 'DEDUCTWEEKLYFEE' COMMAND TO DEDUCT THE WEEKLY FEE BASED ON THE TYPE OF PHONE CARD
                
            }
            else if (command.equals("deductWeeklyFee")) {
                PhoneCard card = ct.first();
                while (card != null) {
                    card.deductWeeklyFee();
                    System.out.printf("Result: card %d charged weekly fee%n",
                        card.getNumber());
                    card = ct.next();
                }
                System.out.println("Result: weekly fees deducted");
           
                // 'PRINTALL' COMMAND TO PRINT OUT ALL THE PHONE CARDS    
                
                } else if (command.equals("printAll")) {
                PhoneCard card = ct.first();
                while (card != null) {
                    System.out.printf("Result: %s%n", card);
                    card = ct.next();
                }
                System.out.println("Result: all cards printed");
            } else {
                System.out.println("Error: command invalid");
            }
            if (! in .hasNextLine()) {
                done = true;
            } else {
                line = in .nextLine();
            }
            if (!done && line.length() >= 4 && line.substring(0, 4).equals("quit")) {
                done = true;
            }
        }
    }
}
