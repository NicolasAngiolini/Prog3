import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer,ArrayList<Arco<T>>> vertices ;
	private Integer total_arcos;
	
	public GrafoDirigido(){ 
		this.vertices=new HashMap<Integer,ArrayList<Arco<T>>>();
		this.total_arcos=0;
	}
	
	@Override
	public void agregarVertice(int verticeId) {//O(1)
		if(!this.contieneVertice(verticeId)) {
			vertices.put(verticeId,new ArrayList<Arco<T>> ());
		}
	}

	@Override
	public void borrarVertice(int verticeId) {//O(V*a) donde v cantidad de vertices para sacar la relacion y a cantidad de arcos 
		if (this.contieneVertice(verticeId)) {
			for (Iterator<Arco<T>> iterator = vertices.get(verticeId).iterator(); iterator.hasNext();) {
				Arco<T> arco = (Arco<T>) iterator.next();
				this.borrarArco(verticeId, arco.getVerticeDestino());
				//this.borrarArco(arco.getVerticeDestino(), verticeId);
			}
			this.borrarArcosDesdeAdyacente(verticeId);
			vertices.remove(verticeId);
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {//O(1)
		if (!this.contieneVertice(verticeId1)) {
			this.agregarVertice(verticeId1);
		}
		vertices.get(verticeId1).add(new Arco<T>(verticeId1,verticeId2,etiqueta));
		total_arcos++;
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {//O(n) donde n es la cantidad de arcos.
		if (this.contieneVertice(verticeId1)) {
			for (Iterator<Arco<T>> iterator = vertices.get(verticeId1).iterator(); iterator.hasNext();) {
				Arco<T> arco = (Arco<T>)iterator.next();
				if (arco.getVerticeDestino() == verticeId2) {
					vertices.get(verticeId1).remove(arco);//Redefino el equal en la clase Arco.
					total_arcos--;
				}			
			}
		}
	}
	
	private void borrarArcosDesdeAdyacente(int verticeAdyacente) {//O(V) donde v son todos los vertices.
		for (Iterator<Integer> iterator = vertices.keySet().iterator(); iterator.hasNext();) {
			Integer vertice = (Integer) iterator.next();
			borrarArco(vertice, verticeAdyacente);					
		}
		
	}

	@Override
	public boolean contieneVertice(int verticeId) {// O(1)
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {//O(n) donde n es la cantidad de arcos. Igual que obtener arco
		
		return this.obtenerArco(verticeId1, verticeId2) != null ? true:false;
		
		/*
		if (this.contieneVertice(verticeId1)) {
			for (Iterator<Arco<T>> iterator = vertices.get(verticeId1).iterator(); iterator.hasNext();) {
				Arco<T> arco = (Arco<T>)iterator.next();
				if (arco.getVerticeDestino() == verticeId2) {
					return true;
				}			
			}
		}
		return false;
		*/
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {//O(n) donde n es la cantidad de arcos.
		if (this.contieneVertice(verticeId1)) {
			for (Iterator<Arco<T>> iterator = vertices.get(verticeId1).iterator(); iterator.hasNext();) {
				Arco<T> arco = (Arco<T>) iterator.next();
				if (arco.getVerticeDestino() == verticeId2) {
					return arco;				
				}
			}		
		}
		return null;
	}

	
	public int cantidadVertices() {//O(1)
		return vertices.size();
	}


	public int cantidadArcos() {//O(1)
		return total_arcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {// O(1)
		return vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {//O(n) donde n es la cantidad de arcos del vertice
		List<Integer> listaAdyacentes = new ArrayList<Integer>();
		for (Iterator<Arco<T>> iterator = vertices.get(verticeId).iterator(); iterator.hasNext();) {
			Arco<T> arco = (Arco<T>) iterator.next();
			listaAdyacentes.add(arco.getVerticeDestino());
		}
		return listaAdyacentes.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {//O(V) donde v son todos los vertices.
		List<Arco<T>> listaArcos = new ArrayList<Arco<T>>();
		for (Iterator<Integer> iterator = vertices.keySet().iterator(); iterator.hasNext();) {
			Integer vertice = (Integer) iterator.next();
			listaArcos.addAll(vertices.get(vertice));					
		}
		return listaArcos.iterator();
	}

	
	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {//O(1)
		return vertices.get(verticeId).iterator();
	}

}