package Workshop;

public class Member extends Person {
	
	private int memberNumber;
	
	
	public Member(String surName, String firstName, String secondName, int memberNumber) {
		super(surName, firstName, secondName);
		this.memberNumber = memberNumber;
	}
	
	public Member(String surName, String firstName,int memberNumber) {
		this(surName, firstName, null, memberNumber);
	}
	
	public int getMemberNumber() {
		return memberNumber;
	}
	
	public String toString(){
		
		String fullname = super.toString();

		return Integer.toString(getMemberNumber())+" "+fullname;
	}

}
