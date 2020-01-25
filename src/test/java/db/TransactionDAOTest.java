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
import java.util.Date;
import model.Client;
import model.DeliveryService;
import model.ShopItem;
import model.Transaction;
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
public class TransactionDAOTest {
    
    public TransactionDAOTest() {
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
     * Test of convertFromResultSet method, of class TransactionDAO.
     *//**
    @Test
    public void testConvertFromResultSet() {
        System.out.println("convertFromResultSet");
        ResultSet rs = null;
        TransactionDAO instance = new TransactionDAO();
        Transaction expResult = null;
        Transaction result = instance.convertFromResultSet(rs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertOne method, of class TransactionDAO.
     */
    @Test
    public void testInsertOne(){
        System.out.println("insertOne");
        ShopItem object1 = new ShopItem(1, "Merce", 1500.0f, 10);
        ShopItemDAO instance1 = new ShopItemDAO();
        instance1.insertOne(object1);
        DeliveryService object2 = new DeliveryService(1, "Test", 123.0F, 150.0F);
        DeliveryServiceDAO instance2 = new DeliveryServiceDAO();
        instance2.insertOne(object2);
        Client object3 = new Client(1,"Lazar", "laki", "123");
        ClientDAO instance3 = new ClientDAO();
        instance3.insertOne(object3);
        Transaction object = new Transaction(1, 1500.0f, 15, new Date(), 1,1,1, 1.0f);
        TransactionDAO instance = new TransactionDAO();
        boolean expResult = true;
        boolean result = instance.insertOne(object);
        assertEquals(expResult, result);
    }
    @Test
    public void testInsertOne1(){
        System.out.println("insertOne");
        ShopItem object1 = new ShopItem(1, "Merce", 1500.0f, 10);
        ShopItemDAO instance1 = new ShopItemDAO();
        instance1.insertOne(object1);
        DeliveryService object2 = new DeliveryService(1, "Test", 123.0F, 150.0F);
        DeliveryServiceDAO instance2 = new DeliveryServiceDAO();
        instance2.insertOne(object2);
        Client object3 = new Client(1,"Lazar", "laki", "123");
        ClientDAO instance3 = new ClientDAO();
        instance3.insertOne(object3);
        Transaction object = new Transaction(1, 1500.0f, 15, new Date(), 1,1,1, 1.0f);
        TransactionDAO instance = new TransactionDAO();
        int i = instance.getAll().size();
        instance.insertOne(object);
        int i2 = instance.getAll().size();
        assertEquals(i+1, i2);
    }
    
}
