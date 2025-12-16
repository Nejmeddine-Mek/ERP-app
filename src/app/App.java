package app;

import java.io.File;
import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.models.UserView;


public class App extends Application{
	// there is no need to initialize this one, as it will be initialized once we login
	@SuppressWarnings("exports")
	public static UserView user;
	
	public static void main(String args[]) {

		System.load(new File("sqlite3.dll").getAbsolutePath());
		
		System.out.println("test");
		launch(args);
	}
    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
		Parent root;
		try {
			LanguageManager.setLanguage("ar");
			root = FXMLLoader.load(getClass().getResource("/views/ui/sales.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

    }
}
