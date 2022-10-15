import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class ServicioCaminos {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;

	protected HashMap<Integer, String> colores;

	// Servicio caminos
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
		this.colores = new HashMap<>();

	}

	public ArrayList<ArrayList<Integer>> caminos() {
		for (Iterator<Integer> vertices = this.grafo.obtenerVertices(); vertices.hasNext();) {
			Integer vertice = (Integer) vertices.next();
			colores.put(vertice, "blanco");
		}
		
		return encontrarCaminos(origen, destino, lim);
	}

	private ArrayList<ArrayList<Integer>> encontrarCaminos(int verticeActual, int destino, int lim) {
			colores.put(verticeActual, "amarillo");
			ArrayList<ArrayList<Integer>> salida = new ArrayList<ArrayList<Integer>>();
			if (lim > -1) {
			if (verticeActual == destino) {
				ArrayList<Integer> caminoUnico = new ArrayList<Integer>();
				caminoUnico.add(verticeActual);
				salida.add(caminoUnico);
				colores.put(verticeActual, "blanco");
				return salida;
			} else {
				for (Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(verticeActual); adyacentes.hasNext();) {
					Integer adyacente = (Integer) adyacentes.next();
					if (colores.get(adyacente).equals("blanco")) {
						ArrayList<ArrayList<Integer>> caminos = encontrarCaminos(adyacente, destino, --lim);
						for (ArrayList<Integer> camino : caminos) {
							if (!camino.isEmpty()) {
								ArrayList<Integer> caminoCompleto = new ArrayList<Integer>();
								caminoCompleto.add(verticeActual);
								caminoCompleto.addAll(camino);
								salida.add(caminoCompleto);
							}
						}
					}
				}
				colores.put(verticeActual, "blanco");
				return salida;
			}
		}
		else {
			if(!salida.isEmpty())
			salida.remove(salida.size()-1);
			return salida;
		}
	}
}