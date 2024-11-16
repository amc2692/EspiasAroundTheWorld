package grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import controller.Ubicacion;

public class Vertice {
	
    private int id; // ID único para cada vértice
	private String nombre;
	private Ubicacion ubicacion;
	private HashMap<Integer, Arista> aristasDelVertice;
	
	public Vertice(String nombre, int id, Ubicacion ubicacion) {
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.aristasDelVertice = new HashMap<Integer, Arista>();
	}
	
	


	public void agregarArista(int idVerticeDestino, Arista arista) {
		aristasDelVertice.put(idVerticeDestino, arista);	
	}
	
	public void quitarArista(int idVerticeDestino) {
		if(aristasDelVertice.containsKey(idVerticeDestino)) {
			aristasDelVertice.remove(idVerticeDestino);
		}
	}

	public boolean contieneArista(int idVerticeDestino) {
		return aristasDelVertice.containsKey(idVerticeDestino);
	}
	
	
	public ArrayList<Arista> getArrayDeAristasOrdenado(){
		List<Arista> ret = new ArrayList<Arista>();
		for(Integer id: aristasDelVertice.keySet()) {
			ret.add(aristasDelVertice.get(id));
		}
		ret.stream().sorted(((a1,a2) -> a1.compareTo(a2))).toList();
		return (ArrayList<Arista>) ret;
	}
	
	
	
	public ArrayList<Integer> getListaDeVecinos(){
		ArrayList<Integer> arrayDeVecinos = new ArrayList<Integer>(aristasDelVertice.keySet());
		return arrayDeVecinos ;
	}

	

	public String getNombre() {
		return nombre;
	}

	public HashMap<Integer, Arista> getAristasDelVertice() {
		return aristasDelVertice;
	}


	public int getId() {
		return id;
	}
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	
	public Arista getAristaMenorPeso() {
		return getArrayDeAristasOrdenado().get(0);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Vertice: " + id + " \n");
		sb.append("Aristas: " + getArrayDeAristasOrdenado() + "\n");
		return  sb.toString();
	}
	
	
}
