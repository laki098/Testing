/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lazar
 */
public class TransactionTest {

    private static Date date;

    private Transaction transaction;
    
    public TransactionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        date = new Date();
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
        transaction = new Transaction(Integer.getInteger("1"), 15000.0F, 5, date, 1, 1, 1, 25.0F);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTotalPrice method, of class Transaction.
     */
    @Test
    public void testGetTotalPrice() {
        Float result = transaction.getTotalPrice();
        assertEquals(15000.0F, result, 0.001);
        
    }

    /**
     * Test of setTotalPrice method, of class Transaction.
     */
    @Test
    public void testSetTotalPrice() {
        transaction.setTotalPrice(5000.0F);
        Float result = transaction.getTotalPrice();
        assertEquals(5000.0F, result, 0.01);
        
    }

    /**
     * Test of getAmount method, of class Transaction.
     */
    @Test
    public void testGetAmount() {
        int result = transaction.getAmount();
        assertEquals(5, result, 0.01);
        
    }

    /**
     * Test of setAmount method, of class Transaction.
     */
    @Test
    public void testSetAmount() {
        transaction.setAmount(10);
        int result = transaction.getAmount();
        assertEquals(10, result, 0.01);
       
    }

    /**
     * Test of getDate method, of class Transaction.
     */
    @Test
    public void testGetDate() {
        Date result = transaction.getDate();
        assertEquals(date, result);
       
    }

    /**
     * Test of setDate method, of class Transaction.
     */
    @Test
    public void testSetDate() {
        Date newDate = new Date();
        newDate.setDate(1);
        newDate.setMonth(2);
        newDate.setYear(2021);
        transaction.setDate(newDate);
        assertEquals(newDate, transaction.getDate());
       
    }

    /**
     * Test of getClientId method, of class Transaction.
     */
    @Test
    public void testGetClientId() {
        int result = transaction.getClientId();
        assertEquals(1,result);
        
    }

    /**
     * Test of setClientId method, of class Transaction.
     */
    @Test
    public void testSetClientId() {
        transaction.setClientId(2);
        int result = transaction.getClientId();
        assertEquals(2,result);
        
    }

    /**
     * Test of getShopItemId method, of class Transaction.
     */
    @Test
    public void testGetShopItemId() {
        int result = transaction.getShopItemId();
        assertEquals(1,result);
        
    }

    /**
     * Test of setShopItemId method, of class Transaction.
     */
    @Test
    public void testSetShopItemId() {
        transaction.setShopItemId(2);
        int result = transaction.getShopItemId();
        assertEquals(2,result);
        
    }

    /**
     * Test of getDeliveryServiceId method, of class Transaction.
     */
    @Test
    public void testGetDeliveryServiceId() {
        int result = transaction.getDeliveryServiceId();
        assertEquals(1,result);
       
    }

    /**
     * Test of setDeliveryServiceId method, of class Transaction.
     */
    @Test
    public void testSetDeliveryServiceId() {
        transaction.setDeliveryServiceId(2);
        int result = transaction.getDeliveryServiceId();
        assertEquals(2,result);
        
    }

    /**
     * Test of getDistance method, of class Transaction.
     */
    @Test
    public void testGetDistance() {
        Float result = transaction.getDistance();
        assertEquals(25.0F, result, 0.001);
        
    }

    /**
     * Test of setDistance method, of class Transaction.
     */
    @Test
    public void testSetDistance() {
        transaction.setDistance(30.0F);
        Float result = transaction.getDistance();
        assertEquals(30.0F, result, 0.001);
       
    }

    /**
     * Test of compareTo method, of class Transaction.
     */
    @Test
    public void testCompareTo() {
        Transaction secondTransaction = new Transaction();
        
        date = new Date();
        transaction.setDate(date);
        secondTransaction.setDate(date);
        assertEquals(0, transaction.compareTo(secondTransaction));
        
    }
    
}
