package views.jfxcontrols;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import controls.ClientController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import models.Client;
import views.helpers.NavigationHelper;
import views.models.ClientModelView;

public class ClientView implements Initializable{
	
	@FXML private Button pos;
	@FXML private Button products;
	@FXML private Button clients;
	@FXML private Button suppliers;
	@FXML private Button history;
	@FXML private Button dashboard;
	
	@FXML private TextField nameSearchField;
	@FXML private TextField deptSearchField;
	@FXML private TextField transactionSearchField;
	
	@FXML private TableView<ClientModelView> table;
	@FXML private TableColumn<ClientModelView,String> nameColumn;
	@FXML private TableColumn<ClientModelView,Integer> idColumn; 
	@FXML private TableColumn<ClientModelView,String> phoneColumn;
	@FXML private TableColumn<ClientModelView,Float> deptsColumn;
	@FXML private TableColumn<ClientModelView,Integer> transactionColumn; 
	
	
	@FXML private Label date;
	@FXML private Label username;
	@FXML private Label occupation;
	@FXML private Label clientsCount; 
	// container of client addition form
	@FXML private VBox detailsFieldBox;
	// fields to add a client
	@FXML private TextField nameField;
	@FXML private TextField phoneField;
	@FXML private TextField deptsField;
	@FXML private TextField transactionsField;
	
	@FXML private Button removeBtn;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

			
		// one shall load all clients from the database
		// TODO Auto-generated method stub
		Platform.runLater(() -> {
			this.removeBtn.setVisible(false);
			
			this.table.setRowFactory(_ -> {
				TableRow<ClientModelView> row  = new TableRow<>();
				row.setOnMouseClicked(click -> {
					if(click.getClickCount() == 2) {
						// open the display window to edit data or delete
					}
				});
				
				return row;
			});
			if(this.detailsFieldBox != null)
			this.detailsFieldBox.setVisible(false);
			this.table.widthProperty().addListener((_,_,newVal) -> {
				double width = newVal.doubleValue();
				
				this.idColumn.setPrefWidth(width * 0.1);
				this.nameColumn.setPrefWidth(width * 0.35);
				this.phoneColumn.setPrefWidth(width * 0.2);
				this.deptsColumn.setPrefWidth(width * 0.2);
				this.transactionColumn.setPrefWidth(width * 0.15);
				
			});
			// set behavior of navigation buttons
			this.pos.setOnAction(_ -> NavigationHelper.goToPOS(this.getClass()));
			this.clients.setOnAction(_ -> NavigationHelper.goToClients(this.getClass()));
			this.suppliers.setOnAction(_ -> NavigationHelper.goToSuppliers());
			this.products.setOnAction(_ -> NavigationHelper.goToProducts());
			this.history.setOnAction(_ -> NavigationHelper.goToHistory());
			this.dashboard.setOnAction(_ -> NavigationHelper.goToDashboard());
			
			// format table cells
			this.idColumn.setCellValueFactory(cell -> cell.getValue().getId().asObject());
			this.nameColumn.setCellValueFactory(cell -> cell.getValue().getName());
			this.phoneColumn.setCellValueFactory(cell -> cell.getValue().getPhone());
			this.deptsColumn.setCellValueFactory(cell -> cell.getValue().getDepts().asObject());
			this.transactionColumn.setCellValueFactory(cell -> cell.getValue().getTransactions().asObject());
			
			// load data into tables and all 
			ClientController cc = new ClientController();
			Optional<List<ClientModelView>> res = cc.loadClients();
			if(!res.isEmpty()) {
				ObservableList<ClientModelView> cmvol =FXCollections.observableArrayList();
				cmvol.addAll(res.get());

				table.getItems().clear();
				table.setItems(cmvol);
				
				// set the count of the clients in the specified label
				this.clientsCount.setText(String.format("%d", cmvol.size()));
				}
		});
	}
	
	public void clickShowForm() {
		if(this.detailsFieldBox != null)
			this.detailsFieldBox.setVisible(true);
		this.nameField.setPromptText("Client name");
		this.phoneField.setPromptText("Client's phone Number");
		this.deptsField.setPromptText("Client's current depts");
		this.transactionsField.setPromptText("Client's transactions");
		System.out.println("Add client");
	}
	
	public void clickAddClient() {
		String name = this.nameField.getText();
		String phone = this.phoneField.getText();
		float depts = Float.parseFloat(this.deptsField.getText());
		int transactions = Integer.parseInt(this.transactionsField.getText());
		ClientController cc = new ClientController();
		ClientModelView cmv = cc.addClient(new Client(1,name, phone, depts,transactions));
		
		if(cmv == null) {
			System.out.println("you disgrace");
			return;
		}
		
		table.getItems().add(cmv);
		this.clientsCount.setText(String.format("%d", table.getItems().size()));
		this.nameField.setText("");
		this.phoneField.setText("");
		this.deptsField.setText("");
		this.transactionsField.setText("");
	}
	public void clickRemoveClient() {
		
	}
}
