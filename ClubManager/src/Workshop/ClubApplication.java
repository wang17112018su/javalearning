package Workshop;

public class ClubApplication {

	public static void main(String[] args) {
		
		System.out.println("Hello World");
		
		Person a = new Person("Wang","Shijun","James");
		Person b = new Person("Wang","Shijun");
		
		a.show();
		b.show();
		
		Facility c = new Facility("Ballroom", "Can hold up to 45 tables");
		Facility d = new Facility("Pool");
		
		c.show();
		d.show();
		

	}

}
