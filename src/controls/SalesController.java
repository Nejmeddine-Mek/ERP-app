package controls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import controls.helpers.DBHelper;
import controls.helpers.ProductIndex;


public class SalesController {
	private static final String DB_name = "products.db";
	private HashMap<String, ProductIndex> productsMap;
	public SalesController() {
		this.productsMap = new HashMap<>();
	}
	public boolean initializeSales(){
		Connection c = DBHelper.connect(DB_name, 2);
		if(c == null)
			return false;
		try {
			PreparedStatement pstmt = c.prepareStatement("SELECT (id, barCode, description ,sellingPrice, buyingPrice, hasDiscount, discountQ, discountPrice) FROM products");
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int id = res.getInt(1);
				String code = res.getString(2);
				String desc = res.getString(3);
				float sellingPrice = res.getFloat(4);
				float buyingPrice = res.getFloat(5);
				boolean hasDiscount = res.getBoolean(6);
				int discountQty = res.getInt(7);
				float discountPrice = res.getFloat(8);
				this.productsMap.put(code, new ProductIndex(id, code, desc, buyingPrice, sellingPrice, hasDiscount, discountQty, discountPrice));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
