package com.main;

import javax.print.attribute.standard.RequestingUserName;

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
	
	public Hilo1(String nombre){
		nombreHilo=nombre;
		ni=0;
		//Instancias de Algoritmos
		F = new Fibonacci();
		P = new Primo();
		estado="Iniciado";
		nFib=0;
		nPrim=1;
		tiempo=0;
		}//end Hilo1
	public  String returnName(){
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
		info= "Nombre hilo: ["+returnName()+"] "+"ID hilo: ["+returnId()+"] "+
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
    
	@Override
	public void run() {
	estado="Ejecutando";
	while(returnNi()<=9){
		//Switch
		if(returnNi()%2==1){
			for(int i=obtenernPrim();i<1000; i++){
				if(returnNi()%2==1){
				 try{
					    long timeIni=System.currentTimeMillis();
                        if(P.calcularPrimo(i)!=0){
                          }
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
		}else{
			for(int i=obtenernFib();;i++){
				if(returnNi()%2==0){
					try{
						  long timeIni=System.currentTimeMillis();
	                       //VHilo1.jTextArea1.append(F.imprimirFibo(i)+"\n");
		                    Thread.sleep(300);
		                     nFib=i;
		                     long timeFin=System.currentTimeMillis();
		                     tiempo=tiempo+(timeFin-timeIni);
					}catch(InterruptedException e){
						  System.out.println("Hilo interrumpido");
					}
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


