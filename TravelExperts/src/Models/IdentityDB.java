package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class IdentityDB {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
	
	}
	public static Identity getIdentity(String userName)
	{
		String sql = "SELECT AgentId, "
				+ "pwd, "
				+ "salt "
				+ "FROM Agents "
				+ "WHERE userid = ?";
		try 
			(Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql))
		{		
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				String password = rs.getString("pwd");
				int agentID = rs.getInt("AgentId");
				byte[] salt = rs.getBytes("salt");
				
						
				Identity ident = new Identity(agentID, salt, userName, password);
				rs.close();
				return ident;
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
	
	
	public static boolean setSalt(int agentID, byte[] salt) {
		String sql = "Update Agents SET "
				+ "salt = ?"
				+ "WHERE AgentId = ?";
		try 				
		(Connection conn = new DBConnection().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql))
		{	
			ps.setBytes(1, salt );
			ps.setInt(2, agentID);
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
		
	public static boolean setPassword(int agentID, String pwd) {
		String sql = "Update Agents SET "
				+ "pwd = ?"
				+ "WHERE AgentId = ?";
		try 				
		(Connection conn = new DBConnection().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql))
		{	
			ps.setString(1, pwd );
			ps.setInt(2, agentID);
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
