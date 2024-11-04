package com.language;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.UUID;


import com.language.User;
import com.language.UserList;
import com.language.DataLoader;
import com.language.DataWriter;


public class UserListTester {
    private UserList userlist;
    private User user;
    private ArrayList<User> users = new ArrayList<>();
    private UUID id;

    @Before
    public void setup(){
        userlist = new UserList();
        userlist.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat");
        user = userlist.getUser("johndoe73");
    }

    @Test
    public void testGetUsersIfOneUsers(){
        ArrayList<User> users = userlist.getUsers();
        assertEquals(2, users.size());

    }

    @Test
    public void testGetUsers(){
        userlist.addUser("John", "Doe", "jdoe@gmail.com", "johndoe73", "ilovemyCat");
        ArrayList<User> users = userlist.getUsers();
        assertEquals("johndoe73", users.get(0).getUsername());
    }

    // should return johndoe73
    @Test
    public void testGetUser(){
        userlist.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat");
        User user = userlist.getUser("johnsmith73");
        assertEquals(null, user);
    }

    @Test
    public void testGetNullUser(){
        userlist.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat");
        User user = userlist.getUser(" ");
        assertEquals(null, user);
    }

    // should return true
    @Test
    public void testAddUser(){
        boolean add = userlist.addUser("John", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat");
        assertEquals(false, add);
    }

    @Test
    public void testAddUserFirstName(){
        boolean firstname = userlist.addUser("", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat");
        assertEquals(false, firstname);
    }

    @Test
    public void testAddUserLastName(){
        boolean lastname = userlist.addUser("John", "", "johndoe@gmail.com", "johndoe73", "IlovemyCat");
        assertEquals(false, lastname);
    }

    @Test
    public void testAddUserEmail(){
        boolean email = userlist.addUser("John", "", "johndoemail", "johndoe73", "IlovemyCat");
        assertEquals(false, email);
    }

    @Test
    public void testAddUserPassword(){
        boolean password = userlist.addUser("John", "", "johndoe@gmail.com", "johndoe73", "");
        assertEquals(false, password);
    }

    @Test
    public void testEditFirstName(){
        userlist.editUser(user, "Johnny", null, null, null, null);
        assertEquals("Johnny", user.getFirstName());
    }

    @Test
    public void testEditLastName(){
        userlist.editUser(user, null, "Doer", null, null, null);
        assertEquals("Doer", user.getLastName());
    }

    @Test
    public void testEditEmail(){
        userlist.editUser(user, null, null , "johnsmith@email.org", null, null);
        assertEquals("johnsmith@email.org", user.getEmail());
    }

    // should return incorrect username
    @Test
    public void testEditUsername(){
        userlist.editUser(user, null, null , null, "johndoe", null);
        assertEquals("IlovemyCat", user.getUsername());
    }

    // should return the changed incorrect password
    @Test
    public void testEditPassword(){
        userlist.editUser(user, null, null , null, null, "IlovemyDog");
        assertEquals("IlovemyCat", user.getPassword());
    }

    @Test
    public void testEditInvalidFirstName(){
        userlist.editUser(user, "", "Doe", "johndoe@gmail.com", "johndoe73", "IlovemyCat");
        assertEquals("John", user.getFirstName());
    }

    @Test
    public void testEditInvalidLastName(){
        userlist.editUser(user, "John", "", "johndoe@gmail.com", "johndoe73", "IlovemyCat");
        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void testEditInvalidEmail(){
        userlist.editUser(user, "John", "Doe", "", "johndoe73", "IlovemyCat");
        assertEquals("johndoe@gmail.com", user.getEmail());
    }

    @Test
    public void testEditInvalidPassword(){
        userlist.editUser(user, "John", "Doe", "johndoe@gmail.com", "johndoe73", "");
        assertEquals("IlovemyCat", user.getPassword());
    }

    @Test
    public void testValidFirstName(){
        boolean valName = userlist.validName("John");
        assertEquals(true, valName);
    }

    @Test
    public void testValidName(){
        boolean valName = userlist.validName("John Doe");
        assertEquals(true, valName);
    }

    @Test
    public void testEmptyName(){
        boolean invalName = userlist.validName("");
        assertEquals(false, invalName);
    }

    @Test
    public void testNullName(){
        boolean invalName = userlist.validName("");
        assertEquals(false, invalName);
    }

    @Test
    public void testValidEmail(){
        boolean valEmail = userlist.validEmail("johndoe@gmail.com");
        assertEquals(true, valEmail);
    }

    @Test
    public void testInvalidEmail(){
        boolean valEmail = userlist.validEmail("johndoegmailcom");
        assertEquals(false, valEmail);
    }

    @Test
    public void testEmptyEmail(){
        boolean valEmail = userlist.validEmail("johndoegmailcom");
        assertEquals(false, valEmail);
    }

}
