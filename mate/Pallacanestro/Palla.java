

public class Palla implements Runnable{	
	private double angolo;
	private double v;
	
	private int x, y;

	CalcoloTraiettoria cT = new CalcoloTraiettoria();
	
	public Palla() {
		
	}
	
	public void setPalla(double angolo, double v) {
		this.angolo = angolo;
		this.v = v;
		System.out.println("Informazioni di lancio impostate");
	}
	
	 public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	@Override
	public void run() {
		cT.setVal(angolo, v);
		for(double i = 0.00; i < 0.5; i += 0.01) {
			cT.setT(i);
			//System.out.println(cT.calcolaX() + "    " + cT.calcolaY());
			setX((int) (cT.calcolaX() * 1000));
			setY((int) (cT.calcolaY() * 1000));
			//System.out.println(x + "    " + y);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
