package es.Studium.Empresa;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Controlador extends Frame implements WindowListener, ActionListener {

	public Controlador() {
		Vista.menuPrincipal.setLayout(new FlowLayout());
		Vista.menuPrincipal.setTitle("Empleados");
		Vista.menuPrincipal.setLocationRelativeTo(null);
		Vista.menuPrincipal.setMenuBar(Vista.mnbMenu);
		// Establecer la barra de menú

		Vista.menuPrincipal.setVisible(true);
		Vista.menuPrincipal.setSize(300, 100);

		Vista.menuPrincipal.addWindowListener(this);
		Vista.mnNuevo.addActionListener(this);
		Vista.mnConsultar.addActionListener(this);
		Vista.mnEliminar.addActionListener(this);
		Vista.mnModificar.addActionListener(this);

		// Creación del dialog
		/*
		 * d.setLayout(new FlowLayout()); d.setSize(180, 150);
		 * d.setLocationRelativeTo(null);
		 */

		// Añadir el botón
		/*
		 * d.add(btnOK); //Para cerrar el dialog d.addWindowListener(this);
		 * 
		 * btnOK.addActionListener(this);
		 */

		// NuevoEmpleado
		Vista.fNuevoEmpleado.setTitle("Nuevo Empleado");
		Vista.fNuevoEmpleado.setLayout(new FlowLayout());

		Vista.fNuevoEmpleado.setSize(300, 100);
		Vista.fNuevoEmpleado.setLocationRelativeTo(null);

		Vista.fNuevoEmpleado.setVisible(false);
		Vista.fNuevoEmpleado.addWindowListener(this);

		// Modificacion empleado
		Vista.fModificacionEmpleado.setTitle("Modificar Empleado");
		Vista.fModificacionEmpleado.setLayout(new FlowLayout());

		Vista.fModificacionEmpleado.setSize(400, 100);
		Vista.fModificacionEmpleado.setLocationRelativeTo(null);

		Vista.dMod.setTitle("Éxito");
		Vista.dMod.setLayout(new FlowLayout());
		Vista.dMod.setSize(180, 150);
		Vista.dMod.setLocationRelativeTo(null);

		// Consulta del Empleado
		Vista.fConsultaEmpleado.setTitle("Consultar");
		Vista.fConsultaEmpleado.setLayout(new FlowLayout());

		Vista.fConsultaEmpleado.setSize(220, 300);
		Vista.fConsultaEmpleado.setLocationRelativeTo(null);
		Vista.fConsultaEmpleado.addWindowListener(this);

		// Frame eliminar
		Vista.fEliminarEmpleado.setTitle("Consultar");
		Vista.fEliminarEmpleado.setLayout(new FlowLayout());

		Vista.fEliminarEmpleado.setSize(220, 150);
		Vista.fEliminarEmpleado.setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		new Controlador();
	}

	public void actionPerformed(ActionEvent ae) {
		Object a;
		a = ae.getSource();
		// Ventana nuevo
		if (a.equals(Vista.mnNuevo)) {
			Vista.fNuevoEmpleado.setVisible(true);
			Vista.btnAceptarNuevo.addActionListener(this);
		}
		// Botón AceptarNuevoEmpleado
		else if (a.equals(Vista.btnAceptarNuevo)) {
			try {
				Class.forName(Modelo.driver);
				Modelo.connection = DriverManager.getConnection(Modelo.url, Modelo.usuario, Modelo.clave);
				Modelo.statement = Modelo.connection.createStatement();
				Modelo.sentencia = "INSERT INTO empleados (nombreEmpleado) VALUES ('"
						+ Vista.txtNombreEmpleado.getText() + "')";
				Modelo.statement.executeUpdate(Modelo.sentencia);
			} catch (ClassNotFoundException cnfe) {
				System.out.println("Error 1-" + cnfe.getMessage());
			} catch (SQLException sqle) {
				System.out.println("Error 2-" + sqle.getMessage());
			} finally {
				try {
					if (Modelo.connection != null) {
						Modelo.connection.close();
					}
				} catch (SQLException e) {
					System.out.println("Error 3-" + e.getMessage());
				}
			}
		}
		// Ventana consultar
		else if (a.equals(Vista.mnConsultar)) {
			Vista.fConsultaEmpleado.setVisible(true);
			Vista.btnVolverCon.addActionListener(this);
			try {
				Class.forName(Modelo.driver);
				Modelo.connection = DriverManager.getConnection(Modelo.url, Modelo.usuario, Modelo.clave);
				Modelo.statement = Modelo.connection.createStatement();
				Modelo.sentencia = "SELECT * FROM empleados";
				Modelo.rs = Modelo.statement.executeQuery(Modelo.sentencia);
				System.out.println("Consulta realizada con éxito");
				Vista.areaConsulta.setText("");
				while (Modelo.rs.next()) {
					if (Vista.areaConsulta.getText().length() == 0) {
						Vista.areaConsulta.setText(
								Modelo.rs.getInt("idEmpleado") + " - " + Modelo.rs.getString("nombreEmpleado"));
					} else {
						Vista.areaConsulta.setText(Vista.areaConsulta.getText() + "\n" + Modelo.rs.getInt("idEmpleado")
								+ " - " + Modelo.rs.getString("nombreEmpleado"));
					}
				}
			} catch (ClassNotFoundException cnfe) {
				System.out.println("Error 1-" + cnfe.getMessage());
			} catch (SQLException sqle) {
				System.out.println("Error 2-" + sqle.getMessage());
			} finally {
				try {
					if (Modelo.connection != null) {
						Modelo.connection.close();
					}
				} catch (SQLException e) {
					System.out.println("Error 3-" + e.getMessage());
				}
			}
		} else if (a.equals(Vista.btnVolverCon)) {
			Vista.fConsultaEmpleado.setVisible(false);
		}
		// Ventana eliminar
		else if (a.equals(Vista.mnEliminar)) {
			Vista.fEliminarEmpleado.setVisible(true);
			Vista.btnEliminarConfirmar.addActionListener(this);
			Vista.btnEliminarVolver.addActionListener(this);

			// Introducir los datos en el choice
			try {
				Class.forName(Modelo.driver);
				Modelo.connection = DriverManager.getConnection(Modelo.url, Modelo.usuario, Modelo.clave);
				Modelo.statement = Modelo.connection.createStatement();
				Modelo.sentencia = "SELECT * FROM empleados";
				Modelo.rs = Modelo.statement.executeQuery(Modelo.sentencia);

				while (Modelo.rs.next()) {
					String s = Integer.toString(Modelo.rs.getInt("idEmpleado"));
					s = s + "-" + Modelo.rs.getString("nombreEmpleado");
					Vista.choEliminarEmpleado.add(s);
				}
			} catch (ClassNotFoundException cnfe) {
				System.out.println("Error 1-" + cnfe.getMessage());
			} catch (SQLException sqle) {
				System.out.println("Error 2-" + sqle.getMessage());
			} finally {
				try {
					if (Modelo.connection != null) {
						Modelo.connection.close();
					}
				} catch (SQLException e) {
					System.out.println("Error 3-" + e.getMessage());
				}
			}
		}
		// Botón volver
		else if (a.equals(Vista.btnEliminarVolver))// Investigar porqué hay que darle al botón 2 veces para que funcione
		{
			Vista.fEliminarEmpleado.setVisible(false);
		}
		// Boton Aceptar
		else if (a.equals(Vista.btnEliminarConfirmar)) {
			try {
				String[] ESeleccionado = Vista.choEliminarEmpleado.getSelectedItem().split("-");

				Class.forName(Modelo.driver);
				Modelo.connection = DriverManager.getConnection(Modelo.url, Modelo.usuario, Modelo.clave);
				Modelo.statement = Modelo.connection.createStatement();
				Modelo.sentencia = "DELETE FROM empleados WHERE idEmpleado = " + Integer.parseInt(ESeleccionado[0]);
				Modelo.statement.executeUpdate(Modelo.sentencia);
				System.out.println("Baja realizada con éxito");
			} catch (ClassNotFoundException cnfe) {
				System.out.println("Error 1-" + cnfe.getMessage());
			} catch (SQLException sqle) {
				System.out.println("Error 2-" + sqle.getMessage());
			} finally {
				try {
					if (Modelo.connection != null) {
						Modelo.connection.close();
					}
				} catch (SQLException e) {
					System.out.println("Error 3-" + e.getMessage());
				}
			}

		}
		// Ventana modificar
		else if (a.equals(Vista.btnVolverMod)) {
			Vista.fModificacionEmpleado.setVisible(false);
		} else if (a.equals(Vista.mnModificar)) {
			Vista.fModificacionEmpleado.setVisible(true);
			Vista.btnVolverMod.addActionListener(this);
			Vista.btnConfirmarMod.addActionListener(this);

			// Choice de modificar
			try {
				Class.forName(Modelo.driver);
				Modelo.connection = DriverManager.getConnection(Modelo.url, Modelo.usuario, Modelo.clave);
				Modelo.statement = Modelo.connection.createStatement();
				Modelo.sentencia = "SELECT * FROM empleados";
				Modelo.rs = Modelo.statement.executeQuery(Modelo.sentencia);
				Vista.choModificacionEmpleado.add("Elegir un empleado...");
				while (Modelo.rs.next()) {
					String s = Integer.toString(Modelo.rs.getInt("idEmpleado"));
					s = s + "-" + Modelo.rs.getString("nombreEmpleado");
					Vista.choModificacionEmpleado.add(s);
				}
			} catch (ClassNotFoundException cnfe) {
				System.out.println("Error 1-" + cnfe.getMessage());
			} catch (SQLException sqle) {
				System.out.println("Error 2-" + sqle.getMessage());
			} finally {
				try {
					if (Modelo.connection != null) {
						Modelo.connection.close();
					}
				} catch (SQLException e) {
					System.out.println("Error 3-" + e.getMessage());
				}
			}
		} else if (a.equals(Vista.btnConfirmarMod)) {
			Vista.dMod.setVisible(true);
			Vista.btnDMod.addActionListener(this);
			 if (a.equals(Vista.btnDMod)) {
				Vista.dMod.setVisible(false);
			
			}
			try {
				int idEmpleado = Integer.parseInt(Vista.choModificacionEmpleado.getSelectedItem().split("-")[0]);
				String nombre = Vista.txtNombreModificar.getText();

				Class.forName(Modelo.driver);
				Modelo.connection = DriverManager.getConnection(Modelo.url, Modelo.usuario, Modelo.clave);
				Modelo.statement = Modelo.connection.createStatement();
				Modelo.sentencia = "UPDATE empleados SET nombreEmpleado = '" + nombre + "' WHERE idEmpleado="
						+ idEmpleado;
				Modelo.statement.executeUpdate(Modelo.sentencia);
				System.out.println("Modificación realizada con éxito");
			} catch (ClassNotFoundException cnfe) {
				System.out.println("Error 1-" + cnfe.getMessage());
			} catch (SQLException sqle) {
				System.out.println("Error 2-" + sqle.getMessage());
			} finally {
				try {
					if (Modelo.connection != null) {
						Modelo.connection.close();
					}
				} catch (SQLException e) {
					System.out.println("Error 3-" + e.getMessage());
				}
			}
			

		}
		else if (a.equals(Vista.btnDMod)) {
			Vista.dMod.setVisible(false);
		}

	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		if (Vista.fNuevoEmpleado.hasFocus()) {
			Vista.fNuevoEmpleado.setVisible(false);

		} else if (Vista.fModificacionEmpleado.hasFocus()) {
			Vista.fModificacionEmpleado.setVisible(false);
		} else if (Vista.dMod.hasFocus()) {
			Vista.dMod.setVisible(false);
		} else if (Vista.fConsultaEmpleado.isActive()) {
			Vista.fConsultaEmpleado.setVisible(false);
		} else if (Vista.fEliminarEmpleado.isActive()) {
			Vista.fEliminarEmpleado.setVisible(false);
		} else {
			System.exit(0);
		}

	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

}
