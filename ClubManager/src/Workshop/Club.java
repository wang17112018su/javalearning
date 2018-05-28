package Workshop;

public class Club {
	
	private static int currentNumber = 0001;
	private static int counter = 0;
	private static Member[] memberList = new Member[1];
	
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
		memberList[counter]=a;		
		counter ++;
		currentNumber ++;
		Member[] newList = new Member[(counter+1)];
		System.arraycopy(memberList, 0, newList, 0, memberList.length);
		memberList = newList;
	}		
	
	public void showMember() {
		for (int i = 0; i < memberList.length; i++) {
			if (memberList[i]!=null) {			
			System.out.println(memberList[i]);
			}
		}	
	}
	
	public void removeMember(int a) {
		memberList[a-1]=null;		
	}
}


