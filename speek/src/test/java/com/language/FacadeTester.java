package com.language;

import com.language.CategorySystemFacade;
import com.language.User;
import com.language.UserList;
import static org.junit.Assert.*;

import java.nio.file.Paths;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class FacadeTester {
    private CategorySystemFacade facade = CategorySystemFacade.getFacadeInstance();

    @Test
    public void loginValidTest() {
        if(!facade.login("johndoe73", "IlovemyCat")){
            System.out.println("Couldn't login John");
            return;
        }
        User user = facade.getCurrentUser();
        assertEquals(user.getUsername(), "johndoe73");
    }

    @Test
    public void testLoadUsers(){

        ArrayList<Course> courses = DataLoader.getCourse();
        assertSame(courses.size(), 5);
        
    }

    @Test
    public void testCreateAccountValid() {
        boolean created = facade.createAccount("John", "Doe", "john@example.com", "johndoe", "password123");
        assertTrue(created, "Expected account to be created successfully");
        
        User newUser = UserList.getInstance().getUser("johndoe");
        assertNotNull(newUser, "New user should be present in UserList");
        assertEquals("johndoe", newUser.getUsername(), "Username should match");
    }

    @Test
    public void testCreateAccountDuplicateUsername() {
        facade.createAccount("Jane", "Doe", "jane@example.com", "janedoe", "password123");
        
        boolean createdDuplicate = facade.createAccount("Janet", "Doe", "janet@example.com", "janedoe", "password456");
        assertFalse(createdDuplicate, "Account with duplicate username should not be created");
    }

    @Test
    public void testCreateSaved() {
        facade.createAccount("Frank", "Marks", "frank.marks@example.com", "fmarks", "password123");
        facade.logout("fmarks");

        // Reinitialize facade to simulate application restart
        facade = CategorySystemFacade.getFacadeInstance();
        facade.login("fmarks", "password123");
        User currentUser = facade.getCurrentUser();
        assertEquals("Expected to retrieve username 'fmarks'", "fmarks", currentUser.getUsername());
    }

    @Test
    public void testCreateEmptyUserName() {
        boolean isCreated = facade.createAccount("", "", "invalid@example.com", "", "pass");
        assertFalse("Account creation should fail for empty username.", isCreated);
    }

}
