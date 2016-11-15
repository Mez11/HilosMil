package com.redes.p3;

public class PruebaHilo1 implements Runnable {
	private boolean calcularFibonacci;

	public PruebaHilo1( ){
		calcularFibonacci = true;
	}
	
	private void calcularFibonacci ( ){
		System.out.println( "Si esto fuera la P3, estaria calculando Fibonacci" );
	}
	
	private void calcularPrimos( ){
		System.out.println( "Si esto fuera la P3, estaria calculando Primos" );
	}
	
	@Override
	public void run() {
		while( true ){
			if( Thread.interrupted() ){
				if( calcularFibonacci == true ){
					calcularFibonacci = false;
				}
				else{
					calcularFibonacci = true;
				}
			}//end if interrumped
			
			if( calcularFibonacci ){
				calcularFibonacci();
			}
			else{
				calcularPrimos( );
			}
		}//end while
	}//end run

}
