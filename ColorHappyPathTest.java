
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
public class ColorHappyPathTest {

	@BeforeAll
	public void getColorTests() {
		int a=1,b=2,c=3,d=4;
		Color hardcodedColor = new Color(1,2,3);
		assertEquals(1,hardcodedColor.getColor1());
		assertEquals(2,hardcodedColor.getColor2());
		assertEquals(3,hardcodedColor.getColor3());
		assertNotEquals(4,hardcodedColor.getColor2());
		assertNotEquals(1,hardcodedColor.getColor3());
		

	}
	
	@Test
	public void getModelTests() {
		Color RYBColor = new Color(51,91,83,"RYB");
		Color RGBColor = new Color(2,5,3,"RGB");
		
		assertEquals("RYB",RYBColor.getModel());
		assertNotEquals("RGB",RYBColor.getModel());
		assertEquals("RGB",RGBColor.getModel());
		assertNotEquals("RYB",RGBColor.getModel());
		assertNotEquals("",RGBColor.getModel());
		assertNotEquals("",RYBColor.getModel());
		assertNotEquals("lorem ipsum",RYBColor.getModel());
	}
	
	
	@BeforeAll
	public void isModelValidHP() { 
		var RYBColor = new Color(1,2,3, "RYB");
		var RGBColor = new Color(2,5,3,"RGB");
		var CMYColor = new Color(24,123,300, "CMY");
	}
	
	@Test
	public void isInputPositive() {
		 Random random = new Random();
		 
		var hardcodedColor = 	new Color(  random.ints(0,255).findFirst().getAsInt(),
											random.ints(0,255).findFirst().getAsInt(),
											random.ints(0,255).findFirst().getAsInt());
		assertTrue(hardcodedColor.getColor1()>=0);	
		assertTrue(hardcodedColor.getColor2()>=0);
		assertTrue(hardcodedColor.getColor3()>=0);
		hardcodedColor = new Color(0,0,0);
		assertTrue(hardcodedColor.getColor2()>=0);
		hardcodedColor = new Color(255,255,255);
		assertTrue(hardcodedColor.getColor2()>=0);
	}
	
	@BeforeAll
	public void isInputCorrectNumber() {
	 Random random = new Random();
	 int rand = random.ints(0,255).findFirst().getAsInt();
	 
		var hardcodedColor = new Color(rand,2,3, "RGB");
		assertEquals(rand,hardcodedColor.getColor1());		
		hardcodedColor = new Color(1,(int)rand/3,3, "RYB");
		assertEquals((int)rand/3,hardcodedColor.getColor2());	
		hardcodedColor = new Color(1,2,rand);
		assertEquals(rand,hardcodedColor.getColor3());	
		assertFalse(hardcodedColor.getColor3()<0);	
		var borderColorRGB = new Color (255,255,255);
		var borderColorCMY = new Color (360,360,360, "CMY");
		var borderColorRYB = new Color (100,100,100, "RYB");
		var whiteColor = new Color(0,0,0,"CMY");
		

	}
	
	@Ignore("Sufficent scope ensured already")
	public void isIsEqualWhenTrue() {
		var color = new Color (4,7,2,"RYB");
		var copyColor = new Color(color.getColor1(),color.getColor2(),color.getColor3(),color.getModel());
		assertTrue(color.isEqual(copyColor));		
		 color = new Color (14,17,121);
		 copyColor = new Color(color.getColor1(),color.getColor2(),color.getColor3(),color.getModel());
		assertTrue(color.isEqual(copyColor));	
	}
	@Test
	public void isIsEqualWhenFalse() {
		var color = new Color (4,97,2,"RGB");
		var copyColor = new Color(color.getColor1()+1,color.getColor2()+1,color.getColor3()+1,color.getModel());
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
	}
	@Test
	public void addTwoSafeTest() {
		
		var color = new Color (13,14,0, "CMY");
		var hardcodedColor = new Color(13,21,1,"CMY"); //rands
		color.add(hardcodedColor);
		new Color(13+13,14+21,0+1, color.getModel());
		assertEquals(color.getColor1(),13+13);
		assertEquals(color.getColor2(),14+21);
		assertEquals(color.getColor3(),0+1);
		
	}
	@Test
	public void addThreeSafeTest() {
		var color = new Color(0,0,1);
		var random = new Random();

		int rand = random.ints(1,100).findFirst().getAsInt();
		
		int t1 = (int)rand/10;
		int t2 = (int)rand;
		int t3 = (int)rand/4;
		Color [] colors = new Color[] {new Color(t1,t2,t3),
										new Color(3,2,1), new Color(0,0,0)};
		color.addAll(colors);
		assertEquals(colors[0].getColor1()+0+colors[1].getColor1(),color.getColor1());	
		assertEquals(colors[0].getColor2()+0+colors[1].getColor2(),color.getColor2());		
		assertEquals(colors[0].getColor3()+1+colors[1].getColor3(),color.getColor3());	
	}
	
	@AfterAll
	public void addThreeBorderSafeTests() {
		var color = new Color(96,96,96,"RYB");
		var colors = new Color[] {new Color(1,2,3, "RYB"), new Color(3,2,1, "RYB")};
		color.addAll(colors);
		assertEquals(colors[0].getColor1()+96+colors[1].getColor1(),color.getColor1());	
		assertEquals(colors[0].getColor2()+96+colors[1].getColor2(),color.getColor2());		
		assertEquals(colors[0].getColor3()+96+colors[1].getColor3(),color.getColor3());
		colors = new Color [0];
		var temp = color;
		color.addAll(colors);
		assertEquals(temp.getColor1(),color.getColor1());	
		assertEquals(temp.getColor2(),color.getColor2());		
		assertEquals(temp.getColor3(),color.getColor3());
	
	}
	
	@Test
	public void isDefaultModelRGB(Color color) {
		var hardcodedColor = new Color(0,0,0);
		assertEquals("RGB",hardcodedColor.getModel());		
	}
	
	@Test
	public void isCorrectModelSet() {
		var rybColor = new Color(11,12,13, "RYB");
		var cmyColor = new Color(255,21,31, "CMY");
		var rgbColor = new Color(61,62,63, "RGB");
		assertEquals("RYB",rybColor.getModel());		
		assertEquals("CMY",cmyColor.getModel());		
		assertEquals("RGB",rgbColor.getModel());	
		assertNotEquals("RYB",rgbColor.getModel());
		assertNotEquals("RYB",cmyColor.getModel());
		assertNotEquals("CMY",rybColor.getModel());
		assertNotEquals("CMY",rgbColor.getModel());
		assertNotEquals("RGB",rybColor.getModel());
		assertNotEquals("RGB",cmyColor.getModel());

	}
	
	@AfterAll
	public void doSameColorsEqual() {
		var color = new Color(11,12,13, "RYB");
		var color2 = new Color(11,12,13, "RYB");
		assertTrue(color.isEqual(color2));
		color = new Color(110,120,130);
		color2 = new Color(110,120,130, "RGB");
		assertTrue(color.isEqual(color2));
		color = new Color(0,120,360, "CMY");
		color2 = new Color(0,120,360, "CMY");
		assertTrue(color.isEqual(color2));
	
	}
	@AfterAll
	public void doDifferentColorsNotEqual() {
		var color = new Color(12,12,13, "RYB");
		var color2 = new Color(11,12,13, "RYB");
		assertFalse(color.isEqual(color2));
		color = new Color(11,120,130);
		color2 = new Color(110,12,130, "RGB");
		assertFalse(color.isEqual(color2));
		color = new Color(10,120,360, "CMY");
		color2 = new Color(0,120,360, "CMY");
		assertFalse(color.isEqual(color2));
		color = new Color(11,12,13);
		color2 = new Color(11,12,13, "RYB");
		assertFalse(color.isEqual(color2));
		color = new Color(0,0,0, "RGB");
		color2 = new Color(0,0,0, "CMY");
		assertFalse(color.isEqual(color2));
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
var c = new ColorHappyPathTest();
c.getColorTests();
c.getModelTests();
c.isModelValidHP();
c.isInputPositive();
c.isInputCorrectNumber();
c.isIsEqualWhenTrue();
c.isIsEqualWhenFalse();
c.addTwoSafeTest();
c.addThreeSafeTest(); 
c.addThreeBorderSafeTests();
c.isCorrectModelSet();
c.doSameColorsEqual();
c.doDifferentColorsNotEqual();

	}

}
