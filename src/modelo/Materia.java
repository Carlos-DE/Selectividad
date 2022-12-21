package modelo;

public class Materia{

    String IdMateria;
    String tramo;

    public String getTramo() {
        return tramo;
    }

    public void setTramo(String tramo) {
        this.tramo = tramo;
    }

    public Materia() {
    	
    }
    
    public Materia(String IdMateria){
        this.IdMateria= IdMateria;
    }

    public String getIdMateria() {
        return IdMateria;
    }

    public void setIdMateria(String idMateria) {
        this.IdMateria = idMateria;
    }
}