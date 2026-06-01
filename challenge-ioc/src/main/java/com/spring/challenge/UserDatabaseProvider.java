package com.spring.challenge;

public class UserDatabaseProvider implements UserDataProvider {
    @Override
    public String getUserDetails() {
        return "User Details From Database";
    }
}
