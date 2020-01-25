/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.DatabaseConnection;
import db.ShopItemDAO;
import db.TransactionDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
public class ShopItemServiceTest {
    
    public ShopItemServiceTest() {
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
     * Test of postItem method, of class ShopItemService.
     */
    @Test
    public void testPostItem1() {
        System.out.println("postItem");
        String name = "Auto";
        float price = 150.0F;
        int amount = 3;
        ShopItemService instance = new ShopItemService();
        boolean expResult = true;
        boolean result = instance.postItem(name, price, amount);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testPostItem3() {
        System.out.println("postItem");
        String name = "Reno";
        float price = 300.0F;
        int amount = 9;
        ShopItemService instance = new ShopItemService();
        ShopItemDAO sdao = new ShopItemDAO();
        int expResult = sdao.getAll().size();
        instance.postItem(name, price, amount);
        int result = sdao.getAll().size();
        assertEquals(expResult+1, result);
        
    }
    @Test
    public void testPostItem4() {
        System.out.println("postItem");
        String name = "Mercedes";
        float price = -400.0F;
        int amount = 16;
        ShopItemService instance = new ShopItemService();
        ShopItemDAO sdao = new ShopItemDAO();
        int expResult = sdao.getAll().size();
        instance.postItem(name, price, amount);
        int result = sdao.getAll().size();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testPostItem5() {
        System.out.println("postItem");
        String name = "Auto";
        float price = -150.0F;
        int amount = 3;
        ShopItemService instance = new ShopItemService();
        boolean expResult = false;
        boolean result = instance.postItem(name, price, amount);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testPostItem6() {
        System.out.println("postItem");
        String name = "Mercedes";
        float price = 400.0F;
        int amount = -16;
        ShopItemService instance = new ShopItemService();
        ShopItemDAO sdao = new ShopItemDAO();
        int expResult = sdao.getAll().size();
        instance.postItem(name, price, amount);
        int result = sdao.getAll().size();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testPostItem7() {
        System.out.println("postItem");
        String name = "Auto";
        float price = 150.0F;
        int amount = -3;
        ShopItemService instance = new ShopItemService();
        boolean expResult = false;
        boolean result = instance.postItem(name, price, amount);
        assertEquals(expResult, result);
        
    }
    /**
     * Test of removeItem method, of class ShopItemService.
     */
    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        ShopItem s = new ShopItem(1, "Auto", 150.0F, 3);
        ShopItemService instance = new ShopItemService();
        instance.postItem("Auto", 150.0F, 3);
        boolean expResult = true;
        boolean result = instance.removeItem(s);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testRemoveItem1() {
        System.out.println("removeItem");
        ShopItem s = new ShopItem(1, "Auto", 150.0F, 3);
        ShopItemService instance = new ShopItemService();
        instance.postItem("Auto", 150.0F, 3);
        ShopItemDAO sdao = new ShopItemDAO();
        int expResult = sdao.getAll().size();
        instance.removeItem(s);
        int result = sdao.getAll().size();
        assertEquals(expResult-1, result);
        
    }
    @Test
    public void testRemoveItem2() {
        System.out.println("removeItem");
        ShopItem s = new ShopItem(1, "Auto", 150.0F, 3);
        ShopItemService instance = new ShopItemService();
        boolean expResult = false;
        boolean result = instance.removeItem(s);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testRemoveItem3() {
        System.out.println("removeItem");
        ShopItem s = new ShopItem(1, "Auto", 150.0F, 3);
        ShopItemService instance = new ShopItemService();
        ShopItemDAO sdao = new ShopItemDAO();
        int expResult = sdao.getAll().size();
        instance.removeItem(s);
        int result = sdao.getAll().size();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of buy method, of class ShopItemService.
     */
    // bug umesto da ispise ne moze se kupiti neisptavno on sabira 6 i 20
    @Test
    public void testBuy1() {
        System.out.println("buy");
        ShopItem s = new ShopItem(1, "Audi", 100.0F, 6);
        int amount = -20;
        int result = s.getAmount() - amount;
        ShopItemService instance = new ShopItemService();
        instance.postItem(s.getName(), s.getPrice(), s.getAmount());
        instance.buy(s, amount);
        ShopItemDAO sdao = new ShopItemDAO();
        ShopItem s2 = sdao.getOne(1);
        
        assertEquals(s2.getAmount(), s.getAmount());
        
    }
    @Test
    public void testBuy2() {
        System.out.println("buy");
        ShopItem s = new ShopItem(1, "Audi", 100.0F, 6);
        int amount = 20;
        ShopItemService instance = new ShopItemService();
        instance.postItem(s.getName(), s.getPrice(), s.getAmount());
        instance.buy(s, amount);
        ShopItemDAO sdao = new ShopItemDAO();
        ShopItem s2 = sdao.getOne(1);
        
        assertEquals(s2.getAmount(), s.getAmount());
    }
    
    @Test
    public void testBuy3() {
        System.out.println("buy");
        ShopItem s = new ShopItem(1, "Audi", 100.0F, 6);
        int amount = 5;
        int x = s.getAmount() - amount;
        ShopItemService instance = new ShopItemService();
        instance.postItem(s.getName(), s.getPrice(), s.getAmount());
        ShopItemDAO sdao = new ShopItemDAO();
        instance.buy(s, amount);
        ShopItem s2 = sdao.getOne(1);
        assertEquals(x, s2.getAmount());
    }
    
    
    

    /**
     * Test of stockUp method, of class ShopItemService.
     */
    @Test
    public void testStockUp1() {
        System.out.println("stockUp");
        ShopItem s = new ShopItem(1, "Audi", 100.0F, 6);
        int amount = 5;
        int result = amount + s.getAmount();
        ShopItemService instance = new ShopItemService();
        instance.postItem(s.getName(), s.getPrice(), s.getAmount());
        ShopItemDAO sdao = new ShopItemDAO();
        instance.stockUp(s, amount);
        ShopItem s1 = sdao.getOne(1);
        assertEquals(result, s1.getAmount());
        
    }
    @Test
    public void testStockUp2() {
        System.out.println("stockUp");
        ShopItem s = new ShopItem(1, "Audi", 100.0F, 6);
        int amount = -5;
        int result = s.getAmount();
        ShopItemService instance = new ShopItemService();
        instance.postItem(s.getName(), s.getPrice(), s.getAmount());
        ShopItemDAO sdao = new ShopItemDAO();
        instance.stockUp(s, amount);
        ShopItem s1 = sdao.getOne(1);
        assertEquals(result, s1.getAmount());
        
    }

    /**
     * Test of checkIfPopular method, of class ShopItemService.
     */
    @Test//paoooo
    public void testCheckIfPopular() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "Audit", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        Transaction t1 = new Transaction(1, 1000, 100, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()>300.0f && amount>(0.6*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    
    }
    
    @Test
    public void testCheckIfPopular2() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "Audit", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        Transaction t1 = new Transaction(1, 100, 100, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()<300.0f && amount>(0.8*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    
    }
    
    @Test
    public void testCheckIfPopular3() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "Audit", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        Transaction t1 = new Transaction(1, 1000, 1, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()>300.0f && amount>(0.6*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    
    }
    
    @Test
    public void testCheckIfPopular4() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "Audit", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        Transaction t1 = new Transaction(1, 100, 1, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()<300.0f && amount>(0.8*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    
    }
    
    @Test
    public void testCheckIfPopular5() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "Audit", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        Transaction t1 = new Transaction(1, 1, 100, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()>300.0f && amount>(0.6*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    
    }
    
    @Test
    public void testCheckIfPopular6() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "Audit", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        System.out.println(d);
        Transaction t1 = new Transaction(1, 1000, 100, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()<300.0f && amount>(0.8*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    
    }
    
    @Test
    public void testCheckIfPopular7() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "Audit", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        Transaction t1 = new Transaction(1, 1, 1, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()>300.0f && amount>(0.6*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    
    }
    
    @Test
    public void testCheckIfPopular8() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "Audit", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        Transaction t1 = new Transaction(1, 1000, 1, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()<300.0f && amount>(0.8*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    
    }
    
    @Test
    public void testCheckIfPopular9() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "Audit", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        Transaction t1 = new Transaction(1, 1000, 1, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        Transaction t2 = new Transaction(1, 1000, 1,java.sql.Date.valueOf(LocalDate.now().minusDays(60)), 1, 1, 1, 10);
        transactions.add(t2);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()<300.0f && amount>(0.8*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    
    }

    /**
     * Test of getTrendingIndex method, of class ShopItemService.
     */
    
    @Test(expected=IllegalArgumentException.class)
    public void testGetTrendingIndex() {
        ShopItem s = new ShopItem(1, "Audit", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        float result = instance.getTrendingIndex(s);
    }
    @Test
    public void testGetTrendingIndex2() {
        ShopItem s = new ShopItem(1, "Audit", 1000.0F, 100);
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction t2 = new Transaction(1, 1000, 1, java.sql.Date.valueOf(LocalDate.now().minusDays(60)), 1, 1, 1, 10);
        transactions.add(t2);
        ShopItemService instance = new ShopItemService();
        int profit = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId()){
                profit+=t.getTotalPrice();
            }
        }
        float expResult = profit/60;
        float result = instance.getTrendingIndex(s);
        assertEquals(expResult, result, 0.0);
    }
    
}
