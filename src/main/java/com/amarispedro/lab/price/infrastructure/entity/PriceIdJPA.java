package com.amarispedro.lab.price.infrastructure.entity;

import java.io.Serializable;

public final class PriceIdJPA implements Serializable{
	
	private static final long serialVersionUID = 3120681543622246547L;
	
	private String brand_id;
	private String product_id;
	private String priceList;
	
	public PriceIdJPA() {} 

	protected PriceIdJPA(String brand_id, String product_id, String priceList) {
		super();
		this.brand_id = brand_id;
		this.product_id = product_id;
		this.priceList = priceList;
	}
	
	public String getBrand_id() {
		return brand_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public String getPriceList() {
		return priceList;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brand_id == null) ? 0 : brand_id.hashCode());
        result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
        result = prime * result + ((priceList == null) ? 0 : priceList.hashCode());
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
        PriceIdJPA other = (PriceIdJPA) obj;
        if (brand_id == null) {
            if (other.brand_id != null)
                return false;
        } else if (!brand_id.equals(other.brand_id))
            return false;
        if (product_id == null) {
            if (other.product_id != null)
                return false;
        } else if (!product_id.equals(other.product_id))
            return false;
        if (priceList == null) {
            if (other.priceList != null)
                return false;
        } else if (!priceList.equals(other.priceList))
            return false;
        
        return true;
    }
	
	

}
