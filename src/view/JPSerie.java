package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.ProcesoSerie;

public class JPSerie extends JPanel{

	/**
	 * En esta clase se verá el procesamiento en serie
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton procesos;
	private JLabel informacion;
	public JPanel jPProcesos;
	private JPanel jPButton;
	
	public JPSerie(ArrayList<ProcesoSerie> listPs) {
		setLayout(new BorderLayout());	
		jPProcesos = new JPanel();
		jPProcesos.setBackground(Color.decode("#472D84"));
		
		jPProcesos.setBorder(BorderFactory.createEmptyBorder(20, 70, 100, 40));
		GridLayout experimentLayout = new GridLayout(2,3,30,30);
		jPProcesos.setLayout(experimentLayout);
		
		insertarProcesos(listPs);
		this.add(jPProcesos,BorderLayout.CENTER);
		
		jPButton= new JPanel();
		jPButton.setBackground( Color.decode("#FAD7A0"));
		procesos = new JButton("tiempo");
		procesos.setSize(50, 50);
		procesos.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));
		jPButton.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		jPButton.add(procesos);
		
		this.add(jPButton,BorderLayout.SOUTH);
		
	}
//	ArrayList<ProcesoSerie> listPsArrayList<ProcesoSerie> listPs
	public void insertarProcesos(ArrayList<ProcesoSerie> listPs) {
		for (int i = 0; i < listPs.size(); i++) {
		JLabel label = new JLabel(listPs.get(i).getNombre(),SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
		label.setForeground(Color.BLACK);
		jPProcesos.add(label);
		}
		
		for (int i = 0; i < listPs.size(); i++) {
			JLabel label = new JLabel(listPs.get(i).getResultado(),SwingConstants.CENTER);
			label.setOpaque(true);
			label.setBackground(Color.WHITE);
			label.setForeground(Color.BLACK);
			jPProcesos.add(label);
		}
	}
	
	public void updatePanelCenter(ArrayList<ProcesoSerie> listPs){
		this.remove(jPProcesos);
		jPProcesos = new JPanel();
		jPProcesos.setBackground(Color.decode("#472D84"));
		jPProcesos.setBorder(BorderFactory.createEmptyBorder(20, 70, 100, 40));
		GridLayout experimentLayout = new GridLayout(2,3,30,30);
		jPProcesos.setLayout(experimentLayout);
		insertarProcesos(listPs);
//		jPProcesos.updateUI();
//		jPProcesos=panel;
		this.add(jPProcesos,BorderLayout.CENTER);
		repaint();
		revalidate();
	}
}
