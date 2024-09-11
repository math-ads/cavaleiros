package controller;

import java.util.concurrent.Semaphore;

public class ThreadCavaleiros extends Thread {
	private int idCavaleiros;
	private static boolean tocha = false;
	private static boolean pedra;
	private int portas;
	private Semaphore semaforo;

	public ThreadCavaleiros() {
	}

	public ThreadCavaleiros(int idCavaleiros, Semaphore semaforo) {
		this.idCavaleiros = idCavaleiros;
		this.semaforo = semaforo;

	}

public void run() {
	cavaleiroAndando();
	//seção critica inicio
	cavaleiroPorta();
	//seção critica fim

}

private void cavaleiroAndando() {
	int distanciaTotal = 2000;
	int distanciaTocha = 500; 
	int distanciaPedra = 1500; 
	int distanciaPercorrida = 0;
	int tempo = 50;
	int boost= 2;
	while(distanciaPercorrida< distanciaTotal) {
		
		
		distanciaPercorrida+= (int) (Math.random() * 3) + 1 + boost;
		System.out.println(idCavaleiros + "andou" + distanciaPercorrida);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(distanciaPercorrida>=distanciaTocha && !tocha) {
			try {
				semaforo.acquire();
				tocha= true;
				boost+=2;
				 System.err.println(idCavaleiros+ "pegou a tocha");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				semaforo.release();
			}
			
			if(distanciaPercorrida>=distanciaPedra && !pedra) {
				try {
					semaforo.acquire();
					pedra= true;
					boost+=2;
					 System.err.println(idCavaleiros+ "pegou a pedra brilhante");
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				finally {
					semaforo.release();
				}
				
				
		}
		}}
	
}


    
	


private void cavaleiroPorta() {
	System.out.println("fim");
	
}



}