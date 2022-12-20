package modelo;

public class Centro {
	String nombre;
	int nAlumnos;

	public Centro(String nombre, int nAlumnos) {
		this.nombre = nombre;
		this.nAlumnos = nAlumnos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getnAlumnos() {
		return nAlumnos;
	}

	public String getnAlumnosString() {
		return Integer.toString(nAlumnos);
	}

	public void setnAlumnos(int nAlumnos) {
		this.nAlumnos = nAlumnos;
	}
	
	@Override
	public String toString() {
		return nombre + " - " + nAlumnos;
	}

}
