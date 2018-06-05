package workshop;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import data.MemberDAO;
import data.MemberDAOImpl;
import model.Member;

public class ClubApplication {

	public static void main(String[] args) {
		Club club = new Club();

		Member member1, member2, member3, member4, member5;

		member1 = club.addMember("Einstein", "Albert", null);
		member2 = club.addMember("Picasso", "Pablo", "Ruiz");
		member3 = club.addMember("Webber", "Andrew", "Lloyd");
		member4 = club.addMember("Baggio", "Roberto", null);
		member5 = club.addMember("Raffles", "Stamford", null);

		// Member Addition Testing
		System.out.println("Current Members:");
		club.showMember();
		System.out.println("Deleting " + member3);
		int id = member3.getMemberNumber();
		club.removeMember(id);
		member5 = club.addMember("Raffles2", "Stamford2", null);
		System.out.println("Current members:");
		club.showMember();

		// Facility Testing
		club.addFacility("Lab", "Einstein's Experiment Area");
		club.addFacility("Studio", "Picasso's Work Place");
		club.addFacility("Room1", "Conference Room on Level 2");
		club.addFacility("Room2", "Meeting Room on Level 3");
		club.show();

		// Test Booking Class
		System.out.println();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy H:mm");
		try {
			Booking booking1 = new Booking(member1, club.getFacility("Room1"),
					LocalDateTime.parse("1-Aug-2007 09:00", df), LocalDateTime.parse("1-Aug-2007 12:00", df));
			booking1.show();
		} catch (Exception e) {
			System.out.println("Booking class error: " + e.getMessage());
		}

		// Test BadBookingException
		try {
			Booking booking2 = new Booking(member2, club.getFacility("Room1"),
					LocalDateTime.parse("1-Aug-2007 15:00", df), LocalDateTime.parse("1-Aug-2007 14:00", df));
			booking2.show();
		} catch (BadBookingException be) {
			System.out.println("Bad Booking Exception: " + be.getMessage());
		} catch (Exception e) {
			System.out.println("Booking class error: " + e.getMessage());
		}

		// Test BookingRegister
		try {
			BookingRegister register = new BookingRegister();
			System.out.println("Adding bookings for Room1 2-Aug-2007 9:00 to 12:00");
			register.addBooking(member1, club.getFacility("Room1"), LocalDateTime.parse("2-Aug-2007 9:00", df),
					LocalDateTime.parse("2-Aug-2007 12:00", df));
			System.out.println("Adding bookings for Room1 3-Aug-2007 9:00 to 12:00");
			register.addBooking(member1, club.getFacility("Room1"), LocalDateTime.parse("3-Aug-2007 9:00", df),
					LocalDateTime.parse("3-Aug-2007 12:00", df));
			System.out.println("Adding bookings for Room1 2-Aug-2007 9:00 to 12:00");
			register.addBooking(member2, club.getFacility("Room1"), LocalDateTime.parse("4-Aug-2007 9:00", df),
					LocalDateTime.parse("5-Aug-2007 12:00", df));
			System.out.println("Adding bookings for Room1 4-Aug-2007 9:00 to 12:00");
			register.addBooking(member2, club.getFacility("Room1"), LocalDateTime.parse("6-Aug-2007 9:00", df),
					LocalDateTime.parse("6-Aug-2007 12:00", df));
			System.out.println("Adding bookings for Room2 5-Aug-2007 9:00 to 12:00");
			register.addBooking(member2, club.getFacility("Room1"), LocalDateTime.parse("7-Aug-2007 9:00", df),
					LocalDateTime.parse("7-Aug-2007 12:00", df));
			System.out.println("Print out date range 1-Aug-2007 to 4-Aug-2007 for Room1");
			club.showBookings(club.getFacility("Room1"), LocalDateTime.parse("1-Aug-2007 9:00", df),
					LocalDateTime.parse("4-Aug-2007 9:00", df));

		} catch (BadBookingException be) {
			System.out.println("Bad Booking Exception: " + be.getMessage());
		} catch (Exception e) {
			System.out.println("Booking class error: " + e.toString());
		}

		MemberDAO sdao = new MemberDAOImpl();
		Member m = new Member("joo", "HUNGRY", 9);
		Member n = new Member("yoo", "HUNGRY", 9);
		Member o = new Member("koo", "HUNGRY", 9);
		System.out.println("Before DAO");
		try {
			sdao.createMember(m);
			sdao.createMember(n);
			sdao.createMember(o);
			sdao.createMember(m);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Run to queue in biz canteen");
		
		try {
			sdao.listAllMember();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		club.showMember();
		try {
			sdao.listMember("raffles").show();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
