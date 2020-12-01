package model;

import java.util.ArrayList;

public class ProcesoCompartido extends MyThread{

	private String nombre;
	private volatile ArrayList<ProcesoLote> procesoLotes;
	private Cronometro cronometro;

	public ProcesoCompartido(String nombre, ArrayList<ProcesoLote> procesoLotes) {
		this.nombre = nombre;
		this.procesoLotes = procesoLotes;
		this.cronometro = new Cronometro();
	}

	/**
	 * metodo encargado de iniciar todos los parametros principales de los hilos
	 */
	
	@Override
	void executeTask() {
		System.out.println("Inicia tiempo compartido");
		cronometro.start(); // Un cronometro para ir teniendo una idea del tiempo que duro
		iniciarHilos(); // Inicia todos los hilos para asi tenerlos en estado listo
		while (procesoLotes.size() > 0) {
			System.out.println("Procesos actuales: " +procesoLotes.size());
			ejecucionProcesos(); // Aqui ocurre la magia
		}
		cronometro.stop();
		System.out.println(">>>>>>>> Terminando tiempo compartido :). Total de Tiempo: " + cronometro.getTotalTime());
		stop();
	}

	/**
	 * Metodo encargado de dejar "Ready" los procesos
	 */
	private void iniciarHilos() {
		for (ProcesoLote procesoLote : procesoLotes) {
			procesoLote.setTiempoDeSueño(50);
			procesoLote.start();
			procesoLote.pause();
		}
	}
	
	/**
	 * Metodo en el que se va a tendiendo proceso por proceso segun el tiempo establesido
	 */
	private synchronized void ejecucionProcesos() {
		for (ProcesoLote procesoLote : procesoLotes) {
			System.out.println("--------------------------------------------------");
			procesoLote.resume();
			procesoLote.resumeCrono();
			try {
				Thread.sleep(2000); // Tiempo de espera
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			procesoLote.pause();
			procesoLote.pauseCrono();
			if (procesoLote.getSeAcabo()) { // Aqui vamos eliminando todos los procesos que ya finalizaron
				System.out.println("ELIMINANDO PROCESO: " + procesoLote.getNombre());
				procesoLotes.remove(procesoLote);
				break;
			}
		}
	}

	public String getTotalTime() {
		return cronometro.getTotalTime();
	}

	public int getTotalInMiliseconds() {
		return cronometro.getTotalInMiliseconds();
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<ProcesoLote> getProcesoLotes() {
		return procesoLotes;
	}
}