package Workshop;

public class Person {
	
	private String surName;
	private String firstName;
	private String secondName;
	
	public Person(String surName, String firstName, String secondName) {
		super();
		this.surName = surName;
		this.firstName = firstName;
		this.secondName = secondName;
	}
	
	
	
	public Person(String surName, String firstName) {
		
		this(surName,firstName," ");
	}



	public String getFirstName() {
		return firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public String getSurName() {
		return surName;
	}
	
	public void show() {
		
		String fullname;
		fullname = getSurName()+" "+getFirstName();
		
		if (getSecondName() != null) {			
			fullname += ","+getSecondName();
		}
				
		System.out.println(fullname);			
	}
}
