package Models;

/**
 * @author 758111
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Customer;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomerDB {
	
	public static ArrayList<Customer> getCustomers()
	{
		String sql = "SELECT CustomerId, "
							+ "CustFirstName, "
							+ "CustLastName, "
							+ "CustAddress, "
							+ "CustCity, "
							+ "CustProv, "
							+ "CustPostal, "
							+ "CustCountry, "
							+ "CustHomePhone, "
							+ "CustBusPhone, "
							+ "CustEmail, "
							+ "AgentId "
							+ "FROM customers";
		
		ArrayList<Customer> customers = new ArrayList<>();
		
		try 
			(Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery())
		{
			while(rs.next())
			{
				Integer customerId = rs.getInt("CustomerId");
				String custFirstName = rs.getString("CustFirstName");
				String custLastName = rs.getString("CustLastName");
				String custAddress = rs.getString("CustAddress");
				String custCity = rs.getString("CustCity");
				String custProv = rs.getString("CustProv");
				String custPostal = rs.getString("CustPostal");
				String custCountry = rs.getString("CustCountry");
				String custHomePhone = rs.getString("CustHomePhone");
				String custBusPhone = rs.getString("CustBusPhone");
				String custEmail = rs.getString("CustEmail");
				Integer agentId = rs.getInt("AgentId");
						
				Customer c = new Customer(custFirstName, 
										custLastName, 
										custAddress, 
										custCity, 
										custProv, 
										custPostal,
										custBusPhone,
										custEmail);
				customers.add(c);
			}
			return customers;
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ObservableList<Customer> getObservableCustomers()
	{
		String sql = "SELECT  "
							+ "CustFirstName, "
							+ "CustLastName, "
							+ "CustCity, "
							+ "CustProv, "
							+ "CustEmail "
							+ "FROM customers";
		
		ObservableList<Customer> customers = FXCollections.observableArrayList();
		
		try 
			(Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery())
		{
			while(rs.next())
			{
				String custFirstName = rs.getString("CustFirstName");
				String custLastName = rs.getString("CustLastName");
				String custCity = rs.getString("CustCity");
				String custProv = rs.getString("CustProv");
				String custEmail = rs.getString("CustEmail");
				Boolean bool = false;
						
				Customer c = new Customer(bool, custFirstName, 
										custLastName,  
										custCity, 
										custProv, 
										custEmail);
				customers.add(c);
			}
			return customers;
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Customer getCustomer(Integer customerId)
	{
		String sql ="SELECT CustomerId, "
							+ "CustFirstName, "
							+ "CustLastName, "
							+ "CustAddress, "
							+ "CustCity, "
							+ "CustProv, "
							+ "CustPostal, "
							+ "CustCountry, "
							+ "CustHomePhone, "
							+ "CustBusPhone, "
							+ "CustEmail, "
							+ "AgentId "
							+ "FROM customers "
							+ "WHERE CustomerId = ?";
		try 
			(Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql))
		{
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				String custFirstName = rs.getString("CustFirstName");
				String custLastName = rs.getString("CustLastName");
				String custAddress = rs.getString("CustAddress");
				String custCity = rs.getString("CustCity");
				String custProv = rs.getString("CustProv");
				String custPostal = rs.getString("CustPostal");
				String custCountry = rs.getString("CustCountry");
				String custHomePhone = rs.getString("CustHomePhone");
				String custBusPhone = rs.getString("CustBusPhone");
				String custEmail = rs.getString("CustEmail");
				Integer agentId = rs.getInt("AgentId");
						
				Customer c = new Customer(custFirstName, 
										custLastName, 
										custAddress, 
										custCity, 
										custProv, 
										custPostal,
										custBusPhone,
										custEmail);
				rs.close();
				return c;
			}
			else
			{
				rs.close();
				return null;
			}
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean addCustomer(Customer c)
	{
		String sql = "INSERT INTO customers "
				+ "(CustFirstName, "
				+ "CustLastName, "
				+ "CustAddress, "
				+ "CustCity, "
				+ "CustProv, "
				+ "CustPostal, "
				+ "CustCountry, "
				+ "CustHomePhone, "
				+ "CustBusPhone, "
				+ "CustEmail, "
				+ "AgentId) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try 
		(Connection conn = new DBConnection().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql))
		{
			ps.setString(1, c.getCustFirstName());
			ps.setString(2, c.getCustLastName());
			ps.setString(3, c.getCustAddress());
			ps.setString(4, c.getCustCity());
			ps.setString(5, c.getCustProv());
			ps.setString(6, c.getCustPostal());
			ps.setString(7, c.getCustCountry());
			ps.setString(8, c.getCustHomePhone());
			ps.setString(9, c.getCustBusPhone());
			ps.setString(10, c.getCustEmail());
			ps.setInt(11, c.getAgentId());
			
			ps.executeUpdate();
			return true;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteCustomer(Customer c)
	{
		String sql = "DELETE FROM customers " +
					"WHERE CustomerId = ?";
		try 
		(Connection conn = new DBConnection().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql))
		{
			ps.setInt(1, c.getCustomerId());
			ps.executeUpdate();
			return true;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateCustomer(Customer c)
	{
		String sql = "UPDATE customers SET " 
				+ "CustFirstName = ?, "
				+ "CustLastName = ?, "
				+ "CustAddress = ?, "
				+ "CustCity = ?, "
				+ "CustProv = ?, "
				+ "CustPostal = ?, "
				+ "CustCountry = ?, "
				+ "CustHomePhone = ?, "
				+ "CustBusPhone = ?, "
				+ "CustEmail = ?, "
				+ "AgentId = ?"
				+ "WHERE CustomerId = ?";
		try 
		(Connection conn = new DBConnection().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql))
		{
			ps.setString(1, c.getCustFirstName());
			ps.setString(2, c.getCustLastName());
			ps.setString(3, c.getCustAddress());
			ps.setString(4, c.getCustCity());
			ps.setString(5, c.getCustProv());
			ps.setString(6, c.getCustPostal());
			ps.setString(7, c.getCustCountry());
			ps.setString(8, c.getCustHomePhone());
			ps.setString(9, c.getCustBusPhone());
			ps.setString(10, c.getCustEmail());
			ps.setInt(11, c.getAgentId());
			ps.setInt(12, c.getCustomerId());
			
			ps.executeUpdate();
			return true;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
