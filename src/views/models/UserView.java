package views.models;

import javafx.beans.property.SimpleStringProperty;
import models.User;

public class UserView {
	// here are the properties we need for the ui
	private SimpleStringProperty username;
	private SimpleStringProperty occupation;
	
	public UserView(String username, String occupation) {
		this.username = new SimpleStringProperty();
		this.occupation = new SimpleStringProperty();
		this.username.set(username);
		this.occupation.set(occupation);
	}
	
	public UserView(User user) {
		this.username = new SimpleStringProperty();
		this.occupation = new SimpleStringProperty();
		this.username.set(user.getUsername());
		this.occupation.set(user.getOccupation());
		
	}
	
	public SimpleStringProperty getUsername() {
		return this.username;
	}
	
	public SimpleStringProperty getOccupation() {
		return this.occupation;
	}
	
}
