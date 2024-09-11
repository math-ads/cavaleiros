package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCavaleiros;

public class Cavaleiro {

	public static void main(String[] args) {
		
		 int permissoes = 1;
		 Semaphore semaforo = new Semaphore(permissoes);
		 
		 for(int idCavaleiros = 0; idCavaleiros < 4; idCavaleiros++) {
			   Thread tCavaleiros = new ThreadCavaleiros(idCavaleiros, semaforo);			   
			   tCavaleiros.start();
			   
		 }
	}
}
