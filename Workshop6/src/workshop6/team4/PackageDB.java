package workshop6.team4;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import travelexperts.Packages;

public class PackageDB {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
	}
	
	public ArrayList<Packages> getPackages()
	{
		String sql = "SELECT PackageId, "
							+ "PkgName, "
							+ "PkgStartDate, "
							+ "PkgEndDate, "
							+ "PkgDesc, "
							+ "PkgBasePrice, "
							+ "PkgAgencyCommission "
							+ "FROM packages";
		
		ArrayList<Packages> packages = new ArrayList<>();
		
		try 
			(Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery())
		{
			while(rs.next())
			{
				Integer packageId = rs.getInt("PackageId");
				String pkgName = rs.getString("PkgName");
				Date pkgStartDate = rs.getDate("PkgStartDate");
				Date pkgEndDate = rs.getDate("PkgEndDate");
				String pkgDesc = rs.getString("PkgDesc");
				BigDecimal pkgBasePrice = rs.getBigDecimal("PkgBasePrice");
				BigDecimal pkgAgencyCommission = rs.getBigDecimal("PkgAgencyCommission");
						
				Packages pkg = new Packages(packageId,
											pkgName, 
											pkgStartDate, 
											pkgEndDate, 
											pkgDesc, 
											pkgBasePrice, 
											pkgAgencyCommission);
				packages.add(pkg);
			}
			return packages;
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Packages getPackage(Integer packageId)
	{
		String sql = "SELECT PackageId, "
				+ "PkgName, "
				+ "PkgStartDate, "
				+ "PkgEndDate, "
				+ "PkgDesc, "
				+ "PkgBasePrice, "
				+ "PkgAgencyCommission "
				+ "FROM packages "
				+ "WHERE PackageId = ?";
		try 
			(Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql))
		{
			ps.setInt(1, packageId);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				String pkgName = rs.getString("PkgName");
				Date pkgStartDate = rs.getDate("PkgStartDate");
				Date pkgEndDate = rs.getDate("PkgEndDate");
				String pkgDesc = rs.getString("PkgDesc");
				BigDecimal pkgBasePrice = rs.getBigDecimal("PkgBasePrice");
				BigDecimal pkgAgencyCommission = rs.getBigDecimal("PkgAgencyCommission");
						
				Packages pkg = new Packages(pkgName, 
											pkgStartDate, 
											pkgEndDate, 
											pkgDesc, 
											pkgBasePrice, 
											pkgAgencyCommission);
				rs.close();
				return pkg;
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
	
	
	public boolean addPackage(Packages pkg)
	{
		String sql = "INSERT INTO packages "
				+ "(PkgName, "
				+ "PkgStartDate, "
				+ "PkgEndDate, "
				+ "PkgDesc, "
				+ "PkgBasePrice, "
				+ "PkgAgencyCommission) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try 
		(Connection conn = new DBConnection().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql))
		{
			ps.setString(1, pkg.getPkgName());
			ps.setDate(2, (java.sql.Date) pkg.getPkgStartDate());
			ps.setDate(3, (java.sql.Date) pkg.getPkgEndDate());
			ps.setString(4, pkg.getPkgDesc());
			ps.setBigDecimal(5, pkg.getPkgBasePrice());
			ps.setBigDecimal(6, pkg.getPkgAgencyCommission());
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
	
	public boolean deletePackage(Packages pkg)
	{
		String sql = "DELETE FROM packages " +
					"WHERE PackageId = ?";
		try 
		(Connection conn = new DBConnection().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql))
		{
			ps.setInt(1, pkg.getPackageId());
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
	
	public boolean updatePackage(Packages pkg)
	{
		String sql = "UPDATE packages SET " 
				+ "PkgName = ?, "
				+ "PkgStartDate = ?, "
				+ "PkgEndDate = ?, "
				+ "PkgDesc = ?, "
				+ "PkgBasePrice = ?, "
				+ "PkgAgencyCommission = ? "
				+ "WHERE PackageId = ?";
		try 
		(Connection conn = new DBConnection().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql))
		{
			ps.setString(1, pkg.getPkgName());
			ps.setDate(2, (java.sql.Date) pkg.getPkgStartDate());
			ps.setDate(3, (java.sql.Date) pkg.getPkgEndDate());
			ps.setString(4, pkg.getPkgDesc());
			ps.setBigDecimal(5, pkg.getPkgBasePrice());
			ps.setBigDecimal(6, pkg.getPkgAgencyCommission());
			ps.setInt(7, pkg.getPackageId());
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
