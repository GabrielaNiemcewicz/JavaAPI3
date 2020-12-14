import static org.junit.jupiter.api.Assertions.assertEquals;
//check - equals, not equals, edge cases, [...]
public class ColorTest {

	Color color1;
	Color color2;
	
	public boolean getColorTests(Color color) {
		int a=1,b=2,c=3,d=4;
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());
		assertEquals(2,hardcodedColor.getColor2());
		assertEquals(3,hardcodedColor.getColor3());
		//assert not equals
		
		return false;
	}
	
	public boolean getModelTests(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	public boolean isModelValid(Color color) {
		//includes default model choice
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	public boolean isInputPositive(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}

	//might be different for each model?
	public boolean isInputCorrectNumber(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	public boolean isInputNegative(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	
	public boolean isInputAboveTreshold(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}

	public boolean isIntInputWrongMixed(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	
	public boolean isInputNull(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	public boolean isWrongNumberOfArgs(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	public boolean isIsEqualWhenTrue(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	public boolean isIsEqualWhenFalse(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	//can be random, recorded tests
	public boolean addTwoSafeTest(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	
	public boolean addThreeSafeTest(Color color) {
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
	
	public boolean addThreeBorderSafeTests(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	public boolean isWrongArgsNumber(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	
	public boolean isDefaultModelRGB(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	
	public boolean isWrongModelSet(Color color) {
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
		assertEquals(1,2);
	}

}
