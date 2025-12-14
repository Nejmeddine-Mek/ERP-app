package controls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import controls.helpers.DBHelper;
import controls.helpers.PasswordHelper;
import models.User;

public class LoginController {
	private static final String users_DB = "users.db";
	
	// this controller handle the communication between the front and back, for example, here we connect to database
	public Optional<User> Login(String username, String password){
		Connection c = DBHelper.connect(users_DB, 1);
	
		if(c == null)
			return Optional.empty();
		try {
			PreparedStatement pstmt = c.prepareStatement("SELECT * FROM users WHERE username = ?;");
			pstmt.setString(1, username);
			ResultSet res = pstmt.executeQuery();
	        String pswd = res.getString("password");
	        username = res.getString("username");
	        byte[] salt = res.getBytes("salt");
	        int privilege = res.getInt("privilege");
	        
	        if((int) PasswordHelper.hashPassword(password, salt).compareTo(pswd) == 0) {
	        	return Optional.of(new User(username, pswd,(byte)privilege));
	        }	
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Optional.empty();
		
	}
}
