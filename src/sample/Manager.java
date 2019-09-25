package sample;

import java.sql.*;

public class Manager{
    private Connection con = null;

    public Manager() throws SQLException {
        this.con = DriverManager.getConnection("jdbc:h2:C:\\Users\\Brendan\\Documents\\DB\\test");
    }



    public void selectAll() {
        ResultSet rs = null;

        try {
            Statement stmt = this.con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employee;");

            while(rs.next()) {
                System.out.printf("uID = %d%n", rs.getInt("uid"));
                System.out.printf("Name = %s%n", rs.getString("name"));
            }
        } catch (SQLException var3) {
            this.sqlExceptionHandler(var3);
        }

    }

    public void closeCon() {
        try {
            this.con.close();
        } catch (SQLException var2) {
            this.sqlExceptionHandler(var2);
        }

    }

    public void sqlExceptionHandler(SQLException error) {
        System.out.println("Standard Failure: " + error.getMessage());
    }
}
