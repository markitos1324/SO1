package model;

public class Proceso {

	private int tiempoEsperado; //Tiempo en el que el proceso deberia de terminar
	private String nombre;
	
	public Proceso(int tiempoEjecucion, String nombre) {
		this.tiempoEsperado = tiempoEjecucion;
		this.nombre = nombre;
	}

	public int getTiempoEsperado() {
		return tiempoEsperado;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return "Tiempo Esperado: " + tiempoEsperado + ", Nombre: " + nombre;
	}

}