package algoritmos;

import java.util.ArrayList;

import grafos.Arista;
import grafos.Grafo;
import grafos.UnionFind;

public class Kruskal {

	public static Grafo crearKruskal(Grafo grafoOriginal, ArrayList<Arista> aristas) {
		aristas.sort(null);
		Grafo nuevoGrafo = new Grafo();
		UnionFind uf = new UnionFind(grafoOriginal.tamanio());

		for (Arista arista : aristas) {
			int vert1 = arista.getOrigen().getId();
			int vert2 = arista.getDestino().getId();
			nuevoGrafo.crearVertice(arista.getOrigen().getNombre(), arista.getOrigen().getUbicacion());
			nuevoGrafo.crearVertice(arista.getDestino().getNombre(), arista.getDestino().getUbicacion());
			if (uf.find(vert1) != uf.find(vert2)) {
				uf.union(vert1, vert2);
				nuevoGrafo.agregarArista(arista);
			}
		}
		return nuevoGrafo;
	}
}
