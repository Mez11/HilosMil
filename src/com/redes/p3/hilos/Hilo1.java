package com.redes.p3.hilos;

import com.redes.p3.algoritmos.Fibonacci;
import com.redes.p3.algoritmos.HilosListener;
import com.redes.p3.algoritmos.Primo;

public class Hilo1 implements Runnable {
	//Declaracion de atributos de Hilo 1
	private String nombreHilo;
	private int ni;
	private Fibonacci F;
	private Primo P;
	private Thread hilo;
	private String estado;
	private int nFib;
	private int nPrim;
	private long tiempo;
	private String info;
	//Para avisar de nuevos calculos
	private HilosListener listener;

	public Hilo1(String nombre, HilosListener listener){
		nombreHilo=nombre;
		this.listener = listener;
		ni=0;
		//Instancias de Algoritmos
		F = new Fibonacci();
		P = new Primo();
		estado="Iniciado";
		nFib=0;
		nPrim=1;
		tiempo=0;
	}//end Hilo1
	
	public  String getName(){
		return nombreHilo;
	}
	public int returnId(){
		return 1;
	}
	public int returnNi(){
		return ni;	
	}
	public String obtenerEsatado(){
		return estado;
	}


	public void start(){
		estado ="Ejecutable";
		if(hilo == null){
			hilo = new Thread(this,nombreHilo);
			hilo.start();

		}
	}//end start

	public int obtenernPrim(){
		return nPrim;
	}
	public int obtenernFib(){
		return nFib;
	}
	public String returnInfo(){
		info= "Nombre hilo: ["+getName()+"] "+"ID hilo: ["+returnId()+"] "+
				"Estado hilo: ["+obtenerEsatado()+"] "+"Nombre de secuencia: ["+returnEjecutando()+"]";
		return info;
	}//end returnInfo
	public String returnEjecutando(){

		if(returnNi()%2==1){
			return " Primo";
		}else{
			return " Fibonacci";
		}
	}

	private boolean necesitamosCalcularPrimo(  ){
		return ni % 2 == 1;
	}
	
	private void calcularPrimo( ){
		for(int i=obtenernPrim();i<1000; i++){
			if(returnNi()%2==1){
				try{
					long timeIni=System.currentTimeMillis();
					//Avisar al listener que se calculo un nuevo primo
					listener.onNewPrimo( P.calcularPrimo( i ) );
					Thread.sleep(300);
					nPrim=i;
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
	
	private void calcularFibonacci( int i ){
		try{
			long timeIni=System.currentTimeMillis();
			//VHilo1.jTextArea1.append(F.imprimirFibo(i)+"\n");
			//Avisar al listener que un nuevo fibonacci ha sido calculado
			listener.onNewFibonacci( F.imprimirFibo( i ) );
			Thread.sleep( 300 );
			nFib=i;
			long timeFin=System.currentTimeMillis();
			tiempo=tiempo+(timeFin-timeIni);
		}catch(InterruptedException e){
			System.out.println("Hilo interrumpido");
		}
	}
	
	@Override
	public void run() {
		estado="Ejecutando";
		while( ni <= 9){
			//Switch
			if( necesitamosCalcularPrimo( ) ){
				listener.onHiloInterrumpido(  "[" + nombreHilo + "] Calculando Primo" );
				calcularPrimo( );
			}else{
				listener.onHiloInterrumpido(  "[" + nombreHilo + "] Calculando Fibonacci" );
				for( int i=obtenernFib( ); ; i++ ){
					if( !necesitamosCalcularPrimo( ) ){
						calcularFibonacci( i );
					}else{
						break;
					}

				}//end if
			}//end for 
		}//end if first
		estado="Finalizado";
	}
	public void stop(){
		estado="Detenido";
		System.exit(0);
	}
	public long returnTiempo(){
		return tiempo;
	}
	public void setTiempo(){
		tiempo=0;
	}
	public void pause(){
		ni++;
	}

	//Implementacion de numeros pares @.#
	//int n = 0;
	//while( true ){
	//if( n % 2 == 0 ){

	//}
	//}//end while



}//end class


