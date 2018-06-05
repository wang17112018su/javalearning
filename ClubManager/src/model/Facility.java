package model;

public class Facility implements Comparable<Facility> {
	
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
	@Override
	public String toString() {
		String facilityName;
		facilityName = getName();
		
		if (getDescription() != null) {			
			facilityName += "("+getDescription()+")";
		}
				
		return facilityName;
	}
	public void show () {
        System.out.println (toString());

}

	@Override
	public int compareTo(Facility other) {
		return (getName().compareTo(other.getName()));
	}
}

