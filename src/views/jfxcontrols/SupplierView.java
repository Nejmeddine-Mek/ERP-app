package views.jfxcontrols;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import views.helpers.NavigationHelper;
import views.models.SupplierModelView;

public class SupplierView implements Initializable{
	
	@FXML private Button pos;
	@FXML private Button products;
	@FXML private Button clients;
	@FXML private Button history;
	@FXML private Button dashboard;
	
	@FXML private Label date;
	@FXML private Label occupation;
	@FXML private Label username;
	
	@FXML private TextField nameSearchField;
	@FXML private TextField deptSearchField;
	@FXML private TextField invoiceSearchField;
	
	@FXML private TableView<SupplierModelView> table;
	@FXML private TableColumn<SupplierModelView,Integer> idColumn;
	@FXML private TableColumn<SupplierModelView,String> companyColumn;
	@FXML private TableColumn<SupplierModelView,String> nameColumn;
	@FXML private TableColumn<SupplierModelView,String> activeColumn;
	@FXML private TableColumn<SupplierModelView,String> phoneColumn;
	@FXML private TableColumn<SupplierModelView,Integer> invoicesColumn;
	@FXML private TableColumn<SupplierModelView,Double> deptsColumn;
	
	@FXML private Label SupplierModelView;
	@FXML private VBox detailsFieldBox;
	
	@FXML private TextField nameField;
	@FXML private TextField companyField;
	@FXML private TextField phoneField;
	@FXML private TextField deptsField;
	@FXML private TextField invoicesField;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.detailsFieldBox.setVisible(false);
		
		// set widths of columns of the table
		this.table.widthProperty().addListener((_,_,newVal) -> {
			double width = newVal.doubleValue();
			this.idColumn.setPrefWidth(width * 0.1);
			this.companyColumn.setPrefWidth(width * 0.2);
			this.nameColumn.setPrefWidth(width * 0.2);
			this.activeColumn.setPrefWidth(width * 0.1);
			this.phoneColumn.setPrefWidth(width * 0.15);
			this.invoicesColumn.setPrefWidth(width * 0.1);
			this.deptsColumn.setPrefWidth(width * 0.15);
		});
		// set behavior of the buttons
		this.pos.setOnAction(_ -> NavigationHelper.goToPOS(this.getClass()));
		this.clients.setOnAction(_ -> NavigationHelper.goToClients(this.getClass()));
		this.products.setOnAction(_ -> NavigationHelper.goToProducts());
		this.history.setOnAction(_ -> NavigationHelper.goToHistory());
		this.dashboard.setOnAction(_ -> NavigationHelper.goToDashboard());
		
	}
	public void clickShowForm() {
		if(this.detailsFieldBox != null)
			this.detailsFieldBox.setVisible(true);
		this.nameField.setPromptText("Supplier's name");
		this.phoneField.setPromptText("Supplier's phone number");
		this.invoicesField.setPromptText("Number of Invoices");
		this.deptsField.setPromptText("Depts");
		this.companyField.setPromptText("Company's name");
		
	}
	
	public void clickAddSupplier() {
		
	}

}
