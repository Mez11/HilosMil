package com.redes.p3.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class HilosMilClass {

	private JFrame frame;

	/**
	 * M&eacute;todo para llamar al <code>setVisible</code>
	 * del Frame.
	 * @param isVisible
	 * @see JFrame#setVisible(boolean)
	 */
	public void setVisible(boolean isVisible) {
		frame.setVisible( isVisible );
	}



	/**
	 * Create the application.
	 */
	public HilosMilClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(67, 26, 127, 233);
		frame.getContentPane().add(textArea);
		
		JLabel lblHilo = new JLabel("Hilo 1");
		lblHilo.setBounds(12, 12, 50, 15);
		frame.getContentPane().add(lblHilo);
	}
}
