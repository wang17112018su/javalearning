package Workshop;

public class Facility {
	
	private String name;
	private String description;
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Facility(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public Facility(String name) {
		
		this(name, null);
		
	}
	public String ToString() {
		String facilityName;
		facilityName = getName();
		
		if (getDescription() != null) {			
			facilityName += "("+getDescription()+")";
		}
				
		return facilityName;
	}
	public void show () {
        System.out.println (this);
    }
	
	
	

}
