import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Frame extends Thread{
	final String pathPalla = "C:\\Users\\gaeta\\Documents\\java\\Pallacanestro\\palla.png";
	final String pathCanestro = "C:\\Users\\gaeta\\Documents\\java\\Pallacanestro\\canestro.jpg";
	
	final int LARGHEZZA = 800;
	final int ALTEZZA = 500;
	
	private double v;
	private double angolo;
	
	JFrame frame = new JFrame();
	JPanel panel1 = new JPanel();
	JLabel label1 = new JLabel();
	JSlider slider1 = new JSlider(0, 100, 50);
	JLabel label2 = new JLabel();
	JSlider slider2 = new JSlider(0, 100, 50);
	
	JPanel panel2 = new JPanel();
	JLabel label3 = new JLabel();	//palla
	JLabel label4 = new JLabel();	//canestro
	
	JButton button = new JButton();
	
	ImageIcon ic1 = new ImageIcon(pathPalla);
    ImageIcon palla = new ImageIcon(ic1.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
    
    ImageIcon ic2 = new ImageIcon(pathCanestro);
    ImageIcon canestro = new ImageIcon(ic2.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
    
    Palla p = new Palla();
    
    private boolean gioco = false;
    private int x = 0;
    private int y = 0;
    private int xPalla, yPalla, xCanestro, yCanestro;
    private int latoPalla, latoCanestro;
    private int centroXCanestro1, centroXCanestro2, centroYCanestro;
    
	public Frame(){
		setSlider();
		setLabel();
		setButton();
		setPanel();
		setFrame();
		System.out.println("Frame creato");
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
		label1.setText("Velocita': " + slider1.getValue());
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
		slider1.addChangeListener(e -> cambiaVelocita());
		slider1.setVisible(true);
		
		slider2.setAlignmentX(Component.CENTER_ALIGNMENT);
		slider2.setPaintTrack(true);
		slider2.setMajorTickSpacing(25);
		slider2.setPaintLabels(true);
		slider2.addChangeListener(e -> cambiaAngolo());
		slider2.setVisible(true);
	}
	
	 public double getVelocita() {
			return v;
		}
		public void setvelocita(double v) {
			this.v = v;
		}
		public double getAngolo() {
			return angolo;
		}
		public void setAngolo(double angolo) {
			this.angolo = angolo;
		}
	
	public void cambiaVelocita() {
		int v = slider1.getValue();
		label1.setText("Velocita': " + v);
		setvelocita(v);
	}
	
	public void cambiaAngolo() {
		int angolo = slider2.getValue();
		label2.setText("Angolo: " + angolo);
		setAngolo(angolo);
	}

	public void giocaBut(){
		frame.setResizable(false);
		button.setEnabled(false);
		
		//calcolo posizione del canestro
		centroXCanestro1 = (395 * latoCanestro) / 980;		//centro del canestro di dimensioni 980x980  -->  395x340 - [585 - latoPalla]x340
		centroXCanestro2 = ((585 - (latoPalla / 2)) * latoCanestro) / 980;
		centroYCanestro = (340 * latoCanestro) / 980;
		
		centroXCanestro1 += xCanestro;	//aggiungo offset del canestro
		centroXCanestro2 += xCanestro;
		centroYCanestro += yCanestro;
		
		p.setPalla(angolo, v, centroXCanestro1, centroXCanestro2, centroYCanestro);
		p.setMovimento(true);
		
		Thread thFrame = new Thread(p);
		thFrame.start();
		System.out.println("finito");
	}
	
	public void spostaPalla(int x, int y) {
		//System.out.println(h + "  " + w);
		label3.setBounds(x + xPalla, yPalla - y, latoPalla, latoPalla);
	}
	
	private void setDimensioni() {
		int h = panel2.getHeight();
		int w = panel2.getWidth();
		int area = h * w;
		
		//palla
		int areaPalla = area / 500;		//l'area della palla deve essere di scala 1 : 200 rispetto all'area del panel
		latoPalla = (int)Math.sqrt(areaPalla);
		ImageIcon ic1 = new ImageIcon(pathPalla);
	    ImageIcon palla = new ImageIcon(ic1.getImage().getScaledInstance(latoPalla, latoPalla, Image.SCALE_SMOOTH));
	    
	    xPalla = (w / 6) - latoPalla / 2;
		yPalla = (h - (h / 5)) - latoPalla / 2;		
	    
	    if(!p.isMovimento())
	    {
	    	label3.removeAll();
		    label3.setIcon(palla);
	    	label3.setBounds(xPalla, yPalla, latoPalla, latoPalla);
	    }
	    
	    //canestro
	    xCanestro = w - (w / 3);
	    yCanestro = h - (h / 2);
	    
	    int areaCanestro = area / 9;
	    latoCanestro = (int)Math.sqrt(areaCanestro);
	    ImageIcon ic2 = new ImageIcon(pathCanestro);
	    ImageIcon canestro = new ImageIcon(ic2.getImage().getScaledInstance(latoCanestro, latoCanestro, Image.SCALE_SMOOTH));
		
	    label4.removeAll();
	    label4.setIcon(canestro);
	    label4.setBounds(xCanestro, yCanestro, latoCanestro, latoCanestro);
	    
	    //System.out.println(w + " " + h);
	}
	
	@Override
	public void run() {
		gioco = true;
		while(gioco) {
			if(x != p.getX() || y != p.getY()) {
				x = p.getX();
				y = p.getY();
				spostaPalla(x, y);
			}
			if(!p.isMovimento() && p.isCanestro() && !p.isShowMessage())
			{
				p.setShowMessage(true);
				JOptionPane.showMessageDialog(frame, "Hai fatto canestro!");
			}
			
			if(!p.isMovimento())
			{
				frame.setResizable(true);
				button.setEnabled(true);
			}
			
			setDimensioni();
		}
	}
	
	
}
