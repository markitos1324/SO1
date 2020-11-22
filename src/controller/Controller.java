package controller;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import model.Proceso;

public class Controller {

	private ArrayList<Proceso> procesos;
	
	public Controller() {
		procesos = new ArrayList<>();
		
		procesos.add(new Proceso(60, "Cocinar","1",new GregorianCalendar(0, 0, 0, 8, 0, 0)));
		procesos.add(new Proceso(60, "lavar","2",new GregorianCalendar(0, 0, 0, 9, 0, 0)));
		procesos.add(new Proceso(60, "peinar", "3",new GregorianCalendar(0, 0, 0, 10, 0, 0)));
		try {
			EjecucionProcesos(procesos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo encargado de hacer la ejecucion en serie donde los procesos se 
	 * ejecutan uno seguido de otro con el tiempo de espera respectivo a cada
	 * uno de ellos.
	 * @param lista de procesos a ejecutar
	 * @throws InterruptedException
	 */
	public void EjecucionProcesos(ArrayList<Proceso> procesosA�adidos) throws InterruptedException{
		System.out.println("Ejecutando....");
		int totalTiempo = 0, totalEstimado = 0;
		for (Proceso proceso : procesosA�adidos) {
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
		System.out.println("El tiempo total de ejecucion de los " + procesosA�adidos.size() + " procesos fue de: " + totalTiempo + " Minutos");
		System.out.println("El tiempo estimado era de: " + totalEstimado + " minutos");
	}
	
	/**
	 * Metodo encargado de dar una "aleatoriedad" de la duracion de los
	 * procesos de esta manera poder simular procesos que tarden mas
	 * de lo esperado o menos, sea por la razon que sea
	 * @param proceso
	 * @return
	 */
	private int ProbabilidadDeCambio(Proceso proceso) {
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
}