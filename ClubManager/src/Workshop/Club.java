package Workshop;

import java.util.ArrayList; // need to import this for ArrayList
import java.util.Collections;
import java.util.HashMap; // need to import for HashMap

public class Club {
	
	private static int currentNumber = 0001;
	private static int counter = 0;
	private static Member[] memberList = new Member[1];
	private static ArrayList<Member> mList= new ArrayList<Member>();
	private static HashMap<String,Facility> facList = new HashMap<String,Facility>();
	
	public Facility getFacility (String name) {
        return facList.get (name);
    }
	
	public ArrayList<Facility> getFacilities(){
		ArrayList<Facility> result = new ArrayList<Facility>(facList.values());
		//Collections.sort (result);
        return (result);
	}
	
	public Facility addFacility(String name, String description) {
		Facility a = new Facility(name, description);
		facList.put(name,a);
		return a;
	}
	
	public void removeFacility(String name) {
		facList.remove(name);
	}
		
	public void showFacility() {
		for (Facility fac : getFacilities()) {
			System.out.println(fac.ToString());
			
		}
	
	}
	
	public Member addMember(String surName, String firstName, String secondName) {
		Member a = new Member(surName, firstName, secondName, currentNumber);
		addToList(a);
		return a;
		}
		
	public void addMember(String surName, String firstName) {
		Member a = new Member(surName, firstName,currentNumber);
		addToList(a);		
		}
	
	private void addToList(Member a) {
//		memberList[counter]=a;
		mList.add(counter,a);
		counter ++;
		currentNumber ++;
//		Member[] newList = new Member[(counter+1)];
//		System.arraycopy(memberList, 0, newList, 0, memberList.length);
//		memberList = newList;
	}		
	
	public void showMember() {
		
//		for (Member m : mList) {			
//			System.out.println(m);			
//		}
		
		for (int i = 0; i < mList.size(); i++) {						
			System.out.println(mList.get(i));			
		}
		
//		for (int i = 0; i < memberList.length; i++) {
//			if (memberList[i]!=null) {			
//			System.out.println(memberList[i]);
//			}
//		}	
	}
	
	public void removeMember(int a) {
		mList.remove(a-1);
//		memberList[a-1]=null;		
	}
	
	public void show() {
		 System.out.println ("Current Members:");
	        showMember ();
	        System.out.println ();
	        System.out.println ("Facilities:");
	        showFacility ();
	}
}


