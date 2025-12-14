package controls.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	private static final String db_URL = "jdbc:sqlite:";
	// this establishes a connection to a database
	public static Connection connect(String db_name, int src) { // the src option is used to tell us which table to create in case if the table doesn't exists
		Connection connection = null;
		try {
			
			System.out.println("Connecting to: " + db_URL + db_name);
			connection = DriverManager.getConnection(db_URL + db_name);
			Statement stmt = connection.createStatement();
			String sql = "";
			
			switch(src) {
				// user schema
				case 1:
					sql = """
				      CREATE TABLE IF NOT EXISTS users (
				         id INTEGER PRIMARY KEY AUTOINCREMENT,
				         username TEXT NOT NULL UNIQUE,
				         password VARCHAR NOT NULL,
				         salt BLOB,
				         privilege INTEGER
					);""";
					break;
					// products schema
				case 2:
					sql = """
							CREATE TABLE IF NOT EXISTS products (
							id INTEGER AUTOINCREMENT,
							barCode VARCHAR PRIMARY KEY UNIQUE,
							description VARCHAR NOT NULL,
							sellingPrice FLOAT,
							buyingPrice FLOAT,
							hasDiscount BOOLEAN,
							discountQ INT,
							discountPrice FLOAT,
							createdOn DATETIME,
							updatedOn DATETIME
					);""";
					break;
					// categories schema
				case 3:
					sql = """
							CREATE TABLE IF NOT EXISTS categories (
							CATEGORY VARCHAR
							)""";
					break;
					// clients schema
				case 4:
					sql = """
							CREATE TABLE IF NOT EXISTS clients (
							id INTEGER PRIMARY KEY AUTOINCREMENT,
							name VARCHAR,
							phoneNumber VARCHAR UNIQUE,
							transactions INTEGER,
							depts FLOAT,
							createdOn DATETIME,
							updatedOn DATETIME,
							transactionsDates TEXT
							)""";
					break;
					// suppliers schema
				case 5:
					sql = """
							CREATE IF NOT EXISTS suppliers (
							id INTEGER PRIMARY KEY AUTOINCREMENT,
							name VARCHAR,
							phoneNumber VARCHAR UNIQUE,
							invoices INTEGER,
							depts DOUBLE,
							isActive BOOLEAN,
							company VARCHAR,
							createdOn TIMESTAMP,
							updatedOn TIMESTAMP,
							email VARCHAR
							
							)""";
					 // one should add the rest here
					break;

				default:
					sql = "";
				
			}
			
			stmt.execute(sql);

		} catch(SQLException exp) {
			System.out.println("Connection failed");
			System.out.println(exp.getMessage());
		}
		return connection;
	}
	// this closes the connection to the database
	public static boolean closeConnection(Connection c) {
		try {
			c.close();
			return true;
		} catch(SQLException e) {
			System.out.println("connection closing failed");
			return false;
		}
	}
	
}
