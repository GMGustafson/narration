package com.language;

public class UITest {
    private CategorySystemFacade facade;

    public UITest() {

    }

    public void run() {
        facade = CategorySystemFacade.getFacadeInstance();
        login();
        logout();

    }

    public void login() {
        if(!facade.login("johndoe73", "IlovemyCat")){
            System.out.println("Couldn't login John");
            return;
        }
        User user = facade.getCurrentUser();
        System.out.println(user.getFirstName() + " " + user.getLastName() + " is now logged in");
    }

    public void logout(){
        if(!facade.logout("jonedoe73")){
            System.out.println("User couldnt log out");
            return;
        }
        User user = facade.getCurrentUser();
        System.out.println(user.getFirstName() + " " + user.getLastName()+ "is now logged out");
    }

    public static void main(String[] args){
        UITest tester = new UITest();
        tester.run();
    }
}
