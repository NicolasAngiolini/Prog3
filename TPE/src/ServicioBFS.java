import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class ServicioBFS {
	
	private Grafo<?> grafo;
	private HashMap<Integer,Boolean> visitados;
	
	public ServicioBFS(Grafo<?> g) {
		this.grafo = g;
		this.visitados = new HashMap<>();
	}
	
	private void iniciarEstructura() {
		for (Iterator<Integer> vertices = this.grafo.obtenerVertices(); vertices.hasNext();) {
			Integer vertice = (Integer) vertices.next();
			visitados.put(vertice, false);
		}
	}
	
	public ArrayList<Integer> bfsForest(){
		this.iniciarEstructura();
		ArrayList<Integer> resultado = new ArrayList<Integer>();	
		for (Iterator<Integer> vertices = this.grafo.obtenerVertices(); vertices.hasNext();) {
			Integer vertice = (Integer) vertices.next();
			if (!visitados.get(vertice)) {
				resultado.addAll(bfsVisit(vertice));
			}			
		}
		return resultado;
	}
	
	private ArrayList<Integer> bfsVisit(Integer origen){
		ArrayList<Integer> fila = new ArrayList<>();
		ArrayList<Integer> salida = new ArrayList<>();
		visitados.put(origen,true);
		fila.add(origen);
		salida.add(origen);
		while(!fila.isEmpty()) {
			int vertice = fila.remove(0); 
			for (Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice); adyacentes.hasNext();) {
				Integer adyacente = (Integer) adyacentes.next();
				if (!visitados.get(adyacente)) {
					visitados.put(adyacente, true);
					fila.add(adyacente);
					salida.add(adyacente);
				}				
			}
		}
		return salida;
	}
	
	
	
}
