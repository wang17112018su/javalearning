package workshop;

public class Member extends Person implements Comparable<Member> {

	private int memberNumber;

	public Member(String surName, String firstName, String secondName, int memberNum) {
		super(surName, firstName, secondName);
		this.memberNumber = memberNum;
		// TODO Auto-generated constructor stub
	}

	public Member(String surName, String firstName, int memberNum) {
		super(surName, firstName, null);
		this.memberNumber = memberNum;
		// TODO Auto-generated constructor stub
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public String toString() {

		String fullname = super.toString();

		return Integer.toString(getMemberNumber()) + " " + fullname;
	}

	// Added so that Members can be sorted by membership number
	@Override
	public int compareTo(Member other) {
		if (this.getMemberNumber() > other.getMemberNumber())
			return -1;
		
		return 0;

	}

}
