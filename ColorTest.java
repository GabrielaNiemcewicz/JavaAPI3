import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

//check - equals, not equals, edge cases, [...]
//split sad and happy path tests
public class ColorTest {

	Throwable error;
	

	
	//tests to assert type
	

	public void isModelValid() { 
		//includes default model choice
		
		error = Assertions.assertThrows(IllegalArgumentException.class,()->{ var RGBColor = new Color(2,5,3,"supermodel");});
		System.out.println(error.getClass()); //not null
		System.out.println(error.hashCode()); //not null


		error = Assertions.assertThrows(IllegalArgumentException.class,()->{ var RGBColor = new Color(2,5,3,"RGB ");});
		System.out.println(error.getClass()); 
		
		error = Assertions.assertThrows(IllegalArgumentException.class,()->{ var RGBColor = new Color(2,5,3,"cmy");});
		System.out.println(error.getClass());
		
		error = Assertions.assertThrows(Throwable.class,()->{ var RGBColor = new Color(2,5,3,"RGB ");});
		System.out.println(error.getClass());
		error = Assertions.assertThrows(Throwable.class,()->{var RGBColor = new Color(255,20,147, "supermodel");});
		System.out.println(error.getClass());
		
	
	}

	
	public void isInputNegative() {
	
		error = Assertions.assertThrows(Throwable.class,()->{ var RGBColor = new Color(256,500,1000);});
		System.out.println(error.getClass());
		error = Assertions.assertThrows(Throwable.class,()->{ var RGBColor = new Color(-1,200,100, "CMY");});
		System.out.println(error.getClass());
		error = Assertions.assertThrows(Throwable.class,()->{ var RGBColor = new Color(-1,260,0);});
		System.out.println(error.getClass());

		
	}


	
	public void isIntInputWrongMixed() {
		error = Assertions.assertThrows(Throwable.class,()->{ var RGBColor = new Color(21,15,-3,"RYB");});
		System.out.println(error.getClass());
		
		error = Assertions.assertThrows(Throwable.class,()->{ var RGBColor = new Color(0,-3,0,"CMY");});
		System.out.println(error.getClass());

	}
	
	public void isInputNull() {
		error = Assertions.assertThrows(Throwable.class,()->{ var RGBColor = new Color(2,5,3,"");});
		System.out.println(error.getClass()); 
		
		error = Assertions.assertThrows(Throwable.class,()->
		{  var RGBColor = new Color(60,60,2);
		RGBColor.isEqual(new Color(90, 90,204, " "));		
		});
		System.out.println(error.getClass());
		
		error = Assertions.assertThrows(Throwable.class,()->
		{  var RGBColor = new Color(60,60,2);
		RGBColor.isEqual(new Color(90, 90,204, " 	"));		
		});
		System.out.println(error.getClass());

	}
	
	//try catch
	public void isIntTooLarge() {
		error = Assertions.assertThrows(Throwable.class,()->{ var RGBColor = new Color(360,360,361,"CMY");});
		System.out.println(error.getClass());
		error = Assertions.assertThrows(Throwable.class,()->{ var RGBColor = new Color(21,15,222,"RYB");});
		System.out.println(error.getClass());
		error = Assertions.assertThrows(Throwable.class,()->{ var RGBColor = new Color(102,101,2,"RYB");});
		System.out.println(error.getClass());

	
	}
	
	

	//strictly unsafe
	public void addTwoUnsafeTestRGB() {

		error = Assertions.assertThrows(Throwable.class,()->
		{ var color1rgb = new Color(245,230,100);
		color1rgb.add(color1rgb);});
		System.out.println(error.getClass());
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ var color1rgb = new Color(245,230,100);
		color1rgb.add(new Color(10,26,155));}); //edge case
		System.out.println(error.getClass()+" here");
	
			
	} 
	
	public void addTwoUnsafeTestCMY() {
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ var color1cmy = new Color(359,356,135, "CMY");
		color1cmy.add(new Color(359,22,22, "CMY"));}); //edge case
		System.out.println(error.getClass()+" here");
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ var color1cmy = new Color(359,356,135, "CMY");
		color1cmy.add(new Color(1,5,22, "CMY"));}); //edge case
		System.out.println(error.getClass()+" here");
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ var color1cmy = new Color(359,356,135, "CMY");
		color1cmy.add(new Color(1,22,22, "RGB"));}); //edge case
		System.out.println(error.getClass()+" here");
		
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ var colorCMY = new Color(60,60,2,"CMY");
		colorCMY.add(new Color(359, 100,5, "RYB"));
		});
		System.out.println(error.getClass());
		error = Assertions.assertThrows(Throwable.class,()->
		{ var colorCMY = new Color(60,60,2,"CMY");
		colorCMY.add(new Color(9000, 9000,-204, "CMY"));
		});
		System.out.println(error.getClass());
		
	}
	public void addTwoUnsafeTestRYB() {

		error = Assertions.assertThrows(Throwable.class,()->
		{ var color1ryb = new Color(85,99,12, "RYB");
		color1ryb.add(new Color(10,26,5, "RYB"));}); 
		System.out.println(error.getClass()+" here");
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ var color1ryb = new Color(85,99,12, "RYB");
		color1ryb.add(new Color(10,26,5, "RYB"));}); 
		System.out.println(error.getClass()+" here");
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ var color1ryb = new Color(85,99,12, "RYB");
		color1ryb.add(new Color(15,2,88, "RYB"));}); 
		System.out.println(error.getClass()+" here");
		
		
		
	}
	
	
	//unsafe from 2 and then 3
	public void addThreeUnsafeTests() {
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
		
		error = Assertions.assertThrows(Throwable.class,()->
		{ 	var color = new Color(22,25,2,"RGB");
		Color[]colors = new Color[] {color, color, color, color, new Color(255, 180,190)};
		color.addAll(colors);
		});
		System.out.println(error.getClass());
		
		
	}
	
	

	public void addingBoundaryCases () {
		error = Assertions.assertThrows(Throwable.class,()->
		{ 		Color color = new Color(19,19,19,"RYB");
		Color[]colors = new Color[] {color, color, color, color, new Color(6,5,5, "RYB")};
		color.addAll(colors);
		});
		System.out.println(error.getClass());

		error = Assertions.assertThrows(Throwable.class,()->
		{ 		Color color = new Color(300,300,300,"CMY");
		Color[]colors = new Color[] {color};
		color.addAll(colors);
		});
		System.out.println(error.getClass());

		error = Assertions.assertThrows(Throwable.class,()->
		{ 		Color color = new Color(19,19,19);
		Color[]colors = new Color[] {new Color(6, 5,5, "RYB"), new Color(6, 5,5, "CMY")};
		color.addAll(colors);
		});
		System.out.println(error.getClass());
		
	}

	public static void main(String[] args) {
		var c = new ColorTest();
		c.addingBoundaryCases();
		c.addThreeUnsafeTests();
		c.addTwoUnsafeTestCMY();
		c.addTwoUnsafeTestRGB();
		c.addTwoUnsafeTestRYB();
		c.isInputNegative();
		c.isInputNull();
		c.isIntInputWrongMixed();
		c.isIntTooLarge();
		c.isModelValid();
		
		
		
		
		
	

		

	}

}
