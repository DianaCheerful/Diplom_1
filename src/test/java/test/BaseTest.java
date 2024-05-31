package test;

import praktikum.Database;

public class BaseTest {

    private static final Database databaseTest = new Database();

    public static Database getDataBase() {
        return databaseTest;
    }
}
