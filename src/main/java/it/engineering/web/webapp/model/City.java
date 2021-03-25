package it.engineering.web.webapp.model;

public class City {

	private int postCode;
	private String name;
	
	
	public City(int postCode, String name) {
		super();
		this.postCode = postCode;
		this.name = name;
	}


	public int getPostCode() {
		return postCode;
	}


	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + postCode;
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
		City other = (City) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (postCode != other.postCode)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "City [postCode=" + postCode + ", name=" + name + "]";
	}
	
	
	
	
	
}
