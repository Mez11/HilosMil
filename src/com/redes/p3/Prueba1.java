package com.redes.p3;

import java.util.Timer;
import java.util.TimerTask;

public class Prueba1 {
	private Thread hilo1;
	private Thread hilo2;
	
	private void manejadorHilo1( ){
		//Programar una tarea para que se ejecute cada 2 segundos
		new Timer( ).schedule( new TimerTask() {
			@Override
			public void run() {
				//Lo que se ejecute aqui, se ejecutara cada 2 segundos...
				hilo1.interrupt( );
			}
		}, 0, 2000 );
	}
	
	private void manejadorHilo2( ){
		//Programar una tarea para que se ejecute cada 3 segundos
		new Timer( ).schedule( new TimerTask() {
			@Override
			public void run() {
				//Lo que se ejecute aqui, se ejecutara cada 3 segundos...
				hilo2.interrupt( );
			}
		}, 0, 3000 );
	}
	
	public void ejecutarHilos() throws InterruptedException {
		hilo1 = new Thread( new PruebaHilo1( ) );
		hilo2 = new Thread( new PruebaHilo2( ) );
		
		hilo1.start( );
		hilo2.start( );
		
		manejadorHilo1( );
		manejadorHilo2( );
	}//end main
}//end class
