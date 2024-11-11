package Service;

import javax.swing.JOptionPane;

import model.Cliente;
import model.Concensionario;
import model.Concesionario;

public class Main {
	
	
	public static Concesionario concesionario=new Concesionario ("Concesionario");

	public static void main(String[] args) {
		int opcionSubMenu;
		String menuPrincipal="Menu principal\n"+
		"Ingrese el numero correspondiente a la gestion deseada\n"+
		"1.Gestion de vehiculos\n"+
		"2.Gestion de Clientes\n"+
		"3.Gestion de ventas\n"+
		"4.Gestion de inventario\n"+
		"5.Gestion de mantenimiento\n"+
		"6.Salir";
		int opcionSeleccionada = 0;	
		do {
			opcionSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(null,menuPrincipal));
			String mensajeSubMenu=opcionMenu(opcionSeleccionada);
			if(opcionSeleccionada>= 6) break;
			opcionSubMenu = Integer.parseInt(JOptionPane.showInputDialog(null,mensajeSubMenu));
			opcionSubMenu(opcionSeleccionada,opcionSubMenu);
		} while (opcionSeleccionada != 6);
	}

	private static String opcionMenu(int opt) {
		String mensaje = null;
		switch (opt) {
		case 1: 
			mensaje="Gestion de vehiculos.\n"+
			"1.Añadir Vehiculo\n"+
			"2.Eliminar Vehiculo\n"+
			"3.Buscar vehiculo\n"+
			"4. Actulizar informacion del vehiculo";
			break;
		case 2:
			mensaje="Gestion de cliente.\n"+
			"1.Añadir cliente\n"+
			"2.Eliminar cliente\n"+
			"3.Buscar cliente\n"+
			"4.Actualizar informacion del cliente.\n"+
			"5.Regresar";
			break;
		case 3:
			mensaje="Gestion de ventas.\n"+
			"1.Registrar venta\n"+
			"2.Consultar venta\n"+
			"3.Regresar";
			break;
		case 4:
			mensaje="Gestion de inventario.\n"+
			"1.Registrar vehiculo en el inventario\n"+
			"2.Eliminar Vehiculo del inventario"+
			"3.Actualizar inventario";
			break;
		case 5:
			mensaje="Gestion de mantenimiento.\n"+
			"1.Registrar Mantenimiento\n"+
			"2.Consultar mantenimineto";
			break;
		default:
			break;
		}
		return mensaje;
	}
	private static void opcionSubMenu(int opcionPrincipal, int opcionSecundaria) {
		switch(opcionPrincipal) {
		case 1:
			gestionVehiculos(opcionSecundaria);
			break;
		case 2:
			gestionCliente(opcionSecundaria);
			break;
		case 3:
			gestionVentas(opcionSecundaria);
			break;
		case 4:
			gestionInventario(opcionSecundaria);
			break;
		case 5:
			gestionMantenimiento(opcionSecundaria);
			break;
		default:
			break;
		}
	}

	private static void gestionMantenimiento(int opt) {
		switch(opt) {
		case 1:
			
		}
	}

	private static void gestionInventario(int opt) {
		// TODO Auto-generated method stub
		
	}

	private static void gestionVentas(int opt) {
		// TODO Auto-generated method stub
		
	}

	private static void gestionCliente(int opcionSecundaria) {
		switch(opcionSecundaria) {
		case 1:
			agregarCliente();
			break;
		case 2:
			eliminarCliente();
			break;
		case 3:
			buscarCliente();
			break;
		case 4:
			
		}
	}
	private static void gestionVehiculos(int opt) {
	}
	
	//Metodos Cliente
	
	private static void agregarCliente() {
		String nombre=JOptionPane.showInputDialog("Ingrese el nombre del cliente.");
		String direccion=JOptionPane.showInputDialog("Ingrese la direccion del cliente.");
		String telefono=JOptionPane.showInputDialog("Ingrese el telefono del cliente.");
		String correo=JOptionPane.showInputDialog("Ingrese el correo del cliente.");
		Cliente cliente=new Cliente(nombre,direccion,telefono,correo);
		Boolean agregado=concesionario.agregarCliente(cliente);
		String mensaje=(agregado)? "El cliente fue agregado exitosamente." : "El cliente ya existe en la base.";
		JOptionPane.showMessageDialog(null, mensaje);	
	}
	private static void eliminarCliente() {
		String telefono=JOptionPane.showInputDialog("Ingrese el telefono del cliente que desea eliminar.");
		String correo=JOptionPane.showInputDialog("Ingrese el correo del cliente que desea eliminar.");
		boolean eliminado=concesionario.eliminarCliente(telefono, correo);
		String mensaje=(eliminado)? "El cliente fue eliminado exitosamente.": "El cliente no existe.";
		JOptionPane.showMessageDialog(null, mensaje);
	}
	private static void buscarCliente() {
		String nombre=JOptionPane.showInputDialog("Ingrese el nombre del usuario que desea buscar.");
		String direccion=JOptionPane.showInputDialog("Ingrese la direccion del usuario que desea buscar.");
		String telefono=JOptionPane.showInputDialog("Ingrese el telefono del usuario que desea buscar.");
		Cliente cliente=concesionario.buscarCliente(nombre, direccion, telefono);
		
	}
	private static Cliente buscarCliente() {
		return false;
		
	}
	private static void actualizarInformacionCliente() {
	}
	
	//Metodos de 
}
