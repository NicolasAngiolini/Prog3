import java.util.LinkedList;

public class Vertice<T> {
	protected int verticeId;
	private LinkedList<Arco<T>> arcos;
	
	public Vertice(int verticeId) {					
		this.verticeId = verticeId;
		this.arcos = new LinkedList<Arco<T>>();
	}
	
	public int getVerticeId() {				
		return verticeId;
	}

	public LinkedList<Arco<T>> getArcos() {	
		return arcos;
	}
	
	public void agregarArco(int vertice, T etiqueta) {			
		Arco<T> arco = new Arco<T>(this.verticeId, vertice, etiqueta);
		if(!arcos.contains(arco)) {
			this.arcos.add(arco);
		}
	}

	public void borrarArco(int idVertice) {					
		for(Arco<T> a: arcos) {
			if(a.getVerticeDestino()==idVertice) {
				arcos.remove(a);
			}
		}
	}
	
	public int cantidadArcos() {			
		return this.arcos.size();
	}
	
	public boolean existeArco(int verticeId2) {			
		for(Arco<T> a: arcos) {
			if(a.getVerticeDestino() == verticeId2) {
				return true;
			}
		}
		return false;
	}

	protected Arco<T> obtenerArco(int verticeId2) {		
		for(Arco<T> a: arcos) {
			if(a.getVerticeDestino() == verticeId2) {
				return a;
			}
		}
		return null;
	}
}
