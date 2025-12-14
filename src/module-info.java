/**
 * 
 */
/**
 * 
 */
module miniErpapp {
	requires javafx.fxml;
	requires javafx.controls;

    requires java.desktop;
	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;

    opens views.ui to javafx.fxml;          // To load FXML from /ui/Login.fxml
    opens views.jfxcontrols to javafx.fxml;
    exports app;                      // Your Main class

	opens app to javafx.graphics, javafx.fxml;
}