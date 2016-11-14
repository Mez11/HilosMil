package com.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HiloInterrupciones implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger( HiloInterrupciones.class );
	HilosMilClass VHiloI=new HilosMilClass();
	//Propiedades para archivo log--@.@.
		private long time=0;
	    private Thread hilo;
	    private String estado;
	    private String nombreHilo;

	    public HiloInterrupciones(String nombre){
	    //VHiloI.setVisible(true);
		nombreHilo=nombre;
		estado="Nacido";
		//VHiloI.jTextArea1.append("Creando "+nombreHilo+"\n");
	        crearLog("");
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
	    
		//Nombres....
	    public void crearLog(Hilo2 hilo2) {
	    	logger.info( "Creando Log Hilo 2: {}", hilo2.returnInfo( ) );
	    }
	    
	    //Nombres...
	    public void crearLog(Hilo1 hilo1) {
	    	logger.info( "Creando Log Hilo 1: {}", hilo1.returnInfo( ) );
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
	        Hilo1 Hilo_Secuencia1 = new Hilo1( "Hilo_Secuencia1");
	        Hilo2 Hilo_Secuencia2 = new Hilo2( "Hilo_Secuencia2");
	        crearLog(Hilo_Secuencia1);
	        crearLog(Hilo_Secuencia2);
	    	Hilo_Secuencia1.start();
	        Hilo_Secuencia2.start();
	        crearLog(Hilo_Secuencia1);
	        crearLog(Hilo_Secuencia2);
	        while(true){
	            System.out.print("");
	            if(Hilo_Secuencia1.returnTiempo()>=2000){
	               // VHiloI.jTextArea1.append("Interrupcion "+Hilo_Secuencia1.returnName()+Hilo_Secuencia1.returnEjecutando()+"\n");
	                Hilo_Secuencia1.pause();
	                Hilo_Secuencia1.setTiempo();
	                crearLog(Hilo_Secuencia1);
	                crearLog("Hilo_Secuencia1 "+Hilo_Secuencia1.returnNi());
	            }
	            if(Hilo_Secuencia2.returnTiempo()>=3000){
	                //VHiloI.jTextArea1.append("Interrupcion "+Hilo_Secuencia2.returnName()+Hilo_Secuencia2.returnEjecutando()+"\n");
	                Hilo_Secuencia2.pause();
	                Hilo_Secuencia2.setTiempo();
	                crearLog(Hilo_Secuencia2);
	                crearLog("Hilo_Secuencia2 "+Hilo_Secuencia2.returnNi());
	            }
	            //Numero de repeticiones de hilos 
	            if(Hilo_Secuencia1.returnNi()==10){
	                if(Hilo_Secuencia2.returnNi()==10)
	                    break;
	            }
	        }
	        //VHiloI.jTextArea1.append("Termina "+nombreHilo+"\n");
	        estado="Finalizo";
	        crearLog(Hilo_Secuencia1);
	        crearLog(Hilo_Secuencia2);
	        crearLog("Numero maximo de interrupciones alcanzado");
	    }
}
