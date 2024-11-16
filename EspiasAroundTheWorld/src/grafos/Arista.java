package grafos;

public class Arista implements Comparable<Arista> {
	private final Vertice origen;
	private final Vertice destino;
	private final int peso;

	public Arista(Vertice origen, Vertice destino, int peso) {
		verificarParametros(origen, destino, peso);
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
	}

	public Vertice getOrigen() {
		return origen;
	}

	public Vertice getDestino() {
		return destino;
	}

	public int getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return "{origen: "+ origen.getId() + ", destino: " + destino.getId() + ", peso: " + peso + "}";
	}

	@Override
	public int compareTo(Arista otra) {
		return Integer.compare(this.peso, otra.peso);
	}

	private void verificarParametros(Vertice verticeOrigen, Vertice verticeDestino, int peso) {
		if(verticeOrigen == null) {
			throw new RuntimeException("El vertice origen es null");
		}
		if(verticeDestino == null ) {
			throw new RuntimeException("El vertice destino es null");
		}
		if (peso <= 0) {
			throw new IllegalArgumentException("El peso de la arista no debe ser negativo: " + verticeOrigen + ", " + verticeDestino + ", " + peso);
		}
	}
	
	
	
}
