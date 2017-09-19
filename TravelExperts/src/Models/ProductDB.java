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

public class ProductDB {
	
	//get all products
	public static ArrayList<Product> getProducts()
	{
		String sql = "SELECT productId, "
							+ "prodName "
							+ "FROM products";
		
		ArrayList<Product> products = new ArrayList<>();
		try 
		{
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Integer productId = rs.getInt("productId");
				String prodName = rs.getString("prodName");
						
				Product p = new Product(productId, prodName); 
										
				products.add(p);
			}
			return products;
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	//get one product
	public Product getProduct(Integer productId)
	{
		String sql ="SELECT * FROM products WHERE productId = ?";
							
		try 
		{
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				String prodName = rs.getString("prodName");						
				Product p = new Product(prodName);
				rs.close();
				return p;
			}
			else
			{
				rs.close();
				return null;
			}
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//insert product into database
	public boolean addProduct(Product p)
	{
		String sql = "INSERT INTO products (prodName) VALUES (?)";
		try 
		{
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getProdName());
			
			ps.executeUpdate();
			return true;
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	//delete product
	public boolean deleteProduct(Product p)
	{
		String sql = "DELETE FROM products " +
					"WHERE productId = ?";
		try 
		{
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getProductId());
			ps.executeUpdate();
			return true;
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	//update the product
	public boolean updateProduct(Product p)
	{
		String sql = "UPDATE products SET " 
				+ "prodName = ? "
				+ "WHERE productId = ?";
		try 
		{
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getProdName());
			ps.setInt(2, p.getProductId());
			
			ps.executeUpdate();
			return true;
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
