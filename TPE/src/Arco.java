public class Arco<T> {
	private int verticeOrigen;
	private int verticeDestino;
	private T etiqueta;

	public Arco(int origen, int destino, T etiqueta) {
		this.verticeDestino = destino;
		this.verticeOrigen = origen;
		this.etiqueta = etiqueta;

	}


	public Arco() {
		this.verticeDestino = 0;
		this.verticeOrigen = 0;
		this.etiqueta = null;
	}
	
	
	
	public int getVerticeOrigen() {
		return verticeOrigen;
	}

	public int getVerticeDestino() {
		return verticeDestino;
	}

	public T getEtiqueta() {
		return etiqueta;
	}

	@Override
	public String toString() {
		return "Arco  Origen: " + verticeOrigen + " Destino: " + verticeDestino + " etiqueta: " + etiqueta + "  ";
	}

	public boolean equals(Arco<T> arco) {
		if ((this.verticeDestino == arco.verticeDestino) && (this.verticeOrigen == arco.verticeOrigen)) {
			return true;
		} else {
			return false;
		}

	}
}