import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
public class Frame extends Main{
	final String pathPalla = "C:\\Users\\gaeta\\Documents\\java\\Pallacanestro\\palla.png";
	final String pathCanestro = "C:\\Users\\gaeta\\Documents\\java\\Pallacanestro\\canestro.jpg";
	
	final int LARGHEZZA = 800;
	final int ALTEZZA = 500;
	
	private int forza;
	private int angolo;
	
	public int getForza() {
		return forza;
	}
	public void setForza(int forza) {
		this.forza = forza;
	}
	public int getAngolo() {
		return angolo;
	}
	public void setAngolo(int angolo) {
		this.angolo = angolo;
	}

	JFrame frame = new JFrame();
	JPanel panel1 = new JPanel();
	JLabel label1 = new JLabel();
	JSlider slider1 = new JSlider(0, 100, 50);
	JLabel label2 = new JLabel();
	JSlider slider2 = new JSlider(0, 100, 50);
	
	JPanel panel2 = new JPanel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	
	JButton button = new JButton();
	
	
	ImageIcon ic1 = new ImageIcon(pathPalla);
    ImageIcon palla = new ImageIcon(ic1.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
    
    ImageIcon ic2 = new ImageIcon(pathCanestro);
    ImageIcon canestro = new ImageIcon(ic2.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));

	public Frame() throws InterruptedException {
		setSlider();
		setLabel();
		setButton();
		setPanel();
		setFrame();
	}
	private void setFrame(){
		frame.setTitle("Pallacanestro");
		frame.setSize(LARGHEZZA, ALTEZZA);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(10, 10));

		frame.getContentPane().add(panel1, BorderLayout.WEST);
		frame.getContentPane().add(panel2, BorderLayout.CENTER);

		frame.setVisible(true);
		
	}
	
	private void setPanel() {
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		
		panel1.add(label1);
		panel1.add(slider1);
		panel1.add(Box.createRigidArea(new Dimension(0,40)));		//separatore
		panel1.add(label2);
		panel1.add(slider2);
		panel1.add(Box.createRigidArea(new Dimension(0,40)));		//separatore
		panel1.add(button);
		
		panel1.setMaximumSize(null);
		
		panel2.setBorder(BorderFactory.createLineBorder(Color.black));
		panel2.setLayout(null);
		panel2.add(label3);
		panel2.add(label4);
	}
	
	private void setLabel(){
		label1.setBounds(0, 30, 120, 50);
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		label1.setText("Forza: " + slider1.getValue());
		label1.setPreferredSize(new Dimension(120, 30));
		
		label2.setBounds(0, 100, 120, 50);
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		label2.setPreferredSize(new Dimension(120, 30));
		label2.setText("Angolo: " + slider2.getValue());
		label2.setLayout(null);
		
		label3.setBounds(100, 100, 45, 45);
		label3.setIcon(palla);
		
		label4.setBounds(350, 250, 150, 150);
		label4.setIcon(canestro);
	}
	
	private void setButton() {
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setText("Gioca");
		button.setAlignmentY(150);
		button.setPreferredSize(new Dimension(120, 30));
		button.setFocusPainted(false);
		button.addActionListener(e -> giocaBut());
	}
	
	private void setSlider() {
		slider1.setAlignmentX(Component.CENTER_ALIGNMENT);
		slider1.setPaintTrack(true);
		slider1.setMajorTickSpacing(25);
		slider1.setPaintLabels(true);
		slider1.addChangeListener(e -> cambiaForza());
		slider1.setVisible(true);
		
		slider2.setAlignmentX(Component.CENTER_ALIGNMENT);
		slider2.setPaintTrack(true);
		slider2.setMajorTickSpacing(25);
		slider2.setPaintLabels(true);
		slider2.addChangeListener(e -> cambiaAngolo());
		slider2.setVisible(true);
	}
	
	public void cambiaForza() {
		label1.setText("Forza: " + slider1.getValue());
		setForza(slider1.getValue());
	}
	
	public void cambiaAngolo() {
		label2.setText("Angolo: " + slider2.getValue());
		setAngolo(slider2.getValue());
	}
	
	public void giocaBut() {
		super.giocaBut(getForza(), getAngolo());
	}
	
	public void spostaPalla(int x, int y) {
		label3.setBounds(x, y, 45, 45);
	}
}
