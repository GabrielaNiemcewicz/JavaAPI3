
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.Random;
public class ColorHappyPathTest {

	public boolean getColorTests() {
		int a=1,b=2,c=3,d=4;
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());
		assertEquals(2,hardcodedColor.getColor2());
		assertEquals(3,hardcodedColor.getColor3());
		assertNotEquals(4,hardcodedColor.getColor2());
		assertNotEquals(1,hardcodedColor.getColor3());
		//assert not equals
		
		return false;
	}
	
	
	//lower case upper case made true? maybe?
	public boolean getModelTests() {
		Color RYBColor = new Color(51,91,83,"RYB");
		Color RGBColor = new Color(2,5,3,"RGB");
		
		assertEquals("RYB",RYBColor.getModel());
		assertNotEquals("RGB",RYBColor.getModel());
		assertEquals("RGB",RGBColor.getModel());
		assertNotEquals("RYB",RGBColor.getModel());
		assertNotEquals("",RGBColor.getModel());
		assertNotEquals("",RYBColor.getModel());
		assertNotEquals("lorem ipsum",RYBColor.getModel());
		return false;
	}
	
	
	
	public boolean isModelValidHP() { 

		Color RYBColor = new Color(1,2,3, "RYB");
		Color RGBColor = new Color(2,5,3,"RGB");
		String modelCorrect = "RGB";
		//sad path?
		String modelIncorrect = "supermodel";
		String emptyModel = "";
		String spaceModel = "RGB ";
		
		 //Color.models(); //check if in model- might require different assertion
		//////////////////*
//get model Enums and check if it's in		
//////////////////////////////		
		
		return false;
	}
	
	public boolean isInputPositive() {
		 Random random = new Random();
		 
		Color hardcodedColor = new Color( random.ints(0,255).findFirst().getAsInt(),random.ints(0,255).findFirst().getAsInt(),random.ints(0,255).findFirst().getAsInt());
		assertTrue(hardcodedColor.getColor1()>=0);	
		assertTrue(hardcodedColor.getColor2()>=0);
		assertTrue(hardcodedColor.getColor3()>=0);
		hardcodedColor = new Color(0,0,0);
		assertTrue(hardcodedColor.getColor2()>=0);
		hardcodedColor = new Color(255,255,255);
		assertTrue(hardcodedColor.getColor2()>=0);
		return false;
	}
	
	//might be different for each model?
	public boolean isInputCorrectNumber() {
	 Random random = new Random();
	 int rand = random.ints(0,255).findFirst().getAsInt();
	 
		Color hardcodedColor = new Color(rand,2,3, "RGB");
		assertEquals(rand,hardcodedColor.getColor1());		
		hardcodedColor = new Color(1,(int)rand/3,3, "RYB");
		assertEquals((int)rand/3,hardcodedColor.getColor2());	
		hardcodedColor = new Color(1,2,rand);
		assertEquals(rand,hardcodedColor.getColor3());	
		assertFalse(hardcodedColor.getColor3()<0);	
		Color borderColorRGB = new Color (255,255,255);
		Color borderColorCMY = new Color (360,360,360, "CMY");
		Color borderColorRYB = new Color (100,100,100, "RYB");
		
		
		return false;
	}
	
	public boolean isIsEqualWhenTrue() {
		Color color = new Color (4,7,2,"RYB");
		Color copyColor = new Color(color.getColor1(),color.getColor2(),color.getColor3(),color.getModel());
		assertTrue(color.isEqual(copyColor));		
		return false;
	}
	public boolean isIsEqualWhenFalse() {
		Color color = new Color (4,97,2,"RGB");
		Color copyColor = new Color(color.getColor1()+1,color.getColor2()+1,color.getColor3()+1,color.getModel());
		assertFalse(color.isEqual(copyColor));		
		copyColor = new Color(color.getColor1()-2,color.getColor2(),color.getColor3(),color.getModel());
		assertFalse(color.isEqual(copyColor));		
		copyColor = new Color(color.getColor1(),color.getColor2()-50,color.getColor3(),color.getModel());
		assertFalse(color.isEqual(copyColor));		
		copyColor = new Color(color.getColor1(),color.getColor2(),color.getColor3()+3,color.getModel());
		assertFalse(color.isEqual(copyColor));		
		copyColor = new Color(color.getColor1(),color.getColor2(),color.getColor3(),"RYB");
		assertFalse(color.isEqual(copyColor));	
		copyColor = new Color(color.getColor1(),color.getColor2(),color.getColor3(),"CMY");
		assertFalse(color.isEqual(copyColor));	
		copyColor = new Color(color.getColor1(),color.getColor2(),color.getColor3());
		assertTrue(color.isEqual(copyColor));		
		return false;
	}
	//can be random, recorded tests
	public boolean addTwoSafeTest() {
		//new Color(int((modelMAX-color.get)/2))
		Color color = new Color (13,14,0, "CMY");
		Color hardcodedColor = new Color(13,21,1,"CMY"); //rands
		color.add(hardcodedColor);
		int t1 = color.getColor1();
		int t2= color.getColor2();
		int t3= color.getColor3(); new Color(13+13,14+21,0+1, color.getModel());
		assertEquals(color.getColor1(),13+13);
		assertEquals(color.getColor2(),14+21);
		assertEquals(color.getColor3(),0+1);
		return false;
	}
	
	public boolean addThreeSafeTest() {
		var color = new Color(0,0,1);
		var random = new Random();

		int rand = random.ints(1,100).findFirst().getAsInt();
		
		int t1 = (int)rand/10;
		int t2 = (int)rand;
		int t3 = (int)rand/4;
		Color [] colors = new Color[] {new Color(t1,t2,t3),
										new Color(3,2,1)};
		color.addAll(colors);
		assertEquals(colors[0].getColor1()+0+colors[1].getColor1(),color.getColor1());	
		assertEquals(colors[0].getColor2()+0+colors[1].getColor2(),color.getColor2());		
		assertEquals(colors[0].getColor3()+1+colors[1].getColor3(),color.getColor3());	
		return false;
	}
	
	//can have cases for other models, not necessary. not random until implmentation decided
	public boolean addThreeBorderSafeTests() {
		var color = new Color(96,96,96,"RYB");
		var colors = new Color[] {new Color(1,2,3, "RYB"), new Color(3,2,1, "RYB")};
		color.addAll(colors);
		assertEquals(colors[0].getColor1()+96+colors[1].getColor1(),color.getColor1());	
		assertEquals(colors[0].getColor2()+96+colors[1].getColor2(),color.getColor2());		
		assertEquals(colors[0].getColor3()+96+colors[1].getColor3(),color.getColor3());
		return false;
	}
	
	public boolean isDefaultModelRGB(Color color) {
		Color hardcodedColor = new Color(0,0,0);
		assertEquals("RGB",hardcodedColor.getModel());		
		return false;
	}
	
	public boolean isCorrectModelSet() {
		Color rybColor = new Color(11,12,13, "RYB");
		Color cmyColor = new Color(255,21,31, "CMY");
		Color rgbColor = new Color(61,62,63, "RGB");
		assertEquals("RYB",rybColor.getModel());		
		assertEquals("CMY",cmyColor.getModel());		
		assertEquals("RGB",rgbColor.getModel());	
		assertNotEquals("RYB",rgbColor.getModel());
		assertNotEquals("RYB",cmyColor.getModel());
		assertNotEquals("CMY",rybColor.getModel());
		assertNotEquals("CMY",rgbColor.getModel());
		assertNotEquals("RGB",rybColor.getModel());
		assertNotEquals("RGB",cmyColor.getModel());
		return false;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
ColorHappyPathTest c = new ColorHappyPathTest();
c.getColorTests();
c.getModelTests();
//to implement//c.isModelValidHP();
//to implement
c.isInputPositive();
c.isInputCorrectNumber();
c.isIsEqualWhenTrue();
c.isIsEqualWhenFalse();
c.addTwoSafeTest();
c.addThreeSafeTest(); //failing
c.addThreeBorderSafeTests(); //failing
c.isCorrectModelSet();
	}

}
