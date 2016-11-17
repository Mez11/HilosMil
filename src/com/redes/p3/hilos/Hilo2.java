package com.redes.p3.hilos;

import com.redes.p3.algoritmos.Aleatorio;
import com.redes.p3.algoritmos.HilosListener;
import com.redes.p3.algoritmos.Par;

public class Hilo2 implements Runnable{

	private String nombreHilo;
	private int ni;
	private Aleatorio A;
	private Par P;
	private Thread hilo;
	private String estado;
	private int nPar;
	private long tiempo;
	private String info;
	private HilosListener listener;

	public Hilo2(String nombre, HilosListener listener ){
		//VHilo2.setVisible(true);
		nombreHilo=nombre;
		ni=0;
		//VHilo2.jTextArea1.append("Creando "+nombreHilo+"\n");
		this.listener = listener;
		A= new Aleatorio();
		P= new Par();
		estado="Iniciado";
		nPar=0;
		tiempo=0;
		//it=0;
	}

	public String returnName(){
		return nombreHilo;
	}

	public int obtenernPar(){
		return nPar;
	}

	public int returnId(){
		return 2;
	}

	public void addNi(){
		ni++;
	}

	public int returnNi(){
		return ni;
	}

	public String obtenerEstado(){
		return estado;
	}

	public void start(){
		// VHilo2.setVisible(true);
		estado="Ejecutable";
		//VHilo2.jTextArea1.append("Iniciando "+nombreHilo+"\n");
		if (hilo == null) {
			hilo = new Thread (this, nombreHilo);
			hilo.start ();
		}
	}

	public String returnInfo(){
		info= "Nombre hilo: ["+returnName()+"] "+"ID hilo: ["+returnId()+"] "+
				"Estado hilo: ["+obtenerEstado()+"] "+"Nombre de secuencia: ["+returnEjecutando()+"]";
		return info;
	}

	public String returnEjecutando(){
		if(returnNi()%2==1){
			return " Par";
		}else{
			return " Aleatorio";
		}
	}

	@Override
	public void run(){
		//  VHilo2.setVisible(true);
		// VHilo2.jLabel1.setText("Actividad en Hilo 2");
		estado="Ejecutando";
		while(returnNi()<=9){
			//Switch
			if(returnNi()%2==1){
				// VHilo2.jTextArea1.append("Cambio a: Par\n");
				for(int i=obtenernPar();i<1000;i++){
					if(returnNi()%2==1){
						try{
							long timeIni=System.currentTimeMillis();
							listener.onNewPar( P.calcularPar( i ) );

							Thread.sleep(300);
							nPar=i;
							long timeFin=System.currentTimeMillis();
							tiempo=tiempo+(timeFin-timeIni);
						}catch(InterruptedException e){
							System.out.println("Hilo interrumpido");
						}
					}else{
						break;
					}
				}
			}else{
				//VHilo2.jTextArea1.append("Cambio a: Aleatorio\n");
				for(int i=0;i<600;i++){
					if(returnNi()%2==0){
						try{
							long timeIni=System.currentTimeMillis();
							//VHilo2.jTextArea1.append(A.calcularAleatorio()+"\n");
							listener.onNewRandom( A.calcularAleatorio( ) );
							Thread.sleep(300);
							long timeFin=System.currentTimeMillis();
							tiempo=tiempo+(timeFin-timeIni);
						}catch(InterruptedException e){
							System.out.println("Hilo interrumpido");
						}
					}else{
						break;
					}
				}
			}
		}
		estado="Finalizo";
		// VHilo2.jTextArea1.append("Termina ejecucion\n");
	}

	public void stop(){
		estado="Detenido";
		System.exit(0);
	}

	public void pause(){
		ni++;
	}

	public long returnTiempo(){
		return tiempo;
	}

	public void setTiempo(){
		tiempo=0;
	}
}//end class


