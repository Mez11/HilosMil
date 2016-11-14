package com.redes.p3.algoritmos;

import java.util.Random;

public class Aleatorio {
	
	  	int n;
	  	
		private Random al=new Random();
		public int calcularAleatorio(){
			n=al.nextInt(1000);
			return n;
		}
}//end class