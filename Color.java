import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Color implements ColorAPI {
	private int [] colorcodes = new int[3];
	private String model;
	private static ArrayList<String> MODELS = new ArrayList <String> ();
//	static final int []MAX_LENGTH = new int[] {255,100,360};

	public Color(int first, int second, int third) throws IllegalArgumentException, IndexOutOfBoundsException {
		this(first,second,third,"RGB");
	}
	
	
	public Color(int first, int second, int third, String model) throws IllegalArgumentException,IndexOutOfBoundsException, NoArgumentException, ModelException  {
		MODELS.add("RGB"); MODELS.add("RYB"); MODELS.add("CMY");
		if(model.isBlank()) throw new NoArgumentException("Error, missing model while specifiction implied");
		if(isModelValid(model))		this.model = model; 
		else throw 	new ModelException("Not a supported color model");
		
		colorcodes[0]= first;
		colorcodes[1]= second;
		colorcodes[2]= third;
		for(int i=0;i<3;i++)
			if(colorcodes[i]>this.getMax()||colorcodes[i]<0) throw new IndexOutOfBoundsException();

	}
	
	
	
	public int getColor1() { return colorcodes[0];}; 
	public int getColor2() { return colorcodes[1];};
	public int getColor3() { return colorcodes[2];};
	public String getModel() {return model;};

	public void add(Color color) throws IllegalArgumentException, IndexOutOfBoundsException, ModelException {
		if(!this.isSameModel(color))
			throw new ModelException("Exception- Incopatible models to add");//IllegalArgumentException();
		else
	{
		this.colorcodes[0]+=color.getColor1();
		this.colorcodes[1]+=color.getColor2();
		this.colorcodes[2]+= color.getColor3();
		for(int c:colorcodes)
		if (c>getMax()||c<0)
		throw new IndexOutOfBoundsException(); 
		}};
	
	public void addAll(Color[] colors) throws IllegalArgumentException, IndexOutOfBoundsException, ModelException
	{		for(Color color:colors)  this.add(color);	};
	
	private boolean isSameModel(Color color)
	{		return this.getModel().equals(color.getModel());}
	
	private boolean isModelValid(String userInputConstr)
		{		return MODELS.contains(userInputConstr);	}//isIn method wrapped
	
	private int getMax()  {
		if(getModel().equals("RGB"))
			return 255;
		if(getModel().equals("RYB"))
			return 100;
		else
			return 360;
	
		
	}
	
	@Override
	public boolean isEqual(Color color){
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
