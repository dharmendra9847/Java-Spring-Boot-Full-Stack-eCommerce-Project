package com.loose.coupling;

// A - MySQL, PostgreSQL
// B - Web Service, MongoDB

public class UserDatabase implements UserDataProvider {

    public String getUserDetails() {

        // Directly access database here
        return "User Details From Database";
    }
}
