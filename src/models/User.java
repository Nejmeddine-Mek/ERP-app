package models;

public class User {
	public static final int MAX_PRIVILEGE = 3;
	private String username;
	private String password; // this is usually going to be hashed or whatever, i dont know
	private String occupation;
	private byte privilege;
	
	public User() {
		
	}

	public User(String name, String pass, byte privilege) {
		this.username = name;
		this.password = pass;
		this.privilege = privilege;
		this.occupation = whichOccupation(privilege);
	}


	public String getUsername() {
		return this.username;
	}
	public String getOccupation() {
		return this.occupation;
	}
	public void setUsername(String name) {
		this.username = name;
	}
	public void setPrivilege(byte p) {
		this.privilege = p;
	}
	
	public static String whichOccupation(byte privilege2) {
		switch(privilege2) {
			case 0:
				return"Cashier";
			case 1:
				return"Manager";
			case 2:
				return "Owner";
	
			default:
				return "Not listed";

		}
	}
	public static int whichOccupation(String privilege2) {
		switch(privilege2) {
			case "Cashier":
				return 0;
			case "Manager":
				return 1;
			case "Owner":
				return 2;
	
			default:
				return 255;

		}
	}
}
