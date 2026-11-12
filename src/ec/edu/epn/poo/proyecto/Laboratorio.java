package ec.edu.epn.poo.proyecto;
import java.util.Locale; 

public class Laboratorio { 

	 

	// Atributos encapsulados 

	private final String codigo; 

	private final String nombre; 

	private final int numeroSala; 

	private final String edificio; 

	private final int capacidadMaxima; 

	private int ocupacionActual; 

	 

	// Constructor 

	public Laboratorio(String codigo, String nombre, 

	int numeroSala, String edificio, 

	int capacidadMaxima) { 

	 

	this.codigo = codigo; 

	this.nombre = nombre; 

	this.numeroSala = numeroSala; 

	this.edificio = edificio; 

	this.capacidadMaxima = capacidadMaxima; 

	this.ocupacionActual = 0; 

	} 

	 

	// Registrar ingreso de estudiantes 

	public void registrarIngreso() { 

	 

	if (ocupacionActual < capacidadMaxima) { 

	ocupacionActual++; 

	 

	System.out.println("Ingreso de " 

	+ ocupacionActual 

	+ (ocupacionActual == 1 

	? " estudiante" 

	: " estudiantes")); 

	} else { 

	System.out.println("Ingreso estudiante " 

	+ (ocupacionActual + 1) 

	+ " fallido: capacidad maxima alcanzada, sin cupos."); 

	} 

	} 

	 

	// Registrar salida de estudiantes 

	public void registrarSalida() { 

	 

	if (ocupacionActual > 0) { 

	ocupacionActual--; 

	 

	System.out.println("Salida registrada. " 

	+ "Estudiantes actuales: " 

	+ ocupacionActual); 

	} else { 

	System.out.println("No hay estudiantes registrados."); 

	} 

	} 

	 

	// Mostrar informacion del laboratorio 

	@Override 

	public String toString() { 

	return "Laboratorio: " + nombre 

	+ "\nCodigo: " + codigo 

	+ "\nSala: " + numeroSala 

	+ "\nEdificio: " + edificio 

	+ "\nCapacidad maxima: " + capacidadMaxima 

	+ "\nOcupacion actual: " + ocupacionActual 

	+ "\nEspacios disponibles: " 

	+ (capacidadMaxima - ocupacionActual); 

	} 

	} 