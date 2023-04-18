package com.example.modelemvc.service;

public class AdminService {

    public static boolean checkAdminCredentials(String username, String password) {
        boolean credentialsOkay = false;
        if (username == "admin" && password == "admin") {
            credentialsOkay = true;
        }
        return credentialsOkay;
    }
}
