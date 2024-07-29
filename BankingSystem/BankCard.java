
/**
 * Write a description of class BankCard here.
 *
 * @author (22067497 Shristi Rai)
 * @version (1.0.0)
 */
public class BankCard
{
    //attributes
    private int cardId;
    private String clientName;
    private String issuerBank;
    private String bankAccount;
    private double balanceAmount;
    
    //constructor
    public BankCard( int cardId, String issuerBank,String bankAccount,double balanceAmount)
    {
        clientName = "";
        this.cardId = cardId;
        this.issuerBank = issuerBank;
        this.bankAccount = bankAccount;
        this.balanceAmount = balanceAmount;
    }
    
    public int getCardId()
    {
        return cardId;
    }
    
    public String getClientName()
    {
        return clientName;
    }
    
    public String getIssuerBank()
    {
        return issuerBank;
    }
    
    public String getBankAccount()
    {
        return bankAccount;
    }
    
    public double getBalanceAmount()
    {
        return balanceAmount;
    }
    
    //setter method for clientName
    public void setClientName(String  clientName)
    {
        this.clientName = clientName; 
    }
    
    //setter method for balanceAmount
    public void setBalance(double balanceAmount)
    {
        this.balanceAmount = balanceAmount;
    }
    
    /**display method to display the values*/
    public void display(){
        if(clientName == " "){
            System.out.println("Unknown client");
        }
        else
        {
            System.out.println("Name: " + clientName);
        }
        System.out.println("Card ID: " + cardId);
        System.out.println("Issuer Bank: " + issuerBank);
        System.out.println("Account type: " + bankAccount);
        System.out.println("Balance: " + balanceAmount);
        
    }
}

