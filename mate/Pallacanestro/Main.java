
public class Main {

	public static void main(String[] args) throws InterruptedException {

		Frame fr = new Frame();
		
		Thread.sleep(2000);
		
		//per spostare la palla
		for(int i = 0; i < 500; i++) {
			fr.spostaPalla(i, 50);
			Thread.sleep(1);
		}
	}
	
	//Nella tua superclasse:
	public void giocaBut(int forza, int angolo){
		
	}
}
