/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class PromotionServiceTest {
    
    public PromotionServiceTest() {
    }
    private static void clearDataBase(){
        ArrayList<String> tablesNames = new ArrayList<>();
        tablesNames.add("client");
        tablesNames.add("delivery_service");
        tablesNames.add("shop_item");
        tablesNames.add("transaction");
        
        for(String q:tablesNames){
            String query = "DELETE FROM "+q;
            try{

                PreparedStatement st = DatabaseConnection.getConnection().prepareStatement(query);
                st.executeUpdate(); 


            }
            catch(SQLException e){
            }
        }
        for(String q:tablesNames){
            String query = "ALTER TABLE "+q + " AUTO_INCREMENT = 1";
            try{

                PreparedStatement st = DatabaseConnection.getConnection().prepareStatement(query);
                st.executeUpdate(); 


            }
            catch(SQLException e){
            }
        }
        
        
    
        
    }
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        clearDataBase();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculateSeasonalPromotions method, of class PromotionService.
     */
    @Test
    public void testCalculateSeasonalPromotions() {
        System.out.println("calculateSeasonalPromotions");
        Date d = null;
        PromotionService instance = new PromotionService();
        instance.calculateSeasonalPromotions(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkHolidays method, of class PromotionService.
     */
    @Test
    public void testCheckHolidays() {
        System.out.println("checkHolidays");
        Date d = null;
        PromotionService instance = new PromotionService();
        boolean expResult = false;
        boolean result = instance.checkHolidays(d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateSpecialPromotions method, of class PromotionService.
     */
    @Test
    public void testCalculateSpecialPromotions() {
        System.out.println("calculateSpecialPromotions");
        PromotionService instance = new PromotionService();
        instance.calculateSpecialPromotions();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateDiscount method, of class PromotionService.
     */
    @Test
    public void testCalculateDiscount() {
        System.out.println("calculateDiscount");
        PromotionService instance = new PromotionService();
        instance.calculateDiscount();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of applyPromotions method, of class PromotionService.
     */
    @Test
    public void testApplyPromotions() {
        System.out.println("applyPromotions");
        float price = 0.0F;
        Date d = null;
        PromotionService instance = new PromotionService();
        float expResult = 0.0F;
        float result = instance.applyPromotions(price, d);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
