import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
public class Frame{
	
	final int LARGHEZZA = 500;
	final int ALTEZZA = 400;
	
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

	public Frame() {
		setSlider();
		setLabel();
		setPanel();
		setFrame();
	}
	private void setFrame() {
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
		
		panel1.add(label2);
		panel1.add(slider2);
		
		panel1.setMaximumSize(null);
		
		panel2.setBorder(BorderFactory.createLineBorder(Color.black));
		panel2.setLayout(null);
	}
	
	private void setLabel() {
		label1.setBounds(0, 30, 120, 50);
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		label1.setText("Forza: " + slider1.getValue());
		label1.setPreferredSize(new Dimension(120, 30));
		
		label2.setBounds(0, 100, 120, 50);
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		label2.setPreferredSize(new Dimension(120, 30));
		label2.setText("Angolo: " + slider2.getValue());
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
}
