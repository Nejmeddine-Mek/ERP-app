package controls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import controls.helpers.DBHelper;
import controls.helpers.Utils;
import models.Client;
import views.models.ClientModelView;

public class ClientController {
	private ArrayList<Client> clients = new ArrayList<>();
	private static final String DB_NAME = "clients.db";
	
	public Optional<List<ClientModelView>> loadClients(){
		Connection c = DBHelper.connect(DB_NAME, 4);
		if(c == null)
			return Optional.empty();
		PreparedStatement stmt;
		try {
			List<ClientModelView> clientsView = new ArrayList<>();
			stmt = c.prepareStatement("SELECT * FROM clients");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				this.clients.add(new Client(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("phoneNumber"),
						rs.getFloat("depts"),
						rs.getInt("transactions"),
						rs.getTimestamp("createdOn").toLocalDateTime(),
						rs.getTimestamp("updatedOn").toLocalDateTime(),
						Utils.jsonToDates(rs.getString("transactionsDates"))
						));
				
			}
			for(Client cl : clients) {
				clientsView.add(new ClientModelView(
						cl.getNameString(),
						cl.getId(),
						cl.getDept(),
						cl.getPhone(),
						cl.getTransactions()
						));
			}
			return Optional.of(clientsView);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return Optional.empty();
	}
	
	public ClientModelView addClient(Client client) {
		Connection connection = DBHelper.connect(DB_NAME, 4);
		int id = 0;
		if(connection == null)
			return null;
		try {
			PreparedStatement pstmt = connection.prepareStatement("INSERT INTO clients (name, phoneNumber, transactions, depts, createdOn, updatedOn,transactionsDates) VALUES(?,?,?,?,?,?,?)"
					, Statement.NO_GENERATED_KEYS);
			pstmt.setString(1, client.getNameString());
			pstmt.setString(2, client.getPhone());
			pstmt.setInt(3, client.getTransactions());
			pstmt.setFloat(4, client.getDept());
			pstmt.setTimestamp(5, Timestamp.valueOf(client.getCreatedOn()));
			pstmt.setTimestamp(6, Timestamp.valueOf(client.getUpdatedOn()));
			
			String jsonDates = Utils.datesToJson(client.getTransactionDates());
			pstmt.setString(7, jsonDates);

			pstmt.executeUpdate();
			id = pstmt.getGeneratedKeys().getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		ClientModelView cv = new ClientModelView(client.getNameString(), id, client.getDept(), client.getNameString(), client.getTransactions());
		return cv;
	}
	

	public boolean removeClient(int id) {
		Connection connection = DBHelper.connect(DB_NAME, 4);
		if(connection == null)
			return false;
		try {
			PreparedStatement pstmt = connection.prepareStatement("DELETE FROM clients WHERE id = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			return false;
		}
		return true;
	}
	
}
