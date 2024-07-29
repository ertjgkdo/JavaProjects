
/**
 * Write a description of class CreditCard here.
 *
 * @author (22067497 Shristi Rai)
 * @version (1.0.0)
 */
public class CreditCard extends BankCard
{
    //attributes
    private int CVCnumber;
    private double creditLimit;
    private double interestRate;
    private String expirationDate;
    private int gracePeriod;
    private boolean isGranted;
    
    //constructor
    public CreditCard(  int cardId,  String clientName,String issuerBank, String bankAccount,double balanceAmount, int CVCnumber,
                      double interestRate, String expirationDate)
     {
        super( cardId,issuerBank,bankAccount,balanceAmount);
        super.setClientName(clientName);
        this.CVCnumber = CVCnumber;
        this.interestRate = interestRate;
        this.expirationDate = expirationDate;
        isGranted = false;
        
     }
     
     public int getCVCnumber()
     {
         return CVCnumber;
     }
     
     public double getCreditLimit()
     {
         return creditLimit;
     }
     
     public double getInterestRate()
     {
         return interestRate;
     }
     
     public String getExpirationDate()
     {
         return expirationDate;
     }
     
     public int getGracePeriod()
     {
         return gracePeriod;
     }
     
     public boolean getIsGranted()
     {
         return isGranted;
     }
      
     public void setCreditLimit(double creditLimit,int gracePeriod)
     {
         this.creditLimit = creditLimit;
         this.gracePeriod = gracePeriod;
         if(creditLimit<= (2.5 * super.getBalanceAmount()))
         {
             this.isGranted = true;
             System.out.println("The credit has been issued ");
         }
         else{
             System.out.println("The credit cannot be issued");
         }
     }
     
     public void cancelCreditCard()
     {
         CVCnumber = 0;
         creditLimit = 0;
         gracePeriod = 0;
         isGranted = false;
     }
     
     public void display()
     {
         if(isGranted)
         {
             super.display();
             System.out.println("Credit Limit: " + creditLimit);
             System.out.println("Grace period: " + gracePeriod);
         }
         else{
             System.out.println("Sorry, the credit could not be granted.");
            }
             System.out.println("Your CVC number is " + CVCnumber);
             System.out.println("The interest rate is " + interestRate);
             System.out.println("Your credit card expiration date is " + expirationDate);
         
     }
}
