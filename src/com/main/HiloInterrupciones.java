package com.main;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HiloInterrupciones {
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
	    public void start(){
	      // VHiloI.setVisible(true);
	        estado="Ejecutable";
	        crearLog("Inicio");
	        //VHiloI.jTextArea1.append("Iniciando "+nombreHilo+"\n");
		if (hilo == null) {
	            hilo = new Thread ((Runnable) this, nombreHilo);
	            hilo.start ();
	    	}
	    }
		
	    public void crearLog(Hilo2 A) {
	        FileWriter fichero=null;
	        PrintWriter pw=null;
	        try{
	            fichero=new FileWriter("./infoHilos.log",true);
	            pw=new PrintWriter(fichero);
	            pw.println(A.returnInfo());
	            fichero.close();
	        }catch(IOException e){
	            System.err.println(e);
	        }
	    }

	    public void crearLog(Hilo1 A) {
	        FileWriter fichero=null;
	    	PrintWriter pw=null;
	    	try{
		    fichero=new FileWriter("./infoHilos.log",true);
		    pw=new PrintWriter(fichero);
		    pw.println(A.returnInfo());
		    fichero.close();
		}catch(IOException e){
	            System.err.println(e);
		}
	    }
	    
	    public void crearLog(String aux){
	        FileWriter fichero=null;
	    	PrintWriter pw=null;
	    	try{
		    fichero=new FileWriter("./infoHilos.log",true);
		    pw=new PrintWriter(fichero);
		    pw.println("Nombre hilo: ["+nombreHilo+"] "+"ID hilo: ["+3+"] "+
	            "Estado hilo: ["+estado+"] "+aux+"\n");
		    fichero.close();
		}catch(IOException e){
	            System.err.println(e);
		}
	    }
	    
	    public void run() {
	        //VHiloI.setVisible(true);
	        //VHiloI.jLabel1.setText("Actividad en HiloInterrupciones");
	        estado="Ejecutando";
	        crearLog("");
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
	    
	    public static void main(String args[]) {
		HiloInterrupciones Hilo_Interrupciones= new HiloInterrupciones("Hilo_Interrupciones");
	        Hilo_Interrupciones.start();
	        
	    }

}
