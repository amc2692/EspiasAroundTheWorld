package grafos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import controller.Ubicacion;

public class Grafo {

	private int id;
	private HashMap<Integer, Vertice> listaDeVertices;
	private ArrayList<Arista> listaDeAristas;
	private Set<Ubicacion> ubicacionesMarcadas;

	public Grafo() {

		this.id = 0;
		this.listaDeAristas = new ArrayList<Arista>();
		this.listaDeVertices = new HashMap<Integer, Vertice>();
		this.ubicacionesMarcadas = new HashSet<Ubicacion>();
	}

	public void crearVertice(String nombre, Ubicacion ubicacion) {
		Vertice nuevoVertice = new Vertice(nombre, id, ubicacion);
		if (!listaDeVertices.containsKey(nuevoVertice.getId())) {
			listaDeVertices.put(nuevoVertice.getId(), nuevoVertice);
			ubicacionesMarcadas.add(ubicacion);
			id++;
		}

	}

	// Para grafo prim
	public void crearVertice(String nombre, int id, Ubicacion ubicacion) {
		Vertice nuevoVertice = new Vertice(nombre, id, ubicacion);
		if (!listaDeVertices.containsKey(nuevoVertice.getId())) {
			listaDeVertices.put(nuevoVertice.getId(), nuevoVertice);
		}

	}

	public void agregarArista(int idOrigen, int idDestino, int peso) {
		Arista nuevaArista = new Arista(listaDeVertices.get(idOrigen), listaDeVertices.get(idDestino), peso);
		listaDeAristas.add(nuevaArista);
		listaDeVertices.get(idOrigen).agregarArista(idDestino, nuevaArista);
		listaDeVertices.get(idDestino).agregarArista(idOrigen, nuevaArista);
	}

	public void agregarArista(Arista arista) {
		listaDeAristas.add(arista);

	}

	public void quitarArista(int idOrigen, int idDestino) {
		listaDeVertices.get(idOrigen).quitarArista(idDestino);
		listaDeVertices.get(idOrigen).quitarArista(idDestino);
	}

	public void eliminarVertice(int idVertice) {
		for (Integer id : listaDeVertices.keySet()) {
			listaDeVertices.get(id).quitarArista(idVertice);
		}
		listaDeVertices.remove(idVertice);
	}

	// devuelve una arraylist de aristas del grafo ordenadas de menor a mayor
	public List<Arista> getArrayDeAristasOrdenado() {
		return listaDeAristas.stream().sorted((a1, a2) -> a1.compareTo(a2)).toList();
	}

	public ArrayList<Integer> getArrayListDeVertices() {
		List<Integer> ret = new ArrayList<Integer>();
		for (Integer id : listaDeVertices.keySet()) {
			ret.add(id);
		}
		ret.stream().sorted(((a1, a2) -> a1.compareTo(a2))).toList();
		return (ArrayList<Integer>) ret;
	}

	public HashSet<Integer> getSetDeVertices() {
		Set<Integer> ret = new HashSet<Integer>();
		for (Integer id : listaDeVertices.keySet()) {
			ret.add(id);
		}
		return (HashSet<Integer>) ret;
	}

	public HashMap<Integer, Vertice> getListaDeVertices() {
		return listaDeVertices;
	}

	public int tamanio() {
		return listaDeVertices.size();
	}

	public ArrayList<Arista> getListaDeAristas() {
		return listaDeAristas;
	}

	public Collection<Arista> getAristasVecinos(int idVertice) {
		return listaDeVertices.get(idVertice).getAristasDelVertice().values();
	}

	public Set<Ubicacion> getUbicacionesMarcadas() {
		return ubicacionesMarcadas;
	}

	public String getNombreFromIdVertice(int idVertice) {
		return listaDeVertices.get(idVertice).getNombre();
	}

	public Ubicacion getUbicacionFromIdVertice(int idVertice) {
		return listaDeVertices.get(idVertice).getUbicacion();

	}

	public String getInfoVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Arista> getAristasFromIdVertice(int idVertice) {
		return listaDeVertices.get(idVertice).getArrayDeAristasOrdenado();

	}

	public void printAristas() {
		for (Arista a : listaDeAristas) {
			System.out.println(a);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Integer id : listaDeVertices.keySet()) {
			sb.append(listaDeVertices.get(id));
		}
		return sb.toString();

	}
}
