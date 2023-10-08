package com.techelevator;

import com.techelevator.items.CandyStoreItem;
import com.techelevator.items.HardCandy;
import org.junit.*;
public class CashRegisterTest {

    CashRegister register;


    @Before
    public void run_before_each_test(){
        register = new CashRegister();
    }

    //addToBalance
    @Test
    public void add_to_balance_happy_path(){
        //register always starts at 0.0

        //Act
        register.addToBalance(43.20);

        //Assert
        Assert.assertEquals(43.20, register.getBalance(), .001);
    }

    @Test
    public void add_to_balance_negative_doesnt_work(){
        //register always starts at 0.0

        //Act
        register.addToBalance(-3.0);

        //Assert
        Assert.assertEquals(0.0 , register.getBalance(), .001);
    }
    @Test
    public void add_to_balance_more_than_100_wont_work(){
        //register always starts at 0.0

        //Act
        register.addToBalance(101.00);

        //Assert
        Assert.assertEquals(0.0 , register.getBalance(), .001);
    }

    @Test
    public void register_cant_go_over_1000(){
        //register always starts at 0.0
        //add 1000 dollars
        for (int i = 0; i < 10; i++) {
            register.addToBalance(100.00);
        }

        //Act
        //attempt to add another 50
        register.addToBalance(50.00);

        //Assert
        Assert.assertEquals(1000.0 , register.getBalance(), .001);
    }

    @Test
    public void remove_money_removes_appropriate_amount(){
        //ARRANGE
        register.addToBalance(100);
        CandyStoreItem newCandy = new HardCandy("Test Candy", "B4", 3.25, "Y");
        newCandy.setQuantity(4);

        //Act
        register.removeMoney(newCandy);

        //ASSERT
        Assert.assertEquals(87.00, register.getBalance(), .001);
    }

    @Test
    public void change_statement_provides_correct_denominations(){
        //ARRANGE
        register.addToBalance(100);
        CandyStoreItem newCandy = new HardCandy("Test Candy", "B4", 3.10, "Y");
        newCandy.setQuantity(3);
        register.removeMoney(newCandy);

        //ACT & ASSERT
        Assert.assertEquals("(4) Twenties (1) Tens (2) Quarters (2) Dimes ", register.changeStatement());

    }

    public void clear_register_resets_balance(){
        //ARRANGE
        register.addToBalance(100);
        register.clearRegister();

        //ACT & ASSERT
        Assert.assertEquals(0.00 , register.getBalance());

    }


}
