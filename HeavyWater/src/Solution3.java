
public class Solution3 {
	private String name;
	public Solution3 getFood(String name ){
		this.name = name;
		return this;
	}
	public String getFoodName(){
		return this.name;
	}
	public void getName(){
		System.out.println("I am serving "+this.getFoodName());
	}

	

}
