
public class MyIO {
 
    public boolean isLeapYear(int year) {
        return  ((year % 4 == 0)||((year % 400 == 0) && (year % 100 != 0)));
    }
}