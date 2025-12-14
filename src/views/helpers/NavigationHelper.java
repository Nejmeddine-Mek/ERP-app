package views.helpers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NavigationHelper {
	
	public static void goToPOS(Class<?> clazz) {
	    System.out.println("going to pos");
	    try {
	        FXMLLoader loader = new FXMLLoader(clazz.getResource("/views/ui/sales.fxml"));
	        Parent root = loader.load();

	        Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.show();  // <- SHOW THE WINDOW

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public static void goToClients(Class<?> clazz) {
	    System.out.println("going to pos");
	    try {
	        FXMLLoader loader = new FXMLLoader(clazz.getResource("/views/ui/clients.fxml"));
	        Parent root = loader.load();

	        Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.show();  // <- SHOW THE WINDOW

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
	}
	public static void goToSuppliers() {
		
	}
	public static void goToProducts() {
		
	}
	public static void goToHistory() {
		
	}
	public static void goToDashboard() {
		
	}
}
