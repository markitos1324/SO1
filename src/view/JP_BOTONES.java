package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.Constantes;


public class JP_BOTONES extends JPanel {

	/**
	 * Este panel contiene los botones para los tipos de procesos. 
	 */
	private static final long serialVersionUID = 1L;
	private JButton botonserie, botonmono, botonmulti, botontiempoCompartido;
	private static final int NUMERO_FONT = 20;
	
	public JP_BOTONES() {
	    setLayout(new GridLayout(1,4));
	    Border bordejpanel = new TitledBorder(new EtchedBorder(), "Tipos de procesamiento",0, 
	        		0, new Font("Times New Roman", Font.BOLD, 25), Color.BLACK);
	    setBorder(bordejpanel);
	    iniciarCompoenentes();
	    setVisible(true);
	}
	
	public void iniciarCompoenentes() {
		
		botonserie = new JButton("Procesamiento en serie");
		botonserie.setToolTipText("Procesamiento en serie");
		botonserie.setBorder(new LineBorder(Color.BLACK));
		//botonserie.addActionListener(controller);
		botonserie.setActionCommand(Constantes.C_MENU_ITEM_SERIE);
		botonserie.setBackground(Color.decode("#9FB0BB"));
		botonserie.setFocusPainted(false);
		botonserie.setForeground(Color.BLACK);
		botonserie.setHorizontalTextPosition(SwingConstants.RIGHT);
		botonserie.setFont(new Font("Times New Roman", Font.BOLD, NUMERO_FONT));
		add(botonserie);
		
		
		botonmono = new JButton("Procesamiento lotes: Monomodo");
		botonmono.setToolTipText("Procesamiento lotes: Monomodo");
		botonmono.setBorder(new LineBorder(Color.BLACK));
		//botonmono.addActionListener(controller);
		botonmono.setActionCommand(Constantes.C_MENU_ITEM_MONOMODO);
		botonmono.setBackground(Color.decode("#9FB0BB"));
		botonmono.setFocusPainted(false);
		botonmono.setForeground(Color.BLACK);
		botonmono.setHorizontalTextPosition(SwingConstants.RIGHT);
		botonmono.setFont(new Font("Times New Roman", Font.BOLD, NUMERO_FONT));
		add(botonmono);
		
		
		botonmulti = new JButton("Procesamiento lotes: Multimodo");
		botonmulti.setToolTipText("Procesamiento lotes: Multimodo");
		botonmulti.setBorder(new LineBorder(Color.BLACK));
		//botonmulti.addActionListener(controller);
		botonmulti.setActionCommand(Constantes.C_MENU_ITEM_MULTIMODO);
		botonmulti.setBackground(Color.decode("#9FB0BB"));
		botonmulti.setFocusPainted(false);
		botonmulti.setForeground(Color.BLACK);
		botonmulti.setHorizontalTextPosition(SwingConstants.RIGHT);
		botonmulti.setFont(new Font("Times New Roman", Font.BOLD, NUMERO_FONT));
		add(botonmulti);
		
		
		botontiempoCompartido = new JButton("Procesamiento Tiempo Compartido");
		botontiempoCompartido.setToolTipText("Procesamiento Tiempo Compartido");
		botonmulti.setBorder(new LineBorder(Color.BLACK));
		//botontiempoCompartido.addActionListener(controller);
		botontiempoCompartido.setActionCommand(Constantes.C_MENU_ITEM_TIEMPO_COMPARTIDO);
		botontiempoCompartido.setBackground(Color.decode("#9FB0BB"));
		botontiempoCompartido.setFocusPainted(false);
		botontiempoCompartido.setForeground(Color.BLACK);
		botontiempoCompartido.setHorizontalTextPosition(SwingConstants.RIGHT);
		botontiempoCompartido.setFont(new Font("Times New Roman", Font.BOLD, NUMERO_FONT));
		add(botontiempoCompartido);
		
	}

}
