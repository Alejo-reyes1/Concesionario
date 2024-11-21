package Service;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.Automovil;
import model.Camion;
import model.Cliente;
import model.Concesionario;
import model.Mantenimiento;
import model.Motocicleta;
import model.Vehiculo;
import model.Venta;

public class Main {
	
	
	public static Concesionario concesionario=new Concesionario ("Concesionario");

	public static void main(String[] args) {
		quemarDatos();
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
	
	private static void quemarDatos() {
		Automovil v1 = new Automovil("Toyota", "Corolla", "1HGBH41JXMN109186", "Rojo", 50000, 2020, 4, "Gasolina", "Automática", "Delantera");
		 concesionario.agregarVehiculo(v1);
		 Cliente c1 = new Cliente("Juan Perez", "Calle Falsa 123", "555-1234", "juan.perez@example.com");
		 concesionario.agregarCliente(c1);
		 Venta venta = new Venta(c1, v1, 15000.00);
		 concesionario.agregarVenta(v1, c1, venta);
		 Mantenimiento m1=new Mantenimiento(v1,"lavado",50000);
		 concesionario.registrarMantenimiento(m1);
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
			"2.Eliminar Vehiculo del inventario\n"+
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
			registrarMantenimiento();
			break;
		case 2:
			consultarMantenimiento();
			break;
		}
	}

	private static void gestionInventario(int opt) {
		switch(opt) {
		case 1:
			añadirVehiculo();
			break;
		case 2:
			eliminarVehiculo();
			break;
		case 3:
			actualizarInventario();
			break;
		}
		
	}

	private static void gestionVentas(int opt) {
		switch(opt) {
		case 1:
			registrarVenta();
			break;
		case 2:
			historialVenta();
			break;
		}
		
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
			actualizarInformacionCliente();
			break;
		}
	}
	private static void gestionVehiculos(int opcionSecundaria) {
		switch(opcionSecundaria) {
		case 1:
			añadirVehiculo();
			break;
		case 2:
			eliminarVehiculo();
			break;
		case 3:
			buscarVehiculo();
			break;
			
		case 4:
			actualizarInformacionVehiculo();
			break;
		}	
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
		JOptionPane.showMessageDialog(null, cliente!=null ? cliente.toString():"Cliente no se encuentra registrado");
	}
	private static void actualizarInformacionCliente() {
		String nombre=JOptionPane.showInputDialog("Ingrese el nombre del usuario que desea buscar.");
		String direccion=JOptionPane.showInputDialog("Ingrese la direccion del usuario que desea buscar.");
		String telefono=JOptionPane.showInputDialog("Ingrese el telefono del usuario que desea buscar.");
		Cliente cliente=concesionario.buscarCliente(nombre, direccion, telefono);
		if(cliente!=null) {
			String nombreActualizar=JOptionPane.showInputDialog("Ingrese el nombre del usuario que desea buscar.");
			String direccionActualizar=JOptionPane.showInputDialog("Ingrese la direccion del usuario que desea buscar.");
			String telefonoActualizar=JOptionPane.showInputDialog("Ingrese el telefono del usuario que desea buscar.");
			String correoActualizar=JOptionPane.showInputDialog("Ingrese el correo del cliente.");
			cliente.setNombre(nombreActualizar);
			cliente.setDireccion(direccionActualizar);
			cliente.setTelefono(telefonoActualizar);
			cliente.setCorreo(correoActualizar);
		}
	}
	
	//Metodos de gestion de vehiculos
	
	private static void añadirVehiculo() {
		int tipoVehiculo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de vehiculo que tiene\n 1.Automovil\n 2.Motocicleta\n 3.Camion"));
		String marca=JOptionPane.showInputDialog("Ingrese la marca del vehiculo");
		String modelo=JOptionPane.showInputDialog("Ingrese el modelo del vehiculo");
		String VIN=JOptionPane.showInputDialog("Ingrese el VIN del vehiculo");
		String color=JOptionPane.showInputDialog("Ingrese el color del vehiculo");
		int kilometraje=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el kilometraje del vehiculo"));
		int año=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año del vehiculo"));
		switch (tipoVehiculo){
		case 1: 
			agregarAutomovil(marca, modelo, VIN, color, kilometraje, año);
			break;
		case 2:
			agregarMotocicleta(marca,modelo,VIN,color,kilometraje,año);
			break;
		case 3:
			agregarCamion(marca,modelo,VIN,color,kilometraje,año);
			break;
		}
	}
	private static void agregarCamion(String marca, String modelo, String vIN, String color, int kilometraje, int año) {
		double capacidadCarga=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la capacidad de carga del camion"));
		String tipoCamion=JOptionPane.showInputDialog("Ingrese el tipo de camion");
		int ruedas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese las ruedas del camion"));
		String tipoFreno=JOptionPane.showInputDialog("Ingrese el tipo de freno del camion");
		int cilindraje=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el cilindraje del camion"));
		Camion camion=new Camion(marca, modelo, vIN, color, kilometraje, año, capacidadCarga, tipoCamion, ruedas, tipoFreno, cilindraje);
		boolean agregado=concesionario.agregarVehiculo(camion);
		JOptionPane.showMessageDialog(null,agregado?"El vehiculo fue agregado al inventario exitosamente":"El vehiculo ya existe y no fue agregado");
		
	}

	private static void agregarMotocicleta(String marca, String modelo, String VIN, String color, int kilometraje,
			int año) {
		String manillar=JOptionPane.showInputDialog("Ingrese el tipo de manillar de la moto");
		int ruedas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de ruedas de su motocicleta"));
		String tipoFreno=JOptionPane.showInputDialog("Ingrese el tipo de freno");
		int numeroEjes=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de ejes de la motocicleta"));
		Motocicleta moto=new Motocicleta(marca, modelo, VIN, color, kilometraje, año, manillar, ruedas, tipoFreno, numeroEjes);
		boolean agregado=concesionario.agregarVehiculo(moto);
		JOptionPane.showMessageDialog(null,agregado?"El vehiculo fue agregado al inventario exitosamente":"El vehiculo ya existe y no fue agregado");
	}

	private static void agregarAutomovil(String marca, String modelo,String VIN, String color,int kilometraje,
			int año) {
		int puertas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de puertas del automovil"));
		String tipoCombustible=JOptionPane.showInputDialog("Ingrese el tipo de combustible del automovil");
		String transmision=JOptionPane.showInputDialog("Ingrese la transmision del vehichulo");
		String traccion=JOptionPane.showInputDialog("Ingrese el tipo de traccion del vehiculo");
		Automovil auto=new Automovil(marca,modelo,VIN,color,kilometraje,año,puertas,tipoCombustible,transmision,traccion);
		boolean agregado=concesionario.agregarVehiculo(auto);
		JOptionPane.showMessageDialog(null,agregado?"El vehiculo fue agregado al inventario exitosamente":"El vehiculo ya existe y no fue agregado");
	}
	private static void eliminarVehiculo() {
		String marca=JOptionPane.showInputDialog("Ingrese la marca del vehiculo que desea eliminar");
		String modelo=JOptionPane.showInputDialog("Ingrese el modelo del vehiculo que desea eliminar");
		boolean eliminado=concesionario.eliminarVehiculo(marca, modelo);
		JOptionPane.showMessageDialog(null, eliminado?"El vehiculo fue eliminado con exito":"El vehiculo no existe en el inventario");
		}
	private static void actualizarInformacionVehiculo() {
		String marca=JOptionPane.showInputDialog("Ingrese la marca del vehiculo que desea eliminar");
		String modelo=JOptionPane.showInputDialog("Ingrese el modelo del vehiculo que desea eliminar");
		int tipoVehiculo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de vehículo:\n1. Automóvil\n2. Motocicleta\n3. Camión"));
	    Vehiculo vehiculo = concesionario.buscarVehiculo(marca, modelo, tipoVehiculo);
	    if(vehiculo!=null) {
	    	 switch (tipoVehiculo) {
	 	    case 1:
	 	    	actualizarAutomovil(vehiculo);
	 	    	break;
	 	    case 2:
	 	    	actualizarMotocicleta(vehiculo);
	 	    	break;
	 	    case 3:
	 	    	actualizarInformacionCamion(vehiculo);
	 	    	break;
	 	    }
	    }
	
	}
	private static void actualizarInformacionCamion(Vehiculo vehiculo) {
		String nuevoColor = JOptionPane.showInputDialog("Ingrese el nuevo color del vehículo:");
	    int nuevoKilometraje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo kilometraje del vehículo:"));
	    Double capacidadCargaNueva=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la capacidad de carga del camion"));
		String tipoCamionNuevo=JOptionPane.showInputDialog("Ingrese el tipo de camion");
		int nuevoNumeroRuedas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese las ruedas del camion"));
		String nuevoTipoFreno=JOptionPane.showInputDialog("Ingrese el tipo de freno del camion");
		int nuevoCilindraje=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el cilindraje del camion")); 
		concesionario.actualizarInformacionVehiculo(vehiculo, nuevoColor, nuevoKilometraje, capacidadCargaNueva, tipoCamionNuevo, nuevoNumeroRuedas, nuevoTipoFreno, nuevoCilindraje);
		JOptionPane.showMessageDialog(null, "Se actualizo correctamente y su informacion es "+vehiculo.toString());
	}

	//Metodos para actualizar informacion del vehiculo
	private static void actualizarAutomovil(Vehiculo vehiculo) {
	 String nuevoColor = JOptionPane.showInputDialog("Ingrese el nuevo color del vehículo:");
     int nuevoKilometraje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo kilometraje del vehículo:"));
     int puertas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de puertas del vehiculo"));
    String tipoCombustible = JOptionPane.showInputDialog(null, "Ingrese el tipo de combustible (ej. Gasolina, Diesel):");
    String  transmision = JOptionPane.showInputDialog(null, "Ingrese el tipo de transmisión (ej. Manual, Automática):");
    String traccion = JOptionPane.showInputDialog(null, "Ingrese el tipo de tracción (ej. 4x2, 4x4):");
    concesionario.actualizarInformacionVehiculo(vehiculo, nuevoColor, nuevoKilometraje, puertas, tipoCombustible, transmision, traccion);
    JOptionPane.showMessageDialog(null,"Se actualizo correctamente y su informacion es "+vehiculo.toString());
	}
	private static void actualizarMotocicleta(Vehiculo vehiculo) {
		String nuevoColor = JOptionPane.showInputDialog("Ingrese el nuevo color del vehículo:");
	    int nuevoKilometraje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo kilometraje del vehículo:"));
	    String nuevoManillar=JOptionPane.showInputDialog("Ingrese el nuevo manillar");
	    int ruedas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de ruedas del vehiculo"));
	    String tipoFrenoNuevo=JOptionPane.showInputDialog("Ingrese el tipo de freno");
	    int numeroEjes=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de ejes del vehiculo"));
	    concesionario.actualizarInformacionVehiculo(vehiculo, nuevoColor, nuevoKilometraje, nuevoManillar, ruedas, tipoFrenoNuevo, numeroEjes);
	    JOptionPane.showMessageDialog(null,"Se actualizo correctamente y su informacion es "+vehiculo.toString());
	}
		
	
	private static void buscarVehiculo() {
		String marca=JOptionPane.showInputDialog("Ingrese la marca del vehiculo");
		String modelo=JOptionPane.showInputDialog("Ingrese el modelo del vehiculo");
		int tipoVehiculo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de vehiculo\n 1.Automovil\n 2.Motocicleta\n 3.Camion"));  
		Vehiculo v=concesionario.buscarVehiculo(marca,modelo,tipoVehiculo);
		JOptionPane.showMessageDialog(null, v!=null?"El vehiculo fue encontrado con exito y su informacion es"+v.toString():"El vehiculo no fue encontrado");
	}
	
	
	//Gestion de ventas
	private static void registrarVenta() {
		String nombreCliente=JOptionPane.showInputDialog("Ingrese el nombre del cliente ");
		String direccionCliente=JOptionPane.showInputDialog("Ingrese la direccion del cliente");
		String telefonoCliente=JOptionPane.showInputDialog("Ingrese el telefono del cliente");
		Cliente cliente=concesionario.buscarCliente(nombreCliente, direccionCliente, telefonoCliente);
		String marca=JOptionPane.showInputDialog("Ingrese la marca del vehiculo");
		String modelo=JOptionPane.showInputDialog("Ingrese el modelo del vehiculo");
		int tipoVehiculo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de vehiculo\n 1.Automovil\n 2.Motocicleta\n 3.Camion"));
		double precioVenta=(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de venta del vehiculo")));
		Vehiculo vehiculo=concesionario.buscarVehiculo(marca,modelo,tipoVehiculo);
		if(cliente!=null && vehiculo!=null) {
			double precioVentaComision=concesionario.calcularPrecioVenta(tipoVehiculo,precioVenta,vehiculo);
			Venta v=new Venta(cliente,vehiculo,precioVentaComision);
			concesionario.agregarVenta(vehiculo, cliente, v);
		}
	}
	private static void historialVenta() {
		String listaHistorial="";
		int opcionBusqueda=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion con la que desea buscar la venta\n 1.Filtrar por cliente\n 2.Filtrar por vehiculo\n 3.filtrar por fecha"));
		switch(opcionBusqueda) {
		case 1:
			String nombre=JOptionPane.showInputDialog("Ingrese el nombre del usuario que desea buscar.");
			String direccion=JOptionPane.showInputDialog("Ingrese la direccion del usuario que desea buscar.");
			String telefono=JOptionPane.showInputDialog("Ingrese el telefono del usuario que desea buscar.");
			Cliente c=concesionario.buscarCliente(nombre, direccion, telefono);
			listaHistorial=concesionario.consultarVentas(c);
			JOptionPane.showMessageDialog(null, listaHistorial);
			break;
		case 2:
			String marca=JOptionPane.showInputDialog("Ingrese la marca del vehiculo");
			String modelo=JOptionPane.showInputDialog("Ingrese el modelo del vehiculo");
			int tipoVehiculo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de vehiculo\n 1.Automovil\n 2.Motocicleta\n 3.Camion"));  
			Vehiculo v=concesionario.buscarVehiculo(marca,modelo,tipoVehiculo);
			listaHistorial=concesionario.consultarVentas(v);
			JOptionPane.showMessageDialog(null, listaHistorial);
			break;
		case 3:
			LocalDate fecha=LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha en este formato YYYY-MM-DD"));
			listaHistorial=concesionario.consultarVenta(fecha);
			JOptionPane.showMessageDialog(null, listaHistorial);
			break;
		}
	}
	
	
	//Gestion de inventario
	
	private static void actualizarInventario() {
		String listaInventario=concesionario.actualizarInventario();
		JOptionPane.showMessageDialog(null, listaInventario);
	}
	/**private static void actualizarInventario() {
    // Solicitar los datos del vehículo a buscar
    String marca = JOptionPane.showInputDialog("Ingrese la marca del vehículo a actualizar:");
    String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo a actualizar:");
    int tipoVehiculo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de vehículo:\n1. Automóvil\n2. Motocicleta\n3. Camión"));

    // Buscar el vehículo en el concesionario
    Vehiculo vehiculo = concesionario.buscarVehiculo(marca, modelo, tipoVehiculo);

    if (vehiculo != null) {
        // Mostrar los datos actuales y opciones para actualizar
        JOptionPane.showMessageDialog(null, "Vehículo encontrado:\n" + vehiculo.toString());
        int opcionActualizar;
        do {
            opcionActualizar = Integer.parseInt(JOptionPane.showInputDialog(
                "Seleccione el atributo a actualizar:\n" +
                "1. Color\n" +
                "2. Kilometraje\n" +
                "3. Año\n" +
                "4. Salir"
            ));

            switch (opcionActualizar) {
                case 1:
                    String nuevoColor = JOptionPane.showInputDialog("Ingrese el nuevo color del vehículo:");
                    vehiculo.setColor(nuevoColor);
                    break;
                case 2:
                    int nuevoKilometraje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo kilometraje del vehículo:"));
                    vehiculo.setKilometraje(nuevoKilometraje);
                    break;
                case 3:
                    int nuevoAño = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo año del vehículo:"));
                    vehiculo.setAño(nuevoAño);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Actualización completada.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcionActualizar != 4);

        // Confirmar los cambios
        JOptionPane.showMessageDialog(null, "Los cambios han sido guardados:\n" + vehiculo.toString());
    } else {
        // Manejar el caso en el que el vehículo no se encuentra
        JOptionPane.showMessageDialog(null, "El vehículo no fue encontrado en el inventario.");
    }
	}
	*/
	//Gestion de mantenimiento
	private static void registrarMantenimiento() {
		String marca=JOptionPane.showInputDialog("Ingrese la marca del vehiculo");
		String modelo=JOptionPane.showInputDialog("Ingrese el modelo del vehiculo");
		int tipoVehiculo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de vehiculo\n 1.Automovil\n 2.Motocicleta\n 3.Camion"));
		Vehiculo vehiculo=concesionario.buscarVehiculo(marca,modelo,tipoVehiculo);
		if(vehiculo!=null) {
			String tipoMantenimiento=JOptionPane.showInputDialog("Ingrese el tipo de mantenimiento");
			double precioMantenimiento=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo del mantenimiento"));
			double precioMantenimientoComision=concesionario.calcularPrecioMantenimiento(tipoVehiculo,precioMantenimiento,vehiculo);
			Mantenimiento m= new Mantenimiento(vehiculo,tipoMantenimiento,precioMantenimientoComision);
			boolean agregado=concesionario.registrarMantenimiento(m);
			JOptionPane.showMessageDialog(null, agregado?"El mantemineto fue registrado":"El mantenimiento ya existe y no fue agregado");
		}
	}
	private static void consultarMantenimiento() {
		String marca=JOptionPane.showInputDialog("Ingrese la marca del vehiculo");
		String modelo=JOptionPane.showInputDialog("Ingrese el modelo del vehiculo");
		int tipoVehiculo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de vehiculo\n 1.Automovil\n 2.Motocicleta\n 3.Camion"));
		Vehiculo vehiculo=concesionario.buscarVehiculo(marca,modelo,tipoVehiculo);
		String consultarMantenimientoVehiculo=concesionario.consultarMantenimiento(vehiculo);
		JOptionPane.showMessageDialog(null,consultarMantenimientoVehiculo);
	}
}
