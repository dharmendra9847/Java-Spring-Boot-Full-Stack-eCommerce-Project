package com.loose.coupling;

public class LooseCouplingExample {
    
    public static void main(String[] args) {

        UserDataProvider dataProvider = new UserDatabaseProvider();
        UserManager userManager = new UserManager(dataProvider);
        System.out.println(userManager.getUserInfo());

        UserDataProvider webServiceDataProvider = new WebServiceDataProvider();
        UserManager userManagerWithWebServiceProvider = new UserManager(webServiceDataProvider);
        System.out.println(userManagerWithWebServiceProvider.getUserInfo());

        UserDataProvider newDatabaseProvider = new NewDatabaseProvider();
        UserManager userManagerWithNewDatabaseProvider = new UserManager(newDatabaseProvider);
        System.out.println(userManagerWithNewDatabaseProvider.getUserInfo());
    }
}
