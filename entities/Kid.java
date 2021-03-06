package entities;

import java.util.ArrayList;

public class Kid extends Being{


	private int birthday;
	private ArrayList<Product> products;
	private String placeOfBirth;


	public Kid(int code, String name, int birthday, ArrayList<Product> products, String placeOfBirth) {
		super(code, name);
		this.birthday = birthday;
		this.products = products;
		this.placeOfBirth = placeOfBirth;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthday() {
		return birthday;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

    @Override
    public String toString() {
        return "Kid{" + "code=" + super.code + ", name=" + super.name + ", birthday=" + birthday + ", products=" + products + ", placeOfBirth=" + placeOfBirth + '}';
    }
        
        
        


}

