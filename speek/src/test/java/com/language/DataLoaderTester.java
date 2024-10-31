package com.language;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.language.DataLoader;
import com.language.DataWriter;
import com.language.User;
import com.language.UserList;

public class DataLoaderTester {
   // private UserList users = UserList.getInstance(); 
   // private ArrayList<User> userList = users.getUsers(); 

    @Before
    public void setup() { 
      //  userList.clear(); 
      //  users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
      //  users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
      //  DataWriter.saveUsers();
    }

    @After
    public void tearDown() {
      //  users.getUsers().clear();
      //  DataWriter.saveUsers();
    }

    @Test
    public void testGetUsersSize() {
      UserList users = UserList.getInstance(); 
      users.getUsers().clear(); 
      users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
      users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
      ArrayList<User> userList = DataLoader.getUsers();
      assertEquals(2, userList.size());
    }

    @Test
    public void testGetUsersSizeZero() {
        //UserList users = UserList.getInstance(); 
        //users.getUsers().clear(); 
        //DataWriter.saveUsers();
        //assertEquals(0, users.getUsers().size());
    }

    @Test
    public void testGetUserFirstUserName() {

        //userList = DataLoader.getUsers();
        //assertEquals("johndoe73", userList.get(0).getUsername());
    }


    @Test 
    public void testgetProgress()
    { 

    }
}
