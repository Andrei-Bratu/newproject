import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class New {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			final Connection con1 = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db?verifyServerCertificate=false&useSSL=true", "root",
					"MySQLpassdrootV:1.0");
			final Statement st = con1.createStatement();
			final ResultSet res = st.executeQuery("select* from player");
			while (res.next()) {
				System.out.println(res.getInt("idplayer") + ", " + res.getString("playercol"));
			}
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}