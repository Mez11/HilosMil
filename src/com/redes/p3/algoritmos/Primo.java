package com.redes.p3.algoritmos;

public class Primo {

	   private final int n;
	    
	    public Primo(){
		n=1;
	    }
		
	    public boolean esPrimo(int i){
	    //Condiciones para que sea primo 	
	        for(int j=2; j<i; j++){
	    //Al dividirse en si mismo    	
	            if(i%j==0){
			return false;
	            }//end if
		}//end for
		return true;
	    }
	    public int calcularPrimo(int i){
		if(esPrimo(i)){
	            return i;
		}
	        return 0;
	    }
	    //Si no es primo
	    public int ret(){
		return n;
	    }
}
