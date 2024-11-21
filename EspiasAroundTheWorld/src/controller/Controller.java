package controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.swing.JOptionPane;


import algoritmos.Kruskal;
import algoritmos.Prim;
import grafos.Grafo;
import view.VentanaPrincipal;

public class Controller {

	private VentanaPrincipal interfazUsuario;
	private Grafo grafo;
	private LocalDateTime start;
	private LocalDateTime end;
	
	public Controller() {
		this.grafo = new Grafo();
		this.interfazUsuario = new VentanaPrincipal();
		inicializarBotones();
	}

	public void inicializarBotones() {

		agregarUbicacionesToBoxUbicaciones();

		interfazUsuario.getButtonGuardarVertice().addActionListener(e -> {
			crearAndGuardarVertice();
		});

		interfazUsuario.getButtonGuardarArista().addActionListener(e -> {
			crearAndGuardarArista();
		});

		interfazUsuario.getButtonEjecutarPrim().addActionListener(e -> {
			crearGrafoConAlgoritmoPrim();
		});

		interfazUsuario.getButtonEjecutarKruskal().addActionListener(e -> {
			crearGrafoConAlgoritmoKruskal();
		});
		
		interfazUsuario.getButtonLimpiarMapa().addActionListener(e -> {
			limpiarMapa();
		});

		interfazUsuario.getButtonCrearGrafoPrueba().addActionListener(e -> {
			limpiarMapa();
			grafo = GrafoExample.crearGrafoDePrueba();
			ClaseAuxiliar.marcarUbicacionesAndAristas(grafo, interfazUsuario.getMapa());
			actualizarAreaText();
		});

		interfazUsuario.getButtonSalir().addActionListener(e -> {
			interfazUsuario.getFrame().dispose();
		});

	}

	private void crearGrafoConAlgoritmoKruskal() {
		if (!ClaseAuxiliar.esGrafoConexo(grafo) || grafo.getArrayListDeVertices().size() == 0) {
			JOptionPane.showMessageDialog(null,"No se puede ejecutar el Algoritmo de Kruskal, es grafo no es conexo");
		} else {
			
			start = LocalDateTime.now();
			try {
			grafo = Kruskal.crearKruskal(grafo, grafo.getListaDeAristas());
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Reinicie el mapa");
			}
			ClaseAuxiliar.marcarUbicacionesAndAristas(grafo, interfazUsuario.getMapa());
			end = LocalDateTime.now();
			interfazUsuario.getLabelKruskal().setText(calcularTiempoDeEjecucion() + " Mls");
		}
	}

	private void crearGrafoConAlgoritmoPrim() {
		if (!ClaseAuxiliar.esGrafoConexo(grafo) || grafo.getArrayListDeVertices().size() == 0) {
			JOptionPane.showMessageDialog(null, "No se puede ejecutar el Algoritmo de Prim, es grafo no es conexo");
		} else {
			start = LocalDateTime.now();
			try {
				grafo = Prim.crearGrafoPrim(grafo);
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,"Reinicie el mapa");
				}
			ClaseAuxiliar.marcarUbicacionesAndAristas(grafo, interfazUsuario.getMapa());
			end = LocalDateTime.now();
			interfazUsuario.getLabelPrim().setText(calcularTiempoDeEjecucion() + " Mls"); 
		}
	}

	private void crearAndGuardarArista() {
		if (interfazUsuario.getFieldVerticeOrigen().getText().isEmpty() || interfazUsuario.getFieldVerticeDestino().getText().isEmpty()
				|| interfazUsuario.getFieldPesoArista().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese el vertice destino / origen / peso");
		} else {
			agregarAristaOrigenToDestino();
			actualizarAreaText();
			limpiarTextFields();
			ClaseAuxiliar.marcarUbicacionesAndAristas(grafo, interfazUsuario.getMapa());
		}
	}

	private void crearAndGuardarVertice() {
		if (interfazUsuario.getFieldNombreVertice().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese el nombre del vertice");
		} else {
			if (grafo.getUbicacionesMarcadas()
					.contains(interfazUsuario.getBoxUbicaciones().getSelectedItem())) {
				JOptionPane.showMessageDialog(null, "La ubicacion ya se encuentra marcada");
			} else {
				String nombreVertice = interfazUsuario.getFieldNombreVertice().getText();
				Ubicacion ub = (Ubicacion) interfazUsuario.getBoxUbicaciones().getSelectedItem();
				grafo.crearVertice(nombreVertice, ub);
				ClaseAuxiliar.marcarUbicacionesAndAristas(grafo, interfazUsuario.getMapa());
			}
			actualizarAreaText();
			limpiarTextFields();
		}
	}

	private void agregarAristaOrigenToDestino() {
		int verticeOrigen = Integer.parseInt(interfazUsuario.getFieldVerticeOrigen().getText());
		int verticeDestino = Integer.parseInt(interfazUsuario.getFieldVerticeDestino().getText());
		int pesoArista = Integer.parseInt(interfazUsuario.getFieldPesoArista().getText());
		grafo.agregarArista(verticeOrigen, verticeDestino, pesoArista);
	}

	
	private void agregarUbicacionesToBoxUbicaciones() {
		for (Ubicacion ub : Ubicacion.values()) {
			interfazUsuario.getBoxUbicaciones().addItem(ub);
		}
	}

	private void limpiarTextFields() {
		interfazUsuario.getFieldVerticeDestino().setText(null);
		interfazUsuario.getFieldVerticeOrigen().setText(null);
		interfazUsuario.getFieldPesoArista().setText(null);
		interfazUsuario.getFieldNombreVertice().setText(null);
	}

	private void actualizarAreaText() {
		interfazUsuario.getTextArea().setText(grafo.getInfoVertices());
	}

	private void limpiarMapa() {
		grafo = new Grafo();
		interfazUsuario.getMapa().removeAllMapMarkers();
		interfazUsuario.getMapa().removeAllMapPolygons();
	}

	public long calcularTiempoDeEjecucion() {
		return ChronoUnit.MICROS.between(this.start, this.end);
	}
	
	
}
