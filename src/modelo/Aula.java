package modelo;

public class Aula {

	String id;
	int aforo;
	
	public Aula(String id, int aforo) {
		this.id = id;
		this.aforo = aforo;
	}
	
	public String getId() {
		return id;
	}
	public int getAforo() {
		return aforo;
	}
}
