package com.spring.challenge;

public class NewDatabaseProvider implements UserDataProvider {

    @Override
    public String getUserDetails() {
        return "New Database Provider in Action";
    }
}
