/*My name: Jaewon Choi
My student number: 7020090
Tutorial group: Fulltime T03
Declaration: This is my own work.
------------------------------------------------------- */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.stream.DoubleStream;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class Olympic{
	private final int NO = 12;
	private String country;
	private double [] score = new double[NO];
	private int rank;
	
	public Olympic(String country) {
		this.country = country;
		//process the method when Olympic receive String type variable
		processScore();
	}
	
	//copy constructor
	public Olympic(Olympic oly) {
		this(oly.country);
	}
	
	public void processScore() {
		for(int i=0; i<score.length; i++) {
			score[i] = Math.random()*100;
		}
	}
	
	//calculate and return total score using stream 
	public double totalScores() {
		return DoubleStream.of(getScoreArray()).sum();
	}
	
	public void set(int rank) {
		this.rank = rank;
	}
	
	//some mutator methods
	public int getRank() {
		return rank;
	}
	
	public String getName() {
		return country;
	}
	
	private double [] getScoreArray() {
		return score;
	}
	
	@Override
	public String toString() {
		return "Rank: "+ getRank();
	}
}

class OlympicFrame extends JFrame{
	private JButton[] jbArray = new JButton[12];
	private final String[] countryArray  = {"USA", "Spain", "China", "Japan", "Italy", "Germany", 
			"France", "Brazil", "Netherland", "Poland", "Russia", "Ukraine"};
	private ArrayList<Olympic> alist = new ArrayList<Olympic>();
	
	public OlympicFrame() {
		//set basic information
		super("Olympic 2020");
		setLayout(new GridLayout(4,3));
		setSize(600,600);
		constructAlist();
		
		//load png files and initialize to pass the images into JButton
		for(int i=0; i<jbArray.length; i++) {
			ImageIcon ii = new ImageIcon(countryArray[i]+".png");
			jbArray[i] = new JButton(ii);
			jbArray[i].setText(countryArray[i]);
			add(jbArray[i]);
		}
		
		//for event to help to get proper rank
		for(int i=0; i<jbArray.length; i++) {
			int k = -1;
			for(int j=0; j<jbArray.length; j++) 
				if(alist.get(j).getName()==countryArray[i])
					k = j;
			
			int r = alist.get(k).getRank();
			
			jbArray[i].addActionListener(e -> {
				ImageIcon tro = new ImageIcon("trophy.png");
				
				JOptionPane.showMessageDialog (null, getFinalRanking(), "Miss World 2020",
						JOptionPane.PLAIN_MESSAGE,tro);
				
				for(JButton jb : jbArray) {
					if(e.getSource()==jb)
						jb.setText(alist.get(r-1).toString());
				}
			});
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//construct a list
	private void constructAlist() {
		for(String s : countryArray){
			alist.add(new Olympic(s));
		}
		
		//create an array which has each countries' total score
		double[] scoreArray = new double [countryArray.length];
		for(int i=0; i<scoreArray.length; i++) {
			scoreArray[i] = alist.get(i).totalScores();
		}
		
		//set rank
		for(Olympic o : alist) {
			o.set(getRank(scoreArray, o.totalScores()));
		}
		
		Collections.sort(alist, Comparator.comparing(Olympic::getRank));
		//Collections.sort(alist, (o1, o2) -> o1.getRank() - o2.getRank());
	}
	
	//return rank
	private int getRank(double[] scoreArray, double d) {
		Arrays.sort(scoreArray);		
		return Arrays.binarySearch(scoreArray, d)+1;
	}
	
	//generalize ranking information
	private String getFinalRanking() {
		String s = new String("FINAL RANKING\n\n");
		for(int i=0; i<12; i++) {
			String c = getCountry(alist,i);
			s+= String.format("Rank %d: %s(%.2f)%n", i+1, c,getScores(alist,c));
		}
		
		return s;
	}
	
	//return country name
	private String getCountry(ArrayList<Olympic> alist, int n) {
		return alist.get(n).getName();
	}
	
	//generate total score of specific country
	private double getScores(ArrayList<Olympic> alist, String name) {
		int c =-1;
		for(int i=0; i<12; i++) {
			if(alist.get(i).getName()==name) {
				c=i;
			}
		}
		return alist.get(c).totalScores();
	}
}

public class JaewonChoi_A3 {
	public static void main(String[]args) {
		OlympicFrame of = new OlympicFrame();
	}
}
