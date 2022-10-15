
public class Main {

	public static void main(String[] args) {
Grafo<String> grafo = new GrafoDirigido<String>();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
		
		grafo.agregarArco(1, 2, "1-2");
		grafo.agregarArco(1, 4, "1-4");
		grafo.agregarArco(2, 3, "2-3");
		grafo.agregarArco(3, 4, "3-4");
		grafo.agregarArco(3, 2, "3-2");
		grafo.agregarArco(4, 5, "4-5");
		grafo.agregarArco(3, 3, "3-3");
		grafo.agregarArco(5, 1, "5-1");
		grafo.agregarArco(5, 6, "5-6");
		grafo.agregarArco(2, 6, "2-6");
			

		
		ServicioCaminos sc = new ServicioCaminos(grafo,1,6,3);
	
		System.out.println(sc.caminos());
		
	}

}
