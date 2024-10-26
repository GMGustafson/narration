package com.language;

import java.util.ArrayList;
import java.util.UUID;
/**
 * @author zaniah
 */
public class UserList {
    /**
     * attributes for userlist
     */
   // private static UserList userList;
    private static UserList userList;
    private ArrayList<User> users;
    private UUID id;

    /**
     * private constructor
     */
   private UserList(){
        //this.users = new ArrayList<>();
        //users = DataLoader.getUserList();
        users = DataLoader.getUsers();
        this.id = UUID.randomUUID();
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    /**
     * getnstance method (singleton design pat.)
     * creates one instance of the user list
     * @return a single instance of the list
     */
    public static UserList getInstance(){
        if (userList == null){
            userList = new UserList();
        }
        return userList;
    }

    /**
     * getUser method
     * retrieves the users info (username)
     * @param username the users username that they created
     * @return user
     */
    public User getUser(String username){
        for(User user : users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
            return null;
    }

    /**
     * addUser method
     * adds the users info to the app to create account
     * @param firstName users first name
     * @param lastName users last name
     * @param email users email
     */
    public boolean addUser(String firstName, String lastName, String email, String username, String password){
        //User.add(new User(firstName, lastName, email));

        //validate first name
        if (!validName(firstName)) {
            System.out.println("First name must have at least one character!");
            return false;
        }

        // Validate last name
        if (!validName(lastName)) {
            System.out.println("Last name must have at least one character!");
            return false;
        }

        //valudate email
        if (!validEmail(email)) {
            System.out.println("Invalid email!");
            return false;
        }

        //validate username
        if (getUser(username) != null) {
            System.out.println("This username is taken");
            return false;
        }

        //validate password
        if (password.length() < 7) {
            System.out.println("Password must be at least 7 characters");
            return false;
        }

        User newUser = new User(id, firstName, lastName, email, "", null, username,  password);
        users.add(newUser);
        return true;
    }

    /**
     * editUser method
     * able to make any changes to the info the user provided
     * @param firstName users first name
     * @param lastName users last name
     * @param email users email
     * @param username users username
     * @param password users password
     */
    public void editUser(User user, String firstName, String lastName, String email, String username, String password){
        if (user == null) {
            System.out.println(" User not found!");
            return;
        }
            // Edit First Name & make sure its valid
            if (firstName != null && !firstName.trim().isEmpty()) {
                user.setFirstName(firstName);
                System.out.println("Your first name has been updated!");
            } else {
                System.out.println("First name not updated.");
            }

            // Edit Last Name & make sure ots valid
            if (lastName != null && !lastName.trim().isEmpty()) {
                user.setLastName(lastName);
                System.out.println("Your last name has been updated!");
            } else {
                System.out.println("Last name not updated.");
            }

            // Edit Email & make sure its valid
            if (email != null && validEmail(email)) {
                user.setEmail(email);
                System.out.println("Your email has been updated!");
            } else {
                System.out.println("Email not updated.");
            }

            // Edit Username & make sure its valid
            if (user.getUsername() != null && !user.getUsername().trim().isEmpty()) {
                user.setEnterUsername(user.getUsername());
                System.out.println("Your username has been updated!");
            } else {
                System.out.println("Username not updated.");
            }

            // Edit Password & make sure its valid
            if (user.getPassword() != null && user.getPassword().length() >= 7) {
                user.setEnterPassword(user.getPassword());
                System.out.println("Your password has been updated!");
            } else {
                System.out.println("Password not updated.");
            }
    }
    
    /**
     * saveUsers method
     * saves all the users info (first, last, email)
     */
    public void saveUsers(){
        DataWriter.saveUsers();
    }
    
    /**
     * private helper method
     * validates users first and last name
     * first and last should have at least one character
     * @param name users first/last name
     * @return valid first/last name
     */
    private boolean validName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    /**
     * private helper method
     * validate email method
     * email is valid if it has the "@" symbol and a "."
     * email is not valid if it doesnt have "@" or "."
     * valid email ex: janedoe@omg.com
     * @param email the users emial
     * @return valid email
     */
    private boolean validEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    // public ArrayList getUsers() {
    //     return users;
    // }
}