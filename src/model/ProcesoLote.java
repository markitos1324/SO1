package model;

public class ProcesoLote extends MyThread{

	private int tiempoDeSue�o;
	
	private String nombre;
	private int numeroAcciones;
	private Boolean seAcabo;

	private Cronometro cronometro;
	
	public ProcesoLote(String nombre, int numeroAcciones) {
		this.nombre = nombre;
		this.numeroAcciones = numeroAcciones;
		this.cronometro = new Cronometro();
		this.seAcabo = false;
		this.tiempoDeSue�o = 100;
	}

	/**
	 * metodo encargado del hilo del proceso iniciando desde la primera
	 * accion y va avanzando hasta terminar el total de acciones
	 */
	@Override
	void executeTask() {
			System.out.println("Inicia proceso: " + nombre);
			cronometro.start(); // Un cronometro para ir teniendo una idea del tiempo que duro
			for (int i = 0; i < numeroAcciones; i++) {
				System.out.println("Nombre: " + nombre + ". Accion numero: " + i);
				try {
					Thread.sleep(tiempoDeSue�o); // Una pausa para evitar que mi pc lo acabe en 80 milisegundos :'(
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			cronometro.stop();
			System.out.println(">>>>>>>> Terminando proceso: " + nombre + ". Total de Tiempo: " + cronometro.getTotalTime());
			seAcabo = true;
			stop();
	}
	
	public void setTiempoDeSue�o(int tiempoDeSue�o) {
		this.tiempoDeSue�o = tiempoDeSue�o;
	}
	
	@Override
	public String toString() {
		return "ProcesoLote [nombre=" + nombre + ", numeroAcciones=" + numeroAcciones + "]";
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

	public int getNumeroAcciones() {
		return numeroAcciones;
	}
	
	public Boolean getSeAcabo() {
		return seAcabo;
	}

	public void resumeCrono() {
		cronometro.resume();
	}
	
	public void pauseCrono() {
		cronometro.pause();
	}
}