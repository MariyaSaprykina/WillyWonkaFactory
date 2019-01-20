package entities;

public class OompaLoompa extends Being{
	private int height;
	private String favoriteFood;

	public OompaLoompa(int code, String name, int height, String favoriteFood) {
		super(code, name);
		this.height = height;
		this.favoriteFood = favoriteFood;
	}

	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public int getHeight() {
		return height;
	}
	public String getFavoriteFood() {
		return favoriteFood;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

    @Override
    public String toString() {
        return "OompaLoompa{" + "code=" + super.code + ", name=" + super.name + ", height=" + height + ", favoriteFood=" + favoriteFood + '}';
    }
        
        



}

