import java.util.Scanner;

class InvalidHrExcep extends Exception{
	private String message;
	
	public InvalidHrExcep() {
		
	}
	
	public InvalidHrExcep(String str) {
		message = str;
	}
	
	public String getMessage() {
		return message;
	}
}

class InvalidMinExcep extends Exception{
	private String message;
	
	public InvalidMinExcep() {
		
	}
	
	public InvalidMinExcep(String str) {
		message = str;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String toString() {
		return getMessage();
	}
	
}

class InvalidSecExcep extends Exception{
	private String message;
	
	public InvalidSecExcep() {
		
	}
	
	public InvalidSecExcep(String str) {
		message = str;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String toString() {
		return getMessage();
	}
}

public class JaewonChoi_Lab_4 {
	public static Scanner console = new Scanner(System.in);
	
	public static void main (String[]args) {
		int h = 0;
		int m = 0;
		int s = 0;
		
		do {
			try {
				h = getHours();
				m = getMinutes();
				s = getSeconds();
			}
			catch(InvalidHrExcep e){
				System.out.println(e);
			}
			catch(InvalidMinExcep e) {
				System.out.println(e);
			}
			catch(InvalidSecExcep e) {
				System.out.println(e);
			}
		}while(h==0 || m==0 || s==0);
		
		console.nextLine();
		System.out.print("Enter AM or PM: ");
		String ap = console.nextLine();
		
		print24HourTime(h,m,s,ap);
	}
	
	public static int getHours() throws InvalidHrExcep{
		System.out.print("Enter hours: ");
		int h = console.nextInt();
		if(h>12 || h<0)
			throw new InvalidHrExcep("The value of hours must be between 0 and 12");
		return h;
	}
	
	public static int getMinutes() throws InvalidMinExcep{
		System.out.print("Enter minutes: ");
		int m = console.nextInt();
		if(m>60 || m<0)
			throw new InvalidMinExcep("The value of hours must be between 0 and 60");
		return m;
	}
	
	public static int getSeconds() throws InvalidSecExcep{
		System.out.print("Enter seconds: ");
		int s = console.nextInt();
		if(s>60 || s<0)
			throw new InvalidSecExcep("The value of hours must be between 0 and 60");
		return s;
	}
	
	public static void print24HourTime(int hr, int min, int sec, String str) {
		if(str.equals("AM") || str.equals("Am") || str.equals("am") || str.equals("aM")) 
			System.out.printf("\n24 hour clock time: %02d:%02d:%02d", hr, min, sec);
		else if(str.equals("PM") || str.equals("Pm") || str.equals("pm") || str.equals("pM"))
			System.out.printf("\n24 hour clock time: %02d:%02d:%02d", hr*2, min, sec);
	}
}
