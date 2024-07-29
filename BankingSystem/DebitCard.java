
/**
 * Write a description of class DebitCard here.
 *
 * @author (22067497 Shristi Rai)
 * @version (1.0.0)
 */

 public class DebitCard extends BankCard
{
    //attributes
    private int PINnumber;
    private int withdrawalAmount;
    private String dateOfWithdrawal;
    private boolean hasWithdrawn;
    
      //constructor
       public DebitCard(int cardId,  String clientName, String issuerBank, String bankAccount,double balanceAmount,int PINnumber)
       {
        //call the superclass constructor
            super( cardId, issuerBank,bankAccount, balanceAmount );
        // call the setclientName
            super.setClientName(clientName);
        //assigning values to attributes
            this.PINnumber = PINnumber;
            hasWithdrawn = false;
        
       }
      //4 accessor(getter) and 1 mutator(setter) for the parameters
       public int getPINnumber()
       {
          return PINnumber;
       }

        
       public int getWithdrawalAmount()
       {
          return withdrawalAmount;
       }
        
       public String getDateOfWithdrawal()
       {
          return dateOfWithdrawal;
       }  
        
       public boolean getHasWithdrawn()
       {
          return hasWithdrawn;
       }
        
       public void setWithdrawalAmount(int withdrawalAmount)
      {
          this.withdrawalAmount = withdrawalAmount;
      }
        
       public void withDraw(int withdrawalAmount,String dateOfWithdrawal,int PINnumber)
       {
         //checking if PIN is valid and sufficient amount is present in the bank account
         if(this.PINnumber == PINnumber)
         {
             if(withdrawalAmount<= super.getBalanceAmount())
             {
                  //withdraw
                 this.hasWithdrawn = true;
                 //deducting withdrawn amount from the balance amount
                 super.setBalance(super.getBalanceAmount()-(withdrawalAmount));
                 this.dateOfWithdrawal = dateOfWithdrawal;
                 this.withdrawalAmount = withdrawalAmount;
                 System.out.println("The amount has been successfully withdrawn.");
             }else{
                 System.out.println("Your account has insufficient balance.");
             }
            }else{
             System.out.println("Incorrect PIN entered!!");
         }
       
        
       }
     public void display()//same signature as of display method from BankCard
    {
        //call the display method of bankCard
        super.display();
        //display PIN, dateOfWithdrawal and withdrawalAmount
        System.out.println("PIN Number: " + PINnumber);
        if(hasWithdrawn)
        {
        System.out.println("Withdrawal Amount: " + withdrawalAmount);
        System.out.println("The date of withdrawal: " + dateOfWithdrawal);
        }else{
           System.out.println(" Your balance is: " + super.getBalanceAmount() + ". No transaction was carried out."); 
        }
    }
}






