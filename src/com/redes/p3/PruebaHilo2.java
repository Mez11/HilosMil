package com.redes.p3;

public class PruebaHilo2 implements Runnable {
	private boolean calcularAleatorios;

	public PruebaHilo2( ){
		calcularAleatorios = true;
	}
	
	private void calcularAleatorios ( ){
		System.out.println( "Si esto fuera la P3, estaria calculando Aleatorios" );
	}
	
	private void calcularPares( ){
		System.out.println( "Si esto fuera la P3, estaria calculando Pares" );
	}
	
	@Override
	public void run() {
		while( true ){
			if( Thread.interrupted() ){
				if( calcularAleatorios == true ){
					calcularAleatorios = false;
				}
				else{
					calcularAleatorios = true;
				}
			}//end if interrumped
			
			if( calcularAleatorios ){
				calcularAleatorios();
			}
			else{
				calcularPares( );
			}
		}//end while
	}//end run

}
