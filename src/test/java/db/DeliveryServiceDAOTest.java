/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DeliveryService;
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
public class DeliveryServiceDAOTest {
    
    public DeliveryServiceDAOTest() {
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
     * Test of convertFromResultSet method, of class DeliveryServiceDAO.
     *//**
    @Test
    public void testConvertFromResultSet() {
        System.out.println("convertFromResultSet");
        ResultSet rs = null;
        DeliveryServiceDAO instance = new DeliveryServiceDAO();
        DeliveryService expResult = null;
        DeliveryService result = instance.convertFromResultSet(rs);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateOne method, of class DeliveryServiceDAO.
     */
    @Test
    public void testUpdateOneName() {
        System.out.println("updateOne");
        DeliveryService object = new DeliveryService(1, "Test", 123.0F, 150.0F);
        DeliveryServiceDAO instance = new DeliveryServiceDAO();
        instance.insertOne(object);
        String name = "PROBA";
        object.setName(name);
        instance.updateOne(object);
        DeliveryService t = instance.getOne(1);
        assertEquals(t.getName().equals(name), true);
    }
    @Test
    public void testUpdateOneStartingPrice() {
        System.out.println("updateOne");
        DeliveryService object = new DeliveryService(1, "Test", 123.0F, 150.0F);
        DeliveryServiceDAO instance = new DeliveryServiceDAO();
        instance.insertOne(object);
        float startingPrice = 1111.0F;
        object.setStartingPrice(startingPrice);
        instance.updateOne(object);
        DeliveryService t = instance.getOne(1);
        assertEquals(t.getStartingPrice() == (startingPrice), true);
    }
    
    @Test
    public void testUpdateOnePricePerKilometer() {
        System.out.println("updateOne");
        DeliveryService object = new DeliveryService(1, "Test", 123.0F, 150.0F);
        DeliveryServiceDAO instance = new DeliveryServiceDAO();
        instance.insertOne(object);
        float pricePerKilometer = 1111.0F;
        object.setPricePerKilometer(pricePerKilometer);
        instance.updateOne(object);
        DeliveryService t = instance.getOne(1);
        assertEquals(t.getPricePerKilometer()== (pricePerKilometer), true);
    }
    

    /**
     * Test of insertOne method, of class DeliveryServiceDAO.
     */
    @Test
    public void testInsertOne(){
        System.out.println("insertOne");
        DeliveryService object = new DeliveryService(1, "Test", 123.0F, 150.0F);
        DeliveryServiceDAO instance = new DeliveryServiceDAO();
        boolean expResult = true;
        boolean result = instance.insertOne(object);
        assertEquals(expResult, result);
    }
    @Test
    public void testInsertOne1(){
        System.out.println("insertOne");
        DeliveryService object = new DeliveryService(1, "Test", 123.0F, 150.0F);
        DeliveryServiceDAO instance = new DeliveryServiceDAO();
        int i = instance.getAll().size();
        instance.insertOne(object);
        int i2 = instance.getAll().size();
        assertEquals(i+1, i2);
    }

       
}
