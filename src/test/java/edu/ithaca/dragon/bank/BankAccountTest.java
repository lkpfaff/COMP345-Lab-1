package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance());
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
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}