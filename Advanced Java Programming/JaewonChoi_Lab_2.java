/*My name: Jaewon Choi
My student number: 7020090
Tutorial group: Fulltime T03
Declaration: This is my own work.
------------------------------------------------------- */

import java.util.Random;

class Point{
	private int x, y;
	//default constructor
	public Point(){
		
	}
	//other constructor
	public Point(int x, int y) {
		set(x,y);
	}
	//copy constructor
	public Point(Point p) {
		this(p.x,p.y);
	}
	//method which returns the distance between two points
	private double distance(Point p) {
		return Math.sqrt(Math.pow(x-p.x,2)+ Math.pow(y-p.y,2));
	}
	//some accessor methods
	public double getDistance(Point p) {
		return distance(p);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	//mutator method
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//method to get string value 
	public String toString() {
		return "Given Point ("+x+", "+y+")";
	}
}

class Line{
	private Point p1,p2;
	
	public Line() {
		
	}
	//other constructor
	public Line(Point p1, Point p2) {
		set(p1,p2);
	}
	//copy constructor
	public Line(Line aline) {
		this(aline.p1,aline.p2);
	}
	//a method to get distance from class "Point"
	public double getDistance() {
		return p1.getDistance(p2);
	}
	//some accessor method
	public Point getP1() {
		return p1;
	}
	
	public Point getP2() {
		return p2;
	}
	//a mutator method
	public void set(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	//return String value
	public String toString() {
		return String.format("Line ( Point (%d, %d), Point (%d, %d), distance = %.4f",p1.getX(),p1.getY(),p2.getX(),p2.getY(),getDistance());
	}
}

public class JaewonChoi_Lab_2 {
	static Random rand = new Random();
	//generate the number between -100 and 100
	private static int getInt() {
		return rand.nextInt(201)-100;
	}
	//set and print location of two points
	private static void getTwoPoints(Point p1, Point p2) {
		p1.set(getInt(), getInt());
		p2.set(getInt(), getInt());
	}
	
	public static void main(String[]agrs) {
		for(int i=1; i<6; i++) {
			System.out.println("Set "+ i);
			Point p1 = new Point();
			Point p2 = new Point();
			getTwoPoints(p1,p2);
			System.out.println(p1);
			System.out.println(p2);
			Line aline = new Line(p1,p2);
			System.out.println(aline);
			System.out.println("------------------------");
			
		}
	}
}
