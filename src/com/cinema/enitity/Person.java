package com.cinema.enitity;

public class Person {
	private String name;
	private String craft;
	@Override
	public String toString() {
		return "Person [name=" + name + ", craft=" + craft + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((craft == null) ? 0 : craft.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (craft == null) {
			if (other.craft != null)
				return false;
		} else if (!craft.equals(other.craft))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCraft() {
		return craft;
	}
	public void setCraft(String craft) {
		this.craft = craft;
	}
	public Person(String name, String craft) {
		super();
		this.name = name;
		this.craft = craft;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
}
