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
public class DeliveryServiceTest {

    private DeliveryService service;
    
    public DeliveryServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        service = new DeliveryService(1, "Servis", 5000.0F, 30.0F);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class DeliveryService.
     */
    @Test
    public void testGetName() {
        String result = service.getName();
        assertEquals("Servis", result);
        
    }

    /**
     * Test of setName method, of class DeliveryService.
     */
    @Test
    public void testSetName() {
        service.setName("ServiceNew");
        assertEquals("ServiceNew", service.getName());
        
    }

    /**
     * Test of getStartingPrice method, of class DeliveryService.
     */
    @Test
    public void testGetStartingPrice() {
        Float result = service.getStartingPrice();
        assertEquals(5000.0F, result, 0.001);
        
    }

    /**
     * Test of setStartingPrice method, of class DeliveryService.
     */
    @Test
    public void testSetStartingPrice() {
        service.setStartingPrice(2000.0F);
        assertEquals(2000.0F, service.getStartingPrice(), 0.001);
        
    }

    /**
     * Test of getPricePerKilometer method, of class DeliveryService.
     */
    @Test
    public void testGetPricePerKilometer() {
        Float result = service.getPricePerKilometer();
        assertEquals(30.0F, result, 0.001);
        
    }

    /**
     * Test of setPricePerKilometer method, of class DeliveryService.
     */
    @Test
    public void testSetPricePerKilometer() {
        service.setPricePerKilometer(15.0F);
        assertEquals(15.0F, service.getPricePerKilometer(), 0.001);
    }
    
}
