package views.jfxcontrols;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import app.LanguageManager;
import controls.LoginController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.User;
import views.helpers.NavigationHelper;
import views.models.UserView;

public class LoginView implements Initializable{
	public static final String forbidden = ".*[\\[\\]{};:\"'<>?/\\\\*|].*";
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private Button loginBtn;
	@FXML private Label forgotPassword;
	@FXML private Label usernameLabel;
	@FXML private Label passwordLabel;
	@FXML private Label loginTitle;
	@FXML private Label loginSubTitle;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Platform.runLater(()->{
			ResourceBundle bundle = LanguageManager.getBundle();
			this.loginTitle.setText(bundle.getString("login.title"));
			this.loginSubTitle.setText(bundle.getString("login.subtitle"));
			this.usernameLabel.setText(bundle.getString("login.username"));
			this.passwordLabel.setText(bundle.getString("login.password"));
			this.loginBtn.setText(bundle.getString("login.login"));
		});
	}
	@FXML
	public void clickLogin() {
		// here, remove err-field from the style classes of the buttons
		if(username.getStyleClass().contains("err-field"))
			username.getStyleClass().remove("err-field");
		if(password.getStyleClass().contains("err-field"))
			password.getStyleClass().remove("err-field");
		// here the login process happens
		if(username.getText().isEmpty()) {
			username.getStyleClass().add("err-field");
			System.out.println("No login");
			// no login here
			return ;
		}
		// verify the password is empty
		if(password.getText().isEmpty()) {
			password.getStyleClass().add("err-field");
			System.out.println("no login 2");
			// no login again
			return ;
		}
		
		// we fetch the user
		LoginController lc = new LoginController();
		Optional<User> u = lc.Login(username.getText(), password.getText());
		// we check if the user optional is empty
		if(!u.isEmpty()) {
			
			app.App.user = new UserView(u.get().getUsername(),u.get().getOccupation());
			// and then go to the POS window
			NavigationHelper.goToPOS(SalesView.class);
		} else {
			// if the user optional is empty, add both to fields to the << err-field >> class
			password.getStyleClass().add("err-field");
			username.getStyleClass().add("err-field");
			return;
		}
		
	}
}
