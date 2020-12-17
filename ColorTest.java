import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

//check - equals, not equals, edge cases, [...]
//split sad and happy path tests
public class ColorTest {

	Color color1;
	Color color2;
	

	
	//tests to assert type
	

	public boolean isModelValid(Color color) { 
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

	
	public boolean isInputNegative(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertFalse(hardcodedColor.getColor3()<0);		
		return false;
	}

	public boolean constructorIllegalArg() {
		Color hardcodedColor = new Color(1,2,3);
		assertThrows(Exception.class,()->hardcodedColor.add(hardcodedColor));
		return false;
	}

	
	public boolean isColorNotAboveTreshold(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
//is it needed?
	public boolean isIntInputWrongMixed(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	
	public boolean isInputNull(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertNotEquals("",hardcodedColor.getColor1());		
		return false;
	}
	
	//try catch
	public boolean isWrongNumberOfArgs(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}

	//strictly unsafe
	public boolean addTwoUnsafeTest(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	} //unsafe from 2 and then 3
	public boolean addThreeUnsafeTests(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	
	

	
	public boolean isWrongModelSet(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}

@Test 
public void name() {
	Exception exception =
			assertThrows(IllegalArgumentException.class,()-> {Color col = new Color(-5,-5,-5)});
	
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		assertEquals(1,2);
		ColorTest c = new ColorTest();
		c.constructorIllegalArg();
		
		
	}

}
