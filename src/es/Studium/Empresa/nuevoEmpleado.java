package es.Studium.Empresa;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class nuevoEmpleado  extends Frame implements WindowListener, ActionListener

{
	private static final long serialVersionUID = 1L;
	
	Frame fNuevoEmpleado = new Frame("altasEmpleados");
	Label lblNombreEmpleado = new Label("Nombre");
	TextField txtNombreEmpleado = new TextField(20);
	Button btnAceptarNuevo = new Button("Aceptar");
	
	
	nuevoEmpleado()
	{
		setTitle("Nuevo Empleado");
		setLayout(new FlowLayout());
		
		add(lblNombreEmpleado);
		add(txtNombreEmpleado);
		
		setSize(300,100);
		setLocationRelativeTo(null);
		setVisible(true);
		add(btnAceptarNuevo);
		btnAceptarNuevo.addActionListener(this);
	
	addWindowListener(this);
	}
	

	public static void main(String[] args)
	{
		

	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}


	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
