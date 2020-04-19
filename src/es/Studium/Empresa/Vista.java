package es.Studium.Empresa;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Vista extends Frame implements WindowListener, ActionListener
{
	
	private static final long serialVersionUID = 1L;


//Declara la Barra de Menú
	static Frame menuPrincipal = new Frame("Menú Principal");
static MenuBar mnbMenu = new MenuBar();

//Declarar las opciones de la barra de menú
Menu mnEmpleados = new Menu("Empleados");
//Declarar las opciones de empleados
static MenuItem mnNuevo = new MenuItem("Nuevo");
static MenuItem mnConsultar = new MenuItem("Consultar");
static MenuItem mnEliminar = new MenuItem ("Eliminar");
static MenuItem mnModificar = new MenuItem ("Modificar");
//Declarar un dialogo y un texto vacío
/*Dialog d = new Dialog(this, "Aviso", true);
Label texto = new Label("");*/
//Crear botón para el dialog
//Button btnOK = new Button("OK");

//Frame NuevoEmpleado
static Frame fNuevoEmpleado = new Frame("altasEmpleados");
Label lblNombreEmpleado = new Label("Nombre");
static TextField txtNombreEmpleado = new TextField(20);
static Button btnAceptarNuevo = new Button("Aceptar");

//Frame Modificacion
static Frame fModificacionEmpleado = new Frame("modificacionEmpleados");
Label lblModificacionEmpleado = new Label("Nombre a modificar");
static Choice choModificacionEmpleado = new Choice();
static TextField txtNombreModificar= new TextField(20);
static Button btnConfirmarMod = new Button("Aceptar");
static Button btnVolverMod = new Button("Volver");
//Dialog Modificación
static Dialog dMod =new Dialog(fModificacionEmpleado, "Modificación realizada con éxito", true);
static Button btnDMod = new Button("Volver");
Label dLMod = new Label("Éxito");




/*
 * avisoAltas.setLayout(new FlowLayout()); avisoAltas.setSize(300, 160);
 * avisoAltas.setResizable(false); avisoAltas.addWindowListener(this);
 * avisoAltas.add(new Label("¿Es correcta la información proporcionada?"));
 * 
 * Button btnDiAceptar = new Button("Aceptar");
 * btnDiAceptar.addActionListener(this); avisoAltas.add(btnDiAceptar);
 * 
 * Button btnDiCancelar = new Button("Cancelar");
 * btnDiCancelar.addActionListener(this); avisoAltas.add(btnDiCancelar);
 * 
 * avisoAltas.setLocationRelativeTo(null); avisoAltas.setVisible(false);
 */

//Frame Consulta
static Frame fConsultaEmpleado = new Frame("modificacionEmpleados");
Label lblConsultaEmpleado = new Label("Nombre a consultar");
static TextArea areaConsulta = new TextArea(10, 20);
static Button btnVolverCon = new Button("Volver");

//Frame eliminar
static Frame fEliminarEmpleado = new Frame("eliminarEmpleados");
Label lblEliminarEmpleado = new Label("Elige el empleado a eliminar:");
static Choice choEliminarEmpleado = new Choice();
static Button btnEliminarConfirmar = new Button("Confirmar");
static Button btnEliminarVolver = new Button("Volver");

public Vista()
{

	
	//Añadir los submenus al menú
	mnEmpleados.add(mnNuevo);
	mnEmpleados.add(mnConsultar);
	mnEmpleados.add(mnEliminar);
	mnEmpleados.add(mnModificar);
	//Añadir el menú a la barra de menú
	mnbMenu.add(mnEmpleados);
		
	
	//NuevoEmpleado

	
	fNuevoEmpleado.add(lblNombreEmpleado);
	fNuevoEmpleado.add(txtNombreEmpleado);
	fNuevoEmpleado.add(btnAceptarNuevo);
	

	
	
	//Modificacion empleado
	
	fModificacionEmpleado.add(lblModificacionEmpleado);
	fModificacionEmpleado.add(choModificacionEmpleado);
	fModificacionEmpleado.add(txtNombreModificar);
	fModificacionEmpleado.add(btnConfirmarMod);
	fModificacionEmpleado.add(btnVolverMod);
	
	dMod.add(btnDMod);
	dMod.add(dLMod);
		
	//Consulta del Empleado
	fConsultaEmpleado.add(lblConsultaEmpleado);
	fConsultaEmpleado.add(areaConsulta);
	fConsultaEmpleado.add(btnVolverCon);
	
	//Frame eliminar
	fEliminarEmpleado.add(lblEliminarEmpleado);
	fEliminarEmpleado.add(choEliminarEmpleado);
	fEliminarEmpleado.add(btnEliminarConfirmar);
	fEliminarEmpleado.add(btnEliminarVolver);
	
}
public static void main(String[] args)
{
	new Vista();
}


@Override
public void windowActivated(WindowEvent arg0) {}
public void windowClosed(WindowEvent arg0) {}
public void windowClosing(WindowEvent arg0) {}
public void windowDeactivated(WindowEvent arg0) {}
public void windowDeiconified(WindowEvent arg0) {}
public void windowIconified(WindowEvent arg0) {}
public void windowOpened(WindowEvent arg0) {}
public void actionPerformed(ActionEvent ae) 
{

}

}
