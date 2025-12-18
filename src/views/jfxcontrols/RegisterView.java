package views.jfxcontrols;


import java.net.URL;
import java.util.ResourceBundle;

import app.LanguageManager;
import controls.RegisterController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.User;

public class RegisterView implements Initializable{
	public static final String forbidden = ".*[\\[\\]{};:\"'<>?/\\\\*|].*";
	
	@FXML private TextField username;
	@FXML private PasswordField pswd;
	@FXML private PasswordField cpswd;
	@FXML private MenuButton pmenu;
	@FXML private Label returnMsg;
	@FXML private Label registerTitle;
	@FXML private Label usernameLabel;
	@FXML private Label passwordLabel;
	@FXML private Label confirmLabel;
	@FXML private Button registerBtn;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TODO Auto-generated method stub
		Platform.runLater(()-> {
			ResourceBundle bundle = LanguageManager.getBundle();
			this.registerTitle.setText(bundle.getString("register.title"));
			this.usernameLabel.setText(bundle.getString("register.username"));
			this.passwordLabel.setText(bundle.getString("register.password"));
			this.confirmLabel.setText(bundle.getString("register.confirmPassword"));
			this.registerBtn.setText(bundle.getString("register.register"));
		});
		// here, initialize the menu button with the necessary options
		for(int i = 0; i < User.MAX_PRIVILEGE; i++) {
			MenuItem mi = new MenuItem();
			mi.setText(User.whichOccupation((byte)i));
			mi.setOnAction(_ -> pmenu.setText(mi.getText()));
			//mi.getStyleClass().add(".menu-option");
			mi.setStyle("-fx-text-fill: rgb(36, 156, 255);");
			pmenu.getItems().add(mi);
		}
	}
	
	public void clickRegister() {
		returnMsg.setText("");
		// removing err-field classes from all input fields
		if(username.getStyleClass().contains("err-field"))
			username.getStyleClass().remove("err-field");
		
		if(pswd.getStyleClass().contains("err-field"))
			pswd.getStyleClass().remove("err-field");
		
		if(cpswd.getStyleClass().contains("err-field"))
			cpswd.getStyleClass().remove("err-field");
		// check if the field is empty
		if(username.getText().isEmpty()) {
			username.getStyleClass().add("err-field");
			return;
		}
		// check if the field of user name has any forbidden character
		if(username.getText().matches(forbidden)) {
			username.setText("");
			username.getStyleClass().add("err-field");
			return;
		}
		// ensure password field is not empty
		if(pswd.getText().isEmpty()) {
			// no register
			pswd.getStyleClass().add("err-field");
			return;
		}
		// ensure the confirm password field is not empty
		// I think we can get rid of this
	/*	if(cpswd.getText().isEmpty()) {
			// no register
			cpswd.getStyleClass().add("err-field");
			return;
		} */
		// ensure the passwords match
		if(cpswd.getText().compareTo(pswd.getText()) != 0) {
			// no register
			cpswd.getStyleClass().add("err-field");
			pswd.getStyleClass().add("err-field");
			return;
		}
		// now call the controller
		RegisterController rc = new RegisterController();
		boolean res = rc.register(username.getText(), pswd.getText(), (byte)User.whichOccupation(pmenu.getText()));
		if(res) {
			returnMsg.setStyle("-fx-text-fill: #1ABC9C;");
			returnMsg.setText("user added successfully");
		} else {
			returnMsg.setStyle("-fx-text-fill: #EF4444;");
			returnMsg.setText("failed to add user");
		}
	}
	
}
