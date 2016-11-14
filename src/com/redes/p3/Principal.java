package com.redes.p3;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redes.p3.hilos.HiloInterrupciones;

public class Principal {
	private static final Logger logger = LoggerFactory.getLogger( Principal.class );
	
	public static void main(String[] args) {
		logger.info( "Se llamara al hilo principal..." );
		HiloInterrupciones hiloInterrupciones= new HiloInterrupciones("Hilo_Interrupciones");
    	hiloInterrupciones.inicializarHilo( );
		
	}//fin main
}//fin class
