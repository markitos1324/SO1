package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame  extends JFrame {

	
	
	/**
	 *  Ventana principal
	 */
	private static final long serialVersionUID = 1L;
//____________________________________________________________________
	
	
	public JP_BOTONES botonesprincipales;
	
	
	
	public MainFrame() {
		  	setTitle("Tipos de procesamiento");
	        setLayout(new BorderLayout());
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setExtendedState(MAXIMIZED_BOTH);
	        getContentPane().setBackground(Color.decode("#472D84"));
	        iniciarCompoentes();
	        setVisible(true);
	        //ImageIcon icon = new ImageIcon("Image/numeros.png");
	        //setIconImage(icon.getImage());
	}
	
	public void iniciarCompoentes() {
		botonesprincipales = new JP_BOTONES();
		add(botonesprincipales,BorderLayout.NORTH);
	}
}
