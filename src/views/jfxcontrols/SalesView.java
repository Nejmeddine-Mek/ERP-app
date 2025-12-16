package views.jfxcontrols;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import app.LanguageManager;
import javafx.application.Platform;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import views.helpers.NavigationHelper;
import views.models.ProductView;

public class SalesView implements Initializable{
	//--- HERE WE WRITE OUR Buttons and different elements
	@FXML private Button clients;
	@FXML private Button suppliers;
	@FXML private Button history;
	@FXML private Button dashboard;
	@FXML private Button pos;
	@FXML private Button products;
	
	
	@FXML private Label username;
	@FXML private Label occupation;
	@FXML private Label date;
	
	@FXML private Label codeLabel;
	@FXML private Label quantityLabel;
	@FXML private Label unitPriceLabel;
	@FXML private Label descriptionLabel;
	@FXML private Label subTotalLabel;
	
	@FXML private Label netTotalLabel;
	@FXML private Label discountLabel;
	@FXML private Label toPayTotalLabel;
	@FXML private Label trnascationsLabel;
	
	@FXML private Label total_label;
	@FXML private Label payable_total;
	@FXML private Label discount;
	@FXML private Label net_total;
	
	@FXML private Button discountBtn;
	@FXML private Button customFeeBtn;
	@FXML private Button creditBtn;
	
	@FXML private TableView<ProductView> table;
	@FXML private TableColumn<ProductView,Integer> idColumn;
	@FXML private TableColumn<ProductView, String> descriptionColumn;
	@FXML private TableColumn<ProductView, Integer> quantityColumn;
	@FXML private TableColumn<ProductView, Float> unitPriceColumn;
	@FXML private TableColumn<ProductView, Float> subTotalColumn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(app.App.user != null) {
			username.setText(app.App.user.getUsername().get());
			occupation.setText(app.App.user.getOccupation().get());
		}
		LocalDate ld = LocalDate.now();
		date.setText(ld.toString());

		
		// TODO Auto-generated method stub
		// first of all, we must set the default behavior of buttons in run later
		Platform.runLater(() -> {
			// set the text on the labels
			{
				ResourceBundle bundle = LanguageManager.getBundle();
				this.pos.setText(bundle.getString("sales.pos"));
				this.products.setText(bundle.getString("sales.products"));
				this.clients.setText(bundle.getString("sales.clients"));
				this.suppliers.setText(bundle.getString("sales.suppliers"));
				this.history.setText(bundle.getString("sales.history"));
				this.dashboard.setText(bundle.getString("sales.dashboard"));
				this.codeLabel.setText(bundle.getString("sales.code"));
				this.quantityLabel.setText(bundle.getString("sales.quantity"));
				this.unitPriceLabel.setText(bundle.getString("sales.unitPrice"));
				this.subTotalLabel.setText(bundle.getString("sales.subTotal"));
				this.idColumn.setText(bundle.getString("sales.id"));
				this.descriptionColumn.setText(bundle.getString("sales.description"));
				this.unitPriceColumn.setText(bundle.getString("sales.unitPrice"));
				this.quantityColumn.setText(bundle.getString("sales.qty"));
				this.subTotalColumn.setText(bundle.getString("sales.subTotal"));
				this.netTotalLabel.setText(bundle.getString("sales.netTotal"));
				this.discountLabel.setText(bundle.getString("sales.discount"));
				this.toPayTotalLabel.setText(bundle.getString("sales.totalPay"));
				this.trnascationsLabel.setText(bundle.getString("sales.trnasactions"));
				this.discountBtn.setText(bundle.getString("sales.addDiscount"));
				this.customFeeBtn.setText(bundle.getString("sales.customFee"));
				this.creditBtn.setText(bundle.getString("sales.addCredit"));
				
				
			}
			// on each window, we don't reload the page when clicking on it's button
			//this.price.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
			this.idColumn.setCellValueFactory(cell -> cell.getValue().idProperty().asObject());
		
			this.descriptionColumn.setCellValueFactory(cell -> cell.getValue().descriptionProperty());
			this.unitPriceColumn.setCellValueFactory(cell -> cell.getValue().sellinPriceProperty().asObject());
			this.quantityColumn.setCellValueFactory(cell -> cell.getValue().quantityProperty().asObject());
			this.subTotalColumn.setCellValueFactory(cell -> cell.getValue().subTotalProperty().asObject());
			products.setOnAction( _ -> table.getItems().add(new ProductView("Prod",15.2f,12.1f)));
			dashboard.setOnAction( _ -> NavigationHelper.goToDashboard());
			history.setOnAction( _ -> NavigationHelper.goToHistory());
			suppliers.setOnAction( _ -> NavigationHelper.goToSuppliers());
			clients.setOnAction( _ -> NavigationHelper.goToClients(this.getClass()));
			
			
			this.table.widthProperty().addListener((_, _, newVal) -> {
				
				double width = newVal.doubleValue();
				idColumn.setPrefWidth(width * 0.1);
				descriptionColumn.setPrefWidth(width * 0.4);
				quantityColumn.setPrefWidth(width * 0.1);
				unitPriceColumn.setPrefWidth(width * 0.2);
				subTotalColumn.setPrefWidth(width * 0.2);
			});
			
		});
	}

}
