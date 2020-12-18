import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

//check - equals, not equals, edge cases, [...]
//split sad and happy path tests
public class ColorTest {

	Color color1;
	Color color2;
	

	
	//tests to assert type
	

	public void isModelValid(Color color) { 
		//includes default model choice

		
		
		
		 //Color.models(); //check if in model- might require different assertion
		//////////////////*
//get model Enums and check if it's in		
//////////////////////////////		
		
	
	}

	
	public boolean isInputNegative(Color color) {
	
		return false;
	}

	public boolean constructorIllegalArg() {
		Color hardcodedColor = new Color(1,2,3);
		assertThrows(Exception.class,()->hardcodedColor.add(hardcodedColor));
		return false;
	}

	

//is it needed?
	public boolean isIntInputWrongMixed(Color color) {
/////////////////////////////
		return false;
	}
	
	public boolean isInputNull(Color color) {
		Color hardcodedColor = new Color(1,2,3);

		////////////////
		return false;
	}
	
	//try catch
	public boolean isWrongNumberOfArgs(Color color) {
		Color hardcodedColor = new Color(1,2,3);
////////////////////////////////
		return false;
	}

	//strictly unsafe
	public boolean addTwoUnsafeTest(Color color) {

		
		return false;
	} //unsafe from 2 and then 3
	public boolean addThreeUnsafeTests(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());		
		return false;
	}
	
	

	
	public void isWrongModelSet(Color color) {
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(2,hardcodedColor.getColor1());		
	
	}
/*
@Test 
public void name() {
	Exception exception =
			assertThrows(IllegalArgumentException.class,()-> {Color col = new Color(-5,-5,-5)});
	
	
}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		assertEquals(2,2);
		Color col = new Color (2,2,1);
		ColorTest c = new ColorTest();
		c.constructorIllegalArg(); //throwable
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,()->{col.add(col);});
		System.out.println(exception.getMessage());
		System.out.println(exception.getCause());
		System.out.println(exception.getLocalizedMessage());
		System.out.println(exception.getClass()); //not null
		System.out.println(exception.hashCode()); //not null
		
		Throwable error = Assertions.assertThrows(IllegalArgumentException.class,()->{ Color RGBColor = new Color(2,5,3,"supermodel");});
		System.out.println(error.getClass()); //not null
		System.out.println(error.hashCode()); //not null

		
		error = Assertions.assertThrows(IllegalArgumentException.class,()->{ Color RGBColor = new Color(2,5,3,"supermodel");});
		System.out.println(error.getClass()); 
		
		
		error = Assertions.assertThrows(IllegalArgumentException.class,()->{ Color RGBColor = new Color(2,5,3,"");});
		System.out.println(error.getClass()); 
		
		
		error = Assertions.assertThrows(IllegalArgumentException.class,()->{ Color RGBColor = new Color(2,5,3,"RGB ");});
		System.out.println(error.getClass()); 
		
		error = Assertions.assertThrows(IllegalArgumentException.class,()->{ Color RGBColor = new Color(2,5,3,"cmy");});
		System.out.println(error.getClass());
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ Color color1rgb = new Color(245,230,100);
		color1rgb.add(color1rgb);});
		System.out.println(error.getClass());
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ Color color1rgb = new Color(245,230,100);
		color1rgb.add(new Color(10,26,155));}); //edge case
		System.out.println(error.getClass()+" here");
		
		//fail
		error = Assertions.assertThrows(Throwable.class,()->
		{ Color color1cmy = new Color(359,356,135, "CMY");
		color1cmy.add(new Color(1,22,22, "CMY"));}); //edge case
		System.out.println(error.getClass()+" here");
		
		
		
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ Color color1cmy = new Color(359,356,135, "CMY");
		color1cmy.add(new Color(359,22,22, "CMY"));}); //edge case
		System.out.println(error.getClass()+" here");
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ Color color1ryb = new Color(85,99,12, "RYB");
		color1ryb.add(new Color(10,26,5, "RYB"));}); 
		System.out.println(error.getClass()+" here");
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ var color1ryb = new Color(85,99,12, "RYB");
		color1ryb.add(new Color(10,26,5, "RYB"));}); 
		System.out.println(error.getClass()+" here");
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ var color1cmy = new Color(359,356,135, "CMY");
		color1cmy.add(new Color(1,5,22, "CMY"));}); //edge case
		System.out.println(error.getClass()+" here");
		
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ var color1ryb = new Color(85,99,12, "RYB");
		color1ryb.add(new Color(15,2,88, "RYB"));}); 
		System.out.println(error.getClass()+" here");
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ var color1cmy = new Color (9,6,135, "CMY");
		Color [] colors = new Color[] {new Color(300,300,135, "CMY"),new Color(359,356,135, "CMY")};
		color1cmy.addAll(colors);}); 
		System.out.println(error.getClass()+" here");
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ var color1cmy = new Color (9,6,135, "CMY");
		Color [] colors = new Color[] {new Color(301,304,25, "CMY"),new Color(50,51,101, "CMY")};
		color1cmy.addAll(colors);}); //edge case
		System.out.println(error.getClass()+" here");
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ var color1cmy = new Color (9,6,135, "CMY");
		Color [] colors = new Color[] {new Color(300,300,135, "CMY"),new Color(359,356,135, "CMY")};
		color1cmy.addAll(colors);}); //edge case
		System.out.println(error.getClass()+" here");
		
		
		
		//fail
		//error = Assertions.assertThrows(IllegalArgumentException.class,()->{ Color RGBColor = new Color(5,3,"cmy");});
		//System.out.println(error.getClass());
		
	
		//error = Assertions.assertThrows(Throwable.class,()->{ Color RGBColor = new Color(-2,-5,-3,"RGB");});
		//System.out.println(error.getClass());
		


		error = Assertions.assertThrows(Throwable.class,()->{ Color RGBColor = new Color(256,500,1000);});
		System.out.println(error.getClass());
		error = Assertions.assertThrows(Throwable.class,()->{ Color RGBColor = new Color(-1,200,100);});
		System.out.println(error.getClass());
		error = Assertions.assertThrows(Throwable.class,()->{ Color RGBColor = new Color(-1,260,0);});
		System.out.println(error.getClass());
		///////////////
		error = Assertions.assertThrows(Throwable.class,()->{ Color RGBColor = new Color(2,5,3,"RGB ");});
		System.out.println(error.getClass());
		error = Assertions.assertThrows(Throwable.class,()->{ Color RGBColor = new Color(21,15,-3,"RYB");});
		System.out.println(error.getClass());
		error = Assertions.assertThrows(Throwable.class,()->{ Color RGBColor = new Color(21,15,222,"RYB");});
		System.out.println(error.getClass());
		error = Assertions.assertThrows(Throwable.class,()->{ Color RGBColor = new Color(102,101,2,"RYB");});
		System.out.println(error.getClass());
		error = Assertions.assertThrows(Throwable.class,()->{ Color RGBColor = new Color(0,-3,0,"CMY");});
		System.out.println(error.getClass());
		error = Assertions.assertThrows(Throwable.class,()->{ Color RGBColor = new Color(360,360,361,"CMY");});
		System.out.println(error.getClass());
		
		//fail
		//error = Assertions.assertThrows(Throwable.class,()->{ Color RGBColor = new Color("a",200,100);});
		//System.out.println(error.getClass());
		
		
		
		
		
		
		
		
	}

}
