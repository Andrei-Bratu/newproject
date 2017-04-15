import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sql {
	String url = "jdbc:mysql://localhost:3306/db?verifyServerCertificate=false&useSSL=true";
	String user = "root";
	String pas = "MySQLpassdrootV:1.0";

	public void register(String username, String pass) {
		try {
			final Connection con1 = DriverManager.getConnection(url, user, pas);
			Statement st = con1.createStatement();
			String sql = "INSERT INTO player (Username, Password)" + "VALUES (?,?)";
			PreparedStatement pst = con1.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, pass);
			pst.executeUpdate();
			// st.executeUpdate(sql);
			// st.execute("DELETE FROM db.player WHERE ID =" + 1);
			ResultSet res = st.executeQuery("select* from player");
			while (res.next()) {
				System.out.println(res.getInt("idplayer") + ", " + res.getString("Username"));
			}
			con1.close();
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String login(String username, String pass) {
		try {
			final Connection con1 = DriverManager.getConnection(url, user, pas);
			Statement st = con1.createStatement();
			PreparedStatement pst = con1.prepareStatement("select * from player where Username = ?");
			pst.setString(1, username);
			ResultSet rez = pst.executeQuery();
			if (rez.next()) {
				if (rez.getString("Password").equals(pass)) {
					return "Can login";
				} else {
					return "Wrong pas";
				}
			} else {
				return "Wrong user";
			}
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
