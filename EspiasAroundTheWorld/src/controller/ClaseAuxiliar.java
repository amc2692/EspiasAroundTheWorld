package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import grafos.Arista;
import grafos.Grafo;

public class ClaseAuxiliar {
	
	
	private static ArrayList<Integer> verticesVisitados; 
	private static ArrayList<Integer> listaDeVertices;
	

	
	
	public static Set<Integer> verticesAlcanzables(Grafo grafo, int vertice) {
		Set<Integer> setAlcanzables = new HashSet<Integer>();
		listaDeVertices = new ArrayList<Integer>();
		listaDeVertices.add(vertice);
		verticesVisitados = new ArrayList<Integer>();
		while (listaDeVertices.size() > 0) {
			verticesVisitados.add(listaDeVertices.get(0));
			setAlcanzables.add(listaDeVertices.get(0));
			agregarVecinosPendientes(grafo, listaDeVertices.get(0));
			listaDeVertices.remove(0);
		}
		return setAlcanzables;
	}
	
	public static Set<Integer> verticesAlcanzablesVerticeRandom(Grafo grafo) {
		Set<Integer> setAlcanzables = new HashSet<Integer>();
		listaDeVertices = new ArrayList<Integer>();
		verticesVisitados = new ArrayList<Integer>();
		int i = 0;
		for(Integer idVertice: grafo.getListaDeVertices().keySet()) {
			listaDeVertices.add(idVertice);
			i++;
			if(i == 1) {
				break;
			}
		}
		while (listaDeVertices.size() > 0) {
			verticesVisitados.add(listaDeVertices.get(0));
			setAlcanzables.add(listaDeVertices.get(0));
			agregarVecinosPendientes(grafo, listaDeVertices.get(0));
			listaDeVertices.remove(0);
		}
		return setAlcanzables;
	}
	
	
	
	private static void agregarVecinosPendientes(Grafo grafo, int idVertice) {
		if(grafo.getListaDeVertices().containsKey(idVertice)) {
			for (Integer idVerticeVecino : grafo.getListaDeVertices().get(idVertice).getListaDeVecinos()) {
				if (!verticesVisitados.contains(idVerticeVecino) && !listaDeVertices.contains(idVerticeVecino)) {
					listaDeVertices.add(idVerticeVecino);
					verticesVisitados.add(idVerticeVecino);
				}
			}
		}
	}
	
	
	
	public static boolean esGrafoConexo(Grafo grafo) {
		return grafo.getListaDeVertices().size() == verticesAlcanzablesVerticeRandom(grafo).size() ;
		
	}
	
	
	//devuelve un set de aristas alcanzables a partir de un set de vertices
	public static Set<Arista> alcanzablesDeUnSubGrafo(Grafo grafo, Set<Integer> verticesSubGrafo){
		Set<Arista> alcanzables = new HashSet<Arista>();
		for(Integer idVertice : verticesSubGrafo) {
			alcanzables.addAll(grafo.getAristasVecinos(idVertice));
		}
		return alcanzables;
	}
	
	//devuelve un set de aristas alcanzables de un vertice
	public static Set<Arista> alcanzablesDeUnSubGrafo(Grafo grafo, int idVertice){
		Set<Arista> alcanzables = new HashSet<Arista>();
		alcanzables.addAll(grafo.getAristasVecinos(idVertice));
		return alcanzables;
	}
	
	
	//devuelve true o false, si el vertice destino se encuentra en los alcanzables del vertice origen
	public static boolean seFormaCircuito(Grafo subGrafo, Set<Arista> VerticeOrigen, Set<Arista> VerticeDestino) {
		for(Arista a: VerticeDestino) {
			if(VerticeDestino.contains(a)) {
				return true;
			}
		}
		
		return false;
	}
	
	//devuelve true o false, si el vertice destino se encuentra en los alcanzables del vertice origen
	public static boolean formaCircuito(Grafo subGrafo, int idVerticeOrigen, int idVerticeDestino) {	
		return verticesAlcanzables(subGrafo, idVerticeOrigen).contains(idVerticeDestino) ||
				verticesAlcanzables(subGrafo, idVerticeDestino).contains(idVerticeOrigen);
	}
	
	
	public static void marcarAristasFromGrafo(Grafo grafo, JMapViewer mapa) {
		mapa.removeAllMapPolygons();
		for(Arista arista: grafo.getArrayDeAristasOrdenado()) {	
			Coordinate origen = getCoordenadasFromUbicacion(arista.getOrigen().getUbicacion());
			Coordinate destino = getCoordenadasFromUbicacion(arista.getDestino().getUbicacion());
			ArrayList<Coordinate> ruta = new ArrayList<Coordinate>();
			// MAPPOLYGONIMPL UTILIZA TRES COORDENADAS PARA CREAR UN POLIGONO
			// PARA CREAR UNA LINEA ENTRE DOS COORDENADAS
			// SE LE DEBE PASAR UN ARREGLO DONDE SE REPITA UNA COORDENADA CUALQUIERA
			Color color = obtenerColorPorPeso(arista.getPeso());
			ruta.add(origen);
			ruta.add(destino);
			ruta.add(destino);
			MapPolygonImpl linea = new MapPolygonImpl(ruta);
			linea.setColor(color);
			mapa.addMapPolygon(linea);
		}
	}
	
	
	
	private static void marcarUnaUbicacion(String vertice, Ubicacion ubicacion, JMapViewer mapa) {
		Coordinate coord = getCoordenadasFromUbicacion(ubicacion);
		MapMarker marker = new MapMarkerDot(vertice, coord);
		marker.getStyle().setBackColor(Color.RED);
		marker.getStyle().setColor(Color.orange);
		mapa.addMapMarker(marker);
	}
	
	public static void marcarUbicacionesFromGrafo(Grafo grafo, JMapViewer mapa) {
		for (Integer idVertice : grafo.getListaDeVertices().keySet()) {
			String nombreVertice = grafo.getListaDeVertices().get(idVertice).getNombre();
			Ubicacion ub = grafo.getListaDeVertices().get(idVertice).getUbicacion();
			marcarUnaUbicacion(nombreVertice, ub, mapa);
		}
	}
	
	public static void marcarUbicacionesAndAristas(Grafo grafo, JMapViewer mapa) {
		marcarUbicacionesFromGrafo(grafo, mapa);
		marcarAristasFromGrafo(grafo, mapa);
	}
	
	
	private static Color obtenerColorPorPeso(int peso) {
		// El color verde (0, 255, 0) en el extremo más bajo (peso = 0)
		// El color rojo (255, 0, 0) en el extremo más alto (peso = 10)
		int rojo = (int) (255 * (peso / 1000.0)); // Incrementa el componente rojo
		int verde = 255 - rojo; // Disminuye el componente verde
		return new Color(rojo, verde, 0);
	}
	
	
	private static Coordinate getCoordenadasFromUbicacion(Ubicacion ub) {
		switch (ub) {
		case BUENOS_AIRES:
			return new Coordinate(-34.60, -58.44);
		case CATAMARCA:
			return new Coordinate(-28.45,-65.78);
		case CHACO:
			return new Coordinate(-27.46, -58.98);
		case CHUBUT:
			return new Coordinate(-42.63,-63.97);
		case CORDOBA:
			return new Coordinate(-31.41,-64.18);
		case CORRIENTES:
			return new Coordinate(-28.66, -57.63);
		case ENTRE_RIOS:
			return new Coordinate(-31.94,-60.53);
		case FORMOSA:
			return new Coordinate(-26.18,-58.17);
		case JUJUY:
			return new Coordinate(-24.19,-65.29);
		case LA_PAMPA:
			return new Coordinate(-35.06,-63.29);
		case LA_RIOJA:
			return new Coordinate(-30.10,-66.53);
		case MISIONES:
			return new Coordinate(-27.36,-55.89);
		case MENDOZA:
			return new Coordinate(-32.88,-68.78);
		case NEUQUEN:
			return new Coordinate(-38.95,-68.05);
		case RIO_NEGRO:
			return new Coordinate(-40.02,-65.38);
		case SALTA:
			return new Coordinate(-24.78,-65.41);
		case SANTA_CRUZ:
			return new Coordinate(-49.58,-72.41);
		case SANTA_FE:
			return new Coordinate(-31.64,-60.70);
		case SANTIAGO_DEL_ESTERO:
			return new Coordinate(-27.78,-63.25);
		case SAN_JUAN:
			return new Coordinate(-31.52,-68.41);
		case SAN_LUIS:
			return new Coordinate(-32.93,-65.53);
		case TIERRA_DEL_FUEGO:
			return new Coordinate(-54.93, -68.28);
		case TUCUMAN:
			return new Coordinate(-26.82,-65.22);
		case ARGENTINA:
			return new Coordinate(-34.99, -64.96);
		case AUSTRALIA:
			return new Coordinate(-24.77, 134.75);
		case BRASIL:
			return new Coordinate(-10.33, -53.2);
		case CHINA:
			return new Coordinate(35.00, 104.99);
		case EGIPTO:
			return new Coordinate(26.25, 29.26);
		case USA:
			return new Coordinate(39.78, -100.44);
		case INGLATERRA:
			return new Coordinate(52.53, -1.26);
		case MEXICO:
			return new Coordinate(19.43, -99.13);
		case JAPON:
			return new Coordinate(36.57, 139.23);
		case RUSIA:
			return new Coordinate(64.68, 97.74);

		default:
			break;
		}
		return null;
	}
	
	
}


	
