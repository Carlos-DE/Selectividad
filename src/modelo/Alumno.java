package modelo;

public class Alumno {

    String nombre, apellido1, apellido2, centro, DetalleMateria;
    Integer dni;
    
    public Alumno(Integer DNI, String centro, String nombre, String apellido1, String apellido2, String DetalleMateria){
        this.nombre= nombre;
        this.dni=DNI;
        this.centro = centro;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.DetalleMateria = DetalleMateria;
    }

    public Integer getDni() {
        return dni;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getCentro() {
        return centro;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getDetalleMateria() {
        return DetalleMateria;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setDetalleMateria(String s){
        this.DetalleMateria = s;
    }
}