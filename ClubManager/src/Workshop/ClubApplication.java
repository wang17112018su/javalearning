package Workshop;

public class ClubApplication {

	public static void main(String[] args) {
		
//		System.out.println("Hello World");
//		
//		Person a = new Person("Wang","Shijun","James");
//		Person b = new Person("Wang","Shijun");
//		
//		a.show();
//		b.show();
//		
//		Facility c = new Facility("Ballroom", "Can hold up to 45 tables");
//		Facility d = new Facility("Pool");
//		
//		c.show();
//		d.show();
//		
//		Member aa = new Member("Wang","Shijun","James", 1000);
//		Member bb = new Member("Wang","Shijun",1001);
//		Person cc = new Member("Wang","Shijun","James", 1002);
//		Person dd = new Member("Wang","Shijun",1003);
//		
//		
//		aa.show();
//		bb.show();
//		cc.show();
//		dd.show();
		
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
