package Workshop;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

import club.BadBookingException;
import club.Booking;

import java.time.*;

public class ClubApplication {

	public static void main(String[] args) {
		
		Club aaa = new Club();
		Club bbb = new Club();
		Member member1 = aaa.addMember("Wang","Shijun","James");
		aaa.showMember();
		System.out.println("---------------");
		bbb.addMember("Kim","Jun"); // it does haven't a return value
		aaa.showMember();
		System.out.println("---------------");
		aaa.addMember("Rohit","Michael","Adam");
		aaa.showMember();
		System.out.println("---------------");
		aaa.addMember("Koh","Lee","David");
		bbb.showMember();
		System.out.println("---------------");		
		bbb.removeMember(1);
		bbb.showMember();
		
		//Facility Testing
        aaa.addFacility("Lab", "Einstein's Experiment Area");
        bbb.addFacility ("Studio", "Picasso's Work Place");
        bbb.addFacility ("Room1", "Conference Room on Level 2");
        aaa.addFacility ("Room2", "Meeting Room on Level 3");
        bbb.show();
        
        System.out.println("------test booking---------");	
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy H:mm");
        try {
        	Booking booking1 = new Booking(member1, aaa.getFacility("Room1"), LocalDateTime.parse("1-Aug-2007 09:00", df), LocalDateTime.parse("1-Aug-2007 12:00", df));
        	booking1.show();
        } catch (Exception e) {
        	System.out.println ("Booking class error: " + e.getMessage());
        }

        // Test BadBookingException
        try {
        	Booking booking2 = new Booking(member1,aaa.getFacility("Room3"),LocalDateTime.parse("1-Aug-2007 09:00", df), LocalDateTime.parse("31-Sep-2007 12:00", df));
        	booking2.show();
        } catch (MissingFillsException be) {
        	System.out.println ("Bad Booking Exception: " + be.getMessage());
        } catch (Exception e) {
        	System.out.println ("Booking class error: " + e.getMessage());
        }
	}



}
