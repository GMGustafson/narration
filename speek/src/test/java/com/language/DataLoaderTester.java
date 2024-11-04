package com.language;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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


    @Test
    public void testGetUsersSize() {
      UserList users = UserList.getInstance(); 
      users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
      users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
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
        users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
        users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
       ArrayList<User> userList = users.getUsers();
        userList = DataLoader.getUsers();
        assertEquals("johndoe73", userList.get(0).getUsername());
    }

    @Test
    public void testGetSecondUserName() {
        UserList users = UserList.getInstance(); 
        users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
        users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
       ArrayList<User> userList = users.getUsers();
        userList = DataLoader.getUsers();
        assertEquals("janesmith10", userList.get(1).getUsername());
    }

    @Test
    public void testGetFirstFirstName() {
        UserList users = UserList.getInstance(); 
        users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
        users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
        ArrayList<User> userList = users.getUsers();
        userList = DataLoader.getUsers();
        assertEquals("John", userList.get(0).getFirstName());
    }

    @Test
    public void testGetSecondFirstName() {
        UserList users = UserList.getInstance(); 
        users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
        users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
        ArrayList<User> userList = users.getUsers();
        userList = DataLoader.getUsers();
        assertEquals("Jane", userList.get(1).getFirstName());
    }

    @Test
    public void testGetFirstEmail() {
        UserList users = UserList.getInstance(); 
        users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
        users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
        ArrayList<User> userList = users.getUsers();
        userList = DataLoader.getUsers();
        assertEquals("johndoe@gmail.com", userList.get(0).getEmail());
    }
    @Test
    public void testGetSecondEmail() {
        UserList users = UserList.getInstance(); 
       users.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat"); 
        users.addUser("Jane", "Smith", "jsmith@gmail.com", "janesmith10", "IlovemyCat");
        ArrayList<User> userList = users.getUsers();
        userList = DataLoader.getUsers();
        assertEquals("jsmith@gmail.com", userList.get(1).getEmail());
    }

    // false emails 
    @Test
    public void TestFalseEmails() {
        UserList users = UserList.getInstance(); 
        users.addUser("Jen", "Han", "JHanemail.com", "jhan43", "IlovemyDog"); 
        ArrayList<User> userList = users.getUsers();
        userList = DataLoader.getUsers();
        assertEquals("JHan@email.com", "JHanemail.com");
    }
    // Wanted to fail, they forgot the @ sign 



    // how to get the courses

    @Test
    public void testGetCourseID() {
        CourseList courses = CourseList.getInstance(); 
        ArrayList<Course> courseList = DataLoader.getCourse();
        courseList = DataLoader.getCourse();
        assertEquals("8c24fea9-e192-457d-8ba3-db5828f62490", courseList.get(0).getCourseID().toString());
    }

    @Test
    public void TestGetCourseName() { 
        CourseList courses = CourseList.getInstance(); 
        ArrayList<Course> courseList = DataLoader.getCourse();
        courseList = DataLoader.getCourse();
        assertEquals("Spanish", courseList.get(0).getCourse()); 
    }
    @Test
    public void TestGetWordsByCategoryN() { 
        CourseList courses = CourseList.getInstance(); 
        ArrayList<Course> courseList = DataLoader.getCourse();
        courseList = DataLoader.getCourse(); 
        assertEquals("numbers", courseList.get(0).getWordsByCategory("numbers"));
        assertNotNull(courseList.get(0).getWordsByCategory("numbers")); 
    }
    //Want to fail becuase it proves that is it pulling the correct information 
    @Test
    public void TestGetWordsByCategoryP() { 
        CourseList courses = CourseList.getInstance(); 
        ArrayList<Course> courseList = DataLoader.getCourse();
        courseList = DataLoader.getCourse(); 
        assertEquals("places", courseList.get(0).getWordsByCategory("places")); 
        assertNotNull(courseList.get(0).getWordsByCategory("places")); 
    }
    //Want to fail becuase it proves that is it pulling the correct information 

    @Test
    public void TestGetWordsByCategoryW() { 
        CourseList courses = CourseList.getInstance(); 
        ArrayList<Course> courseList = DataLoader.getCourse();
        courseList = DataLoader.getCourse(); 
        assertEquals("weather", courseList.get(0).getWordsByCategory("weather")); 
        assertNotNull(courseList.get(0).getWordsByCategory("weather")); 
    }
    //Want to fail becuase it proves that is it pulling the correct information 

    @Test
    public void TestGetWordsByCategoryPe() { 
        CourseList courses = CourseList.getInstance(); 
        ArrayList<Course> courseList = DataLoader.getCourse();
        courseList = DataLoader.getCourse(); 
        assertEquals("people", courseList.get(0).getWordsByCategory("people")); 
        assertNotNull(courseList.get(0).getWordsByCategory("people")); 
    }
    //Want to fail becuase it proves that is it pulling the correct information 

    @Test
    public void TestGetWordsByCategoryC() { 
        CourseList courses = CourseList.getInstance(); 
        ArrayList<Course> courseList = DataLoader.getCourse();
        courseList = DataLoader.getCourse(); 
        assertEquals("colors", courseList.get(0).getWordsByCategory("colors")); 
        assertNull(courseList.get(0).getWordsByCategory("colors")); 
    }
    //Want to fail becuase it proves that is it pulling the correct information 
    
    @Test
    public void TestGetPhrasesByCategoryC() { 
        CourseList courses = CourseList.getInstance(); 
        ArrayList<Course> courseList = DataLoader.getCourse();
        courseList = DataLoader.getCourse(); 
        assertEquals("colors", courseList.get(0).getPhrasesByCategory("colors")); 
        assertNull(courseList.get(0).getPhrasesByCategory("colors")); 
        //assertTrue(courseList.get(0).getPhrasesByCategory("colors").contains("blue"));
    }
    //Want to fail becuase it proves that is it pulling the correct information 

    @Test
    public void TestGetPhrasesByCategoryP() { 
        CourseList courses = CourseList.getInstance(); 
        ArrayList<Course> courseList = DataLoader.getCourse();
        courseList = DataLoader.getCourse(); 
        assertEquals("colors", courseList.get(0).getPhrasesByCategory("colors")); 
        assertNull(courseList.get(0).getPhrasesByCategory("colors")); 
        //assertTrue(courseList.get(0).getPhrasesByCategory("colors").contains("blue"));
    }
    

    @Test
    public void testGetCoursesSizeZero() {
        CourseList courses = CourseList.getInstance(); 
        ArrayList<Course> courseList = DataLoader.getCourse();
        courseList = DataLoader.getCourse(); 
        assertEquals(0, courses.getCourses().size());
        //WE want this one to fail 
    }



   

    
    



    
    


    
}
