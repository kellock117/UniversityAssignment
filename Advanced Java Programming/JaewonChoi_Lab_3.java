import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class Frame extends JFrame{
	
	private final JLabel jl;
	private final JTextField jl1;
	private final JLabel db;
	private final JTextField db1;
	private final JLabel e;
	private final JTextField e1;
	private final ImageIcon a;
	private final JLabel pic;
	private final JLabel c;
	private final JTextField c1;
	private final JTextField c2;
	
	public Frame() {
		super("Introduce to myself");
		setLayout(new FlowLayout());
		setSize(300, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		jl = new JLabel("Name");
		jl1 = new JTextField ("Jaewon Choi", 20);
		jl1.setEditable(false);
		add(jl);
		add(jl1);
		
		db = new JLabel("Date of birth");
		db1 = new JTextField ("18 Nov 2000", 20);
		db1.setEnabled(false);
		add(db);
		add(db1);
		
		e = new JLabel("Email");
		e1 = new JTextField ("doctor1118@naver.com", 20);
		e1.setForeground(Color.BLACK);
		e1.setEnabled(false);
		add(e);
		add(e1);
		
		a = new ImageIcon ("3683.jpg");
		pic = new JLabel (a, SwingConstants.CENTER);
		pic.setToolTipText ("I am a cat");
		add(pic);
		
		c = new JLabel("My comments to the subject, will update further");
		c1 = new JTextField("Designing GUI is quite burdensome",20);
		c2 = new JTextField("Need to spend a lot of time on lambda",20);
		c1.setEditable(true);
		c2.setEditable(true);
		add(c);
		add(c1);
		add(c2);
		
		Handler handler = new Handler();
		c1.addActionListener(handler);
		c2.addActionListener(handler);
		
		setVisible(true);
	}
	
	private class Handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			String s = "";
			String str = "Summary of your change";
			
			if(event.getSource() == c1)
			{
				str = "1. " + event.getActionCommand() + "\n" +
						"2. " + c2.getText();
			}
			
			else if(event.getSource() == c2)
			{
				str = "1. " + c1.getText() + "\n" +
						"2. " + event.getActionCommand();
			}
			
			JOptionPane.showMessageDialog(null, str, "My " +
									"suggestion to the course",
									JOptionPane.PLAIN_MESSAGE);
		}
	}
}

class JaewonChoi_Lab_3 {
	public static void main(String[]args) {
		new Frame();
		
	}
}
