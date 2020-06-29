package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import service.DBUtil;

public class BillDAO 
{

	static Logger logger = Logger.getLogger(BillDAO.class.getName());
	
	public static int changeStatusDOD(long patient_Id,int no_of_days) 
	{
		int affectedRows = 0;
		try 
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE public.patient_table\r\n" + 
					"	SET \"DOD\"=?, status=?, no_of_days=?\r\n" + 
					"	WHERE \"patient_ID\"=?;");
			stmt.setDate(1,now());
			stmt.setString(2, 'discharged');
			stmt.setInt(3, no_of_days);
			stmt.setLong(4, patient_Id);
			
			affectedRows = stmt.executeUpdate();

		} catch (Exception e)
		{
			logger.log(Level.SEVERE, "Exception Occured", e);
		}
		return affectedRows;
	}
	
}