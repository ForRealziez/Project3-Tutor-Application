package za.ac.cput.TutorApplication;

import za.ac.cput.database.Database;
import za.ac.cput.database.StaffDatabase;
import za.ac.cput.guis.LoginA;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database.main();
        new StaffDatabase();
        new LoginA().setVisible(true);
    }
}