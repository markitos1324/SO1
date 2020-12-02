package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controller.Controller;

public class JP_MONO extends JPanel{


	/**
	 * En esta clase se verá el procesamiento monoprogramcion.
	 */
	private static final long serialVersionUID = 1L;
	
	private JProgressBar procesos;
	private JLabel informacion;
	private Controller controller;
	
	public JP_MONO(Controller controller) {
		this.controller = controller;
        setLayout(new FlowLayout());
        Border bordejpanel = new TitledBorder(new EtchedBorder(), 
        "Procesamiento monoProgramacion",0, 0, new Font("Times New Roman", Font.BOLD, 30), Color.BLACK);
        setBorder(bordejpanel);
        setVisible(true);
	}
	
	public void initComponents(int numeroAcciones,int actualizacion) {
		procesos = new JProgressBar(0,100);
		for (int i = 0; i < numeroAcciones +1 ; i++) {
			
			add(procesos);
			procesos.setValue(i);
			revalidate();
			repaint();
		}
	}
}
