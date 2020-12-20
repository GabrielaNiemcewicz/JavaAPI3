import java.util.HashMap;

public interface ColorAPI {
	public int getColor1(); 
	public int getColor2();
	public int getColor3();
	public String getModel();
	public boolean isEqual(Color color);
	public void add(Color color);
	public void addAll(Color[] colors);
	public static final HashMap<String, Integer> MODELS;

}
