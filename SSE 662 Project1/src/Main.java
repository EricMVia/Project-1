import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.Scanner;
import java.io.IOException;



public class Main {

    @Test
    public void testConcatenate() {
        MyUnit myUnit = new MyUnit();
        MyEquation myEquation = new MyEquation();
        String result = myUnit.concatenate("1", "two");
        String result1 = myEquation.concatenate1(); 
        assertEquals("1two", result);
        assertEquals("hello world",result1);                         
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void testMatchers() {
        assertThat("hello world", is("hello world"));            //sees if two items are matching
        assertThat(124.56777, is(124.56777));            
    }
    
    @Test
    public void isLeapYearKeboardTest() throws IOException {
        MyIO leapYear = new MyIO();
 
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Input a leap year to proceed:");
        int year = scanner1.nextInt();                                     //gets next INT
        assertTrue("Leap Year", leapYear.isLeapYear(year));          //sees if class provides "leap year" as answer
    }
    
    @Test
    public void SimpleMathTest() throws IOException {
    	int[] arr1 = new int [] {5, 2, 42};
   
    	Scanner scanner2 = new Scanner(System.in);
    	System.out.println("What is 10 - 5? ");
        int year = scanner2.nextInt();  
    	
    	System.out.println("What is: 4500 * 2 -8998? ");
    	int two = scanner2.nextInt();
    	
    	System.out.println("What number is depicted as the meaning of life? ");
    	int three = scanner2.nextInt();
    	
    	int []  test = {year,two,three}; 
    	assertArrayEquals(arr1, test);                //ensures arrays are equal 
    	scanner2.close();
    }
    
    @Test
    public void testAssertNotNull() {
    	String string = "hello world"; 
    	String string2= null;

    	assertNotNull(string);  //ensures string is NOT null
    	assertNull(string2);   //ensure string2 is null
    }
}
