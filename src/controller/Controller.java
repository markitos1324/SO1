package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import model.ProcesoSerie;
import model.ProcesoCompartido;
import model.ProcesoLote;
import view.MainFrame;


public class Controller implements ActionListener {

	private ArrayList<ProcesoSerie> procesos;
	private ArrayList<ProcesoLote> procesoLotes;
	
	//___________ main frame_______________
	
	public MainFrame  mainFrame;
	
	
	
	public Controller()  {
		mainFrame = new MainFrame();
	
		procesos = new ArrayList<>();
		procesoLotes = new  ArrayList<>();
		procesos.add(new ProcesoSerie(60, "Cocinar","1",new GregorianCalendar(0, 0, 0, 8, 0, 0)));
		procesos.add(new ProcesoSerie(60, "lavar","2",new GregorianCalendar(0, 0, 0, 9, 0, 0)));
		procesos.add(new ProcesoSerie(60, "peinar", "3",new GregorianCalendar(0, 0, 0, 10, 0, 0)));
		
		procesoLotes.add(new ProcesoLote("peinar",10));
		procesoLotes.add(new ProcesoLote("Cocinar",5));
		procesoLotes.add(new ProcesoLote("lavar",20));
		procesoLotes.add(new ProcesoLote("tejer",40));
		procesoLotes.add(new ProcesoLote("colgar",80));
		procesoLotes.add(new ProcesoLote("minar",160));
		procesoLotes.add(new ProcesoLote("ver tv",320));
		
//		EjecucionProcesosLoteMono(procesoLotes);
//		EjecucionProcesosLoteMulti(procesoLotes);
		EjecucionProcesosTiempoCompartido(procesoLotes);
		
		/*
		 //ejecucion de procesos en serie.
		try {
			EjecucionProcesosSerie(procesos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/

	
	}
	
	
	/**
	 * Metodo encargado de hacer los procesos por lotes(MultiProgramacion) en donde ejecuta
	 * todos los procesos y va ejecuntando cada uno  mostrando el proceso y
	 * la accion en la que va adicionalmente al final imprime la duracion
	 * total del proceso
	 * @param procesoLotes
	 */
	public void EjecucionProcesosTiempoCompartido(ArrayList<ProcesoLote> procesoLotes) {
		ProcesoCompartido pc = new ProcesoCompartido("pc", procesoLotes);
		pc.start(); // Ejecuta todos los hilos iniciando los procesos
		System.out.println("------------------------------------");
	}
	
	/**
	 * Metodo encargado de hacer los procesos por lotes(MonoProgramacion) en donde ejecuta
	 * todos los procesos y va ejecuntando cada uno  mostrando el proceso y
	 * la accion en la que va adicionalmente al final imprime la duracion
	 * total del proceso
	 * @param procesoLotes
	 */
	public void EjecucionProcesosLoteMono(ArrayList<ProcesoLote> procesoLotes) {
		for (ProcesoLote procesoLote : procesoLotes) {
			procesoLote.start(); // Ejecuta todos los hilos iniciando los procesos
			procesoLote.join(); // Espera a que todos los hilos finalicen
		}
		System.out.println("------------------------------------");
		System.out.println("El tiempo total de ejecucion es: " + TiempoTotalEjecucion());
	}
	
	/**
	 * Metodo encargado de hacer los procesos por lotes(MultiProgramacion) en donde ejecuta
	 * todos los procesos y va ejecuntando cada uno  mostrando el proceso y
	 * la accion en la que va adicionalmente al final imprime la duracion
	 * total del proceso
	 * @param procesoLotes
	 */
	public void EjecucionProcesosLoteMulti(ArrayList<ProcesoLote> procesoLotes) {
		for (ProcesoLote procesoLote : procesoLotes) {
			procesoLote.start(); // Ejecuta todos los hilos iniciando los procesos
		}
		for (ProcesoLote procesoLote : procesoLotes) {
			procesoLote.join(); // Espera a que todos los hilos finalicen
		}
		System.out.println("------------------------------------");
		System.out.println("El tiempo total de ejecucion es: " + TiempoTotalEjecucion());
	}
	
	/**
	 * Metodo encargado de darnos el tiempo total de ejecucion dandonos
	 * el tiempo total de todas las ejecuciones
	 * @return
	 */
	private String TiempoTotalEjecucion() {
		int min = 0, sec = 0, milisec = 0;
		for (ProcesoLote procesoLote : procesoLotes) {
			String[] tiempo = procesoLote.getTotalTime().split(":");
			min += Integer.parseInt(tiempo[0]);
			sec += Integer.parseInt(tiempo[1]);
			milisec += Integer.parseInt(tiempo[2]);
			if (milisec >= 1000) {
				milisec = milisec - 1000;
				sec++;
			}else if (sec >= 60) {
				sec = sec - 60;
				min++;
			}
		}
		
		return min + ":" + sec + ":" + milisec;
	}
	
	/**
	 * Metodo encargado de hacer la ejecucion en serie donde los procesos se 
	 * ejecutan uno seguido de otro con el tiempo de espera respectivo a cada
	 * uno de ellos.
	 * @param lista de procesos a ejecutar
	 * @throws InterruptedException
	 */
	public void EjecucionProcesosSerie(ArrayList<ProcesoSerie> procesosAñadidos) throws InterruptedException{
		System.out.println("Ejecutando....");
		int totalTiempo = 0, totalEstimado = 0;
		for (ProcesoSerie proceso : procesosAñadidos) {
			System.out.println("---------------------------------");
			System.out.println(proceso.toString());
			totalEstimado += proceso.getTiempoEsperado();
			int tiempoGastado = ProbabilidadDeCambio(proceso); //aqui hacemos un calculo para determinar cuanto gasto al final el proceso
			if (tiempoGastado <= proceso.getTiempoEsperado()) { //Aqui se elige el caso cuando el proceso tarda menos o igual al tiempo esperado
				Thread.sleep(proceso.getTiempoEsperado()*1000); // apesar de que tarde menos el tiempo de espera seguira siendo el mismo
				System.out.println( (tiempoGastado < proceso.getTiempoEsperado()) ? "Felicidades el programa gasto menos de lo que debia, el proceso tardo:" + tiempoGastado + " min \nTotal de tiempo Gastado: " + proceso.getTiempoEsperado() + " Min": "Total de tiempo Gastado: " + tiempoGastado + " Min");
				totalTiempo += proceso.getTiempoEsperado();
			}else { // para el caso en el que tarde mas hay si el tiempo aumenta
				Thread.sleep(tiempoGastado*1000); // se refleja el aumento de tiempo del proceso
				System.out.println("El programa demoro mas de lo esperado");
				System.out.println("Total de tiempo Gastado: " + tiempoGastado + " min");
				totalTiempo += tiempoGastado;
			}
		}
		System.out.println("Finalizado....");
		System.out.println("El tiempo total de ejecucion de los " + procesosAñadidos.size() + " procesos fue de: " + totalTiempo + " Minutos");
		System.out.println("El tiempo estimado era de: " + totalEstimado + " minutos");
	}
	
	/**
	 * Metodo encargado de dar una "aleatoriedad" de la duracion de los
	 * procesos de esta manera poder simular procesos que tarden mas
	 * de lo esperado o menos, sea por la razon que sea
	 * @param proceso
	 * @return
	 */
	private int ProbabilidadDeCambio(ProcesoSerie proceso) {
		int aleatoreo = (int) (Math.round(Math.random() * (101 - 1) + 1));
		int minmaxominmenos = (int) (Math.round(Math.random() * (51 - 1) + 1));
		
		System.out.println(aleatoreo);
		if (aleatoreo>33 && aleatoreo <=66) {
			return (int) (proceso.getTiempoEsperado() - minmaxominmenos );// aqui se le restan los minutos dependiendo de la probabilidad con un numero aleatorio entre 1 y 60
		}else if (aleatoreo < 33) {
			return (int) (proceso.getTiempoEsperado() + minmaxominmenos );// aqui se le suman los min dependiendo de la probabilidad
		}else{
			return proceso.getTiempoEsperado();
		}
	}
//_______________________________________________________________________________________________________________________________________
	/*Action performed**/

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
				
			

			
		}
		
	}
}