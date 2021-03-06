import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Sql {
	String url = "jdbc:mysql://localhost:3306/db?verifyServerCertificate=false&useSSL=true";
	String user = "root";
	String pas = "MySQLpassdrootV:1.0";

	public String register(String username, String pass) {
		try {
			final Connection con1 = DriverManager.getConnection(url, user, pas);

			PreparedStatement pst1 = con1.prepareStatement("select * from player where Username = ?");
			pst1.setString(1, username);
			ResultSet rez = pst1.executeQuery();
			if (rez.next()) {
				return "Username exists";
			}
			if (pass.isEmpty()) {
				return "Must insert pass";
			}

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
			return "User added";
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error";
	}

	public String login(String username, String pass) {
		try {
			final Connection con1 = DriverManager.getConnection(url, user, pas);

			PreparedStatement pst = con1.prepareStatement("select * from player where Username = ?");
			pst.setString(1, username);
			ResultSet rez = pst.executeQuery();
			if (rez.next()) {
				if (rez.getString("Password").equals(pass)) {
					return "Can login";
				} else {
					return "Wrong password";
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

	public void getStory() {
		try {
			final Connection con1 = DriverManager.getConnection(url, user, pas);
			Statement st = con1.createStatement();

			ResultSet idMax = st.executeQuery("select max(idst) from stories");
			int maxid = 1;
			if (idMax.next()) {
				maxid = idMax.getInt(maxid);
			}
			Random r = new Random();
			int Low = 0;
			int High = maxid + 1;
			int Result = r.nextInt(High - Low) + Low;
			ResultSet rez = st.executeQuery("select * from stories where idst = " + Result);
			if (rez.next()) {
				System.out.println(rez.getString("Full"));
			}
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
