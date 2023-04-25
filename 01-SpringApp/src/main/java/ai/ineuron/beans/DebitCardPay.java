package ai.ineuron.beans;

public class DebitCardPay implements IPay {

	 public DebitCardPay( ) {
	     System.out.println("Debit Card object is created by IOC");
	   }
	 
	    public boolean payBill(Double amt) {
	    System.out.println("Paying bill through debit card");
	    return true;

	 }

}
