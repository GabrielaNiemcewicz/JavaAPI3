
public class Color implements ColorAPI {
	int [] colorcodes = new int[3];
	String model;
	public static final Enum models = null; //enum or hashmap?
	//Hashmap<String, int> models2 = null; //is in test on initialization try catch
	//rgb: <0-255>
	//ryb: lets say <0-100>
	//

	public Color(int first, int second, int third) {
		colorcodes[0]= first;
		colorcodes[1]= second;
		colorcodes[2]= third;
		model = "RGB";
	}
	
	
	public Color(int first, int second, int third, String model) {
		colorcodes[0]= first;
		colorcodes[1]= second;
		colorcodes[2]= third;
		if(isModelValid(model))
		this.model = model; //else exception
	}
	
	
	
	public int getColor1() { return colorcodes[0];}; 
	public int getColor2() { return colorcodes[1];};
	public int getColor3() { return colorcodes[2];};
	public String getModel() {return model;};

	public void add(Color color) {
		if(this.isSameModel(color))
	{
		colorcodes[0]+=color.getColor1();
		System.out.println("ad");
		colorcodes[1]+=color.getColor2();
		System.out.println("add");
		colorcodes[2]+= color.getColor3();
		System.out.println("addd");
	} else System.out.println("diff model");
	};
	
	public void addAll(Color[] colors) 
	{		for(Color color:colors)  this.add(color);	};
	
	private boolean isSameModel(Color color) {return this.getModel().equals(color.getModel());}
	
	private boolean isModelValid(String userInputConstr) {return true;}//isIn method wrapped
	
	//@Override
	public boolean isEqual(Color color) {
		if(getModel()!=color.getModel())
			return false;
		if(colorcodes[0]!=color.getColor1()||colorcodes[1]!=color.getColor2()||colorcodes[2]!=color.getColor3())
			return false;
		return true;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}
