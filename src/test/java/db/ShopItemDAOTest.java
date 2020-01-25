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
import model.ShopItem;
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
public class ShopItemDAOTest {
    
    public ShopItemDAOTest() {
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
     * Test of convertFromResultSet method, of class ShopItemDAO.
     *//**
    @Test
    public void testConvertFromResultSet() {
        System.out.println("convertFromResultSet");
        ResultSet rs = null;
        ShopItemDAO instance = new ShopItemDAO();
        ShopItem expResult = null;
        ShopItem result = instance.convertFromResultSet(rs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateOne method, of class ShopItemDAO.
     */
    @Test
    public void testUpdateOneName() {
        System.out.println("updateOne");
        ShopItem object = new ShopItem(1, "Merce", 1500.0f, 10);
        ShopItemDAO instance = new ShopItemDAO();
        instance.insertOne(object);
        String name = "PROBA";
        object.setName(name);
        instance.updateOne(object);
        ShopItem t = instance.getOne(1);
        assertEquals(t.getName().equals(name), true);
    }
    @Test
    public void testUpdateOnePrice() {
        System.out.println("updateOne");
        ShopItem object = new ShopItem(1, "Merce", 1500.0f, 10);
        ShopItemDAO instance = new ShopItemDAO();
        instance.insertOne(object);
        float price = 1.0f;
        object.setPrice(price);
        instance.updateOne(object);
        ShopItem t = instance.getOne(1);
        assertEquals(t.getPrice()== (price), true);
    }
    @Test
    public void testUpdateOneAmount() {
        System.out.println("updateOne");
        ShopItem object = new ShopItem(1, "Merce", 1500.0f, 10);
        ShopItemDAO instance = new ShopItemDAO();
        instance.insertOne(object);
        int amount = 2;
        object.setAmount(amount);
        instance.updateOne(object);
        ShopItem t = instance.getOne(1);
        assertEquals(t.getAmount()== (amount), true);
    }
    

    /**
     * Test of insertOne method, of class ShopItemDAO.
     */
    @Test
    public void testInsertOne(){
        System.out.println("insertOne");
        ShopItem object = new ShopItem(1, "Merce", 1500.0f, 10);
        ShopItemDAO instance = new ShopItemDAO();
        boolean expResult = true;
        boolean result = instance.insertOne(object);
        assertEquals(expResult, result);
    }
    @Test
    public void testInsertOne1(){
        System.out.println("insertOne");
        ShopItem object = new ShopItem(1, "Merce", 1500.0f, 10);
        ShopItemDAO instance = new ShopItemDAO();
        int i = instance.getAll().size();
        instance.insertOne(object);
        int i2 = instance.getAll().size();
        assertEquals(i+1, i2);
    }
    
}
