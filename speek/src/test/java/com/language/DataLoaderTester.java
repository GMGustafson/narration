package com.language;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

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

   @Test 
   public void testTesting()
   { 
        assertTrue(true);
   }

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
     // users.getUsers().clear(); 
      //users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
      //users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
      ArrayList<User> userList = DataLoader.getUsers();
      assertEquals(2, userList.size());
    }

    @Test
    public void testGetUsersSizeZero() {
        UserList users = UserList.getInstance(); 
        //users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
        ArrayList<User> userList = users.getUsers();
        userList = DataLoader.getUsers(); 
        assertEquals(0, users.getUsers().size());
        //WE want this one to fail 
    }

    @Test
    public void testGetFirstUserName() {
        UserList users = UserList.getInstance(); 
        //users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
        //users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
        ArrayList<User> userList = users.getUsers();
        userList = DataLoader.getUsers();
        assertEquals("johndoe73", userList.get(0).getUsername());
    }

    @Test
    public void testGetSecondUserName() {
        UserList users = UserList.getInstance(); 
        //users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
        //users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
        ArrayList<User> userList = users.getUsers();
        userList = DataLoader.getUsers();
        assertEquals("janesmith10", userList.get(1).getUsername());
    }

    @Test
    public void testGetFirstFirstName() {
        UserList users = UserList.getInstance(); 
        //users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
        //users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
        ArrayList<User> userList = users.getUsers();
        userList = DataLoader.getUsers();
        assertEquals("John", userList.get(0).getFirstName());
    }

    @Test
    public void testGetSecondFirstName() {
        UserList users = UserList.getInstance(); 
        //users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
        //users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
        ArrayList<User> userList = users.getUsers();
        userList = DataLoader.getUsers();
        assertEquals("Jane", userList.get(1).getFirstName());
    }

    @Test
    public void testGetFirstEmail() {
        UserList users = UserList.getInstance(); 
        //users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
        //users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
        ArrayList<User> userList = users.getUsers();
        userList = DataLoader.getUsers();
        assertEquals("johndoe@gmail.com", userList.get(0));
    }
    @Test
    public void testGetSecondEmail() {
        UserList users = UserList.getInstance(); 
        //users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
        //users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
        ArrayList<User> userList = users.getUsers();
        userList = DataLoader.getUsers();
        assertEquals("jsmith@gmail.com", userList.get(1));
    }




    // how to get the courses

    @Test
    public void testGetCourseID() {
        CourseList courses = CourseList.getInstance(); 
        //users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
        //users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
        ArrayList<Course> courseList = DataLoader.getCourse();
        courseList = DataLoader.getCourse();
        assertEquals("8c24fea9-e192-457d-8ba3-db5828f62490", courseList.get(0));
    }


    
    


    
}
