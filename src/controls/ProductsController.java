package controls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import controls.helpers.DBHelper;
import models.Product;
import views.models.ProductView;

public class ProductsController {
	private static final String db_name = "products.db";
	private ArrayList<Product> productsList = new ArrayList<>();
	
	public ArrayList<ProductView> loadProducts(){
		Connection c = DBHelper.connect(db_name, 2);
		ArrayList<ProductView> out = new ArrayList<>();
		try {
			PreparedStatement pstmt = c.prepareStatement("SELECT * FROM products");
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int id =  res.getInt(1);
				String barcode = res.getString(2);
				String name = res.getString(3);
				String category = res.getString(4);
				float sellingPrice = res.getFloat(5);
				float buyingPrice = res.getFloat(6);
				boolean hasDiscount = res.getBoolean(7);
				int discountQ = res.getInt(8);
				float discountPrice = res.getFloat(9);
				LocalDateTime createdOn = res.getTimestamp(10).toLocalDateTime();
				LocalDateTime updatedOn = res.getTimestamp(11).toLocalDateTime();
				this.productsList.add(new Product(id, barcode, name,category,buyingPrice, sellingPrice, hasDiscount, discountQ, discountPrice, createdOn, updatedOn));
				out.add(new ProductView(name, sellingPrice, ));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
}
