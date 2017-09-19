package Models;

/**
 * @author 754967
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Supplier;

public class SupplierDB {
	
	//get all products
	public static ArrayList<Supplier> getSuppliers()
	{
		String sql = "SELECT supplierId, "
							+ "supName "
							+ "FROM suppliers";
		
		ArrayList<Supplier> suppliers = new ArrayList<>();
		try 
		{
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Integer supplierId = rs.getInt("supplierId");
				String supName = rs.getString("supName");
						
				Supplier s = new Supplier(supplierId, supName); 
										
				suppliers.add(s);
			}
			return suppliers;
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	//get one supplier
	public Supplier getSupplier(Integer supplierId)
	{
		String sql ="SELECT * FROM suppliers WHERE supplierId = ?";
							
		try 
		{
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, supplierId);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				String supName = rs.getString("supName");						
				Supplier s = new Supplier(supName);
				rs.close();
				return s;
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
	
	//insert supplier into database
	public boolean addSupplier(Supplier s)
	{
		String sql = "INSERT INTO suppliers (SupplierId, SupName) VALUES (?, ?)";
		
		try 
		{
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, s.getSupplierId());
			ps.setString(2, s.getSupName());
			
			ps.executeUpdate();
			return true;
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static int GetSupplierId()
	{
		int result = 0;
		String sql = "SELECT SupplierId FROM suppliers ORDER BY SupplierId DESC LIMIT 1";
		
			try {
				Connection	conn = new DBConnection().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next())
				{
					result = rs.getInt("SupplierId");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return result + 1;
	}
	
	//delete supplier
	public boolean deleteSupplier(Supplier s)
	{
		String sql = "DELETE FROM suppliers " +
					"WHERE supplierId = ?";
		try 
		{
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, s.getSupplierId());
			ps.executeUpdate();
			return true;
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	//update the supplier
	public boolean updateSupplier(Supplier s)
	{
		String sql = "UPDATE suppliers SET " 
				+ "supName = ? "
				+ "WHERE supplierId = ?";
		try 
		{
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getSupName());
			ps.setInt(2, s.getSupplierId());
			
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

