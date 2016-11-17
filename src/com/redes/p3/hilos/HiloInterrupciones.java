package com.redes.p3.hilos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redes.p3.vista.HilosMilClass;

public class HiloInterrupciones implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger( HiloInterrupciones.class );
	HilosMilClass VHiloI=new HilosMilClass();
	//Propiedades para archivo log--@.@.
	private Thread hilo;
	private String estado;
	private String nombreHilo;

	public HiloInterrupciones(String nombre){
		//VHiloI.setVisible(true);
		nombreHilo=nombre;
		estado="Nacido";
		//VHiloI.jTextArea1.append("Creando "+nombreHilo+"\n");
	}

	public void inicializarHilo( ){
		// VHiloI.setVisible(true);
		estado="Ejecutable";
		crearLog("Inicio");
		//VHiloI.jTextArea1.append("Iniciando "+nombreHilo+"\n");
		//Se crea una nueva instancia
		hilo = new Thread(this, nombreHilo);
		//y se llama a su metodo "start"
		hilo.start ();
	}

	public void crearLog(String aux){
		//"3" es un codigo harcode.. Imagino que el ID debe ser dinamico, no?--yo lo manejo 1 ,2 
		logger.info( "Nombre hilo: [{}], ID hilo: [{}] Estado hilo: [{}]",
				nombreHilo, 3, estado, aux );
	}

	@Override
	public void run() {
		//VHiloI.setVisible(true);
		//VHiloI.jLabel1.setText("Actividad en HiloInterrupciones");
		estado="Ejecutando";
		//Instancias @.@. de hilos
		Hilo1 hilo1 = new Hilo1( "Hilo_Secuencia1" );
		Hilo2 hilo2 = new Hilo2( "Hilo_Secuencia2" );
		logger.info( "Hilo 1: {}", hilo1.returnInfo( ) );
		logger.info( "Hilo 2: {}", hilo2.returnInfo( ) );
		hilo1.start();
		hilo2.start();
		logger.info( "Hilo 1: {}", hilo1.returnInfo( ) );
		logger.info( "Hilo 2: {}", hilo2.returnInfo( ) );
		while(true){
			System.out.print("");
			if(hilo1.returnTiempo()>=2000){
				// VHiloI.jTextArea1.append("Interrupcion "+hilo1.returnName()+hilo1.returnEjecutando()+"\n");
				hilo1.pause();
				hilo1.setTiempo();
				logger.info( "Hilo 1: {}", hilo1.returnInfo( ) );
				crearLog("hilo1 "+hilo1.returnNi());
			}
			if(hilo2.returnTiempo()>=3000){
				//VHiloI.jTextArea1.append("Interrupcion "+hilo2.returnName()+hilo2.returnEjecutando()+"\n");
				hilo2.pause();
				hilo2.setTiempo();
				logger.info( "Log Hilo 2: {}", hilo2.returnInfo( ) );
				crearLog("hilo2 "+hilo2.returnNi());
			}
			//Numero de repeticiones de hilos 
			if(hilo1.returnNi()==10){
				if(hilo2.returnNi()==10)
					break;
			}
		}
		//VHiloI.jTextArea1.append("Termina "+nombreHilo+"\n");
		estado="Finalizo";
		logger.info( "Hilo 1: {}", hilo1.returnInfo( ) );
		logger.info( "Hilo 2: {}", hilo2.returnInfo( ) );
		crearLog("Numero maximo de interrupciones alcanzado");
	}
}
