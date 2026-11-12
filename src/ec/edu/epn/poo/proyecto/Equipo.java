package ec.edu.epn.poo.proyecto;

public class Equipo { 

	// Atributos privados 

	private String idEquipo; 
	private String nombre; 
	private String categoria; 
	private String estado; 
	private int horasUso; 

 
	// Constructor por defecto 
	
	public Equipo() { 
	this.estado = "DISPONIBLE"; 
	this.horasUso = 0; 
	
	} 

 

	// Constructor sobrecargado con validaciones iniciales 
	
	public Equipo(String idEquipo, String nombre, String categoria) { 
	this.setIdEquipo(idEquipo); 
	this.setNombre(nombre); 
	this.setCategoria(categoria); 
	this.estado = "DISPONIBLE"; 
	this.horasUso = 0; 
	
	} 

 

	// Getters y Setters con validación 
	
	public String getIdEquipo() { 
	return idEquipo; 
	
	} 

 

	public void setIdEquipo(String idEquipo) { 
	if (idEquipo != null && !idEquipo.trim().isEmpty()) { 
	this.idEquipo = idEquipo.trim().toUpperCase(); 
	} else { 
	System.err.println("Error: El ID del equipo no puede ser vacío."); 
		} 
	} 

 

	public String getNombre() { 
	return nombre; 
	} 

 

	public void setNombre(String nombre) { 
	if (nombre != null && !nombre.trim().isEmpty()) { 
	this.nombre = nombre.trim(); 
	} else { 
	System.err.println("Error: El nombre del equipo no puede ser nulo."); 
		} 	
	} 

 

	public String getCategoria() { 
	return categoria; 
	} 

 

	public void setCategoria(String categoria) { 
	if (categoria != null && !categoria.trim().isEmpty()) { 
	this.categoria = categoria.trim(); 
	} else { 
	this.categoria = "GENERAL"; 
		} 
	} 


	public String getEstado() { 
	return estado; 
	} 

 

	public void setEstado(String nuevoEstado) { 
	if (nuevoEstado != null) { 
	String est = nuevoEstado.trim().toUpperCase(); 
	if (est.equals("DISPONIBLE") || est.equals("PRESTADO") || est.equals("MANTENIMIENTO")) { 
	this.estado = est; 
	return; 
			} 
		} 
	System.err.println("Error: Estado inválido. Use DISPONIBLE, PRESTADO o MANTENIMIENTO."); 
	} 

 

	public int getHorasUso() { 
	return horasUso; 
	} 

 

	public void setHorasUso(int horasUso) { 
	if (horasUso >= 0) { 
	this.horasUso = horasUso; 
	} else { 
	System.err.println("Error: Las horas de uso acumuladas no pueden ser negativas."); 
		} 
	} 

 

	// Métodos de comportamiento 
	
	public void registrarUso(int horas) { 
	if (horas > 0) { 
	this.horasUso += horas; 
		} 
	} 

 
	public boolean estaDisponible() { 
	return "DISPONIBLE".equalsIgnoreCase(this.estado); 
	} 
	
	
	@Override 
	public String toString() { 
	return "Equipo [ID=" + idEquipo + ", Nombre=" + nombre + ", Categoria=" + categoria + ", Estado=" + estado +  ", HorasUso=" + horasUso + "]"; 
		} 
	} 
