import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Color implements ColorAPI {
	int [] colorcodes = new int[3];
	String model;
	//public static final Enum models = null; //enum or hashmap?
	static ArrayList<String> MODELS = new ArrayList <String> ();
	static HashMap<String,Integer> models = new HashMap<String,Integer>();

	static final int []MAX_LENGTH = new int[] {255,100,360};

	public Color(int first, int second, int third) throws IllegalArgumentException {
		MODELS.add("RGB"); MODELS.add("RYB"); MODELS.add("CMY");
		model = "RGB";
		colorcodes[0]= first;
		colorcodes[1]= second;
		colorcodes[2]= third;
		for(int i=0;i<3;i++)
			if(colorcodes[i]>=this.getMax()||colorcodes[i]<=0) throw new IllegalArgumentException();

	}
	
	
	public Color(int first, int second, int third, String model) throws IllegalArgumentException {
		MODELS.add("RGB"); MODELS.add("RYB"); MODELS.add("CMY");
		if(isModelValid(model))		this.model = model; 
		else throw 			new IllegalArgumentException();
		colorcodes[0]= first;
		colorcodes[1]= second;
		colorcodes[2]= third;
		for(int i=0;i<3;i++)
			if(colorcodes[i]>this.getMax()||colorcodes[i]<0) throw new IllegalArgumentException();

	}
	
	
	
	public int getColor1() throws NullPointerException { return colorcodes[0];}; 
	public int getColor2() throws NullPointerException { return colorcodes[1];};
	public int getColor3() throws NullPointerException { return colorcodes[2];};
	public String getModel() throws NullPointerException {return model;};

	public void add(Color color) throws IllegalArgumentException {
		if(this.isSameModel(color))
	{
		colorcodes[0]+=color.getColor1();
		colorcodes[1]+=color.getColor2();
		System.out.println("add");
		colorcodes[2]+= color.getColor3();
		System.out.println("addd");
		for(int c:colorcodes)
		{if (c>255||c<0)///////////////////////
		throw new IllegalArgumentException(); 
	 else throw new IllegalArgumentException(); 
		}}};
	
	public void addAll(Color[] colors)  throws IllegalArgumentException
	{		for(Color color:colors)  this.add(color);	};
	
	private boolean isSameModel(Color color) throws NullPointerException{return this.getModel().equals(color.getModel());}
	
	private boolean isModelValid(String userInputConstr) throws IllegalArgumentException, NullPointerException {return MODELS.contains(userInputConstr);}//isIn method wrapped
	
	private int getMax()  {
		if(getModel().equals("RGB"))
			return 255;
		if(getModel().equals("RYB"))
			return 100;
		else
			return 360;
	
		
	}
	
	@Override
	public boolean isEqual(Color color) throws NullPointerException{
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
