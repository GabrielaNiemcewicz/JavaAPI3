import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
		Color RYBColor = new Color(1,2,3, "RYB");
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
		//includes default model choice
		Color RYBColor = new Color(1,2,3, "RYB");
		Color RGBColor = new Color(2,5,3,"RGB");
		String modelCorrect = "RGB";
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
		Color hardcodedColor = new Color(1,2,3);
		assertTrue(hardcodedColor.getColor1()>=0);	
		assertTrue(hardcodedColor.getColor2()>=0);
		assertTrue(hardcodedColor.getColor3()>=0);
		return false;
	}
	
	//might be different for each model?
	public boolean isInputCorrectNumber(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
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
		Color [] colors = new Color[] {new Color(1,2,3), new Color(3,2,1)};
		color.addAll(colors);
		assertEquals(1+3+color.getColor1(),color.getColor1());	
		assertEquals(2+2+color.getColor1(),color.getColor1());		
		assertEquals(3+1+color.getColor1(),color.getColor1());	
		return false;
	}
	
	public boolean addThreeBorderSafeTests(Color color) {
		//needs model max 
		//C1(floor(max/3),), C2(floor(max-color-c1)
		Color [] colors = new Color[] {new Color(1,2,3), new Color(3,2,1)};
		color.addAll(colors);
		assertEquals(1+3+color.getColor1(),color.getColor1());	
		assertEquals(2+2+color.getColor1(),color.getColor1());		
		assertEquals(3+1+color.getColor1(),color.getColor1());		
		return false;
	}
	
	public boolean isDefaultModelRGB(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	
	public boolean isCorrectModelSet(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
