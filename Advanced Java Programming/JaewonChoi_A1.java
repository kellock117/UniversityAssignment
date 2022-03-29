/*My name: Jaewon Choi
My student number: 7020090
Tutorial group: Fulltime T03
Declaration: This is my own work.
------------------------------------------------------- */

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;
import java.util.Scanner;

//enum class
enum Month{
	//sets with additional information
    Jan (1, "January"),
    Feb (2, "February"),
    Mar (3, "March"),
    Apr (4, "April"),
    May (5, "May"),
    Jun (6, "June"),
    Jul (7, "July"),
    Aug (8, "August"),
    Sep (9, "September"),
    Oct (10, "October"),
    Nov (11, "November"),
    Dec (12, "December");

    private int month;
    private String name;

    Month(int month, String name){
        this.month = month;
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public String getName() {
        return name;
    }
}

class Set{
	//a private arraylist
    private ArrayList<Month> s = new ArrayList<Month>();
    
    //a default constructor
    public Set() {

    }
    
    //copy constructor
    public Set(Set otherSet) {
    	s = otherSet.s;
    }

    //check whether array is empty or not
    public boolean isEmpty() {
        return (s==null);
    }

    //return size of arraylist
    public int cardinality() {
        return s.size();
    }

    //return true when parameter is included in arraylist
    public boolean belongTo(Month element) {
        return s.contains(element);
    }

    //add value inside arraylist
    public void addElement(Month element) {
        if(!s.contains(element))
            s.add(element);
    }

    //a method for subset
    public boolean subset(Set otherSet) {
        return s.containsAll(otherSet.s);
    }

    public void union(Set otherSet) {
        for(Month m : otherSet.s) {
            if(!s.contains(m))
                s.add(m);
        }
    }

    //a method for intersection using two arraylist
    public void intersection(Set otherSet) {
    	s.retainAll(otherSet.s);
    }

    //a method for difference
    public void difference(Set otherSet) {
        for(Month m : otherSet.s) {
            if(s.contains(m))
                s.remove(m);
        }
    }
    
    //a method for complement,import all values in enum Month 
    public Set complement() {
        Set st = new Set();
        st.s = new ArrayList<>(EnumSet.allOf(Month.class));
        st.s.removeAll(s);
        return st;
    }

    //compare two value and return true if they have same
    public boolean equality(Set otherSet) {
        return (s.containsAll(otherSet.s) && otherSet.s.containsAll(s));
    }

    public String toString() {
        return String.valueOf(s);
    }

    //return int info in enum Month
    public String getString_1() {
        String st = "";
        st+=s.get(0).getMonth();
        for(int i=1; i<s.size(); i++) {
            st+=", "+ s.get(i).getMonth();
        }
        return "["+st+"]";
    }

    //return full name of month in enum Month 
    public String getString_2() {
        String st = "";
        st+=s.get(0).getName();
        for(int i=1; i<s.size(); i++) {
            st+=", "+ s.get(i).getName();
        }
        return "["+st+"]";
    }
}

public class JaewonChoi_A1 {

    static Scanner input = new Scanner(System.in);
    static Set st = new Set();

    //print month information
    private static void displayMonthInfo() {
    	System.out.println("Universal set info\n");
    	for(Month m : Month.values()) {
    		System.out.printf("%-5s%02d%12s%n", m, m.getMonth(), m.getName());
    	}
    }

    //return one of month enum variable
    private static Month getAnElement() {
    	Random r = new Random();
        return Month.values()[r.nextInt(4)];
    }
    
    //return a set which contains arraylist with month variable
    private static Set getASet() {
    	Set s = new Set();
    	for(int i=0; i<10; i++)
            s.addElement(getAnElement());
    	
    	return s;
    }

    //main menu which controls whole system
    private static void displayMenu() {
        System.out.println("\nWelcome to SIM Set Theory lesson\n");
        System.out.println("0: Properties of set");
        System.out.println("1. Union example");
        System.out.println("2. Intersection example");
        System.out.println("3. Subset example");
        System.out.println("4. Difference example");
        System.out.println("5. Complement example");
        System.out.println("6. Sets eqaulity example");
        System.out.println("9. Quit\n");

        System.out.print("Your option: ");
        int i = input.nextInt();
        if(i==0)
            anExample();
        else if(i==1)
            unionExample();
        else if(i==2)
            intersectionExample();
        else if(i==3)
            subsetExample();
        else if(i==4)
            differenceExample();
        else if(i==5)
            complementExample();
        else if(i==6)
            equalityExample();
    }

    //print example of union
    private static void unionExample() {
        Set s1 = getASet();
        Set s2 = getASet();
        
        System.out.println("\nGiven sets");
        System.out.println("\tA = " + s1);
        System.out.println("\tB = " + s2);
        s1.union(s2);
        System.out.println("\tUnion of A and B = " + s1);
        System.out.println("---------------------------------------------------");
        displayMenu();
    }

    //print example of intersection
    private static void intersectionExample() {
        Set s1 = getASet();
        Set s2 = getASet();

        System.out.println("\nGiven sets");
        System.out.println("\tA = " + s1);
        System.out.println("\tB = " + s2);
        s1.intersection(s2);
        System.out.println("\nIntersection of A and B = " + s1);
        System.out.println("---------------------------------------------------");
        displayMenu();
    }

    //print example of subset
    private static void subsetExample() {
        Set s1 = getASet();
        Set s2 = getASet();

        System.out.println("\nGiven sets");
        System.out.println("\tA = " + s1);
        System.out.println("\tB = " + s2);
        System.out.println("\n\tConclusion");
        System.out.println("\tA subset of B: " + s2.subset(s1));
        System.out.println("\tB subset of A: " + s1.subset(s2));
        System.out.println("---------------------------------------------------");
        displayMenu();
    }

    //print example of difference
    private static void differenceExample() {
        Set s1 = getASet();
        Set s2 = getASet();

        System.out.println("\nGiven sets");
        System.out.println("\tA = " + s1);
        System.out.println("\tB = " + s2);
        s1.difference(s2);
        System.out.println("\n\tA - B = " + s1);
        System.out.println("---------------------------------------------------");
        displayMenu();
    }

    //print example of complement
    private static void complementExample() {
        Set s1 = getASet();
        
        System.out.println("\nGiven set");
        System.out.println("\tA = " +  s1);
        System.out.println("\tA' = " +  s1.complement());
        System.out.println("---------------------------------------------------");
        displayMenu();
    }

    //print example of equality
    private static void equalityExample() {
        Set s1 = getASet();
        Set s2 = getASet();

        System.out.println("\nGiven sets");
        System.out.println("\tA = " + s1);
        System.out.println("\tB = " + s2);
        System.out.println("\nAnalysis");
        System.out.println("\tA subset of B: " + s2.subset(s1));
        System.out.println("\tB subset of A: " + s1.subset(s2));
        System.out.println("\nConclusion");
        System.out.println("\tA equals to B: " + s1.equality(s2));
        System.out.println("---------------------------------------------------");
        displayMenu();
    }

    //menu for "properties of set", and print example of set
    public static void displaySubmenu() {
        int i;
        Month name;

        do {
            System.out.println("\nSome basic operations in set");
            System.out.println("\t1. Add an element");
            System.out.println("\t2. Check an element");
            System.out.println("\t3. Cardianlity");
            System.out.println("\t4. Various displays");
            System.out.println("\t9. Quit");
            System.out.print("\nEnter your option: ");

            i = input.nextInt();

            if(i==1) {
                System.out.print("\nEnter an element: ");
                name = Month.valueOf(input.next());
                st.addElement(name);
                System.out.println(st);
            }
            else if(i==2) {
                System.out.print("\nEnter an element: ");
                name = Month.valueOf(input.next());
                if(st.belongTo(name))
                    System.out.printf("\nElement %s is in set%n", name);
                else
                    System.out.printf("\nElement %s is not in set%n", name);

            }
            else if(i==3) {
                System.out.printf("\nNo of elements in set is %d%n",st.cardinality());
            }
            else if(i==4) {
                variousDisplays(st);
            }

            System.out.println("---------------------------------------------------");
        }while(i!=9);

        displayMenu();
    }

    //print example of set
    public static void anExample() {
        System.out.println("\nHere is an example of set");
        for(int i=1; i<6; i++)
            st.addElement(getAnElement());
        System.out.println("\tA = "+ st);
        System.out.println("\tAll elements in set are distinct and random order");

        displaySubmenu();
    }

    //print other kinds of form of sets into integer and full name 
    private static void variousDisplays(Set s) {
        System.out.println("\n Equivalent sets info");
        System.out.println("\tSet 1: "+ s.getString_1());
        System.out.println("\tSet 2: "+ s.getString_2());
    }

    public static void main(String[]args) {
    	displayMonthInfo();
        displayMenu();
    }
}