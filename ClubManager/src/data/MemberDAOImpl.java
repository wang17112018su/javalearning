package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Member;
import workshop.Club;

public class MemberDAOImpl implements MemberDAO {

	Club a = new Club();

	private static Statement statement() throws ClassNotFoundException, SQLException {

		// Step 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Step 2
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/club?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
				"root", "password");
		// Step 3
		Statement statement = conn.createStatement();
		return statement;
	}

	private static void closeConnection() throws ClassNotFoundException, SQLException {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/club?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
				"root", "password");
		statement().close();
		conn.close();

	}

	public MemberDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public MemberDAOImpl(Member m) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void listAllMember() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		ResultSet rs = statement().executeQuery("Select * FROM `club`.`member`");
		while (rs.next()) {
			a.addMember(rs.getString(1), rs.getString(2), rs.getString(3));
		}
		closeConnection();

	}

	@Override
	public Member listMember(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		ResultSet rs = statement().executeQuery("SELECT * FROM `club`.`member`WHERE (`Surname` = '" + name + "' )");
		Member m = null;
		while (rs.next()) {
			m = a.addMember(rs.getString(1), rs.getString(2), rs.getString(3));
		}
		closeConnection();
		return m;
	}

	@Override
	public int createMember(Member m) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		// Step 4
		int status = statement()
				.executeUpdate("INSERT INTO `club`.`member` (`Surname`, `First Name`, `Second Name`) VALUES ('"
						+ m.getSurName() + "', '" + m.getFirstName() + "', '" + m.getSecondName() + "')");
		closeConnection();
		return status;
	}

	@Override
	public int updateMember(Member m) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// Step 4
				int status = statement()
						.executeUpdate("UPDATE `club`.`member` SET `Surname` = '"+m.getSurName()+"', `First Name` = '"+m.getFirstName()+"', `Second Name` = '"+m.getSecondName()+"' WHERE (`Surname` = '"+m.getSurName()+"')");
				closeConnection();
				return status;
	}

	@Override
	public int removeMember(Member m) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// Step 4
		int status = statement()
				.executeUpdate("DELETE FROM `club`.`member` WHERE (`Surname` = '"+m.getSurName()+"')");
		closeConnection();
		return status;


	}

}
