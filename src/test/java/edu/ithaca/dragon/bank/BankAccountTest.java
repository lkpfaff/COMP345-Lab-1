package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class BankAccountTest {

    @Test
    void isAmountValidTest(){
        //Should return false if given amount is negative
        assertFalse(BankAccount.isAmountValid(-1));

        //Should return false if given amount has more than 2 decimal places
        assertFalse(BankAccount.isAmountValid(12.983));

        //Valid amount should return true
        assertTrue(BankAccount.isAmountValid(100.01));
    }

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        //New account for testing
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        //Balance should not change if amount is negative
        bankAccount.withdraw(-50);
        assertEquals(200, bankAccount.getBalance());

        //Balance should not change if given amount is large than current balance
        bankAccount.withdraw(250);
        assertEquals(200, bankAccount.getBalance());

        //Balance should be reduced by 50
        bankAccount.withdraw(50);
        assertEquals(150, bankAccount.getBalance());

    }

    @Test
    void isEmailValidTest(){
        //Email cannot be empty
        assertFalse(BankAccount.isEmailValid(""));
        //Should fail because address cannot have whitespace
        assertFalse(BankAccount.isEmailValid("te st@test.com"));
        //Should fail because address must have an '@' symbol
        assertFalse(BankAccount.isEmailValid("testtest.com"));
        //Should fail because there must be a domain at the end
        assertFalse(BankAccount.isEmailValid("test@.com"));
        //Should fail because there must be characters before the '@'
        assertFalse(BankAccount.isEmailValid("@test.com"));
        //Should fail because there must be a '.' right of the '@'
        assertFalse(BankAccount.isEmailValid("test@test"));
        //Should fail because there must be at least 2 characters after the '.'
        assertFalse(BankAccount.isEmailValid("test@test.a"));

        //Valid email address, should pass
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //Throw exception for negative balance
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@a.com", -50));

        //Throw exception for balance with more than 2 decimals
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@a.com", 50.056));

        //Throw exception for invalid email address
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}