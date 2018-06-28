package database;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DBManager {

	public DBManager() {
		
	}
	
	public String request(String request) {
		StringBuilder result = new StringBuilder();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBOpenHelper.getInstance().getConn().createStatement();
			rs = stmt.executeQuery(request);
			while (rs.next()) {
				ResultSetMetaData rsmd = rs.getMetaData();
				// Doc --> index commence à 1 !
				for (int i = 1; i < rsmd.getColumnCount(); i++) {
					result.append(rs.getString(i) + " ");
				}
				result.append("\n");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result.toString();
	}
	
	public int updateRequest(String updateRequest) {
		// Retourne la valeur de retour de la commande SQL.
		int result = 0;
		
		Statement stmt = null;
		
		try {
			stmt = DBOpenHelper.getInstance().getConn().createStatement();
			//result = stmt.executeUpdate(updateRequest, stmt.NO_GENERATED_KEYS);
			result = stmt.executeUpdate(updateRequest, stmt.RETURN_GENERATED_KEYS);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
