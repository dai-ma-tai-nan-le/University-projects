package Java_Applet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ZouDongLin extends JApplet{	
	private static final long serialVersionUID = 1L;

	JPanel p1;
	JPanel p2;
	JPanel p3;
	JButton jbt;
	JTextField jtf1;
	JTextField jtf2;
	JTextField jtf3;
	JTextArea jta;
	JButton jbtMessage;
	JButton jbtCloseMessage;

	public void init(){
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		jbt = new JButton("比较结果【'X'】");
		jbtMessage = new JButton("打开浏览【'Z'】");
		jbtCloseMessage = new JButton("关闭浏览【'C'】");
		jbt.setMnemonic('X');
		jbtMessage.setMnemonic('Z');
		jbtCloseMessage.setMnemonic('C');
		jbt.setBackground(Color.red);
		jbt.setForeground(Color.yellow);
		jbt.setBorder(new TitledBorder("X"));

		jbtMessage.setBackground(Color.red);
		jbtMessage.setForeground(Color.yellow);
		jbtMessage.setBorder(new TitledBorder("Z"));

		jbtCloseMessage.setBackground(Color.red);
		jbtCloseMessage.setForeground(Color.yellow);
		jbtCloseMessage.setBorder(new TitledBorder("C"));
		jtf1 = new JTextField("0", 8);
		jtf2 = new JTextField("0", 8);
		jtf3 = new JTextField("0", 8);
		jta = new JTextArea();
	}
	
	public void start(){
		setSize(250,300);
		setLayout(new BorderLayout());
		p1.setLayout(new GridLayout(3,2,5,10));
		p2.setLayout(new GridLayout(3,1,10,10));
		p3.setLayout(new BorderLayout());
		p1.add(new JLabel("First Number:"));
		p1.add(jtf1);
		p1.add(new JLabel("Second Number:"));
		p1.add(jtf2);
		p1.add(new JLabel("Result Number:"));
		p1.add(jtf3);
		p2.add(jbt);
		p2.add(jbtMessage);
		p2.add(jbtCloseMessage);
		p3.add(p1, BorderLayout.CENTER);
		p3.add(p2, BorderLayout.SOUTH);
		add(p3, BorderLayout.CENTER);
		add(jta, BorderLayout.SOUTH);
		
		jbt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int jtf1Number = Integer.parseInt(jtf1.getText());
				int jtf2Number = Integer.parseInt(jtf2.getText());
				int jtf3Number = Integer.parseInt("0");
				if(jtf1Number >= jtf2Number){
					jtf3Number = jtf1Number;
				}
				if(jtf1Number < jtf2Number){
					jtf3Number = jtf2Number;
				}
				jtf3.setText(String.valueOf(jtf3Number));
			}
		});
		
		jbtMessage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				add(jta, BorderLayout.SOUTH);
				jta.setBackground(Color.black);
				jta.setForeground(Color.yellow);
				jta.setBorder(new TitledBorder("Display"));
				int jtf1Number = Integer.parseInt(jtf1.getText());
				int jtf2Number = Integer.parseInt(jtf2.getText());
				int jtf3Number = Integer.parseInt(jtf3.getText());
				String text = "**************************************************************\n"+
				"Number1 = "+jtf1Number+"\n"+
				"Number2 = "+jtf2Number+"\n"+
				"Number3 = "+jtf3Number+"\n"+
				"Expression :"+"Number1 >= Number2 ?\n"+
				"Result :"+jtf3Number+
				"\n--------------------------------------------------------------";
				jta.setText(text);
			}
		});
		
		jbtCloseMessage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				add(jta, BorderLayout.SOUTH);

				jta.setText("");
			}
		});
	}
	
	public void stop(){}
	
	public void destroy(){}
	
	public static void main(String arg){
		JFrame frame = new  JFrame();
		TestNumber numberapplet = new TestNumber();
		frame.add(numberapplet);
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
