package views.jfxcontrols;

import java.net.URL;
import java.util.ResourceBundle;

import app.LanguageManager;
import controls.ProductsController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import views.models.ProductView;

public class ProductsView implements Initializable{
	
	@FXML private Button pos;
	@FXML private Button dashboard;
	@FXML private Button clients;
	@FXML private Button suppliers;
	@FXML private Button history;
	@FXML private Button products;
	@FXML private Label date;
	@FXML private Label occupation;
	@FXML private Label username;
	@FXML private Label totalProductsLabel;
	@FXML private Label barCodeLabel;
	@FXML private Label productName;
	
	
	@FXML private TextField nameSearchField;
	@FXML private TextField codeSearchField;
	
	@FXML private TableView<ProductView> table;
	
	@FXML private TableColumn<ProductView, Integer> idColumn;
	@FXML private TableColumn<ProductView, String> nameColumn;
	@FXML private TableColumn<ProductView, String> barCodeColumn;
	@FXML private TableColumn<ProductView, Float> buyingPriceColumn;
	@FXML private TableColumn<ProductView, Float> sellingPriceColumn;
	@FXML private TableColumn<ProductView, String> createdOnColumn;
	@FXML private TableColumn<ProductView,String> updatedOnColumn;
	@FXML private TableColumn<ProductView, String> categoryColumn;
	@FXML private TableColumn<ProductView, String> stockColumn;
	
	@FXML private VBox detailsFieldBox;
		@FXML private TextField nameField;
		@FXML private TextField barCodeField;
		@FXML private TextField buyingPriceField;
		@FXML private TextField sellingPriceField;
		@FXML private TextField stockField;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Platform.runLater(() -> {
			ProductsController pc = new ProductsController();
			// then we must load from the views from the thing!
			this.detailsFieldBox.setVisible(false);
			// set the text
			{
				ResourceBundle bundle = LanguageManager.getBundle();
				this.pos.setText(bundle.getString("sales.pos"));
				this.products.setText(bundle.getString("sales.products"));
				this.clients.setText(bundle.getString("sales.clients"));
				this.suppliers.setText(bundle.getString("sales.suppliers"));
				this.history.setText(bundle.getString("sales.history"));
				this.dashboard.setText(bundle.getString("sales.dashboard"));
				
				this.idColumn.setText(bundle.getString("products.id"));
				this.nameColumn.setText(bundle.getString("products.name"));
				this.categoryColumn.setText(bundle.getString("products.category"));
				this.sellingPriceColumn.setText(bundle.getString("products.sellingPrice"));
				this.buyingPriceColumn.setText(bundle.getString("products.buyingPrice"));
				this.createdOnColumn.setText(bundle.getString("products.createdOn"));
				this.updatedOnColumn.setText(bundle.getString("products.updatedOn"));
				
				
				this.totalProductsLabel.setText(bundle.getString("products.TotalProducts"));
				this.barCodeLabel.setText(bundle.getString("products.barCode"));
				this.productName.setText(bundle.getString("products.productName"));
			}
			// set widths of columns of the table
			this.table.widthProperty().addListener((_,_,newVal) -> {
				double width = newVal.doubleValue();
				this.idColumn.setPrefWidth(width * 0.05);
				this.nameColumn.setPrefWidth(width * 0.15);
				this.barCodeColumn.setPrefWidth(width * 0.15);
				this.buyingPriceColumn.setPrefWidth(width * 0.1);
				this.sellingPriceColumn.setPrefWidth(width * 0.1);
				this.createdOnColumn.setPrefWidth(width * 0.1);
				this.updatedOnColumn.setPrefWidth(width * 0.1);
				this.categoryColumn.setPrefWidth(width * 0.15);
				this.stockColumn.setPrefWidth(width * 0.1);
			});
			
		});
		
	}
	
	public void clickShowForm() {
		this.detailsFieldBox.setVisible(true);
		this.nameField.setPromptText("Product Name");
		this.barCodeField.setPromptText("Product Bar Code");
		this.buyingPriceField.setPromptText("buying Price");
		this.sellingPriceField.setPromptText("Selling Price");
	}
	
	public void clickAddProduct() {
		
	}
}
