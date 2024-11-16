package algoritmos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import controller.ClaseAuxiliar;
import grafos.Arista;
import grafos.Grafo;
import grafos.Vertice;

public class Prim {

	static Arista aristaMenorPeso;
	static Vertice verticeOrigen;
	static Vertice verticeDestino;
	static Grafo grafoPrim;
	static HashSet<Integer> verticesVisitados;
	private static ArrayList<Arista> aristasDisponibles;
	private static ArrayList<Arista> aristasVisitadas;

	public static Grafo crearGrafoPrim(Grafo grafoOriginal) {
		inicializarGrafoPrim(grafoOriginal);
		while (grafoPrim.getListaDeVertices().size() < grafoOriginal.getListaDeVertices().size()) {
			while (verticesDestinoOrigenFormanCircuito(grafoPrim, verticeOrigen, verticeDestino)) {
				aristasDisponibles.remove(0);
				actualizarVerticesAndArista();
			}
			agregarVerticesAndAristasToGrafoPrim();
			actualizarGrafoPrim();
			agregarNuevasAristasAndOrdenar(grafoOriginal);
			actualizarVerticesAndArista();
		}
		return grafoPrim;
	}

	private static boolean verticesDestinoOrigenFormanCircuito(Grafo grafoPrim2, Vertice verticeOrigen,
			Vertice verticeDestino) {
		return ClaseAuxiliar.formaCircuito(grafoPrim, verticeOrigen.getId(), verticeDestino.getId());
	}

	private static void agregarVerticesAndAristasToGrafoPrim() {
		verticesVisitados.add(verticeOrigen.getId());
		verticesVisitados.add(verticeDestino.getId());
		aristasVisitadas.add(aristaMenorPeso);

	}

	private static void inicializarGrafoPrim(Grafo grafoOriginal) {
		grafoPrim = new Grafo();
		aristasVisitadas = new ArrayList<Arista>();
		aristasDisponibles = new ArrayList<Arista>();
		verticesVisitados = new HashSet<Integer>();
		verticesVisitados.add(grafoOriginal.getArrayListDeVertices().get(0));
		agregarNuevasAristasAndOrdenar(grafoOriginal);
		actualizarVerticesAndArista();
	}

	private static void actualizarGrafoPrim() {
		grafoPrim.crearVertice(verticeOrigen.getNombre(), verticeOrigen.getId(), verticeOrigen.getUbicacion());
		grafoPrim.crearVertice(verticeDestino.getNombre(), verticeDestino.getId(), verticeDestino.getUbicacion());
		grafoPrim.agregarArista(verticeOrigen.getId(), verticeDestino.getId(), aristaMenorPeso.getPeso());
	}

	private static void actualizarVerticesAndArista() {
		aristaMenorPeso = aristasDisponibles.get(0);
		verticeDestino = aristaMenorPeso.getDestino();
		verticeOrigen = aristaMenorPeso.getOrigen();
	}

	public static void agregarNuevasAristasAndOrdenar(Grafo grafoOriginal) {
		for (Integer idVerticeVisitado : verticesVisitados) {
			for (Arista arista : grafoOriginal.getAristasFromIdVertice(idVerticeVisitado)) {
				if (!aristasDisponibles.contains(arista)) {
					aristasDisponibles.add(arista);
				}
			}
		}
		ordenarAristasMenorToMayor();
	}

	private static void ordenarAristasMenorToMayor() {
		List<Arista> copia = new ArrayList<Arista>();
		for (Arista a : aristasDisponibles) {
			copia.add(a);
		}
		copia = copia.stream().sorted((a, b) -> a.compareTo(b)).toList();
		aristasDisponibles = new ArrayList<Arista>();
		for (Arista a : copia) {
			aristasDisponibles.add(a);
		}
	}

}
