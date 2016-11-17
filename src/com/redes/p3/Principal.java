package com.redes.p3;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redes.p3.hilos.HiloInterrupciones;
import com.redes.p3.vista.HilosMilClass;

public class Principal {
	private static final Logger logger = LoggerFactory.getLogger( Principal.class );
	
	public static void main(String[] args) {
		HiloInterrupciones hiloInterrupciones= null;
		HilosMilClass ventana = null;
		
		//Inicializar ventana
		ventana = new HilosMilClass( );
		//Inicializar hilos
		logger.info( "Se llamara al hilo principal..." );
		//Notese que HilosMilClass es una clase que "hereda" (implementa) a HilosListener
    	hiloInterrupciones = new HiloInterrupciones( "Hilo_Interrupciones", ventana );
    	hiloInterrupciones.inicializarHilo( );
		//Mostrar ventana
		ventana.desplegar();
		
	}//fin main
}//fin class
