package com.redes.p3.algoritmos;

public class Fibonacci {
	
	    private final int n;
		public Fibonacci(){
			n=0;
		}
		public int fiboRecursivo(int n){
				if(n==0)
					return n;
				else if(n==1)
					return n;
				else
					return fiboRecursivo(n-1)+fiboRecursivo(n-2);
		}
		public int imprimirFibo(int i){		
			int num=fiboRecursivo(i);
			return num;		
		}
}//end class 


