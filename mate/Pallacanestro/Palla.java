

public class Palla implements Runnable{	
	private double angolo;
	private double v;
	
	private int x, y;
	
	private boolean movimento = false;
	private boolean canestro = false;
	private boolean showMessage = false;

	private int centroCanestroX1;
	private int centroCanestroX2;
	private int centroCanestroY;

	CalcoloTraiettoria cT = new CalcoloTraiettoria();
	
	public Palla() {
		
	}
	
	public int getCentroCanestroX2() {
		return centroCanestroX2;
	}

	public void setCentroCanestroX2(int centroCanestroX2) {
		this.centroCanestroX2 = centroCanestroX2;
	}

	public int getCentroCanestroY() {
		return centroCanestroY;
	}

	public void setCentroCanestroY(int centroCanestroY) {
		this.centroCanestroY = centroCanestroY;
	}

	public int getCentroCanestroX1() {
		return centroCanestroX1;
	}

	public void setCentroCanestroX1(int centroCanestroX1) {
		this.centroCanestroX1 = centroCanestroX1;
	}
	
	public boolean isShowMessage() {
		return showMessage;
	}

	public void setShowMessage(boolean showMessage) {
		this.showMessage = showMessage;
	}
	
	public boolean isCanestro() {
		return canestro;
	}

	public void setCanestro(boolean canestro) {
		this.canestro = canestro;
	}
	public boolean isMovimento() {
		return movimento;
	}

	public void setMovimento(boolean movimento) {
		this.movimento = movimento;
	}
	
	public void setPalla(double angolo, double v, int centroCanestroX1, int centroCanestroX2, int centroCanestroY) {
		this.angolo = angolo;
		this.v = v;
		
		this.centroCanestroX1 = centroCanestroX1;
		this.centroCanestroX2 = centroCanestroX2;
		this.centroCanestroY = centroCanestroY;
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
		setShowMessage(false);
		
		//TODO andre: canestro = cT.isCanestro();
		
		for(double i = 0.00; i < 0.5; i += 0.01) {
			cT.setT(i);
			//System.out.println(cT.calcolaX() + "    " + cT.calcolaY());
			setX((int) (cT.calcolaX() * 1000));
			setY((int) (cT.calcolaY() * 1000));
			//System.out.println(x + "    " + y);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		setMovimento(false);
	}

}
