package it.engineering.web.webapp.model;

public class Product {

	private long productCode;
	private String name;
	private double unitPrice;
	private String measurementUnit;
	private String priceCurrency;
	private Manufacturer manufacturer;
	
	public Product(long productCode, String name, double unitPrice, String measurementUnit, String priceCurrency,
			Manufacturer manufacturer) {
		super();
		this.productCode = productCode;
		this.name = name;
		this.unitPrice = unitPrice;
		this.measurementUnit = measurementUnit;
		this.priceCurrency = priceCurrency;
		this.manufacturer = manufacturer;
	}

	public long getProductCode() {
		return productCode;
	}

	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	public String getPriceCurrency() {
		return priceCurrency;
	}

	public void setPriceCurrency(String priceCurrency) {
		this.priceCurrency = priceCurrency;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((measurementUnit == null) ? 0 : measurementUnit.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((priceCurrency == null) ? 0 : priceCurrency.hashCode());
		result = prime * result + (int) (productCode ^ (productCode >>> 32));
		long temp;
		temp = Double.doubleToLongBits(unitPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Product other = (Product) obj;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (measurementUnit == null) {
			if (other.measurementUnit != null)
				return false;
		} else if (!measurementUnit.equals(other.measurementUnit))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priceCurrency == null) {
			if (other.priceCurrency != null)
				return false;
		} else if (!priceCurrency.equals(other.priceCurrency))
			return false;
		if (productCode != other.productCode)
			return false;
		if (Double.doubleToLongBits(unitPrice) != Double.doubleToLongBits(other.unitPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", name=" + name + ", unitPrice=" + unitPrice
				+ ", measurementUnit=" + measurementUnit + ", priceCurrency=" + priceCurrency + ", manufacturer="
				+ manufacturer + "]";
	}
	
	
	
	
	
	
}
