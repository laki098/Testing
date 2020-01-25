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
import model.Client;
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
public class ClientDAOTest {
    
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
    
    public ClientDAOTest() {
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
     * Test of convertFromResultSet method, of class ClientDAO.
     *//**
    @Test
    public void testConvertFromResultSet() {
        System.out.println("convertFromResultSet");
        ResultSet rs = null;
        ClientDAO instance = new ClientDAO();
        Client expResult = null;
        Client result = instance.convertFromResultSet(rs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateOne method, of class ClientDAO.
     */
    @Test
    public void testUpdateOnePassword() {
        System.out.println("updateOne");
        Client object = new Client(1,"Lazar", "laki", "123");
        ClientDAO instance = new ClientDAO();
        instance.insertOne(object);
        String password = "PROBA";
        object.setPassword(password);
        instance.updateOne(object);
        Client t = instance.getOne(1);
        assertEquals(t.getPassword().equals(password), true);
    }
    @Test
    public void testUpdateOneName() {
        System.out.println("updateOne");
        Client object = new Client(1,"Lazar", "laki", "123");
        ClientDAO instance = new ClientDAO();
        instance.insertOne(object);
        String name = "BASAPROBA";
        object.setName(name);
        instance.updateOne(object);
        Client t = instance.getOne(1);
        assertEquals(t.getName().equals(name), true);
    }
    

    /**
     * Test of insertOne method, of class ClientDAO.
     */
    @Test
    public void testInsertOne(){
        System.out.println("insertOne");
        Client object = new Client(1,"Lazar2", "laki2", "1232");
        ClientDAO instance = new ClientDAO();
        boolean expResult = true;
        boolean result = instance.insertOne(object);
        assertEquals(expResult, result);
    }
    @Test
    public void testInsertOne1(){
        System.out.println("insertOne");
        Client object = new Client(1,"Lazar22", "laki22", "12322");
        ClientDAO instance = new ClientDAO();
        int i = instance.getAll().size();
        instance.insertOne(object);
        int i2 = instance.getAll().size();
        assertEquals(i+1, i2);
    }
    
}
