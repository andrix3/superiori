
public class CalcoloTraiettoria {
	private int alfa, v;
	private int t;
	
	private static final double G = 9.81;
	
	public void setAlfa(int alfa) {
		if(alfa > 0 && alfa < 90)
			this.alfa = alfa;
	}
	public void setV(int v) {
		if(v > 0)
			this.v = v;
	}
	public void setT(int t) {
		if(t >= 0)
			this.t = t;
	}
	
	public void setVal(int alfa, int v) {
		if(alfa > 0 && alfa < 90 && v > 0) {
			this.alfa = alfa;
			this.v = v;
		}
	}
	
	public double calcolaX() {
		return v * Math.cos(alfa) * t;
	}
	
	public double calcolaY() {
		return -0.5 * G * Math.pow(t, 2) + v * Math.sin(alfa) * t;
	}
	
	

}
