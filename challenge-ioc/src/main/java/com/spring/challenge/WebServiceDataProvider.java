package com.spring.challenge;

public class WebServiceDataProvider implements UserDataProvider {
    @Override
    public String getUserDetails() {
        return "Fetching Data From Web Service";
    }
}
