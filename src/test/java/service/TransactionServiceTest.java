/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.DatabaseConnection;
import db.TransactionDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
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
public class TransactionServiceTest {
    
    public TransactionServiceTest() {
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
     * Test of completeTransaction method, of class TransactionService.
     */
    //
    @Test// pao
    public void testCompleteTransaction1() {
        System.out.println("completeTransaction");
        Client c = new Client(1, "Lazar", "laki", "123");
        DeliveryService d = new DeliveryService(1, "Milos", 150, 50);
        ShopItem s = new ShopItem(1, "Audi", 100, 6);
        int amount = 2;
        float distance = 150.0F;
        ShopItemService si = new ShopItemService();
        TransactionService instance = new TransactionService(si);
        TransactionDAO tdao = new TransactionDAO();
        int expResult = tdao.getAll().size();
        instance.completeTransaction(c, d, s, amount, distance);
        
        int result = tdao.getAll().size();
        assertEquals(result, expResult+1);
        
    }
    //BAG OCEKIVALI SMO ILEGALARGUMENTEXEPTION A VRATIO JE NULL POINTER
    @Test(expected = IllegalArgumentException.class)
    public void testCompleteTransaction2() {
        System.out.println("completeTransaction");
        Client c = new Client(1, "Lazar", "laki", "123");
        DeliveryService d = new DeliveryService(1, "Milos", 150, 50);
        ShopItem s = null;
        int amount = 2;
        float distance = 150.0F;
        ShopItemService si = new ShopItemService();
        TransactionService instance = new TransactionService(si);
        TransactionDAO tdao = new TransactionDAO();
        int result = tdao.getAll().size();
        instance.completeTransaction(c, d, s, amount, distance);
        
        int expResult = tdao.getAll().size();
        assertEquals(expResult, result+1);
        
    }
    //BAG OCEKIVALI SMO ILEGALARGUMENTEXEPTION A VRATIO JE NULL POINTER
    @Test(expected = IllegalArgumentException.class)
    public void testCompleteTransaction3() {
        System.out.println("completeTransaction");
        Client c = new Client(1, "Lazar", "laki", "123");
        DeliveryService d = null;
        ShopItem s = new ShopItem(3, "Audi", 100, 6);
        int amount = 2;
        float distance = 150.0F;
        ShopItemService si = new ShopItemService();
        TransactionService instance = new TransactionService(si);
        TransactionDAO tdao = new TransactionDAO();
        int result = tdao.getAll().size();
        instance.completeTransaction(c, d, s, amount, distance);
        
        int expResult = tdao.getAll().size();
        assertEquals(expResult, result+1);
        
    }
    //BAG OCEKIVALI SMO ILEGALARGUMENTEXEPTION A VRATIO JE NULL POINTER
    @Test(expected = IllegalArgumentException.class)
    public void testCompleteTransaction4() {
        System.out.println("completeTransaction");
        Client c = null;
        DeliveryService d = new DeliveryService(1, "Milos", 150, 50);
        ShopItem s = new ShopItem(3, "Audi", 100, 6);
        int amount = 2;
        float distance = 150.0F;
        ShopItemService si = new ShopItemService();
        TransactionService instance = new TransactionService(si);
        TransactionDAO tdao = new TransactionDAO();
        int result = tdao.getAll().size();
        instance.completeTransaction(c, d, s, amount, distance);
        
        int expResult = result+1;
        assertEquals(expResult, result);
        
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCompleteTransaction5() {
        System.out.println("completeTransaction");
        Client c = new Client(1, "Lazar", "laki", "123");
        DeliveryService d = new DeliveryService(1, "Milos", 150, 50);
        ShopItem s = new ShopItem(3, "Audi", 100, 6);
        int amount = 0;
        float distance = 150.0F;
        ShopItemService si = new ShopItemService();
        TransactionService instance = new TransactionService(si);
        TransactionDAO tdao = new TransactionDAO();
        int result = tdao.getAll().size();
        
        instance.completeTransaction(c, d, s, amount, distance);
        int expResult = tdao.getAll().size();
        
        assertEquals(expResult, result);
        
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCompleteTransaction6() {
        System.out.println("completeTransaction");
        Client c = new Client(1, "Lazar", "laki", "123");
        DeliveryService d = new DeliveryService(1, "Milos", 150, 50);
        ShopItem s = new ShopItem(3, "Audi", 100, 6);
        int amount = 10;
        float distance = -150.0F;
        ShopItemService si = new ShopItemService();
        TransactionService instance = new TransactionService(si);
        TransactionDAO tdao = new TransactionDAO();
        int result = tdao.getAll().size();
        
        instance.completeTransaction(c, d, s, amount, distance);
        int expResult = tdao.getAll().size();
        
        assertEquals(expResult, result);
        
    }
    /**
     * Test of getRecentTransactions method, of class TransactionService.
     */
    @Test
    public void testGetRecentTransactions() {
        System.out.println("getRecentTransactions");
        Client c = new Client(1, "Lazar", "laki", "123");
        DeliveryService d = new DeliveryService(1, "Milos", 150, 50);
        ShopItem s = new ShopItem(3, "Audi", 100, 6);
        int amount = 10;
        float distance = 150.0F;
        ShopItemService si = new ShopItemService();
        TransactionService instance = new TransactionService(si);
        TransactionDAO tdao = new TransactionDAO();
        instance.completeTransaction(c, d, s, amount, distance);
        ArrayList<Transaction> expResult = new ArrayList<>();
        for(Transaction t : tdao.getAll()){
            if (t.getShopItemId()==s.getId() && t.getDate().after(java.sql.Date.valueOf(LocalDate.now().minusDays(30)))){
                expResult.add(t);
            }
        }
        ArrayList<Transaction> result = instance.getRecentTransactions();
        assertEquals(expResult, result);
        
    }
    
}
