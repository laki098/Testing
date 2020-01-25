/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class ShopItemTest {

    private ShopItem shop;
    
    public ShopItemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        shop = new ShopItem(1, "Laptop", 500.0F, 10);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class ShopItem.
     */
    @Test
    public void testGetName() {
        String result = shop.getName();
        assertEquals("Laptop", result);
    }

    /**
     * Test of setName method, of class ShopItem.
     */
    @Test
    public void testSetName() {
        shop.setName("Graficka");
        assertEquals("Graficka", shop.getName());
        
    }

    /**
     * Test of getPrice method, of class ShopItem.
     */
    @Test
    public void testGetPrice() {
        Float result = shop.getPrice();
        assertEquals(500.0F, result, 0.001);
        
    }

    /**
     * Test of setPrice method, of class ShopItem.
     */
    @Test
    public void testSetPrice() {
        shop.setPrice(300.0F);
        assertEquals(300.0F, shop.getPrice(), 0.01);
        
    }

    /**
     * Test of getAmount method, of class ShopItem.
     */
    @Test
    public void testGetAmount() {
        Integer result = shop.getAmount();
        assertEquals(10, result, 0.01);
        
    }

    /**
     * Test of setAmount method, of class ShopItem.
     */
    @Test
    public void testSetAmount() {
        shop.setAmount(5);
        Integer result = shop.getAmount();
        assertEquals(5, result, 0.01);
        
    }
    
}
