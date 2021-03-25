package it.engineering.web.webapp.model;

public class Manufacturer {

	private int pib;
	private long jmbg;
	private String name;
	private String address;
	private City city;

	public Manufacturer(int pib, long jmbg, String name, String address, City city) {
		super();
		this.pib = pib;
		this.jmbg = jmbg;
		this.name = name;
		this.address = address;
		this.city = city;
	}

	public int getPib() {
		return pib;
	}

	public void setPib(int pib) {
		this.pib = pib;
	}

	public long getJmbg() {
		return jmbg;
	}

	public void setJmbg(long jmbg) {
		this.jmbg = jmbg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + (int) (jmbg ^ (jmbg >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pib;
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
		Manufacturer other = (Manufacturer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (jmbg != other.jmbg)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pib != other.pib)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manufacturer [pib=" + pib + ", jmbg=" + jmbg + ", name=" + name + ", address=" + address + ", city="
				+ city + "]";
	}

}
