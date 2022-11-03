

public class Palla implements Runnable{	
	private double angolo;
	private double v;	

    CalcoloTraiettoria cT = new CalcoloTraiettoria();
	
	public Palla() {
		
	}
	
	public void setPalla(double angolo, double v) {
		this.angolo = angolo;
		this.v = v;
		System.out.println("Informazioni di lancio impostate");
	}
	
	@Override
	public void run() {
		cT.setVal(angolo, v);
		for(double i = 0.00; i < 0.5; i += 0.01) {
			cT.setT(i);
			System.out.println(cT.calcolaX() + "    " + cT.calcolaY());
			int x = (int) (cT.calcolaX() * 1000);
			int y = (int) (cT.calcolaY() * 1000);
			System.out.println(x + "    " + y);
			Frame.spostaPalla(x, y);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
