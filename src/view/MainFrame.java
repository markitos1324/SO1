package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Controller;

public class MainFrame  extends JFrame {

	
	
	/**
	 *  Ventana principal
	 */
	private static final long serialVersionUID = 1L;
//____________________________________________________________________
	
	
	public JP_BOTONES botonesprincipales;
	public  Controller controller;
	public JP_MONO monoProcesamiento;
	


	public MainFrame(Controller controller) {
			this.controller = controller;
		  	setTitle("Tipos de procesamiento");
	        setLayout(new BorderLayout());
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setExtendedState(MAXIMIZED_BOTH);
	        getContentPane().setBackground(Color.decode("#472D84"));
	        monoProcesamiento = new JP_MONO(controller);
	        iniciarCompoentes();
	        setVisible(true);
	        
	}
	
	public void iniciarCompoentes() {
		botonesprincipales = new JP_BOTONES(controller);
		add(botonesprincipales,BorderLayout.NORTH);
	}
	
	public void cambiarpanlenesMono() {
		add(monoProcesamiento,BorderLayout.CENTER);
	}
	
	public JP_MONO getMonoProcesamiento() {
		return monoProcesamiento;
	}

	public void setMonoProcesamiento(JP_MONO monoProcesamiento) {
		this.monoProcesamiento = monoProcesamiento;
	}
}
