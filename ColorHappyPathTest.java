import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.Random;
public class ColorHappyPathTest {

	public boolean getColorTests(Color color) {
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
	public boolean getModelTests(Color color) {
		Color RYBColor = new Color(51,91,83, "RYB");
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
	
	
	
	public boolean isModelValidHP(Color color) { 

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
	
	public boolean isInputPositive(Color color) {
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
	public boolean isInputCorrectNumber(Color color) {
	 Random random = new Random();
	 int rand = random.ints(0,255).findFirst().getAsInt();
	 
		Color hardcodedColor = new Color(rand,2,3, "RGB");
		assertEquals(rand,hardcodedColor.getColor1());		
		hardcodedColor = new Color(1,(int)rand/3,3, "RYB");
		assertEquals((int)rand/3,hardcodedColor.getColor2());	
		hardcodedColor = new Color(1,2,rand);
		assertEquals(rand,hardcodedColor.getColor3());	
		
		return false;
	}
	
	public boolean isIsEqualWhenTrue(Color color) {
		Color copyColor = new Color(color.getColor1(),color.getColor2(),color.getColor3(),color.getModel());
		assertTrue(color.isEqual(copyColor));		
		return false;
	}
	public boolean isIsEqualWhenFalse(Color color) {
		Color copyColor = new Color(color.getColor1()+1,color.getColor2()+1,color.getColor3()+1,color.getModel());
		assertFalse(color.isEqual(copyColor));		
		copyColor = new Color(color.getColor1()-5,color.getColor2(),color.getColor3(),color.getModel());
		assertFalse(color.isEqual(copyColor));		
		copyColor = new Color(color.getColor1(),color.getColor2()-100,color.getColor3(),color.getModel());
		assertFalse(color.isEqual(copyColor));		
		copyColor = new Color(color.getColor1(),color.getColor2(),color.getColor3()+3,color.getModel());
		assertFalse(color.isEqual(copyColor));		
		copyColor = new Color(color.getColor1(),color.getColor2(),color.getColor3(),"RYB");
		assertFalse(color.isEqual(copyColor));	
		copyColor = new Color(color.getColor1(),color.getColor2(),color.getColor3(),"CMY");
		assertFalse(color.isEqual(copyColor));	
		copyColor = new Color(color.getColor1(),color.getColor2(),color.getColor3(),"RGB");
		assertFalse(color.isEqual(copyColor));		
		return false;
	}
	//can be random, recorded tests
	public boolean addTwoSafeTest(Color color) {
		//new Color(int((modelMAX-color.get)/2))
		
		Color hardcodedColor = new Color(13,21,31, color.getModel()); //can be rands
		color.add(hardcodedColor);
		Color solutionColor = new Color (hardcodedColor.getColor1()+color.getColor1(),hardcodedColor.getColor2()+color.getColor2(),hardcodedColor.getColor3()+color.getColor3(), color.getModel());
		assertTrue(color.isEqual(solutionColor));		
		return false;
	}
	
	public boolean addThreeSafeTest(Color color) {
		Random random = new Random();
		int rand = random.ints(1,100).findFirst().getAsInt();
		Color [] colors = new Color[] {new Color((int)rand/10,(int)rand,(int)rand/4),
										new Color(3,2,1)};
		color.addAll(colors);
		assertEquals((int)(rand/10)+3+color.getColor1(),color.getColor1());	
		assertEquals((int)rand+2+color.getColor1(),color.getColor1());		
		assertEquals((int)(rand/4)+1+color.getColor1(),color.getColor1());	
		return false;
	}
	
	//can have cases for other models, not necessary. not random until implmentation decided
	public boolean addThreeBorderSafeTests() {
		Color color = new Color(96,96,96,"RYB");
		var colors = new Color[] {new Color(1,2,3), new Color(3,2,1)};
		color.addAll(colors);
		assertEquals(1+3+color.getColor1(),color.getColor1());	
		assertEquals(2+2+color.getColor2(),color.getColor2());		
		assertEquals(3+1+color.getColor3(),color.getColor3());		
		return false;
	}
	
	public boolean isDefaultModelRGB(Color color) {
		Color hardcodedColor = new Color(0,0,0);
		assertEquals("RGB",hardcodedColor.getModel());		
		return false;
	}
	
	public boolean isCorrectModelSet(Color color) {
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

	}

}
