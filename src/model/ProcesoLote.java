package model;

import java.util.Calendar;

public class ProcesoLote extends MyThread{

	private int tiempoEsperado; //Tiempo en el que el proceso deberia de terminar en min
	private String nombre;
	private String turno;
	private Calendar horaAsignada;
	
	public ProcesoLote(int tiempoEjecucion, String nombre,String turno, Calendar horaAsignada) {
		this.tiempoEsperado = tiempoEjecucion;
		this.nombre = nombre;
		this.turno = turno;
		this.horaAsignada = horaAsignada;
	}

	@Override
	void executeTask() {
		// TODO Auto-generated method stub
		System.out.println("Acabron que soy un hilo mamalon");
	}
	
	@Override
	public String toString() {
		String hora ="Hora: "+horaAsignada.get(Calendar.HOUR_OF_DAY);
		String minutos = horaAsignada.get(Calendar.MINUTE) + " Minutos";
		String completo = hora +":"+ minutos;
		return "Proceso [tiempoEsperado= " + tiempoEsperado + ", nombre= " + nombre + ", turno= " + turno
				+ ", horaAsignada= " + completo +"]";
	}

	public int getTiempoEsperado() {
		return tiempoEsperado;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}


	public Calendar getHoraAsignada() {
		return horaAsignada;
	}


	public void setHoraAsignada(Calendar horaAsignada) {
		this.horaAsignada = horaAsignada;
	}


	public void setTiempoEsperado(int tiempoEsperado) {
		this.tiempoEsperado = tiempoEsperado;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}