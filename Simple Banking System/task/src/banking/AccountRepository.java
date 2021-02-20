package banking;

import java.sql.*;
import java.util.ArrayList;

public class AccountRepository {
    public static final String DB_NAME = Main.getSavedArgs();
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;

    public static final String TABLE_CARD = "card";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NUMBER = "number";
    public static final String COLUMN_PIN = "pin";
    public static final String COLUMN_BALANCE = "balance";


    public Connection connect() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE  TABLE IF NOT EXISTS " + TABLE_CARD +
                    "(" +
                    COLUMN_ID + " INTEGER," +
                    COLUMN_NUMBER + " TEXT," +
                    COLUMN_PIN + " TEXT," +
                    COLUMN_BALANCE + " INTEGER DEFAULT 0)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String number, String pin) {
        String sql = "INSERT INTO " + TABLE_CARD +
                "(" +
                COLUMN_NUMBER + ", " +
                COLUMN_PIN +
                ") VALUES(?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, number);
            pstmt.setString(2, pin);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Account> getAllCustomer() {
        try (Connection conn = connect();
             Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM card";
            ResultSet rst;
            rst = stm.executeQuery(sql);
            ArrayList<Account> accountsList = new ArrayList<>();
            while (rst.next()) {
                Account account = new Account(rst.getString("number"), rst.getString("pin"), rst.getInt("balance"));
                accountsList.add(account);
            }
            return accountsList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public  ArrayList<Account> getAllCustNumbers() {
        try (Connection conn = connect();
             Statement stm = conn.createStatement()){
            String sql = "SELECT * FROM card";
            ResultSet rst;
            rst = stm.executeQuery(sql);
            ArrayList<Account> accountsList = new ArrayList<>();
            while (rst.next()) {
                Account account = new Account(rst.getString("number"));
                accountsList.add(account);
            }
            return accountsList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void addBalance(String number, int addBalance) {
        String sql = "UPDATE card " +
                "SET balance = balance + " + addBalance + " WHERE number = " + number;
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void substractBalance(String number, int subsBalance) {
        String sql = "UPDATE card " +
                "SET balance = balance - " + subsBalance + " WHERE number = " + number;
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAccount(String number) {
        String sql = "DELETE FROM  card " +
                " WHERE number = " + number;
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
