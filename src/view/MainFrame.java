package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.ProcesoSerie;

public class MainFrame  extends JFrame {

	
	
	/**
	 *  Ventana principal
	 */
	private static final long serialVersionUID = 1L;
//____________________________________________________________________
	
	
	public JP_BOTONES botonesprincipales;
	public JPanel panelCentral;
	public JPSerie jps;
	
	public MainFrame(ArrayList<ProcesoSerie> listPs) {
		  	setTitle("Tipos de procesamiento");
	        setLayout(new BorderLayout());
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setExtendedState(MAXIMIZED_BOTH);
	        getContentPane().setBackground(Color.decode("#472D84"));
	        iniciarCompoentes(listPs);
	        setVisible(true);
	        //ImageIcon icon = new ImageIcon("Image/numeros.png");
	        //setIconImage(icon.getImage());
	}
	
	public void iniciarCompoentes(ArrayList<ProcesoSerie> listPs) {
		botonesprincipales = new JP_BOTONES();
		add(botonesprincipales,BorderLayout.NORTH);
		
//		panelCentral = new JPanel();
//		panelCentral.setBackground(Color.decode("#472D84"));
//		add(panelCentral);
		
		jps = new JPSerie(listPs);
		add(jps);
		
	}
	
	public void updatePanelCenter(JPanel panel) {
		this.remove(panelCentral);
		panelCentral=panel;
		this.add(panel);
		repaint();
		revalidate();
	}
	
//	public static void main(String[] args) {
//		new MainFrame();
//	}
	
}
