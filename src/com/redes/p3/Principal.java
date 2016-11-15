package com.redes.p3;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redes.p3.hilos.HiloInterrupciones;

public class Principal {
	private static final Logger logger = LoggerFactory.getLogger( Principal.class );
	
	public static void main(String[] args) throws InterruptedException {
		logger.info( "Se llamara al hilo principal..." );
//		HiloInterrupciones hiloInterrupciones= new HiloInterrupciones("Hilo_Interrupciones");
//    	hiloInterrupciones.inicializarHilo( );
		
		new Prueba1( ).ejecutarHilos( );
		
		//Y asi quedaria mas o menos la parte de hilos de la practica...
		//OK..ya entendi mas..lo de sincro .mañana lo cambio lo de tiempos para q si sea
		//Sincronizacion ñaja
		//si amor... en si, si te fijas, lo que es "sincronizacion" es el "interrupt".
		//Mañana amm... te explico en el receso o en la hora de soto
		//si TIenes dudas o asi en alguna parte del codigo
		//Escribi "Prueba1.java", "PruebaHilo1.java" y "PruebaHilo2.java" no porque
		//tu codigo estuviera mal, sino porque queria escribir codigo que fuera
		///sencillo de entender (sin otras implementaciones mas que hilos)
		//Aparte, tampoco ya recuerdo mucho de hilos, asi que tambien fue para ayudarme a mi
		//Ok..@.q. entendido mañana hago cambios ja hoy hacido mucho hilo por mi pero ya le entiendo mas
		//Eso me alegra mucho mi niña
		//ÑAja segun yo solo lo de sincro es lo q esta mal ..
		//si, lo demas se ve bien. Y ya quedo el logger para archivito
		//Yeah----ñaje mañana continuoo si avance hoy..la..la.. gracias por la ayuda mill
		//de nada mi vida :* ñaha
		//BYe mi niño duerme lo siento por desvelarte y robarte mucho tiempo ñaja 
		//ohhh no digas eso mi vida, me sirvio para ver cosas nuevas de timers y asi
		//genial adios bebo 1 
		//adios mi niña consentida :*
		//wow ..me encanta que me consientas eso me enamora mill
		//entonces siempre te consentire :i<i3i
		//sii igual a ti te gusta que te consienta mil ja lo se adios mi cielo esponjo
		//bye patito te amooo
		
	}//fin main
}//fin class
