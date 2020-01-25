/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.ClientDAO;
import db.DatabaseConnection;
import java.sql.PreparedStatement;
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
public class ClientServiceTest {
    
    public ClientServiceTest() {
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
     * Test of register method, of class ClientService.
     */
    @Test
    public void testRegister1() {
        System.out.println("register");
        String name = "Lazar";
        String username = "laki";
        String password = "123";
        ClientService instance = new ClientService();
        boolean expResult = true;
        boolean result = instance.register(name, username, password);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testRegister7() {
        System.out.println("register");
        String name = "Lazar";
        String username = "laki";
        String password = "123";
        ClientService instance = new ClientService();
        ClientDAO cdao = new ClientDAO();
        int expResult = cdao.getAll().size();
        instance.register(name, username, password);
        int result = cdao.getAll().size();
        assertEquals(expResult+1, result);
        
    }
    @Test
    public void testRegister2() {
        System.out.println("register");
        String name = "Lazar";
        String username = "laki";
        String password = "123";
        ClientService instance = new ClientService();
        instance.register("Lazar", "laki", "123");
        boolean expResult = false;
        boolean result = instance.register(name, username, password);
        assertEquals(expResult, result);
     }
    @Test   
    public void testRegister8() {
        System.out.println("register");
        String name = "Lazar";
        String username = "laki";
        String password = "123";
        ClientService instance = new ClientService();
        instance.register("Lazar", "laki", "123");
        ClientDAO cdao = new ClientDAO();
        int expResult = cdao.getAll().size();
        instance.register("Lazar", "laki", "123");
        int result = cdao.getAll().size();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testRegister3() {
        System.out.println("register");
        String name = "";
        String username = "laki3";
        String password = "1233";
        ClientService instance = new ClientService();
        boolean expResult = false;
        boolean result = instance.register(name, username, password);
        assertEquals(expResult, result);
        
    }///PRAVI GRESKU UPISUJE U BAZU A NE BI SMEO BEZ (NAME, USERNAME, PASSWORDA) ILITI PRAVI NOVOG KORISNIKA U BAZI 
    @Test
    public void testRegister9() {
        System.out.println("register");
        String name = "";
        String username = "laki3";
        String password = "1233";
        ClientService instance = new ClientService();
        ClientDAO cdao = new ClientDAO();
        int expResult = cdao.getAll().size();
        instance.register(name, username, password);
        int result = cdao.getAll().size();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testRegister4() {
        System.out.println("register");
        String name = "Lazar4";
        String username = "test4";
        String password = "";
        ClientService instance = new ClientService();
        boolean expResult = false;
        boolean result = instance.register(name, username, password);
        assertEquals(expResult, result);
        
    }///PRAVI GRESKU UPISUJE U BAZU A NE BI SMEO BEZ (NAME, USERNAME, PASSWORDA) ILITI PRAVI NOVOG KORISNIKA U BAZI 
    @Test
    public void testRegister10() {
        System.out.println("register");
        String name = "Lazar4";
        String username = "test4";
        String password = "";
        ClientService instance = new ClientService();
        ClientDAO cdao = new ClientDAO();
        int expResult = cdao.getAll().size();
        instance.register(name, username, password);
        int result = cdao.getAll().size();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testRegister5() {
        System.out.println("register");
        String name = "Lazar5";
        String username = "";
        String password = "1235";
        ClientService instance = new ClientService();
        boolean expResult = false;
        boolean result = instance.register(name, username, password);
        assertEquals(expResult, result);
        
    } ///PRAVI GRESKU UPISUJE U BAZU A NE BI SMEO BEZ (NAME, USERNAME, PASSWORDA) ILITI PRAVI NOVOG KORISNIKA U BAZI
    @Test
    public void testRegister11(){
        System.out.println("register");
        String name = "Lazar5";
        String username = "";
        String password = "1235";
        ClientService instance = new ClientService();
        ClientDAO cdao = new ClientDAO();
        int expResult = cdao.getAll().size();
        instance.register(name, username, password);
        int result = cdao.getAll().size();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testRegister6() {
        System.out.println("register");
        String name = "";
        String username = "";
        String password = "";
        ClientService instance = new ClientService();
        boolean expResult = false;
        boolean result = instance.register(name, username, password);
        assertEquals(expResult, result);
        
    }
    ///PRAVI GRESKU UPISUJE U BAZU A NE BI SMEO BEZ (NAME, USERNAME, PASSWORDA) ILITI PRAVI NOVOG KORISNIKA U BAZI 
    @Test
    public void testRegister12(){
        System.out.println("register");
        String name = "";
        String username = "";
        String password = "";
        ClientService instance = new ClientService();
        ClientDAO cdao = new ClientDAO();
        int expResult = cdao.getAll().size();
        instance.register(name, username, password);
        int result = cdao.getAll().size();
        assertEquals(expResult, result);
        
    }


    /**
     * Test of login method, of class ClientService.
     */
    @Test
    public void testLogin1() {
        System.out.println("login");
        String username = "laki";
        String password = "123";
        ClientService instance = new ClientService();
        Client expResult = new Client(1, "Lazar", "laki", "123");
        instance.register("Lazar", username, password);
        Client result = instance.login(username, password);
        assertEquals(true,expResult.getUsername().equals(result.getUsername()) && expResult.getPassword().equals(result.getPassword()));
        
    }
    @Test
    public void testLogin2() {
        System.out.println("login");
        String username = "LAki111";
        String password = "12123";
        ClientService instance = new ClientService();
        Client expResult = new Client(1, "Lazar", "laki", "123");
        instance.register("Lazar", "laki", "123");
        Client result = instance.login(username, password);
        assertEquals(null,result);
        
    }

    
    /**
     * Test of deleteUser method, of class ClientService.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        Client c = new Client(1, "Lazar", "laki", "123");
        ClientService instance = new ClientService();
        instance.register("Lazar", "laki", "123");
        boolean expResult = true;
        boolean result = instance.deleteUser(c);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testDeleteUser2(){
        System.out.println("deleteUser");
        Client c = new Client(1, "Lazar", "laki", "123");
        ClientService instance = new ClientService();
        instance.register("Lazar", "laki", "123");
        ClientDAO cdao = new ClientDAO();
        int expResult = cdao.getAll().size();
        instance.deleteUser(c);
        int result = cdao.getAll().size();
        assertEquals(expResult-1, result);
        
    }
    @Test
    public void testDeleteUser3() {
        System.out.println("deleteUser");
        Client c = new Client(1, "Lazar", "laki", "123");
        ClientService instance = new ClientService();
        boolean expResult = false;
        boolean result = instance.deleteUser(c);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testDeleteUser4(){
        System.out.println("deleteUser");
        Client c = new Client(1, "Lazar", "laki", "123");
        ClientService instance = new ClientService();
        ClientDAO cdao = new ClientDAO();
        int expResult = cdao.getAll().size();
        instance.deleteUser(c);
        int result = cdao.getAll().size();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of updateInfo method, of class ClientService.
     */
    // PRAVI GRESKU. NE MENJA IME
    @Test
    public void testUpdateInfoName() {
        System.out.println("updateInfo");
        String name = "Lazar44";
        String oldPassword = "123";
        String password = "1234";
        ClientService instance = new ClientService();
        ClientDAO cdao = new ClientDAO();
        instance.register("Lazar", "laki", "123");
        instance.updateInfo(cdao.getOne(1), name, oldPassword, password);
        Client i = cdao.getOne(1);
        assertEquals(i.getName().equals(name),true);
   }
    @Test
    public void testUpdateInfoPassword() {
        System.out.println("updateInfo");
        String name = "Lazar";
        String oldPassword = "123";
        String password = "1234";
        ClientService instance = new ClientService();
        ClientDAO cdao = new ClientDAO();
        instance.register("Lazar", "laki", "123");
        instance.updateInfo(cdao.getOne(1), name, oldPassword, password);
        Client i = cdao.getOne(1);
        assertEquals(i.getPassword().equals(password),true);
}}

   