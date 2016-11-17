package com.redes.p3.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.redes.p3.algoritmos.HilosListener;

public class HilosMilClass implements HilosListener {

	private JFrame frame;
	private JTextArea areaHilo1;
	private JTextArea areaHilo2;

	/**
	 * M&eacute;todo para desplegar la ventana
	 * @see JFrame#setVisible(boolean)
	 */
	public void desplegar( ) {
		frame.setVisible( true );
	}


	/**
	 * Initialize the contents of the frame.
	 */
	public HilosMilClass() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		areaHilo1 = new JTextArea();
		
		
		JScrollPane scroll1 = new JScrollPane( areaHilo1 );
		scroll1.setBounds(67, 26, 127, 233);
		frame.getContentPane( ).add( scroll1 );
		
		areaHilo2 = new JTextArea();
		JScrollPane scroll2 = new JScrollPane( areaHilo2 );
		scroll2.setBounds( 267, 26, 127, 233 );
		frame.getContentPane( ).add( scroll2 );
		
		JLabel lblHilo = new JLabel("Hilo 1");
		lblHilo.setBounds(12, 12, 50, 15);
		frame.getContentPane().add(lblHilo);
	}

	@Override
	public void onNewFibonacci(int num) {
		areaHilo1.append( "Fibonacci: " + num + "\n" );
	}


	@Override
	public void onNewPrimo(int primo) {
		areaHilo1.append( "Primo: " + primo + "\n" );
	}


	@Override
	public void onNewRandom(int random) {
		
		areaHilo2.append("Ramdom:"+ random + "\n" );
		//System.out.println( "Random :" + random);
	}


	@Override
	public void onNewPar(int par) {
		areaHilo2.append("Par:"+ par + "\n");
		//System.out.println( "Par: "  + par );
	}


	@Override
	public void onHiloInterrumpido(String nombreHilo) {
		System.out.println( "Interrumpcion generada en " + nombreHilo );
	}
}//end class
