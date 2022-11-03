
public class CalcoloTraiettoria{
	private double alfa, v;
	private double t;
	
	private static final double G = 9.81;
	
	public void setAlfa(double alfa) {
		if(alfa > 0 && alfa < 90)
			this.alfa = alfa;
	}
	public void setV(int v) {
		if(v > 0)
			this.v = v;
	}
	public void setT(double t) {
		if(t >= 0)
			this.t = t;
	}
	
	public void setVal(double angolo, double v2) {
		if(angolo > 0 && angolo < 90 && v2 > 0) {
			this.alfa = angolo;
			this.v = v2;
		}
	}
	
	public double calcolaX() {
		double rad = radianti(alfa);
		return v * Math.cos(rad) * t;
	}
	
	public double calcolaY() {
		double rad = radianti(alfa);
		return -0.5 * G * Math.pow(t, 2) + v * Math.sin(rad) * t;
	}
	public double radianti(double gradi) {
		return (gradi * Math.PI) / 180;
	}
	

}
