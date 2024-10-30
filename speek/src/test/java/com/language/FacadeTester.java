package com.language;

import com.language.CategorySystemFacade;
import com.language.User;
import static org.junit.Assert.*;

import java.nio.file.Paths;
import java.util.ArrayList;

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
}
