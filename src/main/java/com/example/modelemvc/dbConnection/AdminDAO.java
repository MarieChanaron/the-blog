package com.example.modelemvc.dbConnection;

import java.sql.Connection;

public class AdminDAO {

    private final Connection connectionToPostDb = ConnectionManager.openConnection();


}
