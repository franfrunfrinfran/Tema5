package es.Studium.Empresa;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Vista extends Frame implements WindowListener, ActionListener
{
	
	private static final long serialVersionUID = 1L;


//Declara la Barra de Men�
MenuBar mnbMenu = new MenuBar();

//Declarar las opciones de la barra de men�
Menu mnEmpleados = new Menu("Empleados");
//Declarar las opciones de empleados
MenuItem mnNuevo = new MenuItem("Nuevo");
MenuItem mnConsultar = new MenuItem("Consultar");
MenuItem mnEliminar = new MenuItem ("Eliminar");
MenuItem mnModificar = new MenuItem ("Modificar");
//Declarar un dialogo y un texto vac�o
Dialog d = new Dialog(this, "Aviso", true);
Label texto = new Label("");
//Crear bot�n para el dialog
Button btnOK = new Button("OK");

public Vista()
{
	setLayout(new FlowLayout());
	setTitle("Empleados");
	this.setLocationRelativeTo(null);
	//Establecer la barra de men�
	setMenuBar(mnbMenu);
	//A�adir los submenus al men�
	mnEmpleados.add(mnNuevo);
	mnEmpleados.add(mnConsultar);
	mnEmpleados.add(mnEliminar);
	mnEmpleados.add(mnModificar);
	//A�adir el men� a la barra de men�
	mnbMenu.add(mnEmpleados);
	
	
	addWindowListener(this);
	mnNuevo.addActionListener(this);
	mnConsultar.addActionListener(this);
	mnEliminar.addActionListener(this);
	mnModificar.addActionListener(this);
	setVisible(true);
	setSize(300, 100);
	//Creaci�n del dialog
	d.setLayout(new FlowLayout());
	d.setSize(180, 150);
	d.setLocationRelativeTo(null);
	//A�adir el bot�n
	d.add(btnOK);
	//Para cerrar el dialog
	d.addWindowListener(this);
	btnOK.addActionListener(this);
	
}
public static void main(String[] args)
{
	new Vista();
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
	if(d.hasFocus())
	{
		d.setVisible(false);
	}
	else
	{
		System.exit(0);	
	}
	
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
@Override
public void actionPerformed(ActionEvent ae) 
{
	// TODO Auto-generated method stub
Object a;
a= ae.getSource();
if(a.equals(mnNuevo))
{
	texto.setText("Crear nuevo empleado");
	if(a.equals(btnOK))
	{
		//Ir a la clase "Nuevo"
	}
}
else if(a.equals(mnConsultar))
{
	texto.setText("Consultar un empleado");
	if(a.equals(btnOK))
	{
		//Ir a la clase "Consulta"
	}
}
else if(a.equals(mnEliminar))
{
	texto.setText("Eliminar un empleado");
	if(a.equals(btnOK))
	{
		//Ir a la clase "Eliminar"
	}
}
else if(a.equals(mnModificar))
{
	texto.setText("Modificar un empleado");
	if(a.equals(btnOK))
	{
		//Ir a la clase "Modificar"
	}
}
d.add(texto);
d.setVisible(true);
}

}
