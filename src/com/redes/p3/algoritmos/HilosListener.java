package com.redes.p3.algoritmos;

public interface HilosListener {
	/**
	 * Avisa cuando el algoritmo de Fibonacci ha 
	 * calculado un nuevo n&uacute;mero
	 * @param num
	 */
	public void onNewFibonacci( int num );
	
	public void onNewPrimo( int primo );
	
	public void onNewRandom( int random );
	
	public void onNewPar( int par );
	
	public void onHiloInterrumpido( String nombreHilo );
}
