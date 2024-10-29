package com.language;

public class UITest {
    private CategorySystemFacade facade;

    public UITest() {

    }

    public void run() {
        facade = CategorySystemFacade.getFacadeInstance();
        login();

    }

    public void login() {
        if(!facade.login("johndoe73", "IlovemyCat")){
            System.out.println("Couldn't login John");
            return;
        }
        User user = facade.getCurrentUser();
        System.out.println(user.getFirstName() + " " + user.getLastName() + " is now logged in");
    }

    public static void main(String[] args){
        UITest tester = new UITest();
        tester.run();
    }
}
