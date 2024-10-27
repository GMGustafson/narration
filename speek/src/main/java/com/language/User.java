package com.language;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author zaniah, sri, gracie, and grace
 */

public class User{

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String username;
    private String password;
    private HashMap<Course,Progress> courses;

    /**
     * Constructor for User that makes a HashMap
     * @param id
     * @param firstName
     * @param lastName
     * @param email
     * @param phoneNumber
     * @param dateOfBirth
     * @param username
     * @param password
     */
    public User(UUID id, String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth, String username, String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
        this.courses = new HashMap <>();
    }

    /**
     * Constructor for User
     * @param id
     * @param firstName
     * @param lastName
     * @param email
     * @param phoneNumber
     * @param dateOfBirth
     * @param username
     * @param password
     * @param courses
     */
    public User(UUID id, String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth, String username, String password, HashMap<Course,Progress> courses) {
        this(id, firstName, lastName, email, "", dateOfBirth, username, password);
    }

    /**
     * getID method
     * Returns user ID
     * @return id
     */
    public UUID getId() {
        return id;
    }

    /**
     * getFirstName method
     * Returns user's first name
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setFirstName method
     * Sets user's first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

     /**
     * getLastName method
     * Returns user's last name
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setLastName method
     * Sets user's last name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getEmail method
     * Returns user's email
     * @return email
     */
    public String getEmail(){
        return email;
    }

    /**
     * setEmail method
     * Sets user's email
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }

<<<<<<< HEAD
    public String getPhoneNumber(){
        if (phoneNumber != null && phoneNumber.length() == 10) {
            return phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6);
        }
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

=======
    /**
     * getUsername method
     * Returns user's username
     * @return username
     */
>>>>>>> ebf6383187d35a2c554d32adc15ff4b28b4dc7b8
    public String getUsername(){
        return username;
    }

    /**
     * setUsername method
     * Sets user's username
     * @param username
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * getEnterUsername method
     * Returns user's entered username
     * @return username
     */
    public String getEnterUsername(){
        return username;
    }

    /**
     * setEnterUsername method
     * Sets user's entered username
     * @param username
     */
    public void setEnterUsername(String username){
        this.username = username;
    }

    /**
     * getPassword method
     * Returns user's password
     * @return password
     */
    public String getPassword(){
        return password;
    }

    /**
     * setPassword method
     * Sets user's password
     * @param password
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * getEnterPassword method
     * Returns user's entered password
     * @return password
     */
    public String getEnterPassword() {
        return password;
    }

    /**
     * setEnterPassword method
     * Sets user's entered password
     * @param password
     */
    public void setEnterPassword(String username){
        this.username = username;
    }

<<<<<<< HEAD
    public void forgotPassword(String newPassword){
        String defaultPassword = "LanguageLearner123@";
        if (newPassword.length() <= 8 || newPassword.length() > 20 || !newPassword.matches(".*[!@#$%^&*()].*")) {
            System.out.print("Password must be 8-20 characters and contain at least one special character. Now setting the default password.");
            this.password = defaultPassword;
        } else {
            this.password = newPassword;
=======
    /**
     * getPhoneNumber method
     * Returns user's phone numer if it is in a valid format
     * @return phoneNumber
     */
    public String getPhoneNumber(){
        if (phoneNumber != null && phoneNumber.length() == 10) {
            return phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6);
>>>>>>> ebf6383187d35a2c554d32adc15ff4b28b4dc7b8
        }
    }

<<<<<<< HEAD
=======
    /**
     * setPhoneNumber method
     * Sets user's phone number
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * getDateOfBirth method
     * Returns user's dateOfBirth
     * @return dateOfBirth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

     /**
     * setDateOfBirth method
     * Sets user's dateOfBirth
     * @param dateOfBirth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
>>>>>>> ebf6383187d35a2c554d32adc15ff4b28b4dc7b8

    /**
     * getFormattedDateOfBirth method
     * Returns user's dateOfBirth formatted in pattern MM/dd/yyyy
     * @return dateOfBirth
     */
    public String getFormattedDateOfBirth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return dateOfBirth.format(formatter);
    }

     /**
     * getCourses method
     * Returns HashMap of courses and progress
     * @return courses
     */
    public HashMap<Course, Progress> getCourses(){
        return courses;
    }

<<<<<<< HEAD
=======
    /**
     * setCourses method
     * Sets courses HashMap
     * @param courses
     */
>>>>>>> ebf6383187d35a2c554d32adc15ff4b28b4dc7b8
    public void setCourses(HashMap<Course, Progress> courses) {
        this.courses = courses;
    }

<<<<<<< HEAD
    
=======
     /**
     * forgotPassword method
     * Sets password to default if the user is not valid
     * @param newPassword
     */
    public void forgotPassword(String newPassword){
        String defaultPassword = "LanguageLearner123@";
        if (newPassword.length() <= 8 || newPassword.length() > 20 || !newPassword.matches(".*[!@#$%^&*()].*")) {
            System.out.print("Password must be 8-20 characters and contain at least one special character. Now setting the default password.");
            this.password = defaultPassword;
        } else {
            this.password = newPassword;
        }
    }
>>>>>>> ebf6383187d35a2c554d32adc15ff4b28b4dc7b8

    /** 
    * toString method
    * Returns User attributes in toString format
    * @return result
    */

    public String toString() {
        String result = "";
        result += id + "--" + firstName + "--" + lastName +"--" + email +"--" + phoneNumber + 
        "--" + dateOfBirth +"--" + username + "--" + password + "--" + courses; 

        return result; 
    
    }
}


