package workshop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import model.Facility;
import model.Member;

import java.util.Iterator;

public class Club {
	private static int currentNumber = 1;
	private static int counter = 0;
	private static ArrayList<Member> mList = new ArrayList<Member>();
	private static HashMap<String, Facility> facList = new HashMap<String, Facility>();
	BookingRegister br = new BookingRegister();

	public Member addMember(String surName, String firstName, String secondName) {
		Member a = new Member(surName, firstName, secondName, currentNumber);
		addToList(a);
		return a;
	}

	public Member addMember(String surName, String firstName) {
		Member a = new Member(surName, firstName, currentNumber);
		addToList(a);
		return a;
	}

	private void addToList(Member a) {
		mList.add(counter, a);
		counter++;
		currentNumber++;

	}

	public void showMember() {

		Iterator<Member> i = mList.iterator();
		while (i.hasNext()) {
			i.next().show();
		}
	}

	public Member getMember(int memberNum) {
		Iterator<Member> i = mList.iterator();
		while (i.hasNext()) {
			Member m = i.next();
			if (m.getMemberNumber() == memberNum) {
				return m;
			}
		}
		return null;
	}

	public void removeMember(int memberNum) {
		Member m = getMember(memberNum);
		if (m != null) {
			mList.remove(m);
		}
		counter -= 1;
	}

	public Facility getFacility(String name) {
		return facList.get(name);
	}

	public List<Facility> getFacilities() {
		ArrayList<Facility> result;
		result = new ArrayList<Facility>(facList.values());
		Collections.sort(result);
		return (result);
	}

	public void addFacility(String name, String description) {
		if (name == null) {
			return;
		}
		Facility f = new Facility(name, description);
		facList.put(name, f);
	}

	public void removeFacility(String name) {
		facList.remove(name);
	}

	public void showFacilities() {
		Iterator<Facility> i = getFacilities().iterator();
		while (i.hasNext()) {
			i.next().show();
		}
	}

	public void show() {
		System.out.println("Current Members:");
		showMember();
		System.out.println();
		System.out.println("Facilities:");
		showFacilities();
	}

	public void addBooking(int membershipNum, Facility facility, LocalDateTime startDate, LocalDateTime endDate) {
		Member m = getMember(membershipNum);
		try {
			br.addBooking(m, facility, startDate, endDate);
		} catch (BadBookingException be) {
			System.out.println("Bad Booking Exception: " + be.getMessage());
		} catch (Exception e) {
			System.out.println("Booking class error: " + e.toString());
		}
	}

	public void getBookings(Facility facility, LocalDateTime start, LocalDateTime endDate) {
		br.getBookings(facility, start, endDate);
	}

	public void showBookings(Facility facility, LocalDateTime start, LocalDateTime endDate) {
		Iterator<Booking> i = br.getBookings(facility, start, endDate).iterator();
		while (i.hasNext()) {
			i.next().show();
		}
	}

	public void sortByMemNumber() {
		Collections.sort(mList);
		this.showMember();
	}

}
