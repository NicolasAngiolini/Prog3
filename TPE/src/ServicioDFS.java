
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class ServicioDFS<T> {

	protected LinkedList<Integer> vertices;
	protected Grafo<T> grafo;
	protected HashMap<Integer, String> colores;

	public ServicioDFS(Grafo<T> grafo) {
		this.grafo = grafo;
	}


	
	public ArrayList<Integer> dfsForest() {		
		for (Iterator<Integer> vertices = this.grafo.obtenerVertices(); vertices.hasNext();) {
			Integer vertice = (Integer) vertices.next();
			this.colores.put(vertice,"blanco");
		}
		
		ArrayList<Integer> resultado = new ArrayList<Integer>();		
		for (Iterator<Integer> vertices = this.grafo.obtenerVertices(); vertices.hasNext();) {
			Integer vertice = (Integer) vertices.next();
			if (colores.get(vertice).equals("blanco")) {
				resultado.addAll(dfsVisit(vertice));
			}
		}		
		return resultado;
		
	}

	private ArrayList<Integer> dfsVisit(Integer vertice) {		
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		colores.put(vertice,"amarillo");
		resultado.add(vertice);		
		for (Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice); adyacentes.hasNext();) {
			Integer adyacente = (Integer) adyacentes.next();
			if (colores.get(adyacente).equals("blanco")) {
				resultado.addAll(dfsVisit(adyacente));
			}			
		}		
		colores.put(vertice,"negro");		
		return resultado;
	}
	

}
