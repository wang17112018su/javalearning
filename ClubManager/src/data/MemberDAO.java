package data;

import java.sql.SQLException;
import model.Member;

public interface MemberDAO {
	
	public void listAllMember() throws ClassNotFoundException, SQLException ;
	public Member listMember (String name) throws ClassNotFoundException, SQLException;
	public int createMember(Member m) throws ClassNotFoundException, SQLException;
	public int updateMember(Member m);
	public int removeMember(Member m);

}
