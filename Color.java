import java.util.HashMap;

public class Color implements ColorAPI {
	private int [] colorcodes = new int[3];
	private String model;
	
	public static final HashMap<String, Integer> MODELS;
	static {
	    MODELS = new HashMap<>();
	    MODELS.put("RGB", 255);
	    MODELS.put("RYB", 100);
	    MODELS.put("CMY", 360);
	}

	public Color(int first, int second, int third) throws IndexOutOfBoundsException {
		this(first,second,third,"RGB");
	}
	
	
	public Color(int first, int second, int third, String model) throws IndexOutOfBoundsException, NoArgumentException, ModelException  {
		if(model.isBlank()) throw new NoArgumentException("Error, missing model while specifiction implied");
	
		if(isModelValid(model))		this.model = model; 
		else throw 	new ModelException("Not a supported color model");
		
		colorcodes[0]= first;
		colorcodes[1]= second;
		colorcodes[2]= third;
		for(int i=0;i<3;i++)
			if(colorcodes[i]>this.getMax()||colorcodes[i]<0) throw new IndexOutOfBoundsException();

	}
	
	
	
	public final int getColor1() { return colorcodes[0];}; 
	public final int getColor2() { return colorcodes[1];};
	public final int getColor3() { return colorcodes[2];};
	public String getModel() {return model;};

	
	public void add(Color color) throws IndexOutOfBoundsException, ModelException {
		if(!this.isSameModel(color))
			throw new ModelException("Exception- Incopatible models to add");
		
		else	{
		this.colorcodes[0]+=color.getColor1();
		this.colorcodes[1]+=color.getColor2();
		this.colorcodes[2]+= color.getColor3();
		for(int c:colorcodes)
		if (c>getMax()||c<0)
			throw new IndexOutOfBoundsException(); 
		}};
	
	public void addAll(Color[] colors) throws IndexOutOfBoundsException, ModelException
	{		for(Color color:colors)  this.add(color);	};
	
	private final boolean isSameModel(Color color)
	{		return this.getModel().equals(color.getModel());}
	
	private final boolean isModelValid(String userInputConstr)
		{	return MODELS.containsKey(userInputConstr);	}//isIn method wrapped
	
	private final int getMax()  {	return MODELS.get(getModel());	}
	
	@Override
	public boolean isEqual(Color color){
		if(getModel()!=color.getModel())	return false;
		
		if(colorcodes[0]!=color.getColor1()||colorcodes[1]!=color.getColor2()||colorcodes[2]!=color.getColor3())
			return false;
	
		return true;		
	}
	




}
