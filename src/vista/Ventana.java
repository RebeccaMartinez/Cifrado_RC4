package vista;
import logica.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class Ventana extends JFrame implements ActionListener {

	//MARGENES PANEL
	
	private static final int TOP = 20;
	private static final int BOT = 20;
	private static final int LEFT = 10;
	private static final int RIGHT = 10;
	
	private static final int HGAP = 10;	//separación horizontal
	private static final int VGAP = 10;	//separación vertical
	
	private static final int ANCHO_CLAVE = 150;
	private static final int ALTO_CLAVE = 20;
	
	private static final int ALTO = 400;
	private static final int ANCHO = 300;
	
	private static final String CIFRAR = "cifrar";
	private static final String DESCIFRAR = "descifrar";

	//COMPONENTES
	private JButton btnCifrar;
	private JButton btnDescifrar;
	private JTextField tfClave;
	private JTextArea taMensaje;
	private JTextArea taRespuesta;
	
	
	public Ventana() {
		
		setLayout(new BorderLayout());
		setSize(ANCHO, ALTO);
		setTitle("Cifrado de Vigenere");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		inicializarPanelSuperior();
		inicializarPanelCentral();
		inicializarPanelInferior();
		
	}
	
	private void inicializarPanelSuperior(){
		
		JPanel panClave = new JPanel ();
		panClave.setBorder(BorderFactory.createEmptyBorder(TOP, 0, 0, 0));		
		
		JLabel lblClave = new JLabel ("Clave:");
		panClave.add(lblClave);
		
		JTextField tfClave = new JTextField();
		tfClave.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		tfClave.setPreferredSize(new Dimension(ANCHO_CLAVE, ALTO_CLAVE));
		panClave.add (tfClave);
		setTfClave(tfClave);
		
		add(panClave, BorderLayout.NORTH);
		
	}
	
	private void inicializarPanelCentral(){
		
		JPanel panTextos = new JPanel();
		panTextos.setLayout(new GridLayout(2, 1, HGAP, VGAP));
		panTextos.setBorder(BorderFactory.createEmptyBorder(TOP, LEFT, BOT, RIGHT));
		
		
		// setEditable() y setEnabled() para activar y desactivar
		JTextArea taMensaje = new JTextArea ();
		taMensaje.setLineWrap(true);
		taMensaje.setWrapStyleWord(true);
		taMensaje.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		panTextos.add(taMensaje);
		setTaMensaje(taMensaje);
		
		JTextArea taRespuesta = new JTextArea ();
		taRespuesta.setLineWrap(true);//Para que sea mmultilinea
		taRespuesta.setWrapStyleWord(true); //Para que no se corten palabras
		taRespuesta.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		taRespuesta.setEnabled(false);
		Color c = getBackground();
		taRespuesta.setBackground(c);
		taRespuesta.setDisabledTextColor(Color.black);
		setTaRespuesta(taRespuesta);
		panTextos.add(taRespuesta);
		
		add(panTextos);
	}
	
	private void inicializarPanelInferior(){
		
		JPanel panBotones = new JPanel();
		add(panBotones, BorderLayout.SOUTH);
		panBotones.setBorder(BorderFactory.createEmptyBorder(0, 0, BOT, 0));


		JButton bCifrar = new JButton("Cifrar");
		bCifrar.addActionListener(this);
		bCifrar.setActionCommand(CIFRAR);
		panBotones.add(bCifrar);
		setBtnCifrar(bCifrar);

		JButton bDescifrar = new JButton("Descifrar");
		bDescifrar.addActionListener(this);
		bDescifrar.setActionCommand(DESCIFRAR);
		//panBotones.add(bDescifrar); no se ha implementado el descifrado
		setBtnDescifrar(bDescifrar);
	}
	
	public static void main(String[] args) {
		Ventana miVentana;
		miVentana = new Ventana();
		miVentana.setVisible(true);
		
	}

	private void cifrar(){
		//TODO
		getTaRespuesta().setText(Cifrador.cifrar(taMensaje.getText(), tfClave.getText()));
	}
	
	private void descifrar(){
		//getTaRespuesta().setText(Descifrador.descifrar(taMensaje.getText(), tfClave.getText()));
	}


	@Override
	public void actionPerformed(ActionEvent e) {		
		String x = e.getActionCommand();
		switch (x) {
		case CIFRAR:
			cifrar();
			break;
		case DESCIFRAR:
			descifrar();
			break;
		}
	}

	public JButton getBtnCifrar() {
		return btnCifrar;
	}

	public void setBtnCifrar(JButton btnCifrar) {
		this.btnCifrar = btnCifrar;
	}

	public JButton getBtnDescifrar() {
		return btnDescifrar;
	}

	public void setBtnDescifrar(JButton btnDescifrar) {
		this.btnDescifrar = btnDescifrar;
	}

	public JTextField getTfClave() {
		return tfClave;
	}

	public void setTfClave(JTextField tfClave) {
		this.tfClave = tfClave;
	}

	public JTextArea getTaMensaje() {
		return taMensaje;
	}

	public void setTaMensaje(JTextArea taMensaje) {
		this.taMensaje = taMensaje;
	}

	public JTextArea getTaRespuesta() {
		return taRespuesta;
	}

	public void setTaRespuesta(JTextArea taRespuesta) {
		this.taRespuesta = taRespuesta;
	}

}
