package view;

import javax.swing.JFrame;
import org.openstreetmap.gui.jmapviewer.JMapViewer;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import controller.Ubicacion;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaPrincipal {

	private JFrame frame;
	private JMapViewer mapa;
	private JButton buttonSalir;
	private JTextArea textArea;
	private JTextField fieldNombreVertice;
	private JTextField fieldVerticeOrigen;
	private JTextField fieldVerticeDestino;
	private JTextField fieldPesoArista;
	private JComboBox<Ubicacion> boxUbicaciones;
	private JButton buttonGuardarVertice;
	private JButton buttonGuardarArista;
	private JButton buttonEjecutarPrim;
	private JButton buttonEjecutarKruskal;
	private JButton buttonCrearGrafoPrueba;
	private JButton buttonLimpiarMapa;
	private JLabel labelPrim;
	private JLabel labelKruskal;

	public VentanaPrincipal() {
		mapa = new JMapViewer();
		mapa.setBounds(10, 11, 1562, 905);
		initialize();

	}

	private void initialize() {
		FlatDarculaLaf.setup();
		frame = new JFrame();
		frame.setBounds(0, 0, 1920, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.getContentPane().add(mapa);

		buttonSalir = new JButton("SALIR");
		buttonSalir.setBounds(663, 927, 240, 23);

		buttonSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(buttonSalir);
		
		textArea = new JTextArea();
		textArea.setBounds(1582, 609, 312, 407);
		frame.getContentPane().add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(1582, 11, 312, 457);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		fieldNombreVertice = new JTextField();
		fieldNombreVertice.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 16));
		fieldNombreVertice.setBounds(114, 41, 188, 31);
		panel.add(fieldNombreVertice);
		fieldNombreVertice.setColumns(10);
		
		boxUbicaciones = new JComboBox<Ubicacion>();
		boxUbicaciones.setBounds(114, 83, 188, 31);
		panel.add(boxUbicaciones);
		
		buttonGuardarVertice = new JButton("GUARDAR VERTICE");
		buttonGuardarVertice.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		buttonGuardarVertice.setBounds(114, 125, 188, 31);
		panel.add(buttonGuardarVertice);
		
		fieldVerticeOrigen = new JTextField();
		fieldVerticeOrigen.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 16));
		fieldVerticeOrigen.setColumns(10);
		fieldVerticeOrigen.setBounds(114, 183, 188, 31);
		panel.add(fieldVerticeOrigen);
		
		fieldVerticeDestino = new JTextField();
		fieldVerticeDestino.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 16));
		fieldVerticeDestino.setColumns(10);
		fieldVerticeDestino.setBounds(114, 225, 188, 31);
		panel.add(fieldVerticeDestino);
		
		buttonGuardarArista = new JButton("GUARDAR ARISTA");
		buttonGuardarArista.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		buttonGuardarArista.setBounds(114, 306, 188, 31);
		panel.add(buttonGuardarArista);
		
		fieldPesoArista = new JTextField();
		fieldPesoArista.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 16));
		fieldPesoArista.setColumns(10);
		fieldPesoArista.setBounds(114, 264, 188, 31);
		panel.add(fieldPesoArista);
		
		JLabel lblVertice = new JLabel("VERTICE");
		lblVertice.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		lblVertice.setBounds(114, 11, 188, 19);
		panel.add(lblVertice);
		
		JLabel lblOrigen = new JLabel("ORIGEN");
		lblOrigen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrigen.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		lblOrigen.setBounds(42, 190, 62, 19);
		panel.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("DESTINO");
		lblDestino.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDestino.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		lblDestino.setBounds(25, 235, 79, 19);
		panel.add(lblDestino);
		
		JLabel lblPeso = new JLabel("PESO");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		lblPeso.setBounds(25, 274, 79, 19);
		panel.add(lblPeso);
		
		buttonCrearGrafoPrueba = new JButton("CARGAR GRAFO DE PRUEBA");
		buttonCrearGrafoPrueba.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		buttonCrearGrafoPrueba.setBounds(0, 415, 302, 31);
		panel.add(buttonCrearGrafoPrueba);
		
		buttonLimpiarMapa = new JButton("LIMPIAR MAPA");
		buttonLimpiarMapa.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		buttonLimpiarMapa.setBounds(0, 367, 302, 31);
		panel.add(buttonLimpiarMapa);
		
		buttonEjecutarPrim = new JButton("CREAR GRAFO CON ALGORITMO PRIM");
		buttonEjecutarPrim.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		buttonEjecutarPrim.setBounds(1582, 479, 312, 31);
		frame.getContentPane().add(buttonEjecutarPrim);
		
		buttonEjecutarKruskal = new JButton("CREAR GRAFO CON ALGORITMO KRUSKAL");
		buttonEjecutarKruskal.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		buttonEjecutarKruskal.setBounds(1582, 521, 312, 31);
		frame.getContentPane().add(buttonEjecutarKruskal);
		
		JLabel lblNewLabel = new JLabel("TIEMPO EJECUCION PRIM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(1592, 563, 188, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTiempoDeEjecucion = new JLabel("TIEMPO EJECUCION KRUSKAL");
		lblTiempoDeEjecucion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTiempoDeEjecucion.setBounds(1592, 584, 188, 14);
		frame.getContentPane().add(lblTiempoDeEjecucion);
		
		labelPrim = new JLabel("");
		labelPrim.setHorizontalAlignment(SwingConstants.RIGHT);
		labelPrim.setBounds(1770, 563, 62, 14);
		frame.getContentPane().add(labelPrim);
		
		labelKruskal = new JLabel("");
		labelKruskal.setHorizontalAlignment(SwingConstants.RIGHT);
		labelKruskal.setBounds(1770, 584, 62, 14);
		frame.getContentPane().add(labelKruskal);

		frame.setVisible(true);

	}

	public JFrame getFrame() {
		return frame;
	}

	public JMapViewer getMapa() {
		return mapa;
	}

	public JButton getButtonSalir() {
		return buttonSalir;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JTextField getFieldNombreVertice() {
		return fieldNombreVertice;
	}

	public JTextField getFieldVerticeOrigen() {
		return fieldVerticeOrigen;
	}

	public JTextField getFieldVerticeDestino() {
		return fieldVerticeDestino;
	}

	public JTextField getFieldPesoArista() {
		return fieldPesoArista;
	}

	public JComboBox<Ubicacion> getBoxUbicaciones() {
		return boxUbicaciones;
	}

	public JButton getButtonGuardarVertice() {
		return buttonGuardarVertice;
	}

	public JButton getButtonGuardarArista() {
		return buttonGuardarArista;
	}

	public JButton getButtonEjecutarPrim() {
		return buttonEjecutarPrim;
	}

	public JButton getButtonEjecutarKruskal() {
		return buttonEjecutarKruskal;
	}

	public JButton getButtonCrearGrafoPrueba() {
		return buttonCrearGrafoPrueba;
	}

	public JButton getButtonLimpiarMapa() {
		return buttonLimpiarMapa;
	}

	public JLabel getLabelPrim() {
		return labelPrim;
	}

	public JLabel getLabelKruskal() {
		return labelKruskal;
	}
	
	
}
