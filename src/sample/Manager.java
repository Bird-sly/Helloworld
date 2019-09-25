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
            rs = stmt.executeQuery("SELECT * FROM product;");

            while(rs.next()) {
                System.out.printf("ID = %d%n", rs.getInt("id"));
                System.out.printf("Name = %s%n", rs.getString("name"));
                System.out.printf("Type = %s%n", rs.getString("type"));
                System.out.printf("Manufacture =%%n",rs.getString("manufacture") );
            }
        } catch (SQLException e) {
            this.sqlExceptionHandler(e);
        }

    }

    public void closeCon() {
        try {
            this.con.close();
        } catch (SQLException e) {
            this.sqlExceptionHandler(e);
        }

    }

    public void sqlExceptionHandler(SQLException error) {
        System.out.println("Standard Failure: " + error.getMessage());
    }
}
