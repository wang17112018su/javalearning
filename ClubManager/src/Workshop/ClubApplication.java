package Workshop;

public class ClubApplication {

	public static void main(String[] args) {
		
		Club aaa = new Club();
		Club bbb = new Club();
		aaa.addMember("Wang","Shijun","James").show();
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
	}



}
