package controls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import controls.helpers.DBHelper;
import controls.helpers.PasswordHelper;


public class RegisterController {

	private static final String DB_name = "users.db";
	
	
	public boolean register(String username, String password, byte privilege) {
		// here, first of all, one must generate a salt key then hash the password using it
		byte[] salt = PasswordHelper.generateSalt();
		String pswd = PasswordHelper.hashPassword(password, salt);
		// then we shall connect to the database
		Connection c = DBHelper.connect(DB_name, 1); 
		if(c == null)
			return false;
		try {
			// now we prepare and execute the query that inserts the new user into our database
			String query = "INSERT INTO users (username, password, salt, privilege) VALUES (?,?,?,?)";
			PreparedStatement pstmt = c.prepareStatement(query);
			pstmt.setString(1,username);
			pstmt.setString(2, pswd);
			pstmt.setBytes(3, salt);
			pstmt.setInt(4, privilege);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
