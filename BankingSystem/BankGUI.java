
/**
 * Write a description of class BankGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BankGUI implements ActionListener
{
    //declare all components here
    private JFrame frame;
    private JLabel heading;
    private JButton clearBtn;

    //debit card components
    private JLabel dcLabel, cardId1, clientName1, issuerBank1, bankAccount1, balanceAmount1,pin1, WcardId, wdAmount, date, Wpin;
    private JTextField cardId1Txt,clientName1Txt, issuerBank1Txt, bankAccount1Txt, balanceAmount1Txt, pin1Txt, WcardIdTxt, wdAmountTxt, WpinTxt  ;
    private JButton dcAdd,withdrawBtn, dcDisplay; 
    private JComboBox dayCombo1,monthCombo1, yearCombo1 ;
    private JSeparator firstSeparator;

    //credit card components
    private JLabel ccLabel, cardId2, clientName2, issuerBank2, bankAccount2, balanceAmount2, cvcNo, interestRate, expirationDate, ScardId, ScreditLimit, gracePeriod;
    private JTextField cardId2Txt, clientName2Txt, issuerBank2Txt, bankAccount2Txt, balanceAmount2Txt, cvcNoTxt, interestRateTxt, ScardIdTxt, ScreditLimitTxt, gracePeriodTxt;
    private JButton ccAdd, setclBtn, cancelcardBtn, ccDisplay;
    private JComboBox dayCombo2, monthCombo2, yearCombo2;
    private JSeparator secondSeparator;

    //arraylist for the objects
    ArrayList<BankCard>Card = new <BankCard>ArrayList();

    //instances of debit and credit cards
    DebitCard debitC ;
    CreditCard creditC;

    public BankGUI(){
        //code for the actual GUI
        frame = new JFrame("Bank Card Details");
        heading = new JLabel("Bank Card Details");

        //FONTS:
        Font mainHeading = new Font("Dialog", Font.BOLD,24);
        Font secondHeading = new Font("Dialog",Font.BOLD,18);
        Font forLabels = new Font("DialogInput",Font.BOLD,12);
        //CREATE GUI FOR DEBIT CARD
        //components for adding debit card:
        //Labels:
        dcLabel = new JLabel("Debit Card");
        cardId1 = new JLabel("Card ID:");
        clientName1 = new JLabel("Client Name:");
        issuerBank1 = new JLabel("Issuer Bank:");
        bankAccount1 = new JLabel("Bank Account:");
        balanceAmount1 = new JLabel("Balance Amount:");
        pin1 = new JLabel("PIN:");
        //Textfields
        cardId1Txt = new JTextField();
        clientName1Txt = new JTextField();
        issuerBank1Txt = new JTextField();
        bankAccount1Txt = new JTextField();
        balanceAmount1Txt = new JTextField();
        pin1Txt = new JTextField();
        //Button:
        dcAdd = new JButton("Add Debit Card");
        //Separator:
        firstSeparator = new JSeparator();

        //components for withdrawal portion
        //Labels:
        WcardId = new JLabel("Card ID:"); 
        wdAmount = new JLabel("Withdrawal Amount:");
        date = new JLabel("Date:");
        Wpin = new JLabel("PIN:");
        //Textfields:
        WcardIdTxt = new JTextField();
        wdAmountTxt = new JTextField();
        WpinTxt = new JTextField();
        //ComboBox:
        Integer[] day = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
        dayCombo1 = new JComboBox(day);
        String[] month = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        monthCombo1 = new JComboBox(month);
        Integer[] year = {2022,2023,2024,2025,2026,2027,2028,2029,2030};
        yearCombo1 = new JComboBox(year);
        //Buttons:
        withdrawBtn = new JButton("Withdraw");
        dcDisplay = new JButton("Display Debit Card");

        //SETTING FONTS:
        heading.setFont(mainHeading);
        dcLabel.setFont(secondHeading);
        cardId1.setFont(forLabels);
        clientName1.setFont(forLabels);
        issuerBank1.setFont(forLabels);
        bankAccount1.setFont(forLabels);
        balanceAmount1.setFont(forLabels);
        pin1.setFont(forLabels);
        WcardId.setFont(forLabels);
        wdAmount.setFont(forLabels);
        date.setFont(forLabels);
        Wpin.setFont(forLabels);

        //SETTING BOUNDS OF THE COMPONENTS OF DEBIT CARD:
        heading.setBounds(220, 17, 250, 34);
        //Labels:
        dcLabel.setBounds(103, 64, 105, 25);
        cardId1.setBounds(42, 106, 76, 20);
        clientName1.setBounds(42, 138, 105, 20);
        issuerBank1.setBounds(42, 170, 110, 20);
        bankAccount1.setBounds(42, 202, 125, 20);
        balanceAmount1.setBounds(42, 234, 140, 20);
        pin1.setBounds(42, 266, 45, 20);
        //TextFields:
        cardId1Txt.setBounds(175, 106, 157, 26);
        clientName1Txt.setBounds(175, 138, 157, 26);
        issuerBank1Txt.setBounds(175, 170, 157, 26);
        bankAccount1Txt.setBounds(175, 202, 157, 26);
        balanceAmount1Txt.setBounds(175, 234, 157, 26);
        pin1Txt.setBounds(175, 266, 157, 26);
        //Button:
        dcAdd.setBounds(115, 304, 119, 26);
        //Separator:
        firstSeparator.setBounds(42, 344, 295, 5);

        //bounds for the components of withdrawal portion
        //Labels:
        WcardId.setBounds(42, 358, 76, 20);
        wdAmount.setBounds(42, 390, 170, 20);
        date.setBounds(42, 422, 50, 20);
        Wpin.setBounds(42, 454, 45, 20);
        //Textfields
        WcardIdTxt.setBounds(175, 358, 157, 26);
        wdAmountTxt.setBounds(175, 390, 157, 26);
        WpinTxt.setBounds(175, 454, 159, 26);
        //ComboBox
        dayCombo1.setBounds(175, 422, 46, 26);
        monthCombo1.setBounds(225, 422, 54, 26);
        yearCombo1.setBounds(283, 422, 50, 26);  
        //Buttons
        withdrawBtn.setBounds(107, 503, 114, 28);
        dcDisplay.setBounds(66, 599, 217, 28);

        //CREATE GUI FOR CREDIT CARD:
        //Labels:
        ccLabel = new JLabel("Credit Card");
        cardId2 = new JLabel("Card ID:");
        clientName2 = new JLabel("Client Name:");
        issuerBank2 = new JLabel("Issuer Bank:");
        bankAccount2 = new JLabel("Bank Account:");
        balanceAmount2 = new JLabel("Balance Amount:");
        cvcNo = new JLabel("CVC No:");
        interestRate = new JLabel("Interest Rate:");
        expirationDate = new JLabel("Expiration date:");
        //Textfields:
        cardId2Txt = new JTextField();
        clientName2Txt = new JTextField();
        issuerBank2Txt = new JTextField();
        bankAccount2Txt = new JTextField();
        balanceAmount2Txt = new JTextField();
        cvcNoTxt = new JTextField();
        interestRateTxt = new JTextField();
        //ComboBox:
        dayCombo2 = new JComboBox(day);
        monthCombo2 = new JComboBox(month);
        yearCombo2 = new JComboBox(year);
        //Button:
        ccAdd = new JButton("Add Credit Card");
        //Separator:
        secondSeparator = new JSeparator();

        //COMPONENTS FOR SETTING A CREDIT LIMIT:
        //Labels:
        ScardId = new JLabel("Card ID:");
        ScreditLimit = new JLabel("Credit Limit:");
        gracePeriod = new JLabel("Grace Period:");
        //TextFields:
        ScardIdTxt = new JTextField();
        ScreditLimitTxt = new JTextField();
        gracePeriodTxt = new JTextField();
        //Buttons:
        setclBtn = new JButton("Set Credit Limit");
        cancelcardBtn = new JButton("Cancel Card");
        ccDisplay = new JButton("Display Credit Card");

        clearBtn= new JButton("Clear");

        //SETTING FONTS:
        ccLabel.setFont(secondHeading);
        cardId2.setFont(forLabels);
        clientName2.setFont(forLabels);
        issuerBank2.setFont(forLabels);
        bankAccount2.setFont(forLabels);
        balanceAmount2.setFont(forLabels);
        cvcNo.setFont(forLabels);
        interestRate.setFont(forLabels);
        expirationDate.setFont(forLabels);
        ScardId.setFont(forLabels);
        ScreditLimit.setFont(forLabels);
        gracePeriod.setFont(forLabels);

        //SETTING BOUNDS TO COMPONENTS OF ADDING CREDIT CARD:
        //Labels:
        ccLabel.setBounds(450, 64, 105, 25);
        cardId2.setBounds(372, 100, 76, 20);
        clientName2.setBounds(372, 138, 105, 20);
        issuerBank2.setBounds(372, 170, 110, 20);
        bankAccount2.setBounds(372, 202, 125, 20);
        balanceAmount2.setBounds(372, 234, 110, 20);
        cvcNo.setBounds(372, 266, 55, 20);
        interestRate.setBounds(372, 298, 115, 20);
        expirationDate.setBounds(372, 330, 160, 20);
        //Textfields
        cardId2Txt.setBounds(495, 100, 157, 26);
        clientName2Txt.setBounds(495, 132, 157, 26);
        issuerBank2Txt.setBounds(495, 164, 157, 26);
        bankAccount2Txt.setBounds(495, 196, 157, 26);
        balanceAmount2Txt.setBounds(495, 228, 157, 26);
        cvcNoTxt.setBounds(495, 260, 157, 26);
        interestRateTxt.setBounds(495, 292, 157,26);
        //ComboBox:
        dayCombo2.setBounds(495, 324, 45, 26);
        monthCombo2.setBounds(544, 324, 46, 26);
        yearCombo2.setBounds(595, 324, 57, 26);
        //Button:
        ccAdd.setBounds(440, 365, 130, 27);
        //Separator:
        secondSeparator.setBounds(370, 400, 288, 1);

        //SETTING BOUNDS TO COMPONENTS OF CANCELING CREDIT CARD:
        //Labels:
        ScardId.setBounds(372, 413, 76, 20);
        ScreditLimit.setBounds(372, 448, 100, 20);
        gracePeriod.setBounds(372, 483, 110, 20);
        //Textfields:
        ScardIdTxt.setBounds(495, 408, 157, 26);
        ScreditLimitTxt.setBounds(495, 442, 157, 26);
        gracePeriodTxt.setBounds(495, 476,157, 26);
        //Buttons:
        setclBtn.setBounds(379, 524, 121, 26);
        cancelcardBtn.setBounds(522, 524, 118, 26);
        ccDisplay.setBounds(407, 599, 217, 28);

        clearBtn.setBounds(283, 662, 114, 28);

        //connecting listener to all the sources
        dcAdd.addActionListener(this);
        withdrawBtn.addActionListener(this);
        dcDisplay.addActionListener(this);
        ccAdd.addActionListener(this);
        setclBtn.addActionListener(this);
        cancelcardBtn.addActionListener(this);
        ccDisplay.addActionListener(this);
        clearBtn.addActionListener(this);

        dayCombo1.addActionListener(this);
        dayCombo2.addActionListener(this);
        monthCombo1.addActionListener(this);
        monthCombo2.addActionListener(this);
        yearCombo1.addActionListener(this);
        yearCombo2.addActionListener(this);

        //adding the components to the frame
        frame.add(heading);
        //DEBIT CARD COMPONENTS:
        //Labels:
        frame.add(dcLabel);
        frame.add(cardId1);
        frame.add(clientName1);
        frame.add(issuerBank1);
        frame.add(bankAccount1);
        frame.add(balanceAmount1);
        frame.add(pin1);
        frame.add(WcardId);
        frame.add(wdAmount);
        frame.add(date);
        frame.add(Wpin);
        //Textfields:
        frame.add(cardId1Txt);
        frame.add(clientName1Txt);
        frame.add(issuerBank1Txt);
        frame.add(bankAccount1Txt);
        frame.add(balanceAmount1Txt);
        frame.add(pin1Txt);
        frame.add(WcardIdTxt);
        frame.add(wdAmountTxt);
        frame.add(WpinTxt);
        //Buttons:
        frame.add(dcAdd);
        frame.add(withdrawBtn);
        frame.add(dcDisplay);
        //Separator:
        frame.add(firstSeparator);
        frame.add(secondSeparator);
        //ComboBox:
        frame.add(dayCombo1);
        frame.add(monthCombo1);
        frame.add(yearCombo1);

        //CREDITCARD COMPONENTS:
        //Labels:
        frame.add(ccLabel);
        frame.add(cardId2);
        frame.add(clientName2);
        frame.add(issuerBank2);
        frame.add(bankAccount2);
        frame.add(balanceAmount2);
        frame.add(cvcNo);
        frame.add(interestRate);
        frame.add(expirationDate);
        frame.add(ScardId);
        frame.add(ScreditLimit);
        frame.add(gracePeriod);
        //Textfields:
        frame.add(cardId2Txt);
        frame.add(clientName2Txt);
        frame.add(issuerBank2Txt);
        frame.add(bankAccount2Txt);
        frame.add(balanceAmount2Txt);
        frame.add(cvcNoTxt);
        frame.add(interestRateTxt);
        frame.add(ScardIdTxt);
        frame.add(ScreditLimitTxt);
        frame.add(gracePeriodTxt);
        //ComboBox:
        frame.add(dayCombo2);
        frame.add(monthCombo2);
        frame.add(yearCombo2);
        //Buttons:
        frame.add(ccAdd);
        frame.add(setclBtn);
        frame.add(cancelcardBtn);
        frame.add(ccDisplay);
        frame.add(clearBtn);

        frame.setSize(720, 720);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //
    }

    public void actionPerformed(ActionEvent e){
        //FOR DEBIT CARD:
        if(e.getSource()==dcAdd){
            //checking if the textfields are empty
            if(cardId1Txt.getText().isEmpty()||
            clientName1Txt.getText().isEmpty()||
            issuerBank1Txt.getText().isEmpty()||
            bankAccount1Txt.getText().isEmpty() ||
            balanceAmount1Txt.getText().isEmpty() || 
            pin1Txt.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please input all the details", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);
            }else{
                try{
                    //get all the values into parameters
                    int cardId = Integer.parseInt(cardId1Txt.getText());
                    String clientName = clientName1Txt.getText();
                    String issuerBank = issuerBank1Txt.getText();
                    String bankAccount = bankAccount1Txt.getText();
                    double balanceAmount = Double.parseDouble(balanceAmount1Txt.getText());
                    int PINnumber = Integer.parseInt(pin1Txt.getText());
                    
                    //checking the input values
                    if(!(clientName.matches("[a-zA-Z]+"))){
                        JOptionPane.showMessageDialog(frame, "Please enter alphabetic values only!", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if(!(issuerBank.matches("[a-zA-Z]+"))){
                        JOptionPane.showMessageDialog(frame, "Please enter alphabetic values only!", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if(!(bankAccount.matches("[a-zA-Z]+"))){
                        JOptionPane.showMessageDialog(frame, "Please enter alphabetic values only!", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (Card.isEmpty()){
                        //creating an instance of DebitCard
                        debitC = new DebitCard( cardId, clientName, issuerBank, bankAccount, balanceAmount, PINnumber);
                        Card.add(debitC);
                        JOptionPane.showMessageDialog(frame, "Debit Card has been successfully added!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        boolean CardIsUnique = true;
                        for (BankCard debitC : Card){
                            if(debitC instanceof DebitCard){
                                //downcasting the BankCard obj into a DebitCard instance
                                DebitCard newCard = (DebitCard) debitC;
                                if(debitC.getCardId() == cardId){
                                    CardIsUnique = false;
                                    JOptionPane.showMessageDialog(frame, "The card with the entered details already exists!", "CARD EXISTS",JOptionPane.WARNING_MESSAGE);
                                    break;
                                }
                            }
                        }
                        if(CardIsUnique){
                            debitC = new DebitCard( cardId, clientName, issuerBank, bankAccount, balanceAmount, PINnumber);
                            Card.add(debitC);
                            JOptionPane.showMessageDialog(frame, "Debit Card has been successfully added!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Invalid input.Please enter correct values.","ERROR", JOptionPane.ERROR_MESSAGE);
                }
                }
        }
        if(e.getSource() ==withdrawBtn){
            //checking if the textfields are empty
            if (WcardIdTxt.getText().isEmpty()||
            wdAmountTxt.getText().isEmpty()||
            WpinTxt.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please enter all the details", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);
            }else{
                try{
                    //get all the values into parameters
                    int cardId = Integer.parseInt(WcardIdTxt.getText());
                    int withdrawalAmount = Integer.parseInt(wdAmountTxt.getText());
                    int PINnumber = Integer.parseInt(WpinTxt.getText());
                    Double balanceAmount = Double.parseDouble(balanceAmount1Txt.getText());
                    String dateOfWithdrawal = dayCombo1.getSelectedItem().toString() + "/" + monthCombo1.getSelectedItem().toString() + "/" + yearCombo1.getSelectedItem().toString();
                    String popup = "Card ID: " + cardId +"\n"+ "Withdrawal Amount: " + withdrawalAmount + "\n" + "Date of Withdrawal: " + dateOfWithdrawal + "\n" + "PIN number: " + PINnumber;
                    boolean debitCardExists = false;
                    for(BankCard debitC : Card){
                        if(debitC instanceof DebitCard &&debitC.getCardId() == cardId){
                            //downcasting BankCard object into a DebitCard intance
                            DebitCard withdrawCard = (DebitCard) debitC;
                            debitCardExists = true;
                            //checking whether the pin is correct
                            if(withdrawCard.getPINnumber() == PINnumber){
                                //checking if sufficient balance present
                                if(withdrawalAmount <= withdrawCard.getBalanceAmount()){
                                    //attempt to withdraw 
                                    withdrawCard.withDraw(withdrawalAmount, dateOfWithdrawal, PINnumber);
                                    JOptionPane.showMessageDialog(frame, popup , "WITHDRAWAL SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                                }else{
                                    JOptionPane.showMessageDialog(frame, "Insufficient Balance! The amount could not be withdrawn", "WITHDRAWAL FAIL", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }else{
                                JOptionPane.showMessageDialog(frame, "Invalid Pin number!", "WITHDRAWAL ERROR", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    }
                    if(!debitCardExists){
                        JOptionPane.showMessageDialog(frame, "Debit Card not found", "INVALID CARD ID", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Invalid input.Please enter correct values.","ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if(e.getSource() == dcDisplay){
            //checking if the text fields are left empty
            if(Card.isEmpty()){
                JOptionPane.showMessageDialog(frame, "The list is empty. No Debit Card to display", "LIST EMPTY", JOptionPane.INFORMATION_MESSAGE);
            }else{
                try{
                    //get the values into parameters
                    int cardId = Integer.parseInt(cardId1Txt.getText());
                    String clientName = clientName1Txt.getText();
                    String issuerBank = issuerBank1Txt.getText();
                    String bankAccount = bankAccount1Txt.getText();
                    double balanceAmount = Double.parseDouble(balanceAmount1Txt.getText());
                    int PINnumber = Integer.parseInt(pin1Txt.getText());

                    boolean cardExists = false;
                    for (BankCard debitC: Card){
                        if(debitC instanceof DebitCard && debitC.getCardId() == cardId){
                            //downcasting a BankCard obj to a DebitCard instance
                            DebitCard displayCard = (DebitCard) debitC;
                            displayCard.display();
                            cardExists = true;
                        }
                    }
                    if(!cardExists){
                        JOptionPane.showMessageDialog(frame, "Debit card not found", "INVALID CARD ID", JOptionPane.INFORMATION_MESSAGE);
                    }

                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Please input numeric values!", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if(e.getSource() == ccAdd){
            //checking if text fields are left empty
            if(cardId2Txt.getText().isEmpty()||
            clientName2Txt.getText().isEmpty()||
            issuerBank2Txt.getText().isEmpty()||
            bankAccount2Txt.getText().isEmpty() ||
            balanceAmount2Txt.getText().isEmpty() ||
            cvcNoTxt.getText().isEmpty()||
            interestRate.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please input all the details", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);
            }else{
                try{
                    //get all the values into the parameters
                    int cardId = Integer.parseInt(cardId2Txt.getText());
                    String clientName = clientName2Txt.getText();
                    String issuerBank = issuerBank2Txt.getText();
                    String bankAccount = bankAccount2Txt.getText();
                    double balanceAmount = Double.parseDouble(balanceAmount2Txt.getText());
                    int CVCnumber = Integer.parseInt(cvcNoTxt.getText());
                    double interestRate = Double.parseDouble(interestRateTxt.getText());
                    String expirationDate = dayCombo2.getSelectedItem().toString() + "/" + monthCombo2.getSelectedItem().toString() + "/" + yearCombo2.getSelectedItem().toString();

                    if(!(clientName.matches("[a-zA-Z]+"))){
                        JOptionPane.showMessageDialog(frame, "Please enter alphabetic values only!", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if(!(issuerBank.matches("[a-zA-Z]+"))){
                        JOptionPane.showMessageDialog(frame, "Please enter alphabetic values only!", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if(!(bankAccount.matches("[a-zA-Z]+"))){
                        JOptionPane.showMessageDialog(frame, "Please enter alphabetic values only!", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(Card.isEmpty()){
                        creditC = new CreditCard(cardId, clientName, issuerBank, bankAccount, balanceAmount, CVCnumber, interestRate, expirationDate);
                        Card.add(creditC);
                        JOptionPane.showMessageDialog(frame, "Credit Card has been successfully added!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        boolean CardIsUnique = true;
                        for(BankCard creditC : Card){
                            if(creditC instanceof CreditCard){
                                //downcasting a BankCard obj into a CreditCard instance
                                CreditCard newCard = (CreditCard) creditC;
                                if(creditC.getCardId() == cardId){
                                    CardIsUnique = false;
                                    JOptionPane.showMessageDialog(frame, "The card with the entered details already exists!", "CARD EXISTS",JOptionPane.WARNING_MESSAGE);
                                    break;
                                }
                            }
                        }
                        if(CardIsUnique){
                            creditC = new CreditCard(cardId, clientName, issuerBank, bankAccount, balanceAmount, CVCnumber, interestRate, expirationDate);
                            Card.add(creditC);
                            JOptionPane.showMessageDialog(frame, "Credit Card has been successfully added!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Invalid input.Please enter correct values.","INPUT ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if(e.getSource() ==setclBtn){
            if(ScardIdTxt.getText().isEmpty()|| ScreditLimitTxt.getText().isEmpty()|| gracePeriodTxt.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please fill all the details", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);
            }else{
                try{
                    //get the values into parameters
                    int cardId = Integer.parseInt(ScardIdTxt.getText());
                    double creditLimit = Double.parseDouble(ScreditLimitTxt.getText());
                    int gracePeriod = Integer.parseInt(gracePeriodTxt.getText());
                    String popup = "Credit Limit: " + creditLimit + "\n" + "Grace Period: " + gracePeriod;
                    boolean cardExists = false;
                    for(BankCard creditC : Card){
                        if (creditC instanceof CreditCard && creditC.getCardId()==cardId){
                            //downcasting a BankCard obj into a CreditCard instance
                            CreditCard newCard = (CreditCard) creditC;
                            newCard.setCreditLimit(creditLimit, gracePeriod);
                            JOptionPane.showMessageDialog(frame,popup +"\n" + "Credit Limit and Grace Period successfully updated", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                            cardExists = true;
                            break;
                        }
                    }
                    if(!cardExists){
                        JOptionPane.showMessageDialog(frame, "Credit Card not found", "INVALID CARD ID", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Please input numeric values!", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
        if(e.getSource() == cancelcardBtn){
            if(ScardIdTxt.getText().isEmpty()|| ScreditLimitTxt.getText().isEmpty()|| gracePeriodTxt.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please fill all the details", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);
            }
            try{
                int cardId = Integer.parseInt(ScardIdTxt.getText());
                boolean cardExists = false;

                for(BankCard creditC: Card){
                    if(creditC instanceof CreditCard && creditC.getCardId()==cardId){
                        ((CreditCard) creditC).cancelCreditCard();
                        JOptionPane.showMessageDialog(frame, "Credit card with ID " + cardId + " has been canceled.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        cardExists = true;
                        break;
                    }
                }
                if(!cardExists){
                    JOptionPane.showMessageDialog(frame, "Credit card with ID " + cardId + " does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Please input numeric values!", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);

            }
        }
        if(e.getSource()== ccDisplay){
            if(Card.isEmpty()){
                JOptionPane.showMessageDialog(frame, "The list is empty. No Credit Card to display", "EMPTY", JOptionPane.INFORMATION_MESSAGE);
            }else{
                try{
                    int cardId = Integer.parseInt(cardId2Txt.getText());
                    String clientName = clientName2Txt.getText();
                    String issuerBank = issuerBank2Txt.getText();
                    String bankAccount = bankAccount2Txt.getText();
                    double balanceAmount = Double.parseDouble(balanceAmount2Txt.getText());
                    int CVCnumber = Integer.parseInt(cvcNoTxt.getText());
                    double interestRate = Double.parseDouble(interestRateTxt.getText());
                    String expirationDate = dayCombo2.getSelectedItem().toString() + "/" + monthCombo2.getSelectedItem().toString() + "/" + yearCombo2.getSelectedItem().toString();

                    boolean cardExists = false;
                    for(BankCard creditC : Card){
                        if(creditC instanceof CreditCard && creditC.getCardId() == cardId){
                            CreditCard displayCard = (CreditCard) creditC;
                            displayCard.display();
                            cardExists = true;
                        }
                    }
                    if(!cardExists){
                        JOptionPane.showMessageDialog(frame, "Credit Card not found!", "INVALID CARD ID", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Please enter numeric values!", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
        if(e.getSource()== clearBtn){
            //creating an arraylist to add all the JTextFields and JComboBoxes to be cleared
            JTextField[] textFields = {cardId1Txt,clientName1Txt, issuerBank1Txt, bankAccount1Txt, balanceAmount1Txt, pin1Txt, WcardIdTxt, wdAmountTxt, WpinTxt,cardId2Txt, clientName2Txt, issuerBank2Txt, bankAccount2Txt, balanceAmount2Txt, cvcNoTxt, interestRateTxt, ScardIdTxt, ScreditLimitTxt, gracePeriodTxt};
            JComboBox[] comboBoxes = {dayCombo1, monthCombo1, yearCombo1, dayCombo2, monthCombo2, yearCombo2};
            
            for(JTextField textField : textFields){
                textField.setText("");
            }

            for(JComboBox comboBox : comboBoxes){
                comboBox.setSelectedIndex(0);
            }
        }
    }

    public static void main(String [] args){
        BankGUI obj = new BankGUI();
    }
}
