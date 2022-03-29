/*My name: Jaewon Choi
My student number: 7020090
Tutorial group: Fulltime T03
Declaration: This is my own work.
------------------------------------------------------- */

import java.util.ArrayList;
import java.util.Random;

enum ShapeColor{Blue,Yellow,Red,Green,White}

//several interfaces
interface Recolorable{
	public void recolor(ShapeColor sc);
}

interface Shape{
	public double area();
}

interface Resizable{
	public void resize(double percentage);
}

//abstract class which implement two interfaces
abstract class TwoD implements Recolorable, Shape{
	//variables are protected
	protected ShapeColor sc;
	protected int a,b,c,d;
	
	public TwoD(){
		
	}
	
	public TwoD(ShapeColor sc, int a) {
		this(sc,a,0,0,0);
	}
	
	public TwoD(ShapeColor sc, int a, int b) {
		this(sc,a,b,0,0);
	}
	
	public TwoD(ShapeColor sc, int a, int b, int c) {
		this(sc,a,b,c,0);
	}
	
	public TwoD(ShapeColor sc, int a, int b, int c, int d) {
		set(sc,a,b,c,d);
	}
	
	public TwoD(TwoD td) {
		this(td.sc,td.a,td.b,td.c,td.d);
	}
	
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	public int getC() {
		return c;
	}
	
	public int getD() {
		return d;
	}
	
	public ShapeColor getShapeColor() {
		return sc;
	}
	
	public void set (ShapeColor sc, int a, int b, int c, int d) {
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	//method from interface recolorable
	public void recolor(ShapeColor sc) {
		Random r = new Random();
		
		while(sc==this.sc)
			this.sc = ShapeColor.values()[r.nextInt(5)];
	}
	
	//printing method
	public String toString() {
		if(b==0&&c==0&&d==0) {
			return String.format("Circle (2D (%s, %d))", 
					getShapeColor(), getA());
		}
		else if(c==0&&d==0) {
			return String.format("Rectangle (2D (%s, %d, %d))", 
					getShapeColor(), getA(), getB());
		}
		else if(d==0) {
			return String.format("Triangle (2D (%s, %d, %d, %d))",
					getShapeColor(), getA(), getB(), getC());
		}
		else {
			return String.format("Trapezoid (2D (%s, %d, %d, %d, %d)",
					getShapeColor(), getA(), getB(), getC(), getD());
		}
	}
}

//four 2D classes
class Circle extends TwoD{
	public Circle(){
		
	}
	
	//other constructor
	public Circle(ShapeColor sc, int radius) {
		set(sc, radius);
	}
	
	public Circle(Circle c) {
		this(c.sc, c.a);
	}
	
	//calculate area from interface Shape
	public double area() {
		return Math.PI*Math.pow(a, 2);
	}
	
	public int getRadius() {
		return a;
	}
	
	public void set(ShapeColor sc, int radius) {
		this.sc = sc;
		this.a = radius;
	}
	
	public String toString() {
		return String.format("%s",super.toString());
	}
}

class Rectangle extends TwoD{
	public Rectangle(){
		super();
	}
	
	//other constructor
	public Rectangle(ShapeColor sc, int length, int width) {
		set(sc, length, width);
	}
	
	public Rectangle(Rectangle r) {
		this(r.sc, r.a, r.b);
	}
	
	//calculate area
	public double area() {
		return a*b;
	}
	
	public int getLength() {
		return a;
	}
	
	public int getWidth() {
		return b;
	}
	
	public void set(ShapeColor sc, int length, int width) {
		this.sc = sc;
		this.a = length;
		this.b = width;
	}
	
	public String toString() {
		return String.format("%s", super.toString());
	}
}

class Triangle extends TwoD{
	public Triangle(){
		super();
	}
	
	//other constructor
	public Triangle(ShapeColor sc, int a, int b, int c) {
		set(sc, a, b, c);
	}
	
	public Triangle(Triangle t) {
		this(t.sc, t.a, t.b, t.c);
	}
	
	//find area
	public double area() {
		double s = (a + b + c)  / 2.0;
		return Math.sqrt (s * (s - a) * (s - b) * (s - c));
	}
	
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	public int getC() {
		return c;
	}
	
	public void set(ShapeColor sc, int a, int b, int c) {
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public String toString() {
		return String.format("%s", super.toString());
	}
}

class Trapezoid extends TwoD{
	//new int variable
	private int h;
	
	public Trapezoid(){
		super();
	}
	
	//other constructor
	public Trapezoid(ShapeColor sc, int a, int b, int c, int d, int h) {
		set(sc, a, b, c, d);
		this.h = h;
	}
	
	public int getRadius() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	public int getC() {
		return c;	
	}
	
	public int getD() {
		return d;
	}
	
	public int getHeight() {
		return h;
	}
	
	//method to find area
	public double area() {
		return ((a + c) / 2.0) * h;
	}
	
	public void set(ShapeColor sc, int a, int b, int c, int d) {
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	public String toString() {
		return String.format("%s, %d)", super.toString(), getHeight());
	}
}

//other abstract class which implements interface Shape and resizable
abstract class ThreeD implements Shape, Resizable{
	protected ShapeColor sc;
	protected double a;
	
	public ThreeD() {
		
	}
	
	public ThreeD(ShapeColor sc, double a) {
		set(sc, a);
	}
	
	public ThreeD (ThreeD td) {
		this(td.sc, td.a);
	}
	
	public double getA() {
		return a;
	}
	
	public void set(ShapeColor sc, double a) {
		this.sc = sc;
		this.a = a;
	}
	
	//a method from interface resizable
	public void resize(double percentage) {
		a *= (100 - percentage)/100; 
	}
	
	public abstract double volume();
	
	public String toString() {
		return String.format("(3D (%s, %.3f))", sc, getA());
	}
}

//three class have their own method to calculate area and volume
class Sphere extends ThreeD{
	public Sphere(){
		super();
	}
	
	public Sphere(ShapeColor sc, double a) {
		set(sc, a);
	}
	
	public Sphere(Sphere s) {
		this(s.sc, s.a);
	}
	
	public double area() {
		return 4*Math.PI*Math.pow(a, 2);
	}
	
	public double volume() {
		return 4/3*Math.PI*Math.pow(a, 3);
	}
	
	public void set(ShapeColor sc, double a) {
		this.sc = sc;
		this.a = a;
	}
	
	public String toString() {
		return String.format("Sphere %s", super.toString());
	}
}

class Cube extends ThreeD{
	public Cube() {
		super();
	}
	
	public Cube(ShapeColor sc, double a) {
		set(sc, a);
	}
	
	public Cube(Cube c) {
		this(c.sc, c.a);
	}
	
	public double area() {
		return Math.pow(a, 2)*6;
	}
	
	public double volume() {
		return Math.pow(a, 3);
	}
	
	public void set(ShapeColor sc, double a) {
		this.sc = sc;
		this.a = a;
	}
	
	public String toString() {
		return String.format("Cube %s", super.toString());
	}
}

class Tetrahedron extends ThreeD{
	public Tetrahedron() {
		super();
	}
	
	public Tetrahedron(ShapeColor sc, double a) {
		set(sc, a);
	}
	
	public Tetrahedron(Tetrahedron t) {
		this(t.sc, t.a);
	}
	
	public double area() {
		return Math.pow(a, 2)*Math.sqrt(3);
	}
	
	public double volume() {
		return Math.pow(a, 3)*Math.sqrt(2)/12;
	}
	
	public void set(ShapeColor sc, double a) {
		this.sc = sc;
		this.a = a;
	}
	
	public String toString() {
		return String.format("Tetrahedron %s", super.toString());
	}
}

class JaewonChoi_A2 {
	//get needed variables
	private static int getInt() {
		return (int)(Math.random()*10+1);
	}
	
	private static double getDouble() {
		return Math.random()*10;
	}
	
	private static ShapeColor getColor() {
		Random r = new Random();
		return ShapeColor.values()[r.nextInt(5)];
	}
	
	//check whether that can be triangle or not
	private static boolean isTriangle(int a, int b, int c) {
		return (a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a);
	}

	//put values in twoD constructor and return
	private static TwoD getTwoD() {
		TwoD td;
		int r = (int)(Math.random()*4);
		int a = getInt();
		int b = getInt();
		int c = getInt();
		int d = getInt();
		switch(r) {
		case 0: return td = new Circle(getColor(),a);
		case 1: return td = new Rectangle(getColor(),a,b);
		case 2: if(!isTriangle(a,b,c))
					getTwoD();
				return td = new Triangle(getColor(),a,b,c);
		default: return td = new Trapezoid(getColor(),a,b,c,d,getInt());
		}
	}
	
	//put values in threeoD constructor and return
	private static ThreeD getThreeD() {
		ThreeD td;
		int c = (int)(Math.random()*3);
		switch(c) {
		case 0: return td = new Sphere(getColor(), getDouble());
		case 1: return td = new Cube(getColor(), getDouble());
		default: return td = new Tetrahedron(getColor(), getDouble());
		}
	}
	
	//display the list
	private static void displayList(ArrayList<Shape> alist) {
		int c = 1;
		for(Shape s : alist) {
			System.out.printf("Shape %d: ", c++);
			System.out.println(s);
			
			//compare dimension
			if(s instanceof TwoD) {
				//downcast
				TwoD td = (TwoD) s;
				td.recolor(td.getShapeColor());
				
				System.out.printf("Updated color: %s%n"
						+ "Area = %.3f%n"
						+ "I am a %s shape with color changed to %s%n",
						td.getShapeColor(), td.area(), td.getClass().getName(), td.getShapeColor());
			}
			else {
				//downcast
				ThreeD thd = (ThreeD) s;
				double percentage = Math.random()*50;
				
				System.out.printf("Surface area = %.3f%nVolume = %.3f%n", thd.area(), thd.volume());
				thd.resize(percentage);
				
				System.out.printf("Size reduced by %.1f%%: %s%n"
						+ "Updated surface area = %.3f%n"
						+ "Updated volume = %.3f%n"
						+ "I am a %s shape%n", percentage, thd.toString(), thd.area(), thd.volume(), thd.getClass().getName());
			}
				
			System.out.println("----------------------------------------------------");
		}
		
		
	}
	
	public static void main(String[]args) {
		ArrayList<Shape> alist = new ArrayList<Shape>();
		Random rd = new Random();
		int r;
		
		//randomly generate 2D,3D and 0 let the loop pause
		do {
			r = rd.nextInt(3);
			if(r==1) 
				alist.add(getTwoD());
			else
				alist.add(getThreeD());
		}while(r!=0);
		
		displayList(alist);
	}
}