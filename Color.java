
public class Color implements ColorAPI {
	int [] colorcodes = new int[3];
	String model;
	public static final Enum models = null;
	

	public Color(int first, int second, int third) {
		
	}
	
	
	public Color(int first, int second, int third, String model) {
		
	}
	
	
	
	public int getColor1() { return 1;}; 
	public int getColor2() { return 2;};
	public int getColor3() { return 3;};
	public String getModel() {return "that's the model";};

	public void add(Color color) {};
	
	@Override
	public boolean isEqual(Color color) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}
