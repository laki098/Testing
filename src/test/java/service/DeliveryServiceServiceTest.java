/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.DatabaseConnection;
import db.DeliveryServiceDAO;
import java.sql.PreparedStatement;
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
public class DeliveryServiceServiceTest {
    
    public DeliveryServiceServiceTest() {
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
     * Test of register method, of class DeliveryServiceService.
     */
    @Test
    public void testRegister1() {
        System.out.println("register");
        String name = "Milos";
        float pricePerKilometer = 150.0F;
        float startingPrice = 50.0F;
        DeliveryServiceService instance = new DeliveryServiceService();
        boolean expResult = true;
        boolean result = instance.register(name, pricePerKilometer, startingPrice);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testRegister4() {
        System.out.println("register");
        String name = "Zoran";
        float pricePerKilometer = 300.0F;
        float startingPrice = 150.0F;
        DeliveryServiceService instance = new DeliveryServiceService();
        DeliveryServiceDAO ddao = new DeliveryServiceDAO();
        int expResult = ddao.getAll().size();
        instance.register(name, pricePerKilometer, startingPrice);
        int result = ddao.getAll().size();
        assertEquals(expResult+1, result);
        
    }
    
    @Test
    public void testRegister5() {
        System.out.println("register");
        String name = "Radovan";
        float pricePerKilometer = -1000.0F;
        float startingPrice = 150.0F;
        DeliveryServiceService instance = new DeliveryServiceService();
        DeliveryServiceDAO ddao = new DeliveryServiceDAO();
        int expResult = ddao.getAll().size();
        instance.register(name, pricePerKilometer, startingPrice);
        int result = ddao.getAll().size();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testRegister3() {
        System.out.println("register");
        String name = "Radovan";
        float pricePerKilometer = -1000.0F;
        float startingPrice = 150.0F;
        DeliveryServiceService instance = new DeliveryServiceService();
        boolean expResult = false;
        boolean result = instance.register(name, pricePerKilometer, startingPrice);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testRegister6() {
        System.out.println("register");
        String name = "Milutin";
        float pricePerKilometer = 50.0F;
        float startingPrice = -300.0F;
        DeliveryServiceService instance = new DeliveryServiceService();
        DeliveryServiceDAO ddao = new DeliveryServiceDAO();
        int expResult = ddao.getAll().size();
        instance.register(name, pricePerKilometer, startingPrice);
        int result = ddao.getAll().size();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testRegister2() {
        System.out.println("register");
        String name = "Milutin";
        float pricePerKilometer = 50.0F;
        float startingPrice = -300.0F;
        DeliveryServiceService instance = new DeliveryServiceService();
        boolean expResult = false;
        boolean result = instance.register(name, pricePerKilometer, startingPrice);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of deleteDeliveryService method, of class DeliveryServiceService.
     */
    @Test
    public void testDeleteDeliveryService() {
        System.out.println("deleteDeliveryService");
        DeliveryService d = new DeliveryService(1, "Milos", 150.0f, 50.0F);
        DeliveryServiceService instance = new DeliveryServiceService();
        instance.register("Milos", 150.0f, 50.0F);
        boolean expResult = true;
        boolean result = instance.deleteDeliveryService(d);
        assertEquals(expResult, result);
     
    }
    @Test
    public void testDeleteDeliveryService1() {
        System.out.println("deleteDeliveryService");
        DeliveryService d = new DeliveryService(1, "Milos", 150.0f, 50.0F);
        DeliveryServiceService instance = new DeliveryServiceService();
        instance.register("Milos", 150.0f, 50.0F);
        DeliveryServiceDAO ddao = new DeliveryServiceDAO();
        int expResult = ddao.getAll().size();
        instance.deleteDeliveryService(d);
        int result = ddao.getAll().size();
        assertEquals(expResult-1, result);
     
    }
    // BUG VRATIO TRUE KAO DA JE OBRISAO U BAZI A NEMA NICEG ZA BRISANJE
    @Test
    public void testDeleteDeliveryService2() {
        System.out.println("deleteDeliveryService");
        DeliveryService d = new DeliveryService(1, "Milos", 150.0f, 50.0F);
        DeliveryServiceService instance = new DeliveryServiceService();
        boolean expResult = false;
        boolean result = instance.deleteDeliveryService(d);
        assertEquals(expResult, result);
     
    }
    @Test
    public void testDeleteDeliveryService3() {
        System.out.println("deleteDeliveryService");
        DeliveryService d = new DeliveryService(1, "Milos", 150.0f, 50.0F);
        DeliveryServiceService instance = new DeliveryServiceService();
        DeliveryServiceDAO ddao = new DeliveryServiceDAO();
        int expResult = ddao.getAll().size();
        instance.deleteDeliveryService(d);
        int result = ddao.getAll().size();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of updateInfo method, of class DeliveryServiceService.
     */
    @Test
    public void testUpdateInfo1() {
        System.out.println("updateInfo");
        DeliveryService d = new DeliveryService(1, "Milos", 150.0f, 50.0F);
        String name = "Test";
        float startingPrice = 200.0F;
        float pricePerKilometer = 15.0F;
        DeliveryServiceService instance = new DeliveryServiceService();
        instance.register("Milos", 150.0f, 50.0F);
        boolean expResult = true;
        boolean result = instance.updateInfo(d, name, startingPrice, pricePerKilometer);
        assertEquals(expResult, result);
    }
    @Test
    public void testUpdateInfo2() {
        System.out.println("updateInfo");
        DeliveryService d = new DeliveryService(1, "Milos", 150.0f, 50.0F);
        String name = "Test";
        float startingPrice = 200.0F;
        float pricePerKilometer = 15.0F;
        DeliveryServiceService instance = new DeliveryServiceService();
        instance.register("Milos", 150.0f, 50.0F);
        DeliveryServiceDAO ddao = new DeliveryServiceDAO();
        instance.updateInfo(d, name, startingPrice, pricePerKilometer);
        DeliveryService d1 = ddao.getOne(1);
        assertEquals(d1.getName().equals(name) && d1.getStartingPrice() == startingPrice && d1.getPricePerKilometer() == pricePerKilometer, true);
    }
    
    
    
    
    
}
