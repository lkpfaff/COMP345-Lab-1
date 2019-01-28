package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     *
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @param amount the amount to be withdrawn from the account
     *
     * Does nothing if the given amount is a negative number
     * Does nothing if the given amount is larger than the current account balance
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount)  {
        //Negatives not allowed
        if (amount > 0){
            //Must be smaller than balance
            if (amount < this.balance){
                this.balance-=amount;
            }
        }

    }

    /**
     * Takes an email address and returns true or false depending on
     * whether it is a valid address
     *
     * A valid email address must have no whitespace,
     * must have an '@' in the middle,
     * must have characters before and after the @,
     * must have a '.' at least 2 characters to the left of the end of the address
     * must have characters between the '@' and the '.'
     *
     * @param email address to validate
     * @return true if email is valid, false if email is invalid
     *
     */

    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1){
            return false;
        }
        if (email.indexOf(' ') > 0){
            return false;
        }
        if ((email.lastIndexOf('.') - email.lastIndexOf('@') == 1)){
            return false;
        }
        if (email.indexOf('@') == 0){
            return false;
        }
        if ((email.lastIndexOf('.') - email.lastIndexOf('@') < 0)){
            return false;
        }
        if (email.length()- email.lastIndexOf('.') < 3){
            return false;
        }
        else {
            return true;
        }
    }
}
